package pl.sdacademy.store.service;

import pl.sdacademy.store.model.Customer;
import pl.sdacademy.store.model.Policy;

public interface SellingService {
    Policy sell(Customer customer, Long price, int numberOfInstallments);
}
