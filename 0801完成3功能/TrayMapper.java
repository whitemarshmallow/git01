package com.ctclri.agv.backend.restfulAPI.mapper;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Mixture;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.NodeData;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Shelf;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Tray;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TrayMapper {

    @Insert("INSERT INTO tray (trayId, areaId, trayName, trayModel, trayLength, trayWidth, trayHeight, trayBindNode, trayStartPos, trayCurrentPos, enableDisable, lockUnlock) " +
            "VALUES (#{trayId}, #{areaId}, #{trayName}, #{trayModel}, #{trayLength}, #{trayWidth}, #{trayHeight}, #{trayBindNode}, #{trayStartPos}, #{trayCurrentPos}, #{enableDisable}, #{lockUnlock})")
    void insert(Tray tray);

//    @Select("SELECT * FROM tray WHERE areaId = #{areaId}")
//    List<Tray> findByAreaId(String areaId);

//    @Select("SELECT s.*, n.ori_x, n.ori_y FROM tray s " +
//            "JOIN smap_nodes_data n ON s.trayBindNode = n.instance_name AND s.areaId = n.area_id " +
//            "WHERE s.areaId = #{areaId}")
//    List<Tray> findByAreaId(String areaId);


    @Update("UPDATE tray SET areaId=#{areaId}, trayName=#{trayName}, trayModel=#{trayModel}, trayLength=#{trayLength}, trayWidth=#{trayWidth}, trayHeight=#{trayHeight}, " +
            "trayBindNode=#{trayBindNode}, trayStartPos=#{trayStartPos}, trayCurrentPos=#{trayCurrentPos}, enableDisable=#{enableDisable}, lockUnlock=#{lockUnlock} WHERE trayId=#{trayId}")
    void update(Tray tray);

    @Delete("DELETE FROM tray WHERE trayId = #{trayId}")
    void deleteById(String trayId);

//

    @Select("<script>" +
            "SELECT * FROM tray " +
            "<where> " +
            "areaId = #{areaId} " +
            "<foreach item='criteria' index='key' collection='filterCriteriaMap' open=' AND ' separator=' AND ' close=''>" +
            " <if test='criteria != null and criteria.filterValue != null'>" +
            " BINARY ${criteria.filterCriteria} = BINARY #{criteria.filterValue} " +
            " </if>" +
            "</foreach>" +
            "</where>" +
            "</script>")
    List<Tray> findByCriteria(@Param("areaId") String areaId, @Param("filterCriteriaMap") Map<String, Map<String, String>> filterCriteriaMap);




    //ori_x和ori_y增加
//    @Select("SELECT s.*, n.ori_x, n.ori_y FROM tray s " +
//            "JOIN smap_nodes_data n ON s.trayBindNode = n.instance_name AND s.areaId =n.area_id" +
//            "WHERE s.areaId = #{areaId}")
//    List<Tray> findByAreaIdSimple(String areaId);

    @Select("SELECT s.*, n.ori_x, n.ori_y FROM tray s " +
            "LEFT JOIN smap_nodes_data n ON s.trayBindNode = n.instance_name AND s.areaId = n.area_id " +
            "WHERE s.areaId = #{areaId}")
    List<Tray> findByAreaIdSimple(String areaId);


//    @Select("SELECT n.instance_name, n.ori_x, n.ori_y " +
//            "FROM mixture m " +
//            "JOIN smap_nodes_data n ON JSON_CONTAINS(m.mixtureBindNode, CONCAT('\"', n.instance_name, '\"'), '$') " +
//            "WHERE m.mixtureId = #{mixtureId}")
//    List<NodeData> findNodeDataByMixtureId(String mixtureId);


    //这段代码的目的是给出mixtureId和areaID,找出smap表中对应的ori_x和ori_y
    @Select("SELECT n.instance_name, n.ori_x, n.ori_y " +
            "FROM mixture m " +
            "JOIN smap_nodes_data n ON JSON_CONTAINS(m.mixtureBindNode, CONCAT('\"', n.instance_name, '\"'), '$') " +
            "WHERE m.mixtureId = #{mixtureId} AND n.area_id = #{areaId}")
    List<NodeData> findNodeDataByMixtureIdAndAreaId(@Param("mixtureId") String mixtureId, @Param("areaId") String areaId);



}







