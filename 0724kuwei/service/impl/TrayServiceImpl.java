package com.ctclri.agv.backend.restfulAPI.service.impl;

import com.ctclri.agv.backend.restfulAPI.mapper.TrayMapper;
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
        return trayMapper.findByAreaId(areaId);
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
