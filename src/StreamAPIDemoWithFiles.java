import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemoWithFiles {

    public static void main(String[] args) throws IOException {

        //Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);去讀這個檔案，後面是編碼方式
        Stream<String> bands = Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);//Jackson Browne,Mumford and Sons,Rolling Stones
        bands.close();

//        ===================================================================

        Stream<String> bands2 = Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);
        List<String> myList = bands2
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        myList.forEach(name -> System.out.println(name));//Arijit Singh

        bands2.close();

//        ===================================================================

        Stream<String> rows = Files.lines(Paths.get("data.txt"), StandardCharsets.UTF_8);
        rows.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + "," + x[1] + "," + x[2]));
        rows.close();
//        B,17,2.8
//        D,23,2.7
//        F,18,3.4

//        ===================================================================

        Stream<String> rows2 = Files.lines(Paths.get("data.txt"), StandardCharsets.UTF_8);
        Map<String, Integer> map = rows2.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        map.forEach((key, value) -> {
            System.out.println(key + "," + value);
        });
//        B,17
//        D,23
//        F,18
    }


}
