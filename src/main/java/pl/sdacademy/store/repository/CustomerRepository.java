package pl.sdacademy.store.repository;

import pl.sdacademy.store.model.Customer;

public interface CustomerRepository {
    Customer byId(Long id);
    Customer add(Customer customer);
}
