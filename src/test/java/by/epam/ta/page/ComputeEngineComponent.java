package by.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputeEngineComponent extends AbstractPage {

    public ComputeEngineComponent(WebDriver driver) {
        super(driver);
    }

    private static final String operatingSystemSoftwareParameter = "//*[@id='select_container_66']//*[contains(text(), '%s')]";
    private static final String machineClassParameter = "//*[@id='select_container_70']//*[contains(text(), '%s')]";
    private static final String machineTypeParameter = "//*[@id='select_container_77']//*[contains(text(), '%s')]";
    private static final String numberOfGPUsParameter = "//*[@id='select_container_349']//md-option[@value='%s']";
    private static final String gpuTypeParameter = "//*[@id='select_container_351']//*[@value='%s']";
    private static final String localSSDParameter = "//*[@id='select_container_79']//*[contains(text(), '%s')]";
    private static final String datacenterLocationParameter = "//*[@id='select_container_81']//*[contains(text(), '%s')]";
    private static final String committedUsageParameter = "//*[@id='select_container_86']//*[contains(text(), '%s')]";

    @FindBy(id = "input_53")
    private WebElement numberOfInstancesPlaceholder;

    @FindBy(id = "select_value_label_46")
    private WebElement operatingSystemSoftwareOption;

    @FindBy(id = "select_value_label_47")
    private WebElement machineClassOption;

    @FindBy(id = "select_value_label_49")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement gPUsCheckbox;

    @FindBy(id = "select_value_label_346")
    private WebElement numberOfGPUsOption;

    @FindBy(id = "select_value_label_347")
    private WebElement gpuTypeOption;

    @FindBy(id = "select_value_label_50")
    private WebElement localSSDOption;

    @FindBy(id = "select_value_label_51")
    private WebElement datacenterLocationOption;

    @FindBy(id = "select_85")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button")
    private WebElement addToEstimateButton;

    public ComputeEngineComponent setNumberOfInstances(String numberOfInstances) {
        numberOfInstancesPlaceholder.click();
        numberOfInstancesPlaceholder.sendKeys(numberOfInstances);
        return this;
    }

    public ComputeEngineComponent expandOperatingSystemDropdown() {
        operatingSystemSoftwareOption.click();
        return this;
    }

    public ComputeEngineComponent setOperatingSystem(String operatingSystem) {
        waitForElementToBeClickable(By.xpath(String.format(operatingSystemSoftwareParameter, operatingSystem)))
                .click();
        return this;
    }

    public ComputeEngineComponent expandMachineClassDropdown() {
        machineClassOption.click();
        return this;
    }

    public ComputeEngineComponent setMachineClass(String machineClass) {
        waitForElementToBeClickable(By.xpath(String.format(machineClassParameter, machineClass)))
                .click();
        return this;
    }

    public ComputeEngineComponent expandMachineTypeDropdown() {
        machineTypeOption.click();
        return this;
    }

    public ComputeEngineComponent setMachineType(String machineType) {
        waitForElementToBeClickable(By.xpath(String.format(machineTypeParameter, machineType)))
                .click();
        return this;
    }

    public ComputeEngineComponent toggleGPUsCheckbox() {
        gPUsCheckbox.click();
        return this;
    }

    public ComputeEngineComponent expandGPUsNumberDropdown() {
        numberOfGPUsOption.click();
        return this;
    }

    public ComputeEngineComponent setNumberOfGPUs(String numberOfGPUs) {
        waitForElementToBeClickable(By.xpath(String.format(numberOfGPUsParameter, numberOfGPUs)))
                .click();
        return this;
    }

    public ComputeEngineComponent expandGPUTypeDropdown() {
        gpuTypeOption.click();
        return this;
    }

    public ComputeEngineComponent setGPUType(String gpuType) {
        waitForElementToBeClickable(By.xpath(String.format(gpuTypeParameter, gpuType)))
                .click();
        return this;
    }

    public ComputeEngineComponent expandLocalSSDDropdown() {
        localSSDOption.click();
        return this;
    }

    public ComputeEngineComponent setLocalSSD(String localSSD) {
        waitForElementToBeClickable(By.xpath(String.format(localSSDParameter, localSSD)))
                .click();
        return this;
    }

    public ComputeEngineComponent expandDatacenterLocationDropdown() {
        datacenterLocationOption.click();
        return this;
    }

    public ComputeEngineComponent setDatacenterLocation(String datacenterLocation) {
        waitForElementToBeClickable(By.xpath(String.format(datacenterLocationParameter, datacenterLocation)))
                .click();
        return this;
    }

    public ComputeEngineComponent expandCommittedUsageDropdown() {
        waitForElementToBeClickable(committedUsageOption)
                .click();
        return this;
    }

    public ComputeEngineComponent setCommittedUsage(String committedUsage) {
        waitForElementToBeClickable(By.xpath(String.format(committedUsageParameter, committedUsage)))
                .click();
        return this;
    }

    public EstimationResultComponent clickAddToEstimateButton() {
        addToEstimateButton.click();
        return new EstimationResultComponent(driver);
    }
}
