import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String PATH_TO_FILE = "./src/resources/lng-big.csv";
        Scanner scanner = new Scanner(System.in);
        int mode = -1;

        System.out.println("Вывод:\n1-файл\n2-stdout");
        while (mode == -1) {
            int tempMode = scanner.nextInt();
            switch (tempMode) {
                case 1, 2 -> mode = tempMode;
                default -> System.out.println("Неверное значение, введите еще раз:");
            }
        }
        scanner.close();
        //Вычисление времени работы программы
        long time = System.currentTimeMillis();

        //чтение csv
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of(PATH_TO_FILE));
        String row;
        Tree tree = new Tree();
        while ((row = bufferedReader.readLine()) != null) {
            String[] data = row.split(";");
            if (Utils.validateStr(row)) {
                continue;
            }
            CSVString csvString = new CSVString(data[0], data[1], data[2]);
            tree.add(csvString);
        }
        //выявление групп
        List<Group> groups = tree.detour().stream().sorted().toList();
        int i = 0;
        int countBiggestGroups = 0;
        while (i < groups.size()) {
            if (groups.get(i).size() > 1) {
                countBiggestGroups++;
            }
            i++;
        }
        if (mode == 2) {
            System.out.println("Кол-во групп, больших 1: " + countBiggestGroups);
            for (int j = 0; j < groups.size(); j++) {
                System.out.println("Группа " + (j + 1));
                System.out.println(groups.get(j).toString());
            }
        } else  {
            try(FileWriter writer = new FileWriter("./src/resources/result.txt", false)) {
                writer.write("Кол-во групп, больших 1: " + countBiggestGroups + "\n");
                for (int j = 0; j < groups.size(); j++) {
                    writer.write("Группа " + (j + 1) + "\n");
                    writer.write(groups.get(j).toString() + "\n");
                }
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

        bufferedReader.close();
        System.out.println("Время работы программы: " + (double)(System.currentTimeMillis() - time) / (double)(1000));
    }
}
