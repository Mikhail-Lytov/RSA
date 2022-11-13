import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5custom {

    public md5custom() {
    }

    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
    public BigInteger md_5_10(String md5_x){
        BigInteger sum = new BigInteger(String.valueOf(0));
        BigInteger element = new BigInteger(String.valueOf(0));
        String element_str;
        Long md5_int;
        BigInteger step_16 = new BigInteger(String.valueOf(16));
        //System.out.println("md5:" + md5_x);
        for(int i = 0; i <32; i++){
            element_str = md5_x.substring(i,i + 1);
            //System.out.println("16:" + element_str);
            md5_int = Long.parseLong(element_str,16);
            element_str = md5_int.toString();
            element = new BigInteger(element_str);
            element = element.multiply(step_16.pow(32-i -1 ));
            sum = sum.add(element);

            //System.out.println("10:" + element_str);
            //System.out.println("element:" + element);
            //System.out.println("sum:" + sum);
        }
        return sum;
    }
}
