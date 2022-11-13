import java.math.BigInteger;
import java.util.Random;

import static java.math.BigInteger.probablePrime;

public class key_generation {
    private BigInteger open_exhibitor = BigInteger.ONE;
    private BigInteger close_exhibitor;
    private BigInteger euler_function;
    private int maxleng = 1024;
    private BigInteger second_number;
    private BigInteger derivative;
    private BigInteger first_number;

    public key_generation(){
        first_number = probablePrime(1024,new Random());
        second_number = probablePrime(1024, new Random());
        derivative = first_number.multiply(second_number);
        BigInteger first_number_sub_1 = first_number.subtract(BigInteger.ONE);
        BigInteger second_number_sub_1 = second_number.subtract(BigInteger.ONE);
        euler_function = first_number_sub_1.multiply(second_number_sub_1);
        //System.out.println(second_number + "\n" + first_number);
        gen();
        //BigInteger open_exhibitor = new BigInteger(String.valueOf(65537));
        //System.out.println("open " + open_exhibitor);
        //System.out.println("close " + close_exhibitor);

    }
    private void gen(){
        open_exhibitor = BigInteger.probablePrime(maxleng / 2, new Random());
        while (euler_function.gcd(open_exhibitor).compareTo(BigInteger.ONE) > 0 && open_exhibitor.compareTo(euler_function) < 0){
            open_exhibitor.add(BigInteger.ONE);
        }

        close_exhibitor = open_exhibitor.modInverse(euler_function);

        //System.out.println(open_exhibitor);

    }
    public BigInteger getOpen_exhibitor(){
        return open_exhibitor;
    }

    public BigInteger getClose_exhibitor(){
        return close_exhibitor;
    }
    public BigInteger getDerivative(){
        return derivative;
    }
    public BigInteger getFirst_number(){
        return first_number;
    }
    public BigInteger getSecond_number(){
        return second_number;
    }




}
