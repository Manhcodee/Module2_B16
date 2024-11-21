import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhap duong dan file");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        readFileText(path);
    }

    public static void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br  = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("tong = " + sum);
        }
        catch (Exception e) {
            System.out.println("file khong ton tai hoac noi dung sai");
        }
    }
}