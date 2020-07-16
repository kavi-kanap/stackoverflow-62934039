package com.example.composite;

import java.io.Serializable;

public class IIOTShiftModelPK  implements Serializable {
    private String machine;

    private String shiftId;

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }
}
