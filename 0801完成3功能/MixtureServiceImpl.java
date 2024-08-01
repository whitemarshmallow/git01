package com.ctclri.agv.backend.restfulAPI.service.impl;

import com.ctclri.agv.backend.restfulAPI.mapper.MixtureMapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Mixture;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.MixtureInventory;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.NodeData;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;
import com.ctclri.agv.backend.restfulAPI.service.MixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MixtureServiceImpl implements MixtureService {

    @Autowired
    private MixtureMapper mixtureMapper;

    public void saveMixture(Mixture mixture) {
        mixtureMapper.insert(mixture);
    }


//    public List<Mixture> getMixturesByAreaId(String areaId) {
//        return mixtureMapper.findByAreaId(areaId);
//    }


    public List<Mixture> getMixturesByAreaId(String areaId) {
        // 查出列表所有的值
        List<Mixture> mixtures = mixtureMapper.findMixturesByAreaId(areaId);
        // 流式处理，为每个mixture替换startPos
        return mixtures.stream().map(mixture -> updateStartPos(mixture, areaId)).collect(Collectors.toList());
    }

    private Mixture updateStartPos(Mixture mixture, String areaId) {
        // 解析绑定节点名称
        String[] nodeNames = mixture.getMixtureBindNode().replace("[", "").replace("]", "").replace("\"", "").split(",");
        // 查询对应的节点数据
        List<NodeData> nodeDataList = mixtureMapper.findNodeDataByInstanceNamesAndAreaId(Arrays.asList(nodeNames), areaId);
        // 创建节点名称到数据的映射
        Map<String, NodeData> nodeMap = nodeDataList.stream().collect(Collectors.toMap(NodeData::getInstanceName, Function.identity()));

        // 构建新的位置字符串
        List<String> newPositions = nodeDataList.stream()
                .map(node -> "[" + node.getOriX() + ", " + node.getOriY() + "]")
                .collect(Collectors.toList());

        // 更新混合对象的起始位置
        mixture.setMixtureStartPos(String.join(" ", newPositions));
        return mixture;
    }












    public void updateMixture(Mixture mixture) {
        mixtureMapper.update(mixture);
    }

    public void deleteMixtureById(String mixtureId) {
        mixtureMapper.deleteById(mixtureId);
    }

//    public List<Mixture> findMixturesByCriteria(Map<String, Map<String, String>> filterCriteriaMap) {
//        return mixtureMapper.findByCriteria(filterCriteriaMap);
//    }

    public List<Mixture> findMixturesByCriteria(String areaId, Map<String, Map<String, String>> filterCriteriaMap) {
        return mixtureMapper.findByCriteria(areaId, filterCriteriaMap);
    }


    public List<MixtureInventory> findAvailableMixturePositions(String areaId, String mixtureId) {
        Mixture mixtureInfo = mixtureMapper.getMixtureInfo(areaId, mixtureId);
        List<String> allPositions = parseMixtureName(mixtureInfo.getMixtureName());
        List<String> usedPositions = mixtureMapper.getUsedPositions(areaId, mixtureId);

        // 分割起始位置和每层高度
        String[] startPoses = mixtureInfo.getMixtureStartPos().replace("[", "").replace("]", "").split(" ");
        String[] perLayers = mixtureInfo.getMixturePerLayer().replace("[", "").replace("]", "").split(",");

        List<MixtureInventory> availablePositions = new ArrayList<>();
        for (String pos : allPositions) {
            if (!usedPositions.contains(pos)) {
                int row = Integer.parseInt(pos.split("-")[0]);
                int col = Integer.parseInt(pos.split("-")[1]);
                // 根据列决定 x,y 坐标，根据行决定 z 坐标
                String[] xy = startPoses[col - 1].split(",");
                String xPos = xy[0].trim();
                String yPos = xy[1].trim();
                String zPos = perLayers[row - 1].trim();
                String position = "[" + xPos + "," + yPos + "," + zPos + "]";
                availablePositions.add(new MixtureInventory(pos, position));
            }
        }

        return availablePositions;
    }


//    public List<MixtureInventory> findAvailableMixturePositions(String areaId, String mixtureId) {
//        String mixtureName = mixtureMapper.getMixtureName(areaId, mixtureId);
//        List<String> allPositions = parseMixtureName(mixtureName);
//        List<String> usedPositions = mixtureMapper.getUsedPositions(areaId, mixtureId);
//
//        // 过滤出未使用的位置
//        List<MixtureInventory> availablePositions = allPositions.stream()
//                .filter(pos -> !usedPositions.contains(pos))
//                .map(pos -> new MixtureInventory(pos, "Temporary Position"))  // 使用临时位置，待更新
//                .collect(Collectors.toList());
//
//        return availablePositions;
//    }

    private List<String> parseMixtureName(String mixtureName) {
        List<String> positions = new ArrayList<>();
        String[] parts = mixtureName.split("/");
        int rows = Integer.parseInt(parts[0].charAt(0) + "");
        int cols = Integer.parseInt(parts[0].charAt(2) + "");

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                positions.add(row + "-" + col);
            }
        }
        return positions;
    }




}
