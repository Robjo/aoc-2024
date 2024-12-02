import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner reader;
        try {
            File data = new File("data.txt");
            reader = new Scanner(data);
            int sum = 0;

            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            
            while (reader.hasNextLine()) {
                leftList.add(Integer.parseInt(reader.next()));
                rightList.add(Integer.parseInt(reader.next()));
            }

            leftList.sort(Integer::compareTo);
            rightList.sort(Integer::compareTo);

            for (int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    if (leftList.get(i).equals(rightList.get(j))) {
                        sum += leftList.get(i);
                    }
                }
            }
            System.out.println(sum);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Som ting is wrong innit");
        }
    }
}
