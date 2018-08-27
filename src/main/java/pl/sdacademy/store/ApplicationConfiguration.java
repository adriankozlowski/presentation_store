package pl.sdacademy.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sdacademy.store.controller.ClaimController;
import pl.sdacademy.store.controller.PolicyController;
import pl.sdacademy.store.repository.*;
import pl.sdacademy.store.service.DefaultPolicyDataService;
import pl.sdacademy.store.service.DefaultSellingService;
import pl.sdacademy.store.service.PolicyDataService;
import pl.sdacademy.store.service.SellingService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    HardDrivePolicyRepository hardDrivePolicyRepository() {
        return new HardDrivePolicyRepository("policies.ser");
    }

    @Bean
    HardDriveCustomerRepository hardDriveCustomerRepository() {
        return new HardDriveCustomerRepository("customers.ser");
    }

    @Bean
    HardDriveClaimRepository hardDriveClaimRepository() {
        return new HardDriveClaimRepository("claims.ser");
    }

    @Bean
    DefaultPolicyDataService defaultPolicyDataService(
            PolicyRepository policyRepository,
            ClaimRepository claimRepository) {
        return new DefaultPolicyDataService(policyRepository, claimRepository);
    }

    @Bean
    DefaultSellingService defaultSellingService(
            PolicyRepository policyRepository,
            CustomerRepository customerRepository,
            ClaimRepository claimRepository) {
        return new DefaultSellingService(policyRepository, customerRepository, claimRepository);
    }

    @Bean
    PolicyController policyDataController(
            PolicyDataService policyDataService,
            SellingService sellingService) {
        return new PolicyController(sellingService, policyDataService);
    }

    @Bean
    ClaimController sellingController(
            PolicyDataService policyDataService) {
        return new ClaimController(policyDataService);
    }

    @Bean
    Application application(
            PolicyController policyDataController,
            ClaimController sellingController) {
        Application application = new Application();
        application.setPolicyController(policyDataController);
        application.setClaimController(sellingController);
        return application;
    }
}