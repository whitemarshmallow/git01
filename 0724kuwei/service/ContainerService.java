package com.ctclri.agv.backend.restfulAPI.service;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;

import java.util.List;
import java.util.Map;

public interface ContainerService {

    public List<Container> getAllContainers();

    public Container getOneContainer(String modelId);

    public void saveContainer(Container container);

    public void updateContainer(Container container);

    public void deleteContainerById(String modelId);

    public List<Container> findContainersByCriteria(Map<String, Map<String, String>> filterCriteriaMap);

}
