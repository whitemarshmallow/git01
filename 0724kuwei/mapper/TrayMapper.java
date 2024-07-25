package com.ctclri.agv.backend.restfulAPI.mapper;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Tray;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TrayMapper {

    @Insert("INSERT INTO tray (trayId, areaId, trayName, trayModel, trayLength, trayWidth, trayHeight, trayBindNode, trayStartPos, trayCurrentPos, enableDisable, lockUnlock) " +
            "VALUES (#{trayId}, #{areaId}, #{trayName}, #{trayModel}, #{trayLength}, #{trayWidth}, #{trayHeight}, #{trayBindNode}, #{trayStartPos}, #{trayCurrentPos}, #{enableDisable}, #{lockUnlock})")
    void insert(Tray tray);

    @Select("SELECT * FROM tray WHERE areaId = #{areaId}")
    List<Tray> findByAreaId(String areaId);

    @Update("UPDATE tray SET areaId=#{areaId}, trayName=#{trayName}, trayModel=#{trayModel}, trayLength=#{trayLength}, trayWidth=#{trayWidth}, trayHeight=#{trayHeight}, " +
            "trayBindNode=#{trayBindNode}, trayStartPos=#{trayStartPos}, trayCurrentPos=#{trayCurrentPos}, enableDisable=#{enableDisable}, lockUnlock=#{lockUnlock} WHERE trayId=#{trayId}")
    void update(Tray tray);

    @Delete("DELETE FROM tray WHERE trayId = #{trayId}")
    void deleteById(String trayId);

//    @Select("<script>" +
//            "SELECT * FROM tray " +
//            "WHERE " +
//            "<choose>" +
//            "<when test='filterCriteria == \"trayId\"'>" +
//            "trayId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"areaId\"'>" +
//            "areaId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayName\"'>" +
//            "trayName = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayModel\"'>" +
//            "trayModel = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayLength\"'>" +
//            "trayLength = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayWidth\"'>" +
//            "trayWidth = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayHeight\"'>" +
//            "trayHeight = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayBindNode\"'>" +
//            "trayBindNode = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayStartPos\"'>" +
//            "trayStartPos = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"trayCurrentPos\"'>" +
//            "trayCurrentPos = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"enableDisable\"'>" +
//            "enableDisable = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"lockUnlock\"'>" +
//            "lockUnlock = #{filterValue}" +
//            "</when>" +
//            "</choose>" +
//            "</script>")
//    List<Tray> findByCriteria(@Param("filterCriteria") String filterCriteria, @Param("filterValue") String filterValue);

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
}

//    @Select("<script>" +
//            "SELECT * FROM tray " +
//            "<where> " +
//            "<foreach item='criteria' index='key' collection='filterCriteriaMap' separator='AND'>" +
//            " BINARY ${criteria.filterCriteria} = BINARY #{criteria.filterValue} " +
//            "</foreach>" +
//            "</where>" +
//            "</script>")
//    List<Tray> findByCriteria(@Param("filterCriteriaMap") Map<String, Map<String, String>> filterCriteriaMap);


