import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * ["flow", "flower", "flicky"]
 * "fl"
 */

public class Main2 {

    public static void main(String[] args) {

        String[] strArray = {"flonnw", "flonwer", "flonicky"};
//        String[] strArray = {"flow", "flon", "flic"};

        //System.out.println(getRepeatableSequence(strArray));

        String a = null;
        String b = "b";

//        System.out.println(b.equals(a));
//        System.out.println(a.equals("s"));

//        Arrays.stream(strArray).sorted().peek();

        System.out.println(longestPrefix(Arrays.stream(strArray)));
    }

    public static String getRepeatableSequence(String[] array) {

        if (array.length == 0) {
            return "Array dont has elements";
        }

        StringBuilder shortString = new StringBuilder(array[0]);

        for (String str : array) {
            if (shortString.length() > str.length()) {
                shortString.setLength(0);
                shortString.append(str);
            }
        }

        while (shortString.length() != 1) {

            int i = 0;

            for (String s : array) {
                if (s.contains(shortString)) {
                    i++;
                }
            }

            if(i == array.length) {
                break;
            }

            shortString.setLength(shortString.length() - 1);
        }

        return shortString.toString();
    }

    public static String getRepeat(String[] array) {

        StringBuilder shortString = new StringBuilder(array[0]);

        for (String st : array) {
            if(shortString.length() > st.length()) {
                shortString.setLength(0);
                shortString.append(st);
            }
        }

        char[] charsArray = shortString.toString().toCharArray();

        return "";
    }


    public static String longestPrefix(Stream<String> stream){


        return stream.reduce((aggregate, elem) -> {

            StringBuilder shortString = new StringBuilder("");

            char[] elemChar = elem.toCharArray();
            char[] aggr = aggregate.toCharArray();

            int size = Math.min(elemChar.length, aggr.length);

            StringBuilder strb = new StringBuilder("");

//            for(int i = 0; i < elemChar.length - 1; i++) {
            for(int i = 0; i < size; i++) {

                if(elemChar[i] == aggr[i]) {

                    char a = elemChar[i];

//                    strb.append(elem[i]);
                    strb.append(elemChar[i]);

                } else {
                    break;
                }
            }
            return strb.toString();
        }).get();
    }

}
