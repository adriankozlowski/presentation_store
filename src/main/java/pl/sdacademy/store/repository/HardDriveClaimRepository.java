package pl.sdacademy.store.repository;

import pl.sdacademy.store.model.Claim;

import java.util.List;

public class HardDriveClaimRepository extends AbstractHardDriveRepository<Claim> implements ClaimRepository {
    private final String repositoryLocation = "claims.ser";

    @Override
    public List<Claim> getAll() {
        return loadAllElements();
    }

    @Override
    public Claim add(Claim claim) {
        List<Claim> claims = loadAllElements();
        Long newPurchaseId = getNextId(claims);
        claim.setId(newPurchaseId);
        claims.add(claim);
        saveAllElements(claims);
        return claim;
    }

    @Override
    protected String getRepositoryLocation() {
        return repositoryLocation;
    }
}
