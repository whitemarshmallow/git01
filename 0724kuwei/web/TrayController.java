package com.ctclri.agv.backend.restfulAPI.web;

import com.ctclri.agv.backend.restfulAPI.pojo.Result;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Tray;
import com.ctclri.agv.backend.restfulAPI.service.TrayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TrayController {
    @Autowired
    private TrayService trayService;

    @PostMapping("/api/container/saveTray")
    public Result saveTray(@RequestBody Tray tray) {
        trayService.saveTray(tray);
        return Result.success(null);
    }

    @GetMapping("/api/container/getTray")
    public Result getTray(@RequestParam String areaId) {
        List<Tray> trays = trayService.getTraysByAreaId(areaId);
        return Result.success(trays);
    }

    @PostMapping("/api/container/updateTray")
    public Result updateTray(@RequestBody Tray tray) {
        trayService.updateTray(tray);
        return Result.success(null);
    }

    @DeleteMapping("/api/container/deleteTray")
    public Result deleteTray(@RequestParam String trayId) {
        trayService.deleteTrayById(trayId);
        return Result.success(null);
    }

    // 查找托盘模型
    @PostMapping("/api/container/findTray")
//    public Result findTray(@RequestBody Map<String, Map<String, String>> filterCriteriaMap) {
//        System.out.println("filterCriteriaMap: " + filterCriteriaMap);
//        List<Tray> trayList = trayService.findTraysByCriteria(filterCriteriaMap);
//        return Result.success(trayList);
//    }
    public Result findTray(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Request Body: " + requestBody);

        String areaId = (String) requestBody.get("areaId");
        System.out.println("Area ID: " + areaId);

        // 将新的请求体结构转换为 filterCriteriaMap
        Map<String, Map<String, String>> filterCriteriaMap = new HashMap<>();
        requestBody.forEach((key, value) -> {
            if (!key.equals("areaId") && value instanceof Map) {
                Map<String, String> criteriaMap = (Map<String, String>) value;
                filterCriteriaMap.put(key, criteriaMap);
            }
        });

        System.out.println("Filter Criteria Map: " + filterCriteriaMap);

//        // 去除请求参数的空格
//        filterCriteriaMap.forEach((key, criteria) -> {
//            if (criteria != null && criteria.get("filterValue") != null) {
//                criteria.put("filterValue", criteria.get("filterValue").trim());
//            } else {
//                System.out.println("Criteria or filterValue is null for key: " + key);
//            }
//        });

        List<Tray> trayList = trayService.findTraysByCriteria(areaId, filterCriteriaMap);
        return Result.success(trayList);
    }


}
