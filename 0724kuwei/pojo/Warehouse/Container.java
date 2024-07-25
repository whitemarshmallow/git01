package com.ctclri.agv.backend.restfulAPI.pojo.Warehouse;

public class Container {

    private String modelId;         // 唯一标识
    private String modelName;     // 可能为空
    private String modelType;     // 货架模型/托盘模型/组合模型
    private float modelLength;    // 正实数：整数/一位小数/两位小数
    private float modelWidth;     // 正实数：整数/一位小数/两位小数
    private float modelHeight;    // 正实数：整数/一位小数/两位小数
    private int modelLayer;       // 正整数
    private int modelColumn;      // 正整数


    public Container() {
    }

    public Container(String modelId, String modelName, String modelType, float modelLength, float modelWidth, float modelHeight, int modelLayer, int modelColumn) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelType = modelType;
        this.modelLength = modelLength;
        this.modelWidth = modelWidth;
        this.modelHeight = modelHeight;
        this.modelLayer = modelLayer;
        this.modelColumn = modelColumn;
    }

    public String getModelId() {
        return modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public float getModelLength() {
        return modelLength;
    }

    public float getModelWidth() {
        return modelWidth;
    }

    public float getModelHeight() {
        return modelHeight;
    }

    public int getModelLayer() {
        return modelLayer;
    }

    public int getModelColumn() {
        return modelColumn;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

//    public void setModelType(String modelType) {
//        this.modelType = modelType;
//    }

    public void setModelLength(float modelLength) {
        this.modelLength = modelLength;
    }

    public void setModelWidth(float modelWidth) {
        this.modelWidth = modelWidth;
    }

    public void setModelHeight(float modelHeight) {
        this.modelHeight = modelHeight;
    }

    public void setModelLayer(int modelLayer) {
        this.modelLayer = modelLayer;
    }

    public void setModelColumn(int modelColumn) {
        this.modelColumn = modelColumn;
    }

    @Override
    public String toString() {
        return "Container{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", modelType='" + modelType + '\'' +
                ", modelLength=" + modelLength +
                ", modelWidth=" + modelWidth +
                ", modelHeight=" + modelHeight +
                ", modelLayer=" + modelLayer +
                ", modelColumn=" + modelColumn +
                '}';
    }
}
