import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHACustom {
    MessageDigest md;
    String message;
    String str_SHA_hex;

    public SHACustom(String message){
        this.message = message;
        //System.out.println(toHEX());
    }
    private void toHEX(){
        byte[] digest = new byte[0];
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.reset();
            md.update(message.getBytes());
            digest = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger bigint = new BigInteger(1, digest);
        String SHA_HEX = bigint.toString(16);
        while (SHA_HEX.length() < 64){
            SHA_HEX = "0" + SHA_HEX;
        }
        str_SHA_hex = SHA_HEX;
        System.out.println(SHA_HEX);

    }
    public BigInteger toBiginteger_SHA(){
        toHEX();
        BigInteger sum = new BigInteger(String.valueOf(0));
        BigInteger element =  new BigInteger(String.valueOf(0));
        String element_str;
        Long SHA_int;
        BigInteger step_16 = new BigInteger(String.valueOf(16));
        for(int i = 0; i < 64; i++){
            element_str = str_SHA_hex.substring(i, i+1);
            SHA_int = Long.parseLong(element_str, 16);
            element_str = SHA_int.toString();
            element = new BigInteger(element_str);
            element = element.multiply(step_16.pow(64 - i - 1));
            sum =  sum.add(element);
        }
        System.out.println(sum.toString());
        return sum;
    }
}
