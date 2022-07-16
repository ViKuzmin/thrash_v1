public class RegEx {

    public static void main(String[] args) {

        String a = "asd11232sdsd44 we2\nasdawd11213 321312asd";
        String b = "1232132133\n2342424";

        System.out.println(b.replaceAll("[^\\n\\d]", ""));

    }
}
