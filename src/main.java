import java.io.IOException;
import java.math.BigInteger;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        key_generation a = new key_generation();
        BigInteger open_exhibitor = a.getOpen_exhibitor();
        BigInteger close_exhibitor = a.getClose_exhibitor();
        BigInteger derivative = a.getDerivative();
        BigInteger first_number = a.getFirst_number();
        BigInteger second_number = a.getSecond_number();
        key_output output = new key_output(open_exhibitor, close_exhibitor, derivative, first_number, second_number);
        //System.out.println(open_exhibitor);
        signature key = new signature("1.txt", "close key.txt");
        Thread.sleep(1000 * 15);
        signature_verification open = new signature_verification("signature_1.txt", "open key.txt");
        System.out.println(open.check());
    }

}
