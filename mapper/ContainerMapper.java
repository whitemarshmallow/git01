package com.ctclri.agv.backend.restfulAPI.mapper;


import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContainerMapper {

    @Select("SELECT * FROM container")
    List<Container> getAllContainers();

    @Select("SELECT * FROM container WHERE modelId = #{modelId}")
    Container findById(String modelId);

    @Insert("INSERT INTO container (modelName, modelType, modelLength, modelWidth, modelHeight, modelLayer, modelColumn) " +
            "VALUES (#{modelName}, #{modelType}, #{modelLength}, #{modelWidth}, #{modelHeight}, #{modelLayer}, #{modelColumn})")
    void insert(Container container);

    @Update("UPDATE container SET modelName=#{modelName}, modelType=#{modelType}, modelLength=#{modelLength}, modelWidth=#{modelWidth}, modelHeight=#{modelHeight}, " +
            "modelLayer=#{modelLayer}, modelColumn=#{modelColumn} WHERE modelId=#{modelId}")
    void update(Container container);

    @Delete("DELETE FROM container WHERE modelId=#{modelId}")
    void deleteById(String modelId);

//    @Select("<script>" +
//            "SELECT * FROM container " +
//            "WHERE " +
//            "<choose>" +
//            "<when test='filterCriteria == \"modelId\"'>" +
//            "modelId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelName\"'>" +
//            "modelName = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelType\"'>" +
//            "modelType = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelLength\"'>" +
//            "modelLength = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelWidth\"'>" +
//            "modelWidth = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelHeight\"'>" +
//            "modelHeight = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelLayer\"'>" +
//            "modelLayer = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"modelColumn\"'>" +
//            "modelColumn = #{filterValue}" +
//            "</when>" +
//            "</choose>" +
//            "</script>")
//    List<Container> findByCriteria(@Param("filterCriteria") String filterCriteria, @Param("filterValue") String filterValue);

    @Select("<script>" +
            "SELECT * FROM container " +
            "<where> " +
            "<foreach item='criteria' index='key' collection='filterCriteriaMap' separator='AND'>" +
            " BINARY ${criteria.filterCriteria} = BINARY #{criteria.filterValue} " +
            "</foreach>" +
            "</where>" +
            "</script>")
    List<Container> findByCriteria(@Param("filterCriteriaMap") Map<String, Map<String, String>> filterCriteriaMap);
}
