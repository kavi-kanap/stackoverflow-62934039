package com.example.composite;

import java.io.Serializable;

public class IIOTProductModelPK  implements Serializable {
    private String productId;
    private String machine;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
