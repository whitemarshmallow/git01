package com.ctclri.agv.backend.restfulAPI.web;


import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Mixture;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.MixtureInventory;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;
import com.ctclri.agv.backend.restfulAPI.service.MixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ctclri.agv.backend.restfulAPI.pojo.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MixtureController {

    @Autowired
    private MixtureService mixtureService;

    @PostMapping("/api/container/saveMixture")
    public Result saveMixture(@RequestBody Mixture mixture) {
        mixtureService.saveMixture(mixture);
        return Result.success(null);
    }

    @GetMapping("/api/container/getMixture")
    public Result getMixture(@RequestParam String areaId) {
        List<Mixture> mixtures = mixtureService.getMixturesByAreaId(areaId);
        return Result.success(mixtures);
    }

    @PostMapping("/api/container/updateMixture")
    public Result updateMixture(@RequestBody Mixture mixture) {
        mixtureService.updateMixture(mixture);
        return Result.success(null);
    }

    @DeleteMapping("/api/container/deleteMixture")
    public Result deleteMixture(@RequestParam String mixtureId) {
        mixtureService.deleteMixtureById(mixtureId);
        return Result.success(null);
    }

    //查询未使用内容组合货架位置
    @GetMapping("/api/container//getMixtureInv")
    public Result getMixtureInventory(@RequestParam String areaId, @RequestParam String mixtureId) {
        List<MixtureInventory> availablePositions = mixtureService.findAvailableMixturePositions(areaId, mixtureId);

        return Result.success(availablePositions);
    }



    // 查找组合货架模型
    @PostMapping("/api/container/findMixture")
//    public Result findMixture(@RequestBody Map<String, Map<String, String>> filterCriteriaMap) {
//        System.out.println("filterCriteriaMap: " + filterCriteriaMap);
//        List<Mixture> mixtureList = mixtureService.findMixturesByCriteria(filterCriteriaMap);
//        return Result.success(mixtureList);
//    }
    public Result findMixture(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Request Body: " + requestBody);

        String areaId = (String) requestBody.get("areaId");
        System.out.println("Area ID: " + areaId);

        // Converting the new request structure to filterCriteriaMap
        Map<String, Map<String, String>> filterCriteriaMap = new HashMap<>();
        requestBody.forEach((key, value) -> {
            if (!key.equals("areaId") && value instanceof Map) {
                Map<String, String> criteriaMap = (Map<String, String>) value;
                filterCriteriaMap.put(key, criteriaMap);
            }
        });

        System.out.println("Filter Criteria Map: " + filterCriteriaMap);

        List<Mixture> mixtureList = mixtureService.findMixturesByCriteria(areaId, filterCriteriaMap);
        return Result.success(mixtureList);
    }
}
