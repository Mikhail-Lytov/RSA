import java.io.*;
import java.math.BigInteger;

public class Signature {
    private String name_file_txt;
    private String name_file_close_key;
    private BigInteger signature;
    private BigInteger close_key;
    private BigInteger derivative;
    Signature(String name_file_txt, String name_file_close_key) throws IOException {
        this.name_file_txt = name_file_txt;
        this.name_file_close_key = name_file_close_key;
        new open_close_key_file();
        new open_text_file();

    }
    class open_text_file{
        private open_text_file() throws IOException {
            String line ;
            String line_sum = "";
            FileReader file_txt_ = new FileReader(name_file_txt);
            BufferedReader buf_txt = new BufferedReader(file_txt_);
            while ((line = buf_txt.readLine()) != null){
                line_sum += line + "\n";
            }
            file_txt_.close();
            buf_txt.close();
            line_sum = line_sum.substring(0,line_sum.length() - 1);

            SHACustom sha = new SHACustom(line_sum);
            BigInteger sha_int = sha.toBiginteger_SHA();

            if(sha_int.compareTo(derivative) <= -1){
                signature = sha_int.modPow(close_key,derivative);
                FileWriter file_signature = new FileWriter(name_file_txt);
                file_signature.write(line_sum + "\n" + signature.toString());
                file_signature.close();

            }else{System.out.println("Ключ мал");}
        }

    }

    class open_close_key_file{
        private open_close_key_file() throws IOException {
            FileReader file_txt = new FileReader(name_file_close_key);
            BufferedReader buf = new BufferedReader(file_txt);
            String line_1 = buf.readLine();
            //System.out.println(line_1);
            String line_2 = buf.readLine();
            line_1 = line_1.substring(16);
            line_2 = line_2.substring(11);
            close_key = new BigInteger(line_1);
            derivative = new BigInteger(line_2);
            buf.close();
            file_txt.close();
        }
    }



}
