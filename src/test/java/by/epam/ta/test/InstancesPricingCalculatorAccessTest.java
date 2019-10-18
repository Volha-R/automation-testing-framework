package by.epam.ta.test;

import by.epam.ta.model.Instance;
import by.epam.ta.page.EstimationResultComponent;
import by.epam.ta.page.MainPage;
import by.epam.ta.service.InstanceCreator;
import by.epam.ta.util.SearchTermsUtils;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.contains;

public class InstancesPricingCalculatorAccessTest extends CommonConditions{
    @Test(description = "Check if input data matches expected after estimation in correspondent fields")
    public void shouldCheckInputDataMatchesExpectedDataAfterEstimation() {
        Instance computeEngineInstance = InstanceCreator.withCredentialsFromProperty();
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

        assertThat(productsAndServicesPage.getVMClass(), containsString("regular"));
        assertThat(productsAndServicesPage.getInstanceType(), containsString("n1-standard-8"));
        assertThat(productsAndServicesPage.getRegion(), containsString("Frankfurt"));
        assertThat(productsAndServicesPage.getLocalSSD(), containsString("2x375 GB"));
        assertThat(productsAndServicesPage.getCommitmentTerm(), containsString("1 Year"));
    }
}
