public class Main5 {

    public static void main(String[] args) {

        Jopa jopa = new Pisqka();

        System.out.println("===========");

        Pisqka pisqka = new Pisqka();
    }


}

abstract class Jopa {

    public Jopa() {
        System.out.println("I am abstract class...");
    }

}

class Pisqka extends Jopa {

    public Pisqka() {
        System.out.println("Jopa...");
    }
}