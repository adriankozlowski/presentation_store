package pl.sdacademy.store.controller;

import pl.sdacademy.store.model.Claim;
import pl.sdacademy.store.model.Policy;
import pl.sdacademy.store.service.PolicyDataService;

import java.util.Date;
import java.util.Scanner;

public class ClaimController {

    private final PolicyDataService policyDataService;

    public ClaimController(PolicyDataService PolicyDataService) {
        this.policyDataService = PolicyDataService;
    }

    public void printReportedClaims() {
        System.out.println("Do której polisy chcesz zgłosić szkodę?");
        Long aLong = Long.valueOf(readInput());
        Policy policy = null;
        try {
            policy = policyDataService.findById(aLong);
        } catch (Exception e) {
            System.out.println("Nie istnieje taka polisa w naszym systemie");
            return;
        }
        Claim claim = new Claim();
        claim.setClaimDate(new Date());
        claim.setPoliceWasCalled(true);
        claim.setPolicyId(policy.getId());
        claim.setClaimantId(policy.getCustomerId());
        System.out.println("Opisz zdarzenie");
        claim.setDescription(readInput());
        policyDataService.reportClaim(claim);
    }


    private String readInput() {
        return new Scanner(System.in).nextLine();
    }

}
