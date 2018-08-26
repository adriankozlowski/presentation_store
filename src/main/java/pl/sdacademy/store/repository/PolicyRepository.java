package pl.sdacademy.store.repository;

import pl.sdacademy.store.model.Policy;

import java.util.List;

public interface PolicyRepository {
    Policy byId(Long id);
    List<Policy> getAll();
    List<Policy> getAvailable();
    Policy update(Policy vehicle);

    Policy add(Policy policy);
}
