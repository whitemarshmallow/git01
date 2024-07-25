package com.ctclri.agv.backend.restfulAPI.service;

import com.ctclri.agv.backend.restfulAPI.mapper.WareSiteMapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public interface WareSiteService {


    public List<Waresite> findUnboundSiteInventories(String AreaId);

}
