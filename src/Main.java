import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        String[] answers = {
                "1",
                "2",
                //region ... прочие значения
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz",
                "16",
                "17",
                "Fizz",
                "19",
                "Buzz",
                "Fizz",
                "22",
                "23",
                "Fizz",
                "Buzz",
                "26",
                "Fizz",
                "28",
                "29",
                "FizzBuzz",
                "31",
                "32",
                "Fizz",
                "34",
                "Buzz",
                "Fizz",
                "37",
                "38",
                "Fizz",
                "Buzz",
                "41",
                "Fizz",
                "43",
                "44",
                "FizzBuzz",
                "46",
                "47",
                "Fizz",
                "49",
                "Buzz",
                "Fizz",
                "52",
                "53",
                "Fizz",
                "Buzz",
                "56",
                "Fizz",
                "58",
                "59",
                "FizzBuzz",
                "61",
                "62",
                "Fizz",
                "64",
                "Buzz",
                "Fizz",
                "67",
                "68",
                "Fizz",
                "Buzz",
                "71",
                "Fizz",
                "73",
                "74",
                "FizzBuzz",
                "76",
                "77",
                "Fizz",
                "79",
                "Buzz",
                "Fizz",
                "82",
                "83",
                "Fizz",
                "Buzz",
                "86",
                "Fizz",
                "88",
                "89",
                "FizzBuzz",
                "91",
                "92",
                "Fizz",
                "94",
                "Buzz",
                "Fizz",
                "97",
                //endregion
                "98",
                "Fizz",
                "Buzz"
        };



        Arrays.stream(answers).distinct().forEach(System.out::println);

        System.out.println("=================================");

//        Arrays.stream(answers).

        Map<String, Integer> map = getMap(answers);

        System.out.println(map);


    }


    public static Map<String, Integer> getMap(String[] array) {

        Map<String, Integer> map = new HashMap<>();

        if (array.length >= 1) {
            for (String key : array) {

                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    Integer value = map.get(key);
                    map.put(key, ++value);
                }
            }
        }
        return map;
    }

}

