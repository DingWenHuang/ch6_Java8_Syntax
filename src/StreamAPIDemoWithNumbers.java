import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIDemoWithNumbers {

    public static void main(String[] args) throws IOException {
        IntSummaryStatistics s = IntStream.of(3, 4, 5, 6, 7, 8, 9, 10).summaryStatistics();
        System.out.println(s.getMax());//10
        System.out.println(s.getMin());//3
        System.out.println(s.getAverage());//6.5
        System.out.println(s.getCount());//8
        System.out.println(s.getSum());//52

//        ===================================================================

        //int result1 = Stream.of(3, 4, 5, 6, 7, 8).reduce(0, (Integer a, Integer b) -> a + b);
        int result1 = Stream.of(3, 4, 5, 6, 7, 8).reduce(0, (Integer a, Integer b) -> {return (a + b);});
        System.out.println(result1);//33
        int result2 = Stream.of(3, 4, 5, 6, 7, 8).reduce(1, (Integer a, Integer b) -> a * b);
        System.out.println(result2);//20160

//        ===================================================================

        Random random = new Random();
        int[] list = random.ints(50000000).toArray();

        System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list)
                .filter(e -> e > 0)//所有大於0的數
                .sorted()//從小到大排序
                .limit(5)//找到前五個數值
                .toArray();//將結果轉存成Array
        System.out.println(Arrays.toString(list1));//Arrays.toString()可以把Array裡面的內容轉成字串輸出
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential execution time is " + (endTime - startTime) + "milliseconds");

        startTime = System.currentTimeMillis();
        int[] list2 = IntStream.of(list)
                .parallel()//進行parallel()同步運算
                .filter(e -> e > 0)
                .sorted()
                .limit(5)
                .toArray();
        System.out.println(Arrays.toString(list2));
        endTime = System.currentTimeMillis();
        System.out.println("Parallel execution time is " + (endTime - startTime) + "milliseconds");

    }
}
