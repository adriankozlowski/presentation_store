package pl.sdacademy.store.service;

import pl.sdacademy.store.model.Customer;
import pl.sdacademy.store.model.Policy;
import pl.sdacademy.store.repository.ClaimRepository;
import pl.sdacademy.store.repository.CustomerRepository;
import pl.sdacademy.store.repository.PolicyRepository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DefaultSellingService implements SellingService {

    private final PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;
    private final ClaimRepository claimRepository;

    public DefaultSellingService(
            PolicyRepository policyRepository,
            CustomerRepository customerRepository,
            ClaimRepository claimRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
        this.claimRepository = claimRepository;
    }

    public Policy sell(Customer customer, Long price, int numberOfInstallments) {
        float sum = price/numberOfInstallments;
        Random random = new Random();
        Policy policy = new Policy();
        policy.setPrice(new BigDecimal(random.nextGaussian() * sum));
        customerRepository.add(customer);
        policy.setCustomerId(customer.getId());
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 365);
        dt = c.getTime();
        policy.setDate(new Date());
        policy.setStartDate(new Date());
        policy.setEndDate(dt);
        policy.setInstallmentsPerYear(numberOfInstallments);
        policyRepository.add(policy);
        return policy;
    }
}
