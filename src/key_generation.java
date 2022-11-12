import java.util.ArrayList;
import java.util.Random;

public class key_generation {
    private long first_element;
    private long second_element;
    private long derivative;
    private long euler_function;
    private long e;
    private long lcm_element;
    private long open_exhibitor;
    private long close_exhibitor;
    public key_generation(long first_element, long second_element){
        this.first_element = first_element;
        this.second_element = second_element;
        this.derivative = first_element * second_element;
        this.euler_function = (first_element - 1) * (second_element - 1);
        this.open_exhibitor = open_exhibitor();
        this.close_exhibitor = close_exhibitor();

    }
    public key_generation(long first_element, long second_element, boolean speed){
        this.first_element = first_element;
        this.second_element = second_element;
        this.derivative = first_element * second_element;
        this.euler_function = (first_element - 1) * (second_element - 1);
        if (speed && (derivative % 65537 != 0)) {
            this.open_exhibitor = 65537;
        }else{ this.open_exhibitor = open_exhibitor();}
        this.close_exhibitor = close_exhibitor();

    }
    private long close_exhibitor(){
        long close_exhibitor = 1;
        while (true){
            if((close_exhibitor * open_exhibitor)%euler_function == 1){
                return close_exhibitor;
            }
            close_exhibitor ++;
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
    private long open_exhibitor(){
        long open_exhibitor = this.euler_function - 1;
        //long euler_function = this.euler_function;
        boolean flag = true;
        int size_element = 0;
        ArrayList<Long> list_simple_number = new ArrayList<Long>(1000);
        while (open_exhibitor > 1 && size_element <= 1000){

            for (long i = 2; i<= euler_function;i++){
                if(open_exhibitor % i == 0 && euler_function % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("true");
                size_element ++;
                list_simple_number.add(open_exhibitor);
                System.out.println(list_simple_number);
            }
            flag = true;
            open_exhibitor--;

        }
        /*while (open_exhibitor > 1){
            for (long i = 2; i <= euler_function; i++) {
                if (open_exhibitor % i == 0 && euler_function % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("true");
                if (simle_number(open_exhibitor)){
                    list_simple_number.add(open_exhibitor);
                }
                System.out.println(list_simple_number);
            }
            flag = true;
            open_exhibitor--;
        }*/

        Random r = new Random();
        open_exhibitor = list_simple_number.get(r.nextInt(0, list_simple_number.size()));
        System.out.println(open_exhibitor);
        return open_exhibitor;
    }
    public Close_key get_close_key(){

        return new Close_key(close_exhibitor, derivative);
    }


    public Open_key get_open_key(){
        return new Open_key(open_exhibitor, derivative);
    }



}
