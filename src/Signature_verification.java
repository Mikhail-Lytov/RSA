import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Signature_verification {
    private String name_file_signature_file;
    private String name_file_open_key;
    private BigInteger signature;
    private String message = "";
    private BigInteger open_exhibitor;
    private BigInteger derivative;

    public Signature_verification(String name_file_signature_file, String name_file_open_key) throws IOException {
        this.name_file_signature_file = name_file_signature_file;
        this.name_file_open_key = name_file_open_key;
        data_file_signature_file();
        data_name_file_open_key();

    }
    public String check() throws IOException {
        SHA sha = new SHA(message);
        BigInteger sha_int = sha.getInteger();
        BigInteger check = new BigInteger("0");
        if ((sha_int.compareTo(derivative)) <= -1){
            check = signature.modPow(open_exhibitor, derivative);
            if((check.compareTo(sha_int)) == 0){
                FileWriter file = new FileWriter(name_file_signature_file);
                file.write(message);
                file.close();
                return "подлинный";
            }
        }
        return "фальсификация";
    }
    private void data_name_file_open_key()throws IOException{
        FileReader file_open_key = new FileReader(name_file_open_key);
        BufferedReader buf = new BufferedReader(file_open_key);
        String open_exhibitor = buf.readLine();
        String derivative = buf.readLine();
        open_exhibitor = open_exhibitor.substring(15);
        derivative = derivative.substring(11);
        this.open_exhibitor = new  BigInteger(open_exhibitor);
        this.derivative = new BigInteger(derivative);

        buf.close();
        file_open_key.close();
    }
    private void data_file_signature_file()throws IOException {
        String signature = "";
        String line = "";
        FileReader read_signature_file = new FileReader(name_file_signature_file);
        BufferedReader buf_signature_file = new BufferedReader(read_signature_file); // чек buf
        while ((line = buf_signature_file.readLine()) != null){
            message += line + "\n";
            signature = line;
        }
        message = message.substring(0, message.length() - signature.length() - 2);

        this.signature = new BigInteger(signature);
        buf_signature_file.close();
        read_signature_file.close();
    }
}
