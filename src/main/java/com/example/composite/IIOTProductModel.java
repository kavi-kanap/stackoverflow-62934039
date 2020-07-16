package com.example.composite;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="iiot_product")
@IdClass(IIOTProductModelPK.class)
public class IIOTProductModel implements Serializable {

    private static final long serialVersionUID = 7807669404047523909L;

    @Id
    @Column(name = "product_id", length = 100)
    private String productId;

    @Id
    @ManyToOne
    @JoinColumn(name="machine_id", referencedColumnName = "machine_id")
    private IIOTMachineModel machine;

    @Column(name = "line_id")
    private String lineId;

    @Column(name = "shift_id")
    private String shiftId;

    private String variant;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="shift_id", referencedColumnName="shift_id", insertable = false, updatable = false),
            @JoinColumn(name="machine_id", referencedColumnName="machine_id", insertable = false, updatable = false)
    })
    private IIOTShiftModel shift;
    private String operatorName;

    public IIOTProductModel() {
    }

    public IIOTProductModel(String productId, IIOTMachineModel machine, String lineId, String variant, IIOTShiftModel shift, String operatorName) {
        this.productId = productId;
        this.machine = machine;
        this.lineId = lineId;
        this.variant = variant;
        this.shift = shift;
        this.operatorName = operatorName;
        if (Objects.nonNull(shift))
            this.shiftId = shift.getShiftId();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public IIOTMachineModel getMachine() {
        return machine;
    }

    public void setMachine(IIOTMachineModel machine) {
        this.machine = machine;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public IIOTShiftModel getShift() {
        return shift;
    }

    public void setShift(IIOTShiftModel shift) {
        this.shift = shift;
        this.shiftId = shift.getShiftId();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }
}
