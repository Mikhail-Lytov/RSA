import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class signature {
    private String name_file_txt;
    private String name_file_close_key;
    private BigInteger signature;
    signature(String name_file_txt, String name_file_close_key) throws IOException {
        this.name_file_txt = name_file_txt;
        this.name_file_close_key = name_file_close_key;
        FileReader file_txt = new FileReader(name_file_close_key);
        BufferedReader buf = new BufferedReader(file_txt);
        String line_1 = buf.readLine();
        String line_2 = buf.readLine();
        line_1 = line_1.substring(16);
        line_2 = line_2.substring(11);
        BigInteger close_key = new  BigInteger(line_1);
        BigInteger derivative = new BigInteger(line_2);
        //System.out.println(line_1 + "\n" + line_2);
        buf.close();
        file_txt.close();


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
        //System.out.print(line_sum);
        //System.out.println("все");
        md5custom md5 = new md5custom();
        String md5_x = md5.md5Custom(line_sum);
        BigInteger md5_10 = md5.md_5_10(md5_x);
        //System.out.println(line_sum);
        //System.out.println(md5_x);
        //System.out.println(md5_10);
        if(md5_10.compareTo(derivative) <= -1){
            signature = md5_10.modPow(close_key,derivative);
            //System.out.println(signature);
            FileWriter file_signature = new FileWriter("signature_"+name_file_txt, true);
            file_signature.write(line_sum + "\n");
            file_signature.write(signature.toString());
            file_signature.close();

        }else{System.out.println("Ключ мал");}
    }



}
