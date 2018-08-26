package pl.sdacademy.store.repository;

import pl.sdacademy.store.model.Claim;

import java.util.List;

public interface ClaimRepository {
    List<Claim> getAll();
    Claim add(Claim purchase);
}
