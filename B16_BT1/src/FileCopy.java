/*Kiểm tra tệp nguồn:
Nếu không tồn tại, hiển thị cảnh báo.
Kiểm tra tệp đích:
Nếu đã tồn tại, cảnh báo người dùng và yêu cầu xác nhận ghi đè.
Sao chép nội dung:
Sử dụng các lớp trong java.io để đọc từ tệp nguồn và ghi vào tệp đích.
Đếm số ký tự:
Đếm số ký tự trong quá trình sao chép và hiển thị kết quả.
 */

import java.io.*;
import java.util.Scanner;
public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập đường dẫn tệp nguồn: ");
            String sourceFilePath = scanner.nextLine();
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()) {
                System.out.println("Tệp nguồn không tồn tại!");
                return;
            }

            System.out.print("Nhập đường dẫn tệp đích: ");
            String targetFilePath = scanner.nextLine();
            File targetFile = new File(targetFilePath);
            if (targetFile.exists()) {
                System.out.println("Tệp đích đã tồn tại. Bạn có muốn ghi đè? (y/n): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("y")) {
                    System.out.println("Hủy sao chép.");
                    return;
                }
            }

            int charCount = copyFile(sourceFile, targetFile);
            System.out.println("Sao chép hoàn tất!");
            System.out.println("Số ký tự trong tệp: " + charCount);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int copyFile(File source, File target) throws IOException {
        int charCount = 0;

        try (
                FileReader fileReader = new FileReader(source);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(target);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            int character;
            while ((character = bufferedReader.read()) != -1) {
                bufferedWriter.write(character);
                charCount++;
            }
        }
        return charCount;
    }
}