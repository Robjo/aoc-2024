import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B {
    public static void main(String[] args) {
        Path path = Path.of("data.txt");
        int sum = 0;
        Pattern p1 = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Pattern p2 = Pattern.compile("-?\\d+");
        Pattern p3 = Pattern.compile("(?<=don't)(.*?)(?=do)");

        try (Stream<String> input = Files.lines(path)) {
            String lines = input.collect(Collectors.joining());
            Matcher m1 = p3.matcher(lines);
            String s = "";

            while (m1.find()) {
                lines = lines.replace(m1.group(), "");
            }
            Matcher matcher = p1.matcher(lines);

            while (matcher.find()) {
                s = s + matcher.group();
            }

            matcher = p2.matcher(s);

            int mul = 1;
            boolean second = false;
            while (matcher.find()) {
                if (!second) {
                    mul = Integer.parseInt(matcher.group());
                    second = true;
                } else {
                    sum += Integer.parseInt(matcher.group()) * mul;
                    second = false;
                }
            }

            System.out.println(sum);

        } catch (IOException e) {
            System.out.println("something went wrong");
        }
    }
}
