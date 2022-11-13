import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class signature_verification {
    private String name_file_signature_file;
    private String name_file_open_key;
    private BigInteger signature;
    private String message = "";
    private BigInteger open_exhibitor;
    private BigInteger derivative;

    public signature_verification(String name_file_signature_file, String name_file_open_key) throws IOException {
        this.name_file_signature_file = name_file_signature_file;
        this.name_file_open_key = name_file_open_key;
        data_file_signature_file();
        data_name_file_open_key();

    }
    public String check(){
        String md_5_hex;
        BigInteger md5_int;
        BigInteger signature_check;
        md5custom md5 = new md5custom();
        md_5_hex = md5.md5Custom(message);
        md5_int = md5.md_5_10(md_5_hex);
        BigInteger check = new BigInteger("0");
        if ((md5_int.compareTo(derivative)) <= -1){
            check = signature.modPow(open_exhibitor, derivative);
            if((check.compareTo(md5_int)) == 0){
                return "сошлось";
            }
        }
        return "не сошлось";
    }
    private void data_name_file_open_key()throws IOException{
        FileReader file_open_key = new FileReader(name_file_open_key);
        BufferedReader buf = new BufferedReader(file_open_key);
        String open_exhibitor = buf.readLine();
        String derivative = buf.readLine();
        open_exhibitor = open_exhibitor.substring(15);
        derivative = derivative.substring(11);
        System.out.println("open" + open_exhibitor);
        this.open_exhibitor = new  BigInteger(open_exhibitor);
        this.derivative = new BigInteger(derivative);
        //System.out.println(open_exhibitor + "\n" + derivative);
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
        System.out.println("text" + message);
        System.out.println("sign" + signature);
        this.signature = new BigInteger(signature);
        buf_signature_file.close();
        read_signature_file.close();
    }
}
