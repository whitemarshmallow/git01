package com.ctclri.agv.backend.restfulAPI.service.impl;

import com.ctclri.agv.backend.restfulAPI.mapper.TrayMapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.NodeData;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Shelf;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Tray;
import com.ctclri.agv.backend.restfulAPI.service.TrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrayServiceImpl implements TrayService {

    @Autowired
    private TrayMapper trayMapper;

    public void saveTray(Tray tray) {
        trayMapper.insert(tray);
    }

    public List<Tray> getTraysByAreaId(String areaId) {
        // 从数据库中获取指定区域的所有托盘信息
        List<Tray> trays = trayMapper.findByAreaIdSimple(areaId);

        System.out.println("第一条SQL语句");
        System.out.println(trays);

        // 遍历每个托盘，进行必要的数据处理
        trays.forEach(tray -> {
            // 检查是否为复杂格式
            if (tray.getTrayBindNode().contains("/")) {
                // 处理复杂的绑定节点，首先解析出mixtureId
                String mixtureId = tray.getTrayBindNode().split("/")[0];

                // 根据mixtureId和areaId查询相关的节点数据
                List<NodeData> nodeDataList = trayMapper.findNodeDataByMixtureIdAndAreaId(mixtureId, areaId);

                // 解析出绑定节点后的索引号，并转换为数组索引
                int index = Integer.parseInt(tray.getTrayBindNode().split("-")[1]) - 1;

                // 确保索引号在返回的列表范围内
                if (index < nodeDataList.size()) {
                    NodeData nodeData = nodeDataList.get(index);

                    // 设置托盘的原始X和Y坐标
                    tray.setOriX(nodeData.getOriX());
                    tray.setOriY(nodeData.getOriY());
                }
            }

            // 解析现有的trayStartPos以保留最后一个值，这通常是一个固定的深度或其他度量
            String[] parts = tray.getTrayStartPos().replaceAll("[\\[\\]]", "").split(",");

            // 确保解析后的部分完整（即包含三个元素）
            if (parts.length == 3) {
                // 重新格式化trayStartPos，仅更新前两个值，保留最后一个值
                String formattedStartPos = String.format("[%.6f,%.6f,%s]", tray.getOriX(), tray.getOriY(), parts[2]);

                // 更新托盘的起始位置信息
                tray.setTrayStartPos(formattedStartPos);
            }
        });

        // 返回更新后的托盘列表
        return trays;
    }

    public void updateTray(Tray tray) {
        trayMapper.update(tray);
    }

    public void deleteTrayById(String trayId) {
        trayMapper.deleteById(trayId);
    }

//    public List<Tray> findTraysByCriteria(Map<String, Map<String, String>> filterCriteriaMap) {
//        return trayMapper.findByCriteria(filterCriteriaMap);
//    }
    public List<Tray> findTraysByCriteria(String areaId, Map<String, Map<String, String>> filterCriteriaMap) {
        return trayMapper.findByCriteria(areaId, filterCriteriaMap);
    }


}
