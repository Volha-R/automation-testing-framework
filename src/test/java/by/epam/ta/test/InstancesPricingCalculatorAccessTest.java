package by.epam.ta.test;

import by.epam.ta.model.ComputeEngineInstance;
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
        ComputeEngineInstance computeEngineInstance = InstanceCreator.withCredentialsFromProperty();
        String searchTerm = SearchTermsUtils.getSearchTerm();
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

//        assertThat(productsAndServicesPage.getVMClass(), containsString("regular"));
//        assertThat(productsAndServicesPage.getVMClass(), containsStringIgnoringCase("regular"));
        assertThat(productsAndServicesPage.getVMClass(), containsStringIgnoringCase("regular"));
        assertThat(productsAndServicesPage.getInstanceType(), containsStringIgnoringCase("n1-standard-8"));
        assertThat(productsAndServicesPage.getRegion(), containsStringIgnoringCase("Frankfurt"));
        assertThat(productsAndServicesPage.getLocalSSD(), containsStringIgnoringCase("2x375 GB"));
        assertThat(productsAndServicesPage.getCommitmentTerm(), containsStringIgnoringCase("1 Year"));
    }
}
