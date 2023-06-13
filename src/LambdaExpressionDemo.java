import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(30);
        arr.add(40);
        arr.add(50);

        arr.forEach(i -> System.out.println(i));

        Map<String, Integer> map = new HashMap<>();
        map.put("wilson", 30);
        map.put("Grace", 40);
        map.put("Mike", 50);

        map.forEach((k, v) -> {//Lambda Expression裡面的parameter數量大於1，要用()刮起來
            System.out.println("Key is " + k + ", and value is " + v);
        });
    }
}
