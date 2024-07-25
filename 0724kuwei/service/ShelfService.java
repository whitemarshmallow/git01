package com.ctclri.agv.backend.restfulAPI.service;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Shelf;

import java.util.List;
import java.util.Map;

public interface ShelfService {


    public void saveShelf(Shelf shelf);

    public List<Shelf> getShelvesByAreaId(String areaId);

    public void updateShelf(Shelf shelf);

    public void deleteShelfById(String shelfId);

    public List<Shelf> findShelvesByCriteria(String areaId, Map<String, Map<String, String>> filterCriteriaMap);

//    public List<Shelf> findShelvesByCriteria(Map<String, Map<String, String>> filterCriteriaMap);
}
