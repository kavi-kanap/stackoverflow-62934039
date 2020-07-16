package com.example.composite;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "iiot_shift")
@IdClass(IIOTShiftModelPK.class)
public class IIOTShiftModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "shift_id")
    private String shiftId;

    @Id
    @ManyToOne
    @JoinColumn(name="machine_id", referencedColumnName = "machine_id")
    private IIOTMachineModel machine;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "start_time")
    private LocalTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name= "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;

    public IIOTShiftModel() {
    }

    public IIOTShiftModel(String shiftId, IIOTMachineModel machine, LocalTime startTime, LocalTime endTime, LocalDateTime createdOn) {
        this.shiftId = shiftId;
        this.machine = machine;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdOn = createdOn;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public IIOTMachineModel getMachine() {
        return machine;
    }

    public void setMachine(IIOTMachineModel machine) {
        this.machine = machine;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
