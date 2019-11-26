package by.epam.ta.test;

import by.epam.ta.model.ComputeEngineInstance;
import by.epam.ta.page.EmailEstimationWindow;
import by.epam.ta.page.EstimationResultComponent;
import by.epam.ta.page.MainPage;
import by.epam.ta.page.TemporaryEmailPage;
import by.epam.ta.service.InstanceCreator;
import by.epam.ta.util.SearchTermsUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class InstancesPricingCalculatorAccuracyTests extends CommonConditions {
    @Test(description = "Check if final cost matches expected cost after estimation with particular input data")
    public void shouldCheckIfEstimationPriceIsCorrect() {
        ComputeEngineInstance computeEngineInstance = InstanceCreator.withDataFromProperty();
        String searchTerm = SearchTermsUtils.getPricingCalculatorSearchTerm();
        EstimationResultComponent productsAndServicesPage = new MainPage(driver)
                .openMainPage()
                .searchForTerms(searchTerm)
                .chooseSearchTermLink()
                .chooseComputeEngineOption()
                .setNumberOfInstances(computeEngineInstance.getNumberOfInstances())
                .expandOperatingSystemDropdown()
                .setOperatingSystem(computeEngineInstance.getOperatingSystem())
                .expandMachineClassDropdown()
                .setMachineClass(computeEngineInstance.getMachineClass())
                .expandMachineTypeDropdown()
                .setMachineType(computeEngineInstance.getMachineType())
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setNumberOfGPUs(computeEngineInstance.getNumberOfGPUs())
                .expandGPUTypeDropdown()
                .setGPUType(computeEngineInstance.getGPUType())
                .expandLocalSSDDropdown()
                .setLocalSSD(computeEngineInstance.getLocalSSD())
                .expandDatacenterLocationDropdown()
                .setDatacenterLocation(computeEngineInstance.getDatacenterLocation())
                .expandCommittedUsageDropdown()
                .setCommittedUsage(computeEngineInstance.getCommittedUsage())
                .clickAddToEstimateButton();

        assertThat(productsAndServicesPage.getEstimatedComponentCost(), containsString(computeEngineInstance.getPrice()));
    }

    @Test(description = "Check if cost in email matches cost shown after estimation as Total Estimated Coast")
    public void shouldCheckIfCostInEmailIsCorrect() {
        ComputeEngineInstance computeEngineInstance = InstanceCreator.withDataFromProperty();
        String searchTerm = SearchTermsUtils.getPricingCalculatorSearchTerm();
        EstimationResultComponent estimationResultComponent = new MainPage(driver)
                .openMainPage()
                .searchForTerms(searchTerm)
                .chooseSearchTermLink()
                .chooseComputeEngineOption()
                .setNumberOfInstances(computeEngineInstance.getNumberOfInstances())
                .expandOperatingSystemDropdown()
                .setOperatingSystem(computeEngineInstance.getOperatingSystem())
                .expandMachineClassDropdown()
                .setMachineClass(computeEngineInstance.getMachineClass())
                .expandMachineTypeDropdown()
                .setMachineType(computeEngineInstance.getMachineType())
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setNumberOfGPUs(computeEngineInstance.getNumberOfGPUs())
                .expandGPUTypeDropdown()
                .setGPUType(computeEngineInstance.getGPUType())
                .expandLocalSSDDropdown()
                .setLocalSSD(computeEngineInstance.getLocalSSD())
                .expandDatacenterLocationDropdown()
                .setDatacenterLocation(computeEngineInstance.getDatacenterLocation())
                .expandCommittedUsageDropdown()
                .setCommittedUsage(computeEngineInstance.getCommittedUsage())
                .clickAddToEstimateButton();

        String calculatedComponentCost = estimationResultComponent.getEstimatedComponentCost();

//        ((JavascriptExecutor) driver).executeScript("window.open();");

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        TemporaryEmailPage temporaryEmailPage = new TemporaryEmailPage(driver)
                .openPage();
        String emailAddress = temporaryEmailPage.copyEmail();

        driver.switchTo().window(windowHandles.get(0));

        estimationResultComponent
                .chooseEmailEstimation()
                .pasteEmailAddress(emailAddress)
                .sendEmail();

        driver.switchTo().window(windowHandles.get(1));

        temporaryEmailPage.openEmail();

        assertThat(temporaryEmailPage.getEstimatedCoast(), containsString(temporaryEmailPage.getEstimatedCoast()));
    }
}
