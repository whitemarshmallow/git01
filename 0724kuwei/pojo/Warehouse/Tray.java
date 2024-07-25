package com.ctclri.agv.backend.restfulAPI.pojo.Warehouse;

public class Tray {
    private String trayId;          // 唯一标识
    private String areaId;          // 区域ID
    private String trayName;        // 托盘名称
    private String trayModel;       // 托盘模型ID
    private float trayLength;       // 正实数：整数/一位小数/两位小数
    private float trayWidth;        // 正实数：整数/一位小数/两位小数
    private float trayHeight;       // 正实数：整数/一位小数/两位小数
    private String trayBindNode;    // 绑定站点
    private String trayStartPos;    // 入场位置
    private String trayCurrentPos;  // 当前位置
    private boolean enableDisable;  // 启用/禁用
    private boolean lockUnlock;     // 解锁/锁定

    public Tray() {
    }

    public Tray(String trayId, String areaId, String trayName, String trayModel, float trayLength, float trayWidth, float trayHeight, String trayBindNode, String trayStartPos, String trayCurrentPos, boolean enableDisable, boolean lockUnlock) {
        this.trayId = trayId;
        this.areaId = areaId;
        this.trayName = trayName;
        this.trayModel = trayModel;
        this.trayLength = trayLength;
        this.trayWidth = trayWidth;
        this.trayHeight = trayHeight;
        this.trayBindNode = trayBindNode;
        this.trayStartPos = trayStartPos;
        this.trayCurrentPos = trayCurrentPos;
        this.enableDisable = enableDisable;
        this.lockUnlock = lockUnlock;
    }

    public String getTrayId() {
        return trayId;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getTrayName() {
        return trayName;
    }

    public String getTrayModel() {
        return trayModel;
    }

    public float getTrayLength() {
        return trayLength;
    }

    public float getTrayWidth() {
        return trayWidth;
    }

    public float getTrayHeight() {
        return trayHeight;
    }

    public String getTrayBindNode() {
        return trayBindNode;
    }

    public String getTrayStartPos() {
        return trayStartPos;
    }

    public String getTrayCurrentPos() {
        return trayCurrentPos;
    }

    public boolean isEnableDisable() {
        return enableDisable;
    }

    public boolean isLockUnlock() {
        return lockUnlock;
    }

    public void setTrayId(String trayId) {
        this.trayId = trayId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setTrayName(String trayName) {
        this.trayName = trayName;
    }

    public void setTrayModel(String trayModel) {
        this.trayModel = trayModel;
    }

    public void setTrayLength(float trayLength) {
        this.trayLength = trayLength;
    }

    public void setTrayWidth(float trayWidth) {
        this.trayWidth = trayWidth;
    }

    public void setTrayHeight(float trayHeight) {
        this.trayHeight = trayHeight;
    }

    public void setTrayBindNode(String trayBindNode) {
        this.trayBindNode = trayBindNode;
    }

    public void setTrayStartPos(String trayStartPos) {
        this.trayStartPos = trayStartPos;
    }

    public void setTrayCurrentPos(String trayCurrentPos) {
        this.trayCurrentPos = trayCurrentPos;
    }

    public void setEnableDisable(boolean enableDisable) {
        this.enableDisable = enableDisable;
    }

    public void setLockUnlock(boolean lockUnlock) {
        this.lockUnlock = lockUnlock;
    }

    @Override
    public String toString() {
        return "Tray{" +
                "trayId='" + trayId + '\'' +
                ", areaId='" + areaId + '\'' +
                ", trayName='" + trayName + '\'' +
                ", trayModel='" + trayModel + '\'' +
                ", trayLength=" + trayLength +
                ", trayWidth=" + trayWidth +
                ", trayHeight=" + trayHeight +
                ", trayBindNode='" + trayBindNode + '\'' +
                ", trayStartPos='" + trayStartPos + '\'' +
                ", trayCurrentPos='" + trayCurrentPos + '\'' +
                ", enableDisable=" + enableDisable +
                ", lockUnlock=" + lockUnlock +
                '}';
    }
}
