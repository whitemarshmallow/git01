package com.ctclri.agv.backend.restfulAPI.web;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;
import com.ctclri.agv.backend.restfulAPI.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ctclri.agv.backend.restfulAPI.service.ContainerService;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    private static Container container;


    // 保存容器模型
    @PostMapping("/api/container/saveModel")
    public Result saveModel(@RequestBody Container container) {
        containerService.saveContainer(container);
        return Result.success(null);
    }

    // 获取所有容器模型
    @GetMapping("/api/container/getModel")
    public Result getModel() {
        List<Container> containerList = containerService.getAllContainers();
        return Result.success(containerList);
    }

    // 更新容器模型
    @PostMapping("/api/container/updateModel")
    public Result updateModel(@RequestBody Container updatedContainer) {
        containerService.updateContainer(updatedContainer);
        return Result.success(null);
    }

    // 删除容器模型
//    @DeleteMapping("/api/container/deleteModel")
//    public Result deleteModel(@RequestBody Container container) {
////        System.out.println(container.getModelId());
//        containerService.deleteContainerById(container.getModelId());
//        return Result.success(null);
//    }
    @DeleteMapping("/api/container/deleteModel")
    public Result deleteModel(@RequestParam String modelId) {
        containerService.deleteContainerById(modelId);
        return Result.success(null);
    }

//     查找容器模型
    @PostMapping ("/api/container/findModel")
//    public Result findModel(@RequestParam String filterCriteria, @RequestParam String filterValue) {
//        System.out.println("filterCriteria:" + filterCriteria);
//        List<Container> containerList = containerService.findContainersByCriteria(filterCriteria, filterValue);
//        return Result.success(containerList);
//    }
    public Result findModel(@RequestBody Map<String, Map<String, String>> filterCriteriaMap) {
        System.out.println("filterCriteriaMap: " + filterCriteriaMap);
        List<Container> containerList = containerService.findContainersByCriteria(filterCriteriaMap);
        return Result.success(containerList);
    }

}
