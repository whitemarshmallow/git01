package com.ctclri.agv.backend.restfulAPI.pojo.Warehouse;

public class Shelf {
    private String shelfId; // 唯一标识
    private String areaId; // 区域ID
    private String shelfName; // 货架名称
    private String shelfModel; // 对应的货架模型的ID
    private float shelfLength; // 货架长度
    private float shelfWidth; // 货架宽度
    private float shelfHeight; // 货架高度
    private int shelfLayer; // 层
    private int shelfColumn; // 列
    private int shelfCapacity; // 容量
    private String shelfBindNode; // 绑定站点
    private String shelfStartPos; // 入场位置
    private String shelfCurrentPos; // 当前位置
    private boolean enableDisable; // 启用/禁用
    private boolean lockUnlock; // 解锁/锁定

    public Shelf() {
    }

    public Shelf(String shelfId, String areaId, String shelfName, String shelfModel, float shelfLength, float shelfWidth, float shelfHeight, int shelfLayer, int shelfColumn, int shelfCapacity, String shelfBindNode, String shelfStartPos, String shelfCurrentPos, boolean enableDisable, boolean lockUnlock) {
        this.shelfId = shelfId;
        this.areaId = areaId;
        this.shelfName = shelfName;
        this.shelfModel = shelfModel;
        this.shelfLength = shelfLength;
        this.shelfWidth = shelfWidth;
        this.shelfHeight = shelfHeight;
        this.shelfLayer = shelfLayer;
        this.shelfColumn = shelfColumn;
        this.shelfCapacity = shelfCapacity;
        this.shelfBindNode = shelfBindNode;
        this.shelfStartPos = shelfStartPos;
        this.shelfCurrentPos = shelfCurrentPos;
        this.enableDisable = enableDisable;
        this.lockUnlock = lockUnlock;
    }

    public String getShelfId() {
        return shelfId;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public String getShelfModel() {
        return shelfModel;
    }

    public float getShelfLength() {
        return shelfLength;
    }

    public float getShelfWidth() {
        return shelfWidth;
    }

    public float getShelfHeight() {
        return shelfHeight;
    }

    public int getShelfLayer() {
        return shelfLayer;
    }

    public int getShelfColumn() {
        return shelfColumn;
    }

    public int getShelfCapacity() {
        return shelfCapacity;
    }

    public String getShelfBindNode() {
        return shelfBindNode;
    }

    public String getShelfStartPos() {
        return shelfStartPos;
    }

    public String getShelfCurrentPos() {
        return shelfCurrentPos;
    }

    public boolean isEnableDisable() {
        return enableDisable;
    }

    public boolean isLockUnlock() {
        return lockUnlock;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public void setShelfModel(String shelfModel) {
        this.shelfModel = shelfModel;
    }

    public void setShelfLength(float shelfLength) {
        this.shelfLength = shelfLength;
    }

    public void setShelfWidth(float shelfWidth) {
        this.shelfWidth = shelfWidth;
    }

    public void setShelfHeight(float shelfHeight) {
        this.shelfHeight = shelfHeight;
    }

    public void setShelfLayer(int shelfLayer) {
        this.shelfLayer = shelfLayer;
    }

    public void setShelfColumn(int shelfColumn) {
        this.shelfColumn = shelfColumn;
    }

    public void setShelfCapacity(int shelfCapacity) {
        this.shelfCapacity = shelfCapacity;
    }

    public void setShelfBindNode(String shelfBindNode) {
        this.shelfBindNode = shelfBindNode;
    }

    public void setShelfStartPos(String shelfStartPos) {
        this.shelfStartPos = shelfStartPos;
    }

    public void setShelfCurrentPos(String shelfCurrentPos) {
        this.shelfCurrentPos = shelfCurrentPos;
    }

    public void setEnableDisable(boolean enableDisable) {
        this.enableDisable = enableDisable;
    }

    public void setLockUnlock(boolean lockUnlock) {
        this.lockUnlock = lockUnlock;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfId=" + shelfId +
                ", areaId='" + areaId + '\'' +
                ", shelfName='" + shelfName + '\'' +
                ", shelfModel='" + shelfModel + '\'' +
                ", shelfLength=" + shelfLength +
                ", shelfWidth=" + shelfWidth +
                ", shelfHeight=" + shelfHeight +
                ", shelfLayer=" + shelfLayer +
                ", shelfColumn=" + shelfColumn +
                ", shelfCapacity=" + shelfCapacity +
                ", shelfBindNode='" + shelfBindNode + '\'' +
                ", shelfStartPos='" + shelfStartPos + '\'' +
                ", shelfCurrentPos='" + shelfCurrentPos + '\'' +
                ", enableDisable=" + enableDisable +
                ", lockUnlock=" + lockUnlock +
                '}';
    }
}
