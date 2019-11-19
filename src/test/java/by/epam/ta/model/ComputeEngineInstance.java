package by.epam.ta.model;

public class ComputeEngineInstance {
    private String numberOfInstances;
    private String operatingSystemOrSoftware;
    private String machineClass;
    private String machineType;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    private String price;

    public ComputeEngineInstance(String numberOfInstances, String operatingSystemOrSoftware, String machineClass,
                                 String machineType, String numberOfGPUs, String GPUType, String localSSD,
                                 String datacenterLocation, String committedUsage, String price) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemOrSoftware = operatingSystemOrSoftware;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
        this.price = price;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
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

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
