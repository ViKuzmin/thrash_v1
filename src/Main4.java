import java.util.*;
import java.util.stream.Collectors;

public class Main4 {

    public static void main(String[] args) {

        String[] strArray = {"flow", "flower", "floicky"};

        List<String> stringList = Arrays.stream(strArray)
                .map(element -> element.toCharArray())
                .map(array -> {
                    for (char ch : array) {
                        System.out.println(ch);
                    }

                    return Arrays.toString(array);
                }).collect(Collectors.toList());

        System.out.println(stringList.get(0) + "\n" + stringList.get(1) + "\n" + stringList.get(2));

    }

    public static String getSequence(String[] array) {

        String shortString = getShortString(array);

        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        Set<String> set1 = new LinkedHashSet<>();
        set1.add(shortString);

        System.out.println(set.retainAll(set1));

        return "";
    }

    public static String getShortString(String[] array) {

        StringBuilder shortString = new StringBuilder(array[0]);

        for (String str : array) {
            if (shortString.length() > str.length()) {
                shortString.setLength(0);
                shortString.append(str);
            }
        }

        return shortString.toString();
    }
}

