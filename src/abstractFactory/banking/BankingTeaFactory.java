package abstractFactory.banking;

import abstractFactory.Developer;
import abstractFactory.Manager;
import abstractFactory.ProjectTeamFactory;
import abstractFactory.Tester;

public class BankingTeaFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public Manager getManager() {
        return new BankingPM();
    }
}
