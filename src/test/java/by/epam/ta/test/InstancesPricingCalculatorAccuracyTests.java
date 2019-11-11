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
        ComputeEngineInstance computeEngineInstance = InstanceCreator.withCredentialsFromProperty();
        String searchTerm = SearchTermsUtils.getSearchTerm();
        EstimationResultComponent productsAndServicesPage = new MainPage(driver)
                .openMainPage()
                .searchForTerms(searchTerm)
                .chooseSearchTermLink()
                .chooseComputeEngineOption()
                .setNumberOfInstances(computeEngineInstance)
                .expandOperatingSystemDropdown()
                .setOperatingSystem(computeEngineInstance)
                .expandMachineClassDropdown()
                .setMachineClass(computeEngineInstance)
                .expandMachineTypeDropdown()
                .setMachineType(computeEngineInstance)
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setGPUsNumber(computeEngineInstance)
                .expandGPUTypeDropdown()
                .setGPUType(computeEngineInstance)
                .expandLocalSSDDropdown()
                .setLocalSSD(computeEngineInstance)
                .expandDatacenterLocationDropdown()
                .setDatacenterLocation(computeEngineInstance)
                .expandCommittedUsageDropdown()
                .setCommittedUsage(computeEngineInstance)
                .clickAddToEstimateButton();

        assertThat(productsAndServicesPage.getEstimatedComponentCost(), containsString("USD 1,082.77 per 1 month"));
    }

    @Test(description = "Check if cost in email matches cost shown after estimation as Total Estimated Coast")
    public void shouldCheckIfCoastInEmailCorrect() {
        ComputeEngineInstance computeEngineInstance = InstanceCreator.withCredentialsFromProperty();
        String searchTerm = SearchTermsUtils.getSearchTerm();
        EmailEstimationWindow emailEstimationWindow = new MainPage(driver)
                .openMainPage()
                .searchForTerms(searchTerm)
                .chooseSearchTermLink()
                .chooseComputeEngineOption()
                .setNumberOfInstances(computeEngineInstance)
                .expandOperatingSystemDropdown()
                .setOperatingSystem(computeEngineInstance)
                .expandMachineClassDropdown()
                .setMachineClass(computeEngineInstance)
                .expandMachineTypeDropdown()
                .setMachineType(computeEngineInstance)
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setGPUsNumber(computeEngineInstance)
                .expandGPUTypeDropdown()
                .setGPUType(computeEngineInstance)
                .expandLocalSSDDropdown()
                .setLocalSSD(computeEngineInstance)
                .expandDatacenterLocationDropdown()
                .setDatacenterLocation(computeEngineInstance)
                .expandCommittedUsageDropdown()
                .setCommittedUsage(computeEngineInstance)
                .clickAddToEstimateButton()
                .chooseEmailEstimation();

        ((JavascriptExecutor)driver).executeScript("window.open();");

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        TemporaryEmailPage temporaryEmailPage = new TemporaryEmailPage(driver)
                .openPage()
                .copyEmail();

        driver.switchTo().window(windowHandles.get(0));

        emailEstimationWindow.pasteEmailAddress(temporaryEmailPage.getEmailAddress()).sendEmail();

        driver.switchTo().window(windowHandles.get(1));

        temporaryEmailPage.openEmail();
        assertThat(temporaryEmailPage.getEstimatedCoast(), containsString("Estimated Monthly Cost: USD 1,082.77"));
    }
}
