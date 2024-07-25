package com.ctclri.agv.backend.restfulAPI.mapper;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Mixture;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MixtureMapper {

//    @Insert("INSERT INTO mixture (areaId, mixtureName, mixtureModel, mixtureLength, mixtureWidth, mixtureHeight, mixtureLayer, mixtureColumn, mixtureCapacity, mixtureBindNode, mixtureStartPos, enableDisable, lockUnlock) " +
//            "VALUES (#{areaId}, #{mixtureName}, #{mixtureModel}, #{mixtureLength}, #{mixtureWidth}, #{mixtureHeight}, #{mixtureLayer}, #{mixtureColumn}, #{mixtureCapacity}, #{mixtureBindNode}, #{mixtureStartPos}, #{enableDisable}, #{lockUnlock})")
//    @Options(useGeneratedKeys = true, keyProperty = "mixtureId")
//    void insert(Mixture mixture);

    @Insert("INSERT INTO mixture (areaId, mixtureName, mixtureModel, mixtureLength, mixtureWidth, mixtureHeight, mixtureLayer, mixtureColumn, mixtureCapacity, mixtureBindNode, mixtureStartPos, mixturePerLayer, enableDisable, lockUnlock) " +
            "VALUES (#{areaId}, #{mixtureName}, #{mixtureModel}, #{mixtureLength}, #{mixtureWidth}, #{mixtureHeight}, #{mixtureLayer}, #{mixtureColumn}, #{mixtureCapacity}, #{mixtureBindNode}, #{mixtureStartPos}, #{mixturePerLayer}, #{enableDisable}, #{lockUnlock})")
    @Options(useGeneratedKeys = true, keyProperty = "mixtureId")
    void insert(Mixture mixture);



    @Select("SELECT * FROM mixture WHERE areaId = #{areaId}")
    List<Mixture> findByAreaId(String areaId);

//    @Update("UPDATE mixture SET areaId=#{areaId}, mixtureName=#{mixtureName}, mixtureModel=#{mixtureModel}, mixtureLength=#{mixtureLength}, mixtureWidth=#{mixtureWidth}, mixtureHeight=#{mixtureHeight}, " +
//            "mixtureLayer=#{mixtureLayer}, mixtureColumn=#{mixtureColumn}, mixtureCapacity=#{mixtureCapacity}, mixtureBindNode=#{mixtureBindNode}, mixtureStartPos=#{mixtureStartPos}, enableDisable=#{enableDisable}, lockUnlock=#{lockUnlock} WHERE mixtureId=#{mixtureId}")
//    void update(Mixture mixture);

    @Update("UPDATE mixture SET areaId=#{areaId}, mixtureName=#{mixtureName}, mixtureModel=#{mixtureModel}, mixtureLength=#{mixtureLength}, mixtureWidth=#{mixtureWidth}, mixtureHeight=#{mixtureHeight}, " +
            "mixtureLayer=#{mixtureLayer}, mixtureColumn=#{mixtureColumn}, mixtureCapacity=#{mixtureCapacity}, mixtureBindNode=#{mixtureBindNode}, mixtureStartPos=#{mixtureStartPos}, mixturePerLayer=#{mixturePerLayer}, enableDisable=#{enableDisable}, lockUnlock=#{lockUnlock} WHERE mixtureId=#{mixtureId}")
    void update(Mixture mixture);


    @Delete("DELETE FROM mixture WHERE mixtureId = #{mixtureId}")
    void deleteById(String mixtureId);

    @Select("<script>" +
            "SELECT * FROM mixture " +
            "<where> " +
            "areaId = #{areaId} " +
            "<foreach item='criteria' index='key' collection='filterCriteriaMap' open=' AND ' separator=' AND ' close=''>" +
            " <if test='criteria != null and criteria.filterValue != null'>" +
            " BINARY ${criteria.filterCriteria} = BINARY #{criteria.filterValue} " +
            " </if>" +
            "</foreach>" +
            "</where>" +
            "</script>")
    List<Mixture> findByCriteria(@Param("areaId") String areaId, @Param("filterCriteriaMap") Map<String, Map<String, String>> filterCriteriaMap);


    @Select("SELECT mixtureName FROM mixture WHERE areaId = #{areaId} AND mixtureId = #{mixtureId}")
    String getMixtureName(String areaId, String mixtureId);

    // 更新SQL查询，以正确解析位置信息
    @Select("SELECT SUBSTRING(trayBindNode, LOCATE('/', trayBindNode) + 1) FROM tray WHERE areaId = #{areaId} AND SUBSTRING_INDEX(trayBindNode, '/', 1) = #{mixtureId}")
    List<String> getUsedPositions(String areaId, String mixtureId);

    @Select("SELECT mixtureName, mixtureStartPos, mixturePerLayer FROM mixture WHERE areaId = #{areaId} AND mixtureId = #{mixtureId}")
    Mixture getMixtureInfo(String areaId, String mixtureId);

//无areaID查询成功版
//    @Select("<script>" +
//            "SELECT * FROM mixture " +
//            "<where> " +
//            "<foreach item='criteria' index='key' collection='filterCriteriaMap' separator='AND'>" +
//            " BINARY ${criteria.filterCriteria} = BINARY #{criteria.filterValue} " +
//            "</foreach>" +
//            "</where>" +
//            "</script>")
//    List<Mixture> findByCriteria(@Param("filterCriteriaMap") Map<String, Map<String, String>> filterCriteriaMap);

//    @Select("<script>" +
//            "SELECT * FROM mixture " +
//            "WHERE " +
//            "<choose>" +
//            "<when test='filterCriteria == \"mixtureId\"'>" +
//            "mixtureId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"areaId\"'>" +
//            "areaId = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureName\"'>" +
//            "mixtureName = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureModel\"'>" +
//            "mixtureModel = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureLength\"'>" +
//            "mixtureLength = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureWidth\"'>" +
//            "mixtureWidth = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureHeight\"'>" +
//            "mixtureHeight = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureLayer\"'>" +
//            "mixtureLayer = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureColumn\"'>" +
//            "mixtureColumn = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureCapacity\"'>" +
//            "mixtureCapacity = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureBindNode\"'>" +
//            "mixtureBindNode = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"mixtureStartPos\"'>" +
//            "mixtureStartPos = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"enableDisable\"'>" +
//            "enableDisable = #{filterValue}" +
//            "</when>" +
//            "<when test='filterCriteria == \"lockUnlock\"'>" +
//            "lockUnlock = #{filterValue}" +
//            "</when>" +
//            "</choose>" +
//            "</script>")
//    List<Mixture> findByCriteria(@Param("filterCriteria") String filterCriteria, @Param("filterValue") String filterValue);



}
