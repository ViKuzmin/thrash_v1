public class Generator <T>{

    private String name;

    private T t;

    public Generator(String name, T t) {
        this.name = name;
        this.t = t;
    }

    public Generator() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
