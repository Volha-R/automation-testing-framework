package by.epam.ta.test;

import by.epam.ta.model.ComputeEngineInstance;
import by.epam.ta.page.EstimationResultComponent;
import by.epam.ta.page.MainPage;
import by.epam.ta.service.InstanceCreator;
import by.epam.ta.util.SearchTermsUtils;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class InstancesPricingCalculatorAccessTest extends CommonConditions {
    @Test(description = "Check if input data matches expected after estimation in correspondent fields")
    public void shouldCheckInputDataMatchesExpectedDataAfterEstimation() {
        ComputeEngineInstance computeEngineInstance = InstanceCreator.withDataFromProperty();
        String searchTerm = SearchTermsUtils.getPricingCalculatorSearchTerm();
        EstimationResultComponent productsAndServicesPage = new MainPage(driver)
                .openMainPage()
                .searchForTerms(searchTerm)
                .chooseSearchTermLink()
                .chooseComputeEngineOption()
                .setNumberOfInstances(computeEngineInstance.getNumberOfInstances())
                .expandOperatingSystemDropdown()
                .setOperatingSystem(computeEngineInstance.getOperatingSystemOrSoftware())
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

        assertThat(productsAndServicesPage.getVMClass(), containsStringIgnoringCase(computeEngineInstance.getMachineClass()));
        assertThat(productsAndServicesPage.getInstanceType(), containsStringIgnoringCase(computeEngineInstance.getMachineType()));
        assertThat(productsAndServicesPage.getRegion(), containsStringIgnoringCase(computeEngineInstance.getDatacenterLocation()));
        assertThat(productsAndServicesPage.getLocalSSD(), containsStringIgnoringCase(computeEngineInstance.getLocalSSD()));
        assertThat(productsAndServicesPage.getCommitmentTerm(), containsStringIgnoringCase(computeEngineInstance.getCommittedUsage()));
    }
}
