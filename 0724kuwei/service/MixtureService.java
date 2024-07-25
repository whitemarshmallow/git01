package com.ctclri.agv.backend.restfulAPI.service;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Mixture;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.MixtureInventory;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;

import java.util.List;
import java.util.Map;

public interface MixtureService {

    public void saveMixture(Mixture mixture);

    public List<Mixture> getMixturesByAreaId(String areaId);

    public void updateMixture(Mixture mixture);

    public void deleteMixtureById(String mixtureId);

    public List<Mixture> findMixturesByCriteria(String areaId, Map<String, Map<String, String>> filterCriteriaMap);

    List<MixtureInventory> findAvailableMixturePositions(String areaId, String mixtureId);

//    public List<Mixture> findMixturesByCriteria(Map<String, Map<String, String>> filterCriteriaMap);
//    public List<Mixture> findMixturesByCriteria(String filterCriteria, String filterValue);
}
