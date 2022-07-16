package abstractFactory;

import abstractFactory.banking.BankingTeaFactory;

public class SuperBankSystem {

    public static void main(String[] args) {

        BankingTeaFactory bankingTeaFactory = new BankingTeaFactory();
        Developer javaDeveloper = bankingTeaFactory.getDeveloper();
        Tester bankTester = bankingTeaFactory.getTester();
        Manager bankPM = bankingTeaFactory.getManager();

        javaDeveloper.writeCode();
        bankTester.testCode();
        bankPM.manageProject();
    }
}
