package abstractFactory.website;

import abstractFactory.Manager;

public class WebsitePM implements Manager {
    @Override
    public void manageProject() {
        System.out.println("Website manager manages project...");
    }
}
