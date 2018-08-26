package pl.sdacademy.store.controller;

import pl.sdacademy.store.model.Customer;
import pl.sdacademy.store.model.Policy;
import pl.sdacademy.store.service.DefaultPolicyDataService;
import pl.sdacademy.store.service.DefaultSellingService;
import pl.sdacademy.store.service.SellingService;

import java.util.List;
import java.util.Scanner;

public class PolicyController {

    private final SellingService sellingService;
    private final DefaultPolicyDataService policyDataService;

    public PolicyController(DefaultSellingService defaultSellingService, DefaultPolicyDataService defaultPolicyDataService) {
        this.sellingService = defaultSellingService;
        this.policyDataService = defaultPolicyDataService;
    }

    public void buyPolicy() {
        Customer customer = getCustomerData();
        Long customerPrice = getCustomerPrice();
        int installemnts = getMonthCount();
        sellingService.sell(customer, customerPrice, installemnts);
    }

    private int getMonthCount() {
        System.out.print("   Na ile rat rozłożyć ratę? ");
        return Integer.valueOf(readInput());
    }

    private Customer getCustomerData() {
        Customer customer = new Customer();
        System.out.println("Wprowadź dane klienta:");
        System.out.print("   Imię: ");
        customer.setName(readInput());
        System.out.print("   Nazwisko: ");
        customer.setSurname(readInput());
        System.out.print("   Numer dowodu osobistego: ");
        customer.setDocumentNo(readInput());
        System.out.print("   Numer telefonu: ");
        customer.setTelephone(readInput());
        return customer;
    }

    private Long getCustomerPrice() {
        while (true) {
            try {
                System.out.print("Podaj wartość policy dla tego klienta: ");
                return Long.parseLong(readInput());
            } catch (NumberFormatException e) {
                System.out.println("Wartość niepoprawna. Spróbuj ponownie.");
            }
        }
    }

    private String readInput() {
        return new Scanner(System.in).nextLine();
    }

    public void printAvailablePolicies() {
        List<Policy> policies = this.policyDataService.loadSoldPolicies();
        System.out.println("id  |  wartosc |  data poczatkowa | data konca   ");
        policies.stream().forEach(policy -> {
            System.out.printf("%d | %f10 | %s15 | %s15 |", policy.getId(), policy.getPrice(), policy.getStartDate(), policy.getEndDate());
            System.out.println();
        });
    }
}
