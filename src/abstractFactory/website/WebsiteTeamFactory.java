package abstractFactory.website;

import abstractFactory.Developer;
import abstractFactory.Manager;
import abstractFactory.ProjectTeamFactory;
import abstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PHPDeveloper();
    }

    @Override
    public Tester getTester() {
        return new SiteTester();
    }

    @Override
    public Manager getManager() {
        return new WebsitePM();
    }
}
