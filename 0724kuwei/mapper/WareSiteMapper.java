package com.ctclri.agv.backend.restfulAPI.mapper;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Waresite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WareSiteMapper {

    @Select("SELECT instance_name AS stock, CONCAT('[', nodeLoc_x, ',', nodeLoc_y, ']') AS position " +
            "FROM smap_nodes_data WHERE area_id = #{areaId}")
    List<Waresite> selectAllSiteInventories(String areaId);



    @Select("SELECT DISTINCT bind_node_name FROM (" +
            "SELECT shelfBindNode AS bind_node_name FROM shelf WHERE areaId = #{areaId} " +
            "UNION ALL " +
            "SELECT trayBindNode AS bind_node_name FROM tray WHERE areaId = #{areaId} " +
            "UNION ALL " +
            "SELECT JSON_UNQUOTE(JSON_EXTRACT(mixtureBindNode, CONCAT('$[', numbers.i, ']'))) AS bind_node_name " +
            "FROM mixture, JSON_TABLE('[0,1,2]', '$[*]' COLUMNS(i INT PATH '$')) numbers " +
            "WHERE areaId = #{areaId}) AS bound_sites")
    List<String> selectBoundSiteIds(String areaId);

//    @Select("SELECT DISTINCT bind_node_name FROM (" +
//            "SELECT shelfBindNode AS bind_node_name FROM shelf WHERE areaId = #{areaId} " +
//            "UNION ALL " +
//            "SELECT trayBindNode AS bind_node_name FROM tray WHERE areaId = #{areaId} " +
//            "UNION ALL " +
//            "SELECT mixtureBindNode AS bind_node_name FROM mixture WHERE areaId = #{areaId}) AS bound_sites")
//    List<String> selectBoundSiteIds(String areaId);


}
