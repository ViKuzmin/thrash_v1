package abstractFactory;

public interface ProjectTeamFactory {

    Developer getDeveloper();
    Tester getTester();
    Manager getManager();
}
