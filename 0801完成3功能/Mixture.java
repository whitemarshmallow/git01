package com.ctclri.agv.backend.restfulAPI.pojo.Warehouse;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Mixture {

       //新增参数
    private String mixtureId;          // 唯一标识
    private String areaId;             // 区域ID
    private String mixtureName;        // 组合货架名称
    private String mixtureModel;       // 组合货架模型ID
    private float mixtureLength;       // 长度
    private float mixtureWidth;        // 宽度
    private float mixtureHeight;       // 高度
    private int mixtureLayer;          // 层数
    private int mixtureColumn;         // 列数
    private int mixtureCapacity;       // 容量
    private String mixturePerLayer;
    private String mixtureBindNode;    // 绑定站点
    private String mixtureStartPos;    // 入场位置
    private boolean enableDisable;     // 启用/禁用
    private boolean lockUnlock;        // 解锁/锁定

    @JsonIgnore
    private float oriX; // 新字段
    @JsonIgnore
    private float oriY; // 新字段

    public Mixture() {
    }

    public Mixture(String mixtureId, String areaId, String mixtureName, String mixtureModel, float mixtureLength, float mixtureWidth, float mixtureHeight, int mixtureLayer, int mixtureColumn, int mixtureCapacity, String mixturePerLayer, String mixtureBindNode, String mixtureStartPos, boolean enableDisable, boolean lockUnlock, float oriX, float oriY) {
        this.mixtureId = mixtureId;
        this.areaId = areaId;
        this.mixtureName = mixtureName;
        this.mixtureModel = mixtureModel;
        this.mixtureLength = mixtureLength;
        this.mixtureWidth = mixtureWidth;
        this.mixtureHeight = mixtureHeight;
        this.mixtureLayer = mixtureLayer;
        this.mixtureColumn = mixtureColumn;
        this.mixtureCapacity = mixtureCapacity;
        this.mixturePerLayer = mixturePerLayer;
        this.mixtureBindNode = mixtureBindNode;
        this.mixtureStartPos = mixtureStartPos;
        this.enableDisable = enableDisable;
        this.lockUnlock = lockUnlock;
        this.oriX = oriX;
        this.oriY = oriY;
    }

    public String getMixtureId() {
        return mixtureId;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getMixtureName() {
        return mixtureName;
    }

    public String getMixtureModel() {
        return mixtureModel;
    }

    public float getMixtureLength() {
        return mixtureLength;
    }

    public float getMixtureWidth() {
        return mixtureWidth;
    }

    public float getMixtureHeight() {
        return mixtureHeight;
    }

    public int getMixtureLayer() {
        return mixtureLayer;
    }

    public int getMixtureColumn() {
        return mixtureColumn;
    }

    public int getMixtureCapacity() {
        return mixtureCapacity;
    }

    public String getMixtureBindNode() {
        return mixtureBindNode;
    }

    public String getMixtureStartPos() {
        return mixtureStartPos;
    }

    public boolean isEnableDisable() {
        return enableDisable;
    }

    public boolean isLockUnlock() {
        return lockUnlock;
    }

    public void setMixtureId(String mixtureId) {
        this.mixtureId = mixtureId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setMixtureName(String mixtureName) {
        this.mixtureName = mixtureName;
    }

    public void setMixtureModel(String mixtureModel) {
        this.mixtureModel = mixtureModel;
    }

    public void setMixtureLength(float mixtureLength) {
        this.mixtureLength = mixtureLength;
    }

    public void setMixtureWidth(float mixtureWidth) {
        this.mixtureWidth = mixtureWidth;
    }

    public void setMixtureHeight(float mixtureHeight) {
        this.mixtureHeight = mixtureHeight;
    }

    public void setMixtureLayer(int mixtureLayer) {
        this.mixtureLayer = mixtureLayer;
    }

    public void setMixtureColumn(int mixtureColumn) {
        this.mixtureColumn = mixtureColumn;
    }

    public void setMixtureCapacity(int mixtureCapacity) {
        this.mixtureCapacity = mixtureCapacity;
    }

    public void setMixtureBindNode(String mixtureBindNode) {
        this.mixtureBindNode = mixtureBindNode;
    }

    public void setMixtureStartPos(String mixtureStartPos) {
        this.mixtureStartPos = mixtureStartPos;
    }

    public void setEnableDisable(boolean enableDisable) {
        this.enableDisable = enableDisable;
    }

    public void setLockUnlock(boolean lockUnlock) {
        this.lockUnlock = lockUnlock;
    }

    public String getMixturePerLayer() {
        return mixturePerLayer;
    }

    public void setMixturePerLayer(String mixturePerLayer) {
        this.mixturePerLayer = mixturePerLayer;
    }

    public float getOriX() {
        return oriX;
    }

    public float getOriY() {
        return oriY;
    }

    public void setOriX(float oriX) {
        this.oriX = oriX;
    }

    public void setOriY(float oriY) {
        this.oriY = oriY;
    }

    @Override
    public String toString() {
        return "Mixture{" +
                "mixtureId='" + mixtureId + '\'' +
                ", areaId='" + areaId + '\'' +
                ", mixtureName='" + mixtureName + '\'' +
                ", mixtureModel='" + mixtureModel + '\'' +
                ", mixtureLength=" + mixtureLength +
                ", mixtureWidth=" + mixtureWidth +
                ", mixtureHeight=" + mixtureHeight +
                ", mixtureLayer=" + mixtureLayer +
                ", mixtureColumn=" + mixtureColumn +
                ", mixtureCapacity=" + mixtureCapacity +
                ", mixturePerLayer='" + mixturePerLayer + '\'' +
                ", mixtureBindNode='" + mixtureBindNode + '\'' +
                ", mixtureStartPos='" + mixtureStartPos + '\'' +
                ", enableDisable=" + enableDisable +
                ", lockUnlock=" + lockUnlock +
                ", oriX=" + oriX +
                ", oriY=" + oriY +
                '}';
    }
}
