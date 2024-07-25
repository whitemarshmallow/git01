package com.ctclri.agv.backend.restfulAPI.service.impl;

import com.ctclri.agv.backend.restfulAPI.mapper.ContainerMapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;
import com.ctclri.agv.backend.restfulAPI.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    private ContainerMapper containerMapper;

    public List<Container> getAllContainers() {
        return containerMapper.getAllContainers();
    }

    public Container getOneContainer(String modelId) {
        return containerMapper.findById(modelId);
    }

    public void saveContainer(Container container) {
        containerMapper.insert(container);
    }

    public void updateContainer(Container container) {
        containerMapper.update(container);
    }

    public void deleteContainerById(String modelId) {
        containerMapper.deleteById(modelId);
    }

    public List<Container> findContainersByCriteria(Map<String, Map<String, String>> filterCriteriaMap) {
        return containerMapper.findByCriteria(filterCriteriaMap);
    }


}
