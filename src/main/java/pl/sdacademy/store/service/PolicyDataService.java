package pl.sdacademy.store.service;

import pl.sdacademy.store.model.Claim;
import pl.sdacademy.store.model.Policy;

import java.util.List;

public interface PolicyDataService {
    List<Policy> loadSoldPolicies();

    Policy findById(Long id);

    void reportClaim(Claim claim);
}
