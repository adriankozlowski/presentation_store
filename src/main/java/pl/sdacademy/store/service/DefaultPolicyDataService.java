package pl.sdacademy.store.service;

import pl.sdacademy.store.model.Claim;
import pl.sdacademy.store.model.Policy;
import pl.sdacademy.store.repository.ClaimRepository;
import pl.sdacademy.store.repository.HardDriveClaimRepository;
import pl.sdacademy.store.repository.HardDrivePolicyRepository;
import pl.sdacademy.store.repository.PolicyRepository;

import java.util.List;

public class DefaultPolicyDataService implements PolicyDataService {
    private final PolicyRepository policyRepository;
    private final ClaimRepository claimRepository;

    public DefaultPolicyDataService(PolicyRepository hardDrivePolicyRepository, ClaimRepository hardDriveClaimRepository) {
        this.policyRepository = hardDrivePolicyRepository;
        this.claimRepository = hardDriveClaimRepository;
    }

    public List<Policy> loadSoldPolicies() {
        return policyRepository.getAll();
    }

    @Override
    public Policy findById(Long id) {
        return policyRepository.byId(id);
    }

    @Override
    public void reportClaim(Claim claim) {
        claimRepository.add(claim);
    }
}
