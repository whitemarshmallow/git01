package com.ctclri.agv.backend.restfulAPI.service.impl;


import com.ctclri.agv.backend.restfulAPI.mapper.ShelfMapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Shelf;

import com.ctclri.agv.backend.restfulAPI.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfMapper shelfMapper;

//    public List<Shelf> findShelvesByCriteria(String filterCriteria, String filterValue) {
//        return shelfMapper.findByCriteria(filterCriteria, filterValue);
//    }
    public void saveShelf(Shelf shelf) {
        shelfMapper.insert(shelf);
    }

//    public List<Shelf> getShelvesByAreaId(String areaId) {
//        return shelfMapper.findByAreaId(areaId);
//    }
public List<Shelf> getShelvesByAreaId(String areaId) {
    List<Shelf> shelves = shelfMapper.findByAreaId(areaId);
    // 重新格式化shelfStartPos以包含ori_x和ori_y
    shelves.forEach(shelf -> {
        String formattedStartPos = String.format("[%.6f,%.6f]", shelf.getOriX(), shelf.getOriY());
        shelf.setShelfStartPos(formattedStartPos);
    });
    return shelves;
}





    public void updateShelf(Shelf shelf) {
        shelfMapper.update(shelf);
    }

    public void deleteShelfById(String shelfId) {
        shelfMapper.deleteById(shelfId);
    }

//    public List<Shelf> findShelvesByCriteria(Map<String, Map<String, String>> filterCriteriaMap) {
//        return shelfMapper.findByCriteria(filterCriteriaMap);
//    }
    public List<Shelf> findShelvesByCriteria(String areaId, Map<String, Map<String, String>> filterCriteriaMap) {
        return shelfMapper.findByCriteria(areaId, filterCriteriaMap);
    }

}
