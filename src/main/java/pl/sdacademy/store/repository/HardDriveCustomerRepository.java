package pl.sdacademy.store.repository;

import pl.sdacademy.store.model.Customer;

import java.util.List;

public class HardDriveCustomerRepository extends AbstractHardDriveRepository<Customer> implements CustomerRepository {
    private final String repositoryLocation;

    public HardDriveCustomerRepository(String repoLocation) {
        this.repositoryLocation = repoLocation;
    }

    public Customer byId(Long id) {
        return loadAllElements().stream().filter(customer -> customer.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Customer add(Customer customer) {
        List<Customer> customers = loadAllElements();
        Long newCustomerId = getNextId(customers);
        customer.setId(newCustomerId);
        customers.add(customer);
        saveAllElements(customers);
        return customer;
    }

    @Override
    protected String getRepositoryLocation() {
        return repositoryLocation;
    }
}
