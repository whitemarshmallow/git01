package com.ctclri.agv.backend.restfulAPI.service;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Tray;

import java.util.List;
import java.util.Map;

public interface TrayService {

    public void saveTray(Tray tray);

    public List<Tray> getTraysByAreaId(String areaId);

    public void updateTray(Tray tray);

    public void deleteTrayById(String trayId);

    public List<Tray> findTraysByCriteria(String areaId, Map<String, Map<String, String>> filterCriteriaMap);

//    public List<Tray> findTraysByCriteria(Map<String, Map<String, String>> filterCriteriaMap);

}
