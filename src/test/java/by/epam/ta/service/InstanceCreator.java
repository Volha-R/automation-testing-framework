package by.epam.ta.service;

import by.epam.ta.model.ComputeEngineInstance;

public class InstanceCreator {
    public static final String NUMBER_OF_INSTANCES = "number.of.instances";
    public static final String OPERATING_SYSTEM_OR_SOFTWARE = "operating.system.or.software";
    public static final String MACHINE_CLASS = "machine.class";
    public static final String MACHINE_TYPE = "machine.type";
    public static final String NUMBER_OF_GPU = "number.of.gpu";
    public static final String GPU_TYPE = "gpu.type";
    public static final String LOCAL_SSD = "local.ssd";
    public static final String DATACENTER_LOCATION = "datacenter.location";
    public static final String COMMITTED_USAGE = "committed.usage";
    public static final String PRICE = "price";

    public static ComputeEngineInstance withDataFromProperty() {
        return new ComputeEngineInstance(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM_OR_SOFTWARE),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE),
                TestDataReader.getTestData(PRICE));
    }


}
