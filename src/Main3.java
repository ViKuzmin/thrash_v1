import java.util.LinkedList;
import java.util.TreeSet;

public class Main3 {

    public static void main(String[] args) {

        String [] strArray = {"flow", "flower", "flowicky", "flow"};

        System.out.println(commonPrefix(strArray));

    }

    public static String commonPrefix(String[] str) {

        StringBuilder builder = new StringBuilder(); // Строка не изменяется, по этому StringBuilder

        StringBuilder shortString = new StringBuilder(str[0]);

        for (String st : str) {
            if(shortString.length() > st.length()) {
                shortString.setLength(0);
                shortString.append(st);
            }
        }



        char[] chars = shortString.toString().toCharArray(); // Записываем символы 1-го элемента в массив char

        for (int i = 0; i < chars.length; i++) { // Проходим по массиву char-ов
            for (int j = 0; j < str[i].length(); j++) { // Проходим по массиву строк из параметра
                if (chars[i] == str[i].charAt(j)) { // Сравниваем символы массива char-ов c символами каждого элемента
                    builder.append(chars[i]); // Если совпадают записываем в builder
                }
            }
        }
        return builder.toString(); // Возвращаем
    }
}

