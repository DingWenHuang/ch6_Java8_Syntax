import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamAPIDemo {

    public static void main(String[] args) {
        Stream.of("Ron", "Wilson", "Harry")
                .sorted()
                //.forEach(s -> System.out.println(s));
                .forEach(System.out::println);

//        ===================================================================

        String[] names = {"Ron", "Wilson", "Harry", "Grace", "Mike", "Ray"};
        Arrays.stream(names)
                .filter(name -> name.startsWith("R"))//startsWith會回傳布林值，所以這邊就表示開頭是R的會是true所以可以通過filter
                .forEach(name -> System.out.println(name));

//        ===================================================================

        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(n -> n * n)//把裡面的每個值都拿去做平方
                .average()//然後取平均，也就是(4+16+36+64+100)/5
                .ifPresent(System.out::println);

//        ===================================================================

        ArrayList<String> people = new ArrayList<>();
        people.add("Ron");
        people.add("rat");
        people.add("Harry");
        people.add("Grace");
        people.add("Mike");
        people.add("Ray");
        people.stream()
                //.map(name -> name.toLowerCase())也可以寫成下面那樣
                .map(String::toLowerCase)
                .filter(name -> name.startsWith("r"))
                .forEach(System.out::println);//ron,rat,ray
    }

}
