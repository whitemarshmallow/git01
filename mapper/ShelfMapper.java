package com.ctclri.agv.backend.restfulAPI.mapper;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Shelf;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

//testgit02

@Mapper
public interface ShelfMapper {

    @Insert("INSERT INTO shelf (areaId, shelfName, shelfModel, shelfLength, shelfWidth, shelfHeight, shelfLayer, shelfColumn, shelfCapacity, shelfBindNode, shelfStartPos, shelfCurrentPos, enableDisable, lockUnlock) " +
            "VALUES (#{areaId}, #{shelfName}, #{shelfModel}, #{shelfLength}, #{shelfWidth}, #{shelfHeight}, #{shelfLayer}, #{shelfColumn}, #{shelfCapacity}, #{shelfBindNode}, #{shelfStartPos}, #{shelfCurrentPos}, #{enableDisable}, #{lockUnlock})")
    void insert(Shelf shelf);

    @Select("SELECT * FROM shelf WHERE areaId = #{areaId}")
    List<Shelf> findByAreaId(String areaId);

    @Update("UPDATE shelf SET areaId=#{areaId}, shelfName=#{shelfName}, shelfModel=#{shelfModel}, shelfLength=#{shelfLength}, shelfWidth=#{shelfWidth}, shelfHeight=#{shelfHeight}, " +
            "shelfLayer=#{shelfLayer}, shelfColumn=#{shelfColumn}, shelfCapacity=#{shelfCapacity}, shelfBindNode=#{shelfBindNode}, shelfStartPos=#{shelfStartPos}, shelfCurrentPos=#{shelfCurrentPos}, " +
            "enableDisable=#{enableDisable}, lockUnlock=#{lockUnlock} WHERE shelfId=#{shelfId}")
    void update(Shelf shelf);

    @Delete("DELETE FROM shelf WHERE shelfId = #{shelfId}")
    void deleteById(String shelfId);

    @Select("SELECT * FROM shelf WHERE shelfModel = #{shelfModel}")
    List<Shelf> findByModel(String shelfModel);


    @Select("<script>" +
            "SELECT * FROM shelf " +
            "<where> " +
            "<foreach item='criteria' index='key' collection='filterCriteriaMap' separator='AND'>" +
            " BINARY ${criteria.filterCriteria} = BINARY #{criteria.filterValue} " +
            "</foreach>" +
            "</where>" +
            "</script>")
    List<Shelf> findByCriteria(@Param("filterCriteriaMap") Map<String, Map<String, String>> filterCriteriaMap);

//    @Select("<script>" +
//            "SELECT * FROM shelf " +
//            "WHERE " +
//            "<choose>" +
//            "<when test='filterCriteria == \"shelfId\"'>" +
//            "shelfId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"areaId\"'>" +
//            "areaId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfName\"'>" +
//            "shelfName = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfModel\"'>" +
//            "shelfModel = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfLength\"'>" +
//            "shelfLength = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfWidth\"'>" +
//            "shelfWidth = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfHeight\"'>" +
//            "shelfHeight = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfLayer\"'>" +
//            "shelfLayer = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfColumn\"'>" +
//            "shelfColumn = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfCapacity\"'>" +
//            "shelfCapacity = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfBindNode\"'>" +
//            "shelfBindNode = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfStartPos\"'>" +
//            "shelfStartPos = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"shelfCurrentPos\"'>" +
//            "shelfCurrentPos = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"enableDisable\"'>" +
//            "enableDisable = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"lockUnlock\"'>" +
//            "lockUnlock = #{filterValue}" +
//            "</when>" +
//            "</choose>" +
//            "</script>")
//    List<Shelf> findByCriteria(@Param("filterCriteria") String filterCriteria, @Param("filterValue") String filterValue);
}

