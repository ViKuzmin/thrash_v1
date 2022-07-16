package abstractFactory.banking;

import abstractFactory.Manager;

public class BankingPM implements Manager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages project...");
    }
}
