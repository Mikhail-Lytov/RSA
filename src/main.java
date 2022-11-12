import javax.management.BadAttributeValueExpException;
import javax.management.ValueExp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        long first_prime_number = 0;
        long second_prime_number = 0;
        Scanner read = new Scanner(System.in);
        try {
            System.out.println("Введите первое простое число");
            first_prime_number = read.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ошибка в воде первого числа");
            main a = new main();
            System.exit(0);
        }
        try {
            System.out.println("Введите второе простое число");
            second_prime_number = read.nextInt();
        }catch (InputMismatchException e){
            System.out.println("ошибка в воде первого числа");
            main a = new main();
            System.exit(0);
        }
        key_generation key = new key_generation(first_prime_number, second_prime_number);
        Close_key close_key = key.get_close_key();
        Open_key open_key = key.get_open_key();
        System.out.println(close_key);
        System.out.println(open_key);
    }
}
