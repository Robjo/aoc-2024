import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class A {
    public static void main(String[] args) {
        Path path = Path.of("data.txt");
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        try (Stream<String> lines = Files.lines(path)) {
            for (String line : lines.toList()) {
                String[] digits = line.split(" ");

                for (String digit : digits) {
                    list.add(Integer.valueOf(digit));
                }

                if (isValid(list)) {
                    sum++;
                }
                list.clear();
            }
            System.out.println(sum);

        } catch (IOException e) {
            System.out.println("Som ting went wrong innit");
        }
    }

    private static boolean isValid(List<Integer> list) {
        boolean checkAscending = list.get(1) - list.get(0) > 0;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            int diffSize = Math.abs(diff);
            if (checkAscending) {
                if (diff < 0 || diffSize > 3 || diffSize < 1)
                    return false;
            } else {
                if (diff > 0 || diffSize > 3 || diffSize < 1)
                    return false;
            }
        }
        return true;
    }
}