
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class A {
    public static void main(String[] args) {
        Path path = Path.of("data.txt");
        int sum = 0;
        Pattern p1 = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Pattern p2 = Pattern.compile("-?\\d+");

        try (Stream<String> input = Files.lines(path)) {
            String lines = input.collect(Collectors.joining());
            Matcher matcher = p1.matcher(lines);
            String s = "";

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