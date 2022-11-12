import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input_data{
    int action;
    private long first_prime_number;
    private long second_prime_number;
    public Input_data()throws IOException{
        Action();
        if(action  == 1){
            input_simple_number();
        } else if (action == 2) {
            random_simple_number();
        }
    }
    private void random_simple_number()throws IOException {
        generation_simple_number gen = new generation_simple_number();
        first_prime_number = gen.getFirst_number();
        second_prime_number = gen.getSecond_number();
        System.out.println("первое число: " + first_prime_number);
        System.out.println("второе число: " + second_prime_number);
    }
    private void input_simple_number(){
        Scanner read = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("Введите первое простое число: ");
                first_prime_number = read.nextInt();
                if (simle_number(first_prime_number)) {
                    flag = false;
                }else{
                    System.out.println("\nпервое число не простое");
                    input_simple_number();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nошибка в воде первого числа");
                input_simple_number();
                break;
            }
            try {
                System.out.print("Введите второе простое число: ");
                second_prime_number = read.nextInt();
                if (simle_number(second_prime_number)){
                    if(first_prime_number == second_prime_number){
                        flag = true;
                        System.out.println("\nДва числа одинаковы");
                    }
                }else {
                    System.out.println("\nВторое число не простое");
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nошибка в воде первого числа");
                input_simple_number();
                break;

            }
        }
    }
    private void Action(){
        boolean flag = true;
        Scanner read = new Scanner(System.in);
        while (flag) {
            try {
                System.out.print("Выберите действие:\n1-свои простые числа\n2-случайные числа\nдействие: ");
                action = read.nextInt();
                if (action == 1 || action == 2){
                    flag = false;

                }else{ System.out.println("вы выбрали не правильное число");}
            } catch (InputMismatchException e) {
                System.out.println("ввдеите число");
                Action();
                flag = false;
            }
        }

    }
    private boolean simle_number(long number){
        for (long j = 2; j < number; j++) {
            if (number % j == 0) {
                return false;
            }
        }

        return true;
    }
    public long getFirst_prime_number(){
        return first_prime_number;
    }

    public long getSecond_prime_number() {
        return second_prime_number;
    }
}
