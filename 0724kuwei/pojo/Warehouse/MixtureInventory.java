package com.ctclri.agv.backend.restfulAPI.pojo.Warehouse;

import lombok.Data;

@Data
public class MixtureInventory {
    private String stock;
    private String position;

    public MixtureInventory(String stock, String position) {
        this.stock = stock;
        this.position = position;
    }


}
