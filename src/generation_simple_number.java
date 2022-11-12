import java.io.*;
import java.util.Random;

public class generation_simple_number {
    private String[] data;
    private long first_number;
    private long second_number;
    public generation_simple_number() throws IOException {
        try {
            File file = new File("first_number.txt");
            FileInputStream read = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            read.read(bytes);
            String s = new String(bytes);
            data = s.split(", ");
            First_number();
            Second_number();
        }catch (FileNotFoundException e){
            System.out.println("ошибка открытия файла, проверьте наличие файла");
        }


    }
    private void First_number(){
        Random random = new Random();
        String element = data[random.nextInt(0,8363 / 6 % 100000)];
        first_number = Long.parseLong(element);
        //System.out.println(first_number);
    }
    private void Second_number(){
        Random random = new Random();
        boolean flag = true;

        while (flag){
            String element = data[random.nextInt(0,8363 / 6 % 100000)];
            second_number = Long.parseLong(element);
            if (second_number != first_number){
                flag = false;
            }
        }
    }

    public long getFirst_number() {
        return first_number;
    }

    public long getSecond_number() {
        return second_number;
    }
}
