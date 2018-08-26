package pl.sdacademy.store.repository;

import pl.sdacademy.store.model.Policy;

import java.util.List;
import java.util.stream.Collectors;

public class HardDrivePolicyRepository extends AbstractHardDriveRepository<Policy> implements PolicyRepository {

    private final String repositoryLocation = "policies.ser";

    @Override
    public Policy byId(Long id) {
        return loadAllElements().stream().filter(policy -> policy.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<Policy> getAll() {
        return loadAllElements();
    }

    @Override
    public List<Policy> getAvailable() {
        return loadAllElements().stream().filter(policy -> !policy.getIsAvailable()).collect(Collectors.toList());
    }

    @Override
    public Policy update(Policy newPolicy) {
        List<Policy> allPolicys = loadAllElements();
        List<Policy> filteredOutPolicys = allPolicys.stream().filter(oldPolicy -> !oldPolicy.getId().equals(newPolicy.getId())).collect(Collectors.toList());
        filteredOutPolicys.add(newPolicy);
        saveAllElements(filteredOutPolicys);
        return newPolicy;
    }

    @Override
    public Policy add(Policy policy) {
        List<Policy> policies = loadAllElements();
        Long newPurchaseId = getNextId(policies);
        policy.setId(newPurchaseId);
        policies.add(policy);
        saveAllElements(policies);
        return policy;
    }

    @Override
    protected String getRepositoryLocation() {
        return repositoryLocation;
    }
}
