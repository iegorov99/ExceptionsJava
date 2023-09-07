package HomeTask3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        String[] arrInfo = getInfo();
        makeRecord(arrInfo);
    }

    public static String[] getInfo() {
        System.out.println("Введите фаимилю, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол (символ латиницей f или m) через пробел");
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        sc.close();
        String[] arr = info.split(" ");
        if (arr.length != 6) throw new RuntimeException("Введено неверное количество параметров!");
        else return arr;
    }


    public static void makeRecord(String[] arr) throws Exception {
        try {
            String lastame = arr[0];
            String firstname = arr[1];
            String surname = arr[2];

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date birthday = format.parse(arr[3]);

            Integer number = Integer.parseInt(arr[4]);

            String gender = arr[5];
            if (!gender.equals("m") && !gender.equals("f")) throw new RuntimeException("Неверно указан пол!");

            // String fileName = "Users/79257/Desktop/GB/HomeTasksExceptions/HomeTask3" + lastame.toLowerCase() + "txt";

            File file = new File("HomeTask3\\" + lastame.toLowerCase() + ".txt");
            try (FileWriter writer = new FileWriter(file, true)){
                if (file.length() > 0) writer.write("\n");
                writer.write(String.format("%s %s %s %s %s %s", lastame, firstname, surname, format.format(birthday), number, gender));
                writer.close();
            } catch (IOException e) {
                e.getStackTrace();
                throw new IOException("Ошибка при работе с файлом!");
                
            }

        } catch (ParseException e) {
            throw new ParseException("Неверный формат даты!", e.getErrorOffset());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат номера телефона!");
        }         
    }
    
}
