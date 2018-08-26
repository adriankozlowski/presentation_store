package pl.sdacademy.store;

import pl.sdacademy.store.controller.ClaimController;
import pl.sdacademy.store.controller.PolicyController;

import java.util.Scanner;

public class Application {
    private PolicyController policyController;
    private ClaimController claimController;

    public void start() {
        Long choice = -1L;
        while (choice != 9L) {
            printMenu();
            choice = readInput();
            switch (choice.intValue()) {
                case 1:
                    policyController.printAvailablePolicies();
                    break;
                case 2:
                    System.out.print("Komu sprzedać polisę? ");
                    policyController.buyPolicy();
                    break;
                case 3:
                    claimController.printReportedClaims();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Niewłaściwy wybór.");
            }
        }

    }

    private void printMenu() {
        System.out.println();
        System.out.println();
        System.out.println("Witaj w systenmie obsługi ubezpieczeń.");
        System.out.println("1) Pokaż sprzedane polisy");
        System.out.println("2) Sprzedaj polisę");
        System.out.println("3) Zgłoś szkodę");
        System.out.println("9) Exit");
        System.out.print("Co robimy?? ");
    }

    private Long readInput() {
        try {
            return Long.parseLong(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public void setPolicyController(PolicyController policyController) {
        this.policyController = policyController;
    }

    public void setClaimController(ClaimController claimController) {
        this.claimController = claimController;
    }
}
