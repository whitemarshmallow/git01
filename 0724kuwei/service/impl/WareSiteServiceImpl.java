package com.ctclri.agv.backend.restfulAPI.service.impl;

import com.ctclri.agv.backend.restfulAPI.mapper.WareSiteMapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;
import com.ctclri.agv.backend.restfulAPI.service.WareSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.mysql.cj.conf.PropertyKey.logger;

@Service
public class WareSiteServiceImpl implements WareSiteService {

//    public List<Waresite> findUnboundSiteInventories(String areaId) {
//        List<Waresite> allSites = siteMapper.selectAllSiteInventories(areaId);
//        List<String> boundSiteIds = siteMapper.selectBoundSiteIds(areaId);
//
//        return allSites.stream()
//                .filter(siteInventory -> !boundSiteIds.contains(Long.parseLong(siteInventory.getStock())))
//                .collect(Collectors.toList());
//    }
    @Autowired
    private WareSiteMapper siteMapper;

    public List<Waresite> findUnboundSiteInventories(String areaId) {
        List<Waresite> allSites = siteMapper.selectAllSiteInventories(areaId);
        List<String> boundSiteNames = siteMapper.selectBoundSiteIds(areaId);

        System.out.println("看看所有站点");
        System.out.println(allSites);
        // 打印 allSites 的详细信息
//        allSites.forEach(site -> Logger.info("Site: {}, Position: {}", site.getStock(), site.getPosition()));

        // 打印 boundSiteNames 的内容
//       Logger.info("Bound Site Names: {}", boundSiteNames);



        return allSites.stream()
                .filter(waresite -> !boundSiteNames.contains(waresite.getStock()))
                .collect(Collectors.toList());
    }





}
