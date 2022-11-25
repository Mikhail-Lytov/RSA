import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class key_output {
    private String path_close_key;
    private String path_open_key;
    public key_output(BigInteger open_exhibitor, BigInteger close_exhibitor, BigInteger derivative, BigInteger first_number, BigInteger second_number) throws IOException {
        output_open_key(open_exhibitor, derivative);
        output_close_key(close_exhibitor, derivative);
        simple_number(first_number, second_number);

    }
    private void output_open_key(BigInteger open_exhibitor, BigInteger derivative) throws IOException {
        File file = new File("open key.txt");
        path_open_key = file.getCanonicalPath();
        FileWriter output = new FileWriter(file);
        String open_exhib = open_exhibitor.toString();
        String der = derivative.toString();
        output.write("open exhibitor:" + open_exhib + "\nderivative:" + der);
        output.close();
    }
    private void output_close_key(BigInteger close_exhibitor, BigInteger derivative) throws IOException {
        File file = new File("close key.txt");
        path_close_key = file.getCanonicalPath();
        //System.out.println(file.getCanonicalPath());
        FileWriter output = new FileWriter(file);
        String close_exhib = close_exhibitor.toString();
        String der = derivative.toString();
        output.write("close exhibitor:" + close_exhib + "\nderivative:" + der);
        output.close();

    }
    private void simple_number(BigInteger first_number, BigInteger second_number) throws IOException {
        FileWriter output = new FileWriter("simple_number.txt");
        String first = first_number.toString();
        String second = second_number.toString();
        output.write("first number: " + first + "\nsecond number: " + second);
        output.close();
    }
    public String path_open_key(){
        return path_open_key;
    }
    public String path_close_key(){
        return path_close_key;
    }
}
