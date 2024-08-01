package com.ctclri.agv.backend.restfulAPI.pojo.Warehouse;

import lombok.Data;

@Data
public class NodeData {

    private String instanceName;
    private float oriX;
    private float oriY;

    public NodeData() {
    }

    public NodeData(String instanceName, float oriX, float oriY) {
        this.instanceName = instanceName;
        this.oriX = oriX;
        this.oriY = oriY;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public float getOriX() {
        return oriX;
    }

    public float getOriY() {
        return oriY;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public void setOriX(float oriX) {
        this.oriX = oriX;
    }

    public void setOriY(float oriY) {
        this.oriY = oriY;
    }


}
