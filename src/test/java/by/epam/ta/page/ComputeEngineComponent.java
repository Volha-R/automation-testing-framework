package by.epam.ta.page;

import by.epam.ta.model.Instance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputeEngineComponent extends AbstractPage{
    public ComputeEngineComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='input_53']")
    private WebElement numberOfInstancesPlaceholder;

    @FindBy(xpath = "//*[@id='select_value_label_46']")
    private WebElement operatingSystemSoftwareOption;

//    @FindBy(xpath = "//*[@id='select_option_55']")
//    private WebElement operatingSystemSoftwareIsFree;
    private String operatingSystemSoftwareParameter = "//*[@id='select_container_66']//md-option[@value='%s']";

    @FindBy(xpath = "//*[@id='select_value_label_47']")
    private WebElement machineClassOption;

    private String machineClassParameter = "//*[@id='select_container_70']//md-option[@value='%s']";

    @FindBy(xpath = "//*[@id='select_value_label_49']")
    private WebElement machineTypeOption;

//    @FindBy(xpath = "//*[@id='select_option_217']")
//    private WebElement machineTypeIsN1Standard8vCPUs8RAM30GB;
    private String machineTypeParameter = "//*[@id='select_container_77']//md-option[@value='%s']";

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement gPUsCheckbox;

    @FindBy(xpath = "//*[@id='select_value_label_346']")
    private WebElement numberOfGPUsOption;

//    @FindBy(xpath = "//*[@id='select_option_353']")
//    private WebElement numberOfGPUsIsOne;
    private String numberOfGPUsParameter = "//*[@id='select_container_349']//md-option[@value='%s']";

    @FindBy(xpath = "//*[@id='select_value_label_347']")
    private WebElement gpuTypeOption;

//    @FindBy(xpath = "//*[@id='select_option_360']")
//    private WebElement gPUTypeIsNVIDIATeslaV100;
    private String gpuTypeParameter = "//*[@id='select_container_351']//*[@value='%s']";

    @FindBy(xpath = "//*[@id='select_value_label_50']")
    private WebElement localSSDOption;

//    @FindBy(xpath = "//*[@id='select_option_171']")
//    private WebElement localSSSIs2times375;
    private String localSSDParameter = "//*[@id='select_container_79']//*[@value='%s']";

    @FindBy(xpath = "//*[@id='select_value_label_51']")
    private WebElement datacenterLocationOption;

//    @FindBy(xpath = "//*[@id='select_option_185']")
//    private WebElement datacenterLocationIsFrankfurt;
    private String datacenterLocationParameter = "//*[@id='select_container_81']//*[@value='%s']";

    @FindBy(xpath = "//*[@id='select_85']")
    private WebElement committedUsageOption;

//    @FindBy(xpath = "//*[@id='select_option_83']")
//    private WebElement committedUsageIsOneYear;
    private String committedUsageParameter = "//*[@id='select_container_86']//*[@value='%s']";

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button")
    private WebElement addToEstimateButton;


//    public ComputeEngineComponent setNumberOfInstances(String numberOfInstances) {
//        numberOfInstancesPlaceholder.click();
//        numberOfInstancesPlaceholder.sendKeys(numberOfInstances);
//        return this;
//    }
public ComputeEngineComponent setNumberOfInstances(Instance computeEngineInstance) {
    numberOfInstancesPlaceholder.click();
    numberOfInstancesPlaceholder.sendKeys(computeEngineInstance.getNumberOfInstances());
    return this;
}
    public ComputeEngineComponent expandOperatingSystemDropdown() {
        operatingSystemSoftwareOption.click();
        return this;
    }

    public ComputeEngineComponent setOperatingSystem(Instance computeEngineInstance) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(operatingSystemSoftwareParameter, computeEngineInstance.getOperatingSystemOrSoftware()))))
                .click();
        return this;
    }

    public ComputeEngineComponent expandMachineClassDropdown() {
        machineClassOption.click();
        return this;
    }


    public ComputeEngineComponent setMachineClass(Instance computeEngineInstance) {
//        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@id='select_container_1260']//div[contains(text(), '" + machineClass + "')]")
//        )).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(machineClassParameter, computeEngineInstance.getMachineClass()))
        )).click();

//        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(machineClassIsRegular))
//                .click();
        return this;
    }

    public ComputeEngineComponent expandMachineTypeDropdown() {
        machineTypeOption.click();
        return this;
    }

    public ComputeEngineComponent setMachineType(Instance computeEngineInstance) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(machineTypeParameter, computeEngineInstance.getMachineType()))))
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

    public ComputeEngineComponent setGPUsNumber(Instance computeEngineInstance) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(numberOfGPUsParameter, computeEngineInstance.getNumberOfGPUs()))))
                .click();
        return this;
    }

    public ComputeEngineComponent expandGPUTypeDropdown() {
        gpuTypeOption.click();
        return this;
    }

    public ComputeEngineComponent setGPUType(Instance computeEngineInstance) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(gpuTypeParameter, computeEngineInstance.getTypeOfGPU()))))
                .click();
        return this;
    }

    public ComputeEngineComponent expandLocalSSDDropdown() {
        localSSDOption.click();
        return this;
    }

    public ComputeEngineComponent setLocalSSD(Instance computeEngineInstance) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(localSSDParameter, computeEngineInstance.getLocalSSD()))))
                .sendKeys(Keys.ENTER);
        return this;
    }

    public ComputeEngineComponent expandDatacenterLocationDropdown() {
        datacenterLocationOption.click();
        return this;
    }

    public ComputeEngineComponent setDatacenterLocation(Instance computeEngineInstance) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(datacenterLocationParameter, computeEngineInstance.getDatacenterLocation()))))
                .click();
        return this;
    }

    public ComputeEngineComponent expandCommittedUsageDropdown() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(committedUsageOption))
                .click();
        return this;
    }

    public ComputeEngineComponent setCommittedUsage(Instance computeEngineInstance) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(committedUsageParameter, computeEngineInstance.getCommittedUsage()))))
                .click();

        return this;
    }

    public EstimationResultComponent clickAddToEstimateButton() {
        addToEstimateButton.click();
        return new EstimationResultComponent(driver);
    }
}
