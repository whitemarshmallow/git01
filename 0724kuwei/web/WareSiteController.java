package com.ctclri.agv.backend.restfulAPI.web;


import com.ctclri.agv.backend.restfulAPI.pojo.Result;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;
import com.ctclri.agv.backend.restfulAPI.service.WareSiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class WareSiteController {

    @Autowired
    private WareSiteService siteService;

    @GetMapping("/api/container/getPointInv")
    public Result getUnboundSiteInventories(@RequestParam String areaId) {
        List<Waresite> unboundSites = siteService.findUnboundSiteInventories(areaId);
        return Result.success(unboundSites);
    }


}
