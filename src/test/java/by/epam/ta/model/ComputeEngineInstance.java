package by.epam.ta.model;

public class ComputeEngineInstance {
    private final String numberOfInstances;
    private final String operatingSystemOrSoftware;
    private final String machineClass;
    private final String machineType;
    private final String numberOfGPUs;
    private final String GPUType;
    private final String localSSD;
    private final String datacenterLocation;
    private final String committedUsage;
    private final String price;

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

    public String getOperatingSystemOrSoftware() {
        return operatingSystemOrSoftware;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getPrice() {
        return price;
    }
}
