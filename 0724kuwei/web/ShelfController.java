package com.ctclri.agv.backend.restfulAPI.web;

import com.ctclri.agv.backend.restfulAPI.pojo.Result;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Container;
import com.ctclri.agv.backend.restfulAPI.pojo.Warehouse.Shelf;

import com.ctclri.agv.backend.restfulAPI.service.ShelfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ShelfController {

//    private static Shelf shelfex;
//    // 构造函数 - 固定值
//    public static void createShelf() {
//        shelfex = new Shelf();
//        shelfex.setShelfId(21L);
//        shelfex.setAreaId("1");
//        shelfex.setShelfName("Test Shelf2");
//        shelfex.setShelfModel("Model1");
//        shelfex.setShelfLength(100.00f);
//        shelfex.setShelfWidth(50.00f);
//        shelfex.setShelfHeight(200.00f);
//        shelfex.setShelfLayer(1);
//        shelfex.setShelfColumn(1);
//        shelfex.setShelfCapacity(10);
//        shelfex.setShelfBindNode("Station 1");
//        shelfex.setShelfStartPos("x=1.234, y=5.678");
//        shelfex.setShelfCurrentPos("x=1.234, y=5.678");
//        shelfex.setEnableDisable(true);
//        shelfex.setLockUnlock(false);
//    }
//
//    // 构造函数 - 随机值
//    public static void createRandomShelf() {
//        Random random = new Random();
//        shelfex = new Shelf();
//        shelfex.setShelfId((long) (random.nextInt(100) + 1)); // 生成1到100之间的随机ID
//        shelfex.setAreaId("1");
//        shelfex.setShelfName("Test Shelf" + random.nextInt(100)); // 生成随机名称
//        shelfex.setShelfModel("Model" + random.nextInt(10)); // 生成随机模型ID
//        shelfex.setShelfLength(50.00f + random.nextFloat() * 150.00f); // 生成随机长度
//        shelfex.setShelfWidth(30.00f + random.nextFloat() * 70.00f); // 生成随机宽度
//        shelfex.setShelfHeight(100.00f + random.nextFloat() * 200.00f); // 生成随机高度
//        shelfex.setShelfLayer(random.nextInt(10) + 1); // 生成1到10之间的随机层
//        shelfex.setShelfColumn(random.nextInt(10) + 1); // 生成1到10之间的随机列
//        shelfex.setShelfCapacity(random.nextInt(20) + 1); // 生成1到20之间的随机容量
//        shelfex.setShelfBindNode("Station " + random.nextInt(10)); // 生成随机站点绑定
//        shelfex.setShelfStartPos("x=" + (random.nextDouble() * 10) + ", y=" + (random.nextDouble() * 10)); // 生成随机入场位置
//        shelfex.setShelfCurrentPos("x=" + (random.nextDouble() * 10) + ", y=" + (random.nextDouble() * 10)); // 生成随机当前位置
//        shelfex.setEnableDisable(random.nextBoolean()); // 随机启用状态
//        shelfex.setLockUnlock(random.nextBoolean()); // 随机锁定状态
//    }
    @Autowired
    private ShelfService shelfService;


    //test git

    @PostMapping("/api/container/saveShelf")
    public Result saveShelf(@RequestBody Shelf shelf) {
        shelfService.saveShelf(shelf);
        return Result.success(null);
    }

    @GetMapping("/api/container/getShelf")
//    public Result getShelves(@RequestBody String areaId) {
//        List<Shelf> shelves = shelfService.getShelvesByAreaId(areaId);
//        return Result.success(shelves);
//    }
    public Result getShelves(@RequestParam String areaId) {
        List<Shelf> shelves = shelfService.getShelvesByAreaId(areaId);
        return Result.success(shelves);
    }



    @PostMapping("/api/container/updateShelf")
    public Result updateShelf(@RequestBody Shelf shelf) {
        shelfService.updateShelf(shelf);
        return Result.success(null);
    }

    //查找某个货架
//    @GetMapping("/api/container/findShelfModel")
//    public Result findModel(@RequestBody Shelf shelf) {
//        String shelfModel = shelf.getShelfModel();
//        List<Shelf> shelves = shelfService.findShelvesByModel(shelfModel);
//        return Result.success(shelves);
//    }
//    public Result findShelfModel(@RequestParam String shelfModel) {
//        List<Shelf> shelves = shelfService.findShelvesByModel(shelfModel);
//        return Result.success(shelves);
//    }


    @DeleteMapping("/api/container/deleteShelf")
    public Result deleteModel(@RequestParam String shelfId) {
        shelfService.deleteShelfById(shelfId);
        return Result.success(null);
    }

    //查找更新
    //     查找容器模型
    @PostMapping("/api/container/findShelf")
//    public Result findShelf(@RequestBody Map<String, Map<String, String>> filterCriteriaMap) {
//        System.out.println("filterCriteriaMap: " + filterCriteriaMap);
//        List<Shelf> shelfList = shelfService.findShelvesByCriteria(filterCriteriaMap);
//        return Result.success(shelfList);
//    }

    public Result findShelf(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Request Body: " + requestBody);

        String areaId = (String) requestBody.get("areaId");
        System.out.println("Area ID: " + areaId);

        // 将新的请求体结构转换为 filterCriteriaMap
        Map<String, Map<String, String>> filterCriteriaMap = new HashMap<>();
        requestBody.forEach((key, value) -> {
            if (!key.equals("areaId") && value instanceof Map) {
                Map<String, String> criteriaMap = (Map<String, String>) value;
                filterCriteriaMap.put(key, criteriaMap);
            }
        });

        System.out.println("Filter Criteria Map: " + filterCriteriaMap);

//        // 去除请求参数的空格
//        filterCriteriaMap.forEach((key, criteria) -> {
//            if (criteria != null && criteria.get("filterValue") != null) {
//                criteria.put("filterValue", criteria.get("filterValue").trim());
//            } else {
//                System.out.println("Criteria or filterValue is null for key: " + key);
//            }
//        });

        List<Shelf> shelfList = shelfService.findShelvesByCriteria(areaId, filterCriteriaMap);
        return Result.success(shelfList);
    }

//    //外面加了一层"filterCriteriaMap"的版本，已经跑通
//    public Result findShelf(@RequestBody Map<String, Object> requestBody) {
//        System.out.println("Request Body: " + requestBody);
//
//        String areaId = (String) requestBody.get("areaId");
//        System.out.println("Area ID: " + areaId);
//
//        Map<String, Map<String, String>> filterCriteriaMap = (Map<String, Map<String, String>>) requestBody.get("filterCriteriaMap");
//        System.out.println("Filter Criteria Map: " + filterCriteriaMap);
//
//        // 去除请求参数的空格
//        filterCriteriaMap.forEach((key, criteria) -> {
//            if (criteria != null && criteria.get("filterValue") != null) {
//                criteria.put("filterValue", criteria.get("filterValue").trim());
//            } else {
//                System.out.println("Criteria or filterValue is null for key: " + key);
//            }
//        });
//
//        List<Shelf> shelfList = shelfService.findShelvesByCriteria(areaId, filterCriteriaMap);
//        return Result.success(shelfList);
//    }


//    public Result findShelf(@RequestBody Map<String, Object> requestBody) {
//        System.out.println("Request Body: " + requestBody);
//
//        String areaId = (String) requestBody.get("areaId");
//        System.out.println("Area ID: " + areaId);
//
//        // 将请求体中每个 query 转换为 filterCriteriaMap
//        Map<String, Map<String, String>> filterCriteriaMap = new HashMap<>();
//        requestBody.forEach((key, value) -> {
//            if (!key.equals("areaId") && value instanceof Map) {
//                Map<String, String> criteriaMap = (Map<String, String>) value;
//                filterCriteriaMap.put(key, criteriaMap);
//            }
//        });
//
//        System.out.println("Filter Criteria Map: " + filterCriteriaMap);
//
//        // 去除请求参数的空格
//        filterCriteriaMap.forEach((key, criteria) -> {
//            if (criteria != null && criteria.get("filterValue") != null) {
//                criteria.put("filterValue", criteria.get("filterValue").trim());
//            } else {
//                System.out.println("Criteria or filterValue is null for key: " + key);
//            }
//        });
//
//        List<Shelf> shelfList = shelfService.findShelvesByCriteria(areaId, filterCriteriaMap);
//        return Result.success(shelfList);
//    }

//    @GetMapping("/api/testHelloWorld")
//    public Result list(){
//        log.info("Hello World");
////        List<Dept> deptList= deptService.list();
////        return Result.success(deptList);
//        return Result.success("Hello World");
//    }
//
//    //查询语句
//    @GetMapping("/api/container/getModel")
//    public Result getModel(){
//        log.info("查询获取的所有货架信息");
//        List<Shelf> Shelflist=shelfService.getAllShelf();
//        return Result.success(Shelflist);
//    }
//
//    //查询某个ID的值
//    @GetMapping("/api/container/getOneModel")
//    public Result getoneModel(){
//        log.info("根据本地设定查询某个ID的货架信息");
//        long id=15;
//        Shelf shelfone=shelfService.getOneShelf(id);
//        return Result.success(shelfone);
//    }
//
//    @GetMapping("/api/container/getOneModel/{id}")
//    public Result getOneModel(@PathVariable long id) {
//        log.info("根据前端请求查询ID为 {} 的货架信息", id);
//        Shelf shelfOne = shelfService.getOneShelf(id);
//        return Result.success(shelfOne);
//    }
//
////插入/新增语句
//
//    @PostMapping("/api/container/saveModel")
////    public Result saveModel(@RequestBody Shelf shelf){}
//    public Result saveModel(){
//        log.info("根据本地信息插入货架信息");
////        ShelfController.creatshelf();
//        ShelfController.createRandomShelf();
//        shelfService.saveShelf(shelfex);
//        return Result.success(shelfex);
//    }
//
//    @PostMapping("api/container/saveModel2")
//    public Result saveModel(@RequestBody Shelf shelf) {
//        log.info("根据前端给的货架信息插入");
//        shelfService.saveShelf(shelf);
//        return Result.success(shelf);
//    }
//
//    //更新语句
//
//    @PostMapping("/api/container/updateModel")
////    public Result updateModel(@RequestBody Shelf updatedShelf) {
//    public Result updateModel() {
//        log.info("根据本地信息更新货架信息");
//        ShelfController.creatshelf();
//        shelfService.updateShelf(shelfex);
//        return Result.success(shelfex);
//    }
//
//    @PostMapping("/api/container/updateModel/{id}")
//    public Result updateModel(@PathVariable long id, @RequestBody Shelf updatedShelf) {
//        log.info("更新ID为 {} 的货架信息", id);
//        updatedShelf.setId(id);
//        shelfService.updateShelf(updatedShelf);
//        return Result.success(updatedShelf);
//    }
//
//    //删除语句
//
//    @DeleteMapping("/api/container/deleteModel")
////    public Result deleteModel(@RequestParam Long id) {
//    public Result deleteModel() {
//        log.info("删除货架信息");
//        ShelfController.creatshelf();
//        long id = shelfex.getId();
//        shelfService.deleteShelfById(id);
//        return Result.success("Shelf with ID " + id + " has been deleted.");
//    }
//
//    @DeleteMapping("/api/container/deleteModel/{id}")
//    public Result deleteModel(@PathVariable long id) {
//        log.info("删除ID为 {} 的货架信息", id);
//        shelfService.deleteShelfById(id);
//        return Result.success("Shelf with ID " + id + " has been deleted.");
//    }

}
