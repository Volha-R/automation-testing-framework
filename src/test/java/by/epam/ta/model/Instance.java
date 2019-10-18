package by.epam.ta.model;

public class Instance {
    private String numberOfInstances;
    private String operatingSystemOrSoftware;
    private String machineClass;
    private String machineType;
    private String numberOfGPUs;
    private String typeOfGPU;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public Instance(String numberOfInstances, String operatingSystemOrSoftware, String machineClass, String machineType, String numberOfGPUs, String typeOfGPU, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemOrSoftware = operatingSystemOrSoftware;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.typeOfGPU = typeOfGPU;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemOrSoftware() {
        return operatingSystemOrSoftware;
    }

    public void setOperatingSystemOrSoftware(String operatingSystemOrSoftware) {
        this.operatingSystemOrSoftware = operatingSystemOrSoftware;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }
}
