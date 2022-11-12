import java.io.IOException;

public class main {

    public static void main(String[] args)throws IOException {

        Input_data input = new Input_data();
        long first_prime_number = input.getFirst_prime_number();
        long second_prime_number = input.getSecond_prime_number();
        key_generation key = new key_generation(first_prime_number, second_prime_number, true);
        Close_key close_key = key.get_close_key();
        Open_key open_key = key.get_open_key();
        System.out.println(close_key);
        System.out.println(open_key);

    }

}
