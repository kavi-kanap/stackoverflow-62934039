package com.example.composite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "iiot_machine")
public class IIOTMachineModel {

    @Id
    @Column(name = "machine_id")
    private String machineId;

    @Column(name = "machine_name")
    private String machineName;

    @Column(name = "machine_description")
    private String machineDescription;

    @Column(name="created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;

    public IIOTMachineModel() {
    }

    public IIOTMachineModel(String machineId, String machineName, String machineDescription, LocalDateTime createdOn) {
        this.machineId = machineId;
        this.machineName = machineName;
        this.machineDescription = machineDescription;
        this.createdOn = createdOn;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
