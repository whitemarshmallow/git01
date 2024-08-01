package com.ctclri.agv.backend.restfulAPI.mapper;

import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Mixture;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.NodeData;
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


    //ori_x和ori_y最新版

    /**
     * 根据 areaId 查询所有相关的 Mixture 记录。
     * @param areaId 区域ID
     * @return 返回所有匹配的 Mixture 对象列表。
     */
    @Select("SELECT * FROM mixture WHERE areaId = #{areaId}")
    List<Mixture> findMixturesByAreaId(String areaId);

    /**
     * 根据一组实例名称查询 smap_nodes_data 表中的节点数据。
     * @param instanceNames 实例名称列表,即LM7,LM8等
     * @return 返回所有匹配的 NodeData 对象列表。即LM7,LM8加上他们对应的坐标
     */
    @Select("<script>" +
            "SELECT * FROM smap_nodes_data " +
            "WHERE instance_name IN " +
            "<foreach item='item' collection='list' open='(' separator=',' close=')'>" +
            "#{item}" +
            "</foreach> " +
            "AND area_id = #{areaId}" +
            "</script>")
    List<NodeData> findNodeDataByInstanceNamesAndAreaId(@Param("list") List<String> instanceNames, @Param("areaId") String areaId);







//
//    @Select("SELECT * FROM mixture WHERE areaId = #{areaId}")
//    List<Mixture> findByAreaId(String areaId);






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


    //ori_x和ori_y的查询




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
