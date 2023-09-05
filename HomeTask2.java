import java.io.FileNotFoundException;
import java.util.Scanner;

public class HomeTask2 {
    public static void main(String[] args) throws Exception {
        //Задание 1
        // float num = getFloat();
        // System.out.println(num);
    
        //Задание 2
        // task2(0);

        //Задание 3
        // task3();

        //Задание 4
        String res = isEmpty();
        System.out.println(res);
    }

    //Задание 1
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
    // Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static float getFloat() {
        System.out.println("Введите число с плавающей запятой: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            float num = Float.parseFloat(input);
            sc.close();
            return num;
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат строки!");
            return getFloat();
        }
    }

    //Задание 2
    
    public static void task2(int d) {
        if (d == 0) throw new ArithmeticException("Catching exception: by zero");
        int[] intArray = {17, 3, 13, 4, 6, 7, 81, 54, 23};
        double catchedRes1 = Double.valueOf(intArray[8]) / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    }

    //Задание 3

    public static void task3() throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2, 3, 4 };
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Делить на 0 нельзя!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    //Задание 4
    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    private static String isEmpty(){
        System.out.println("Введите сообщение: ");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        sc.close();
        if (message.equals("")) throw new RuntimeException("Нельзя вводить пустую строку!");
        else return message;
    }




}