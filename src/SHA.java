import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class SHA {
    private int number_blocks = 0;
    private int h0 = 0x6a09e667;
    private int h1 = 0xbb67ae85;
    private int h2 = 0x3c6ef372;
    private int h3 = 0xa54ff53a;
    private int h4 = 0x510e527f;
    private int h5 = 0x9b05688c;
    private int h6 = 0x1f83d9ab;
    private int h7 = 0x5be0cd19;
    private static int[] ARR_CONST = {0x428a2f98,0x71374491,0xb5c0fbcf,0xe9b5dba5,0x3956c25b,0x59f111f1,0x923f82a4,0xab1c5ed5,
            0xd807aa98,0x12835b01,0x243185be,0x550c7dc3,0x72be5d74,0x80deb1fe,0x9bdc06a7,0xc19bf174,
            0xe49b69c1,0xefbe4786,0x0fc19dc6,0x240ca1cc,0x2de92c6f,0x4a7484aa,0x5cb0a9dc,0x76f988da,
            0x983e5152,0xa831c66d,0xb00327c8,0xbf597fc7,0xc6e00bf3,0xd5a79147,0x06ca6351,0x14292967,
            0x27b70a85,0x2e1b2138,0x4d2c6dfc,0x53380d13,0x650a7354,0x766a0abb,0x81c2c92e,0x92722c85,
            0xa2bfe8a1,0xa81a664b,0xc24b8b70,0xc76c51a3,0xd192e819,0xd6990624,0xf40e3585,0x106aa070,
            0x19a4c116,0x1e376c08,0x2748774c,0x34b0bcb5,0x391c0cb3,0x4ed8aa4a,0x5b9cca4f,0x682e6ff3,
            0x748f82ee,0x78a5636f,0x84c87814,0x8cc70208,0x90befffa,0xa4506ceb,0xbef9a3f7,0xc67178f2};
    public SHA(String text){

        byte[] byte_text = String_in_Bytes(text);

        byte_text = add_one(byte_text);

        byte_text = add_zero(byte_text);

        for (int i = 0; i < number_blocks; i++) {
            int[] array_int  = words(Arrays.copyOfRange(byte_text, i * 64, 64 + i * 64));
            //System.out.println(Arrays.toString(array_int));
            array_int = add_words_zero(array_int);
            array_int = changing_zero_indexes(array_int);
            compression(array_int);

        }

    }
    private byte[] String_in_Bytes(String text){
        byte[] byte_text = text.getBytes();
        return byte_text;
    }
    private byte[] add_one(byte[] byte_text){
        byte_text = Arrays.copyOf(byte_text, byte_text.length + 1);
        byte_text[byte_text.length - 1] = (byte) 0b10000000;
        return byte_text;
    }
    private byte[] add_zero(byte[] byte_text){
        long size_array = byte_text.length; // для изменения размера массива
        long length_source_array = byte_text.length; // длина входного массива
        while (size_array % 64 != 0){
            byte_text = Arrays.copyOf(byte_text, byte_text.length + 1);
            byte_text[byte_text.length - 1] = (byte) 0b00000000;
            size_array = byte_text.length;

        }
        byte[] line = new byte[8];
        ByteBuffer line_array = ByteBuffer.allocate(line.length);
        line_array.putLong((length_source_array - 1) * 8);
        line = line_array.array();
        //System.out.println(Arrays.toString(line));
        for (int i = 0; i < line.length; i++){
            byte_text[Math.toIntExact(size_array - 1 - i)] = line[line.length - 1 - i];
        }

        number_blocks = (int) (size_array / 64);
        return byte_text;

    }
    private int[] words(byte[] byte_text){
        int[] array_int = new int[16];
        for (int i = 0; i < 16; i++) {
            byte[] byte_word = Arrays.copyOfRange(byte_text, i * 4, 4 + i * 4);
            array_int[i] = ByteBuffer.wrap(byte_word).getInt();
        }
        return array_int;
    }
    private int[] add_words_zero(int[] array_int){
        int size = array_int.length + 1;
        array_int = Arrays.copyOf(array_int, 64);
        Arrays.fill(array_int, size, 64, 0);

        return  array_int;
    }
    private int[] changing_zero_indexes(int[] array_int){
        long twe_32 = 4294967296l;

        for(int j = 16; j < 64; j++) {
            long s_0 = Integer.rotateRight(array_int[j-15], 7) ^ Integer.rotateRight(array_int[j-15], 18) ^ (array_int[j-15] >>> 3);
            long s_1 = Integer.rotateRight(array_int[j - 2], 17) ^ Integer.rotateRight(array_int[j - 2], 19) ^ (array_int[j - 2] >>> 10);
            long result = (array_int[j-16] + s_0 + array_int[j - 7] + s_1) % twe_32;
            array_int[j] = (int) result;
        }
        return array_int;
    }
    private void compression(int[] array_int){
        long twe_32 = 4294967296l;
        int a = h0;
        int b = h1;
        int c = h2;
        int d = h3;
        int e = h4;
        int f = h5;
        int g = h6;
        int h = h7;
        for(int j = 0; j < 64; j++){
            int Sum_1 = Integer.rotateRight(e, 6) ^ Integer.rotateRight(e, 11) ^ Integer.rotateRight(e,25);
            int Ch = (e & f) ^ ((~e) & g );
            int T_1 = (int) (h + Sum_1 + Ch + ARR_CONST[j] + array_int[j] % twe_32);
            int Sum_0 = Integer.rotateRight(a, 2) ^ Integer.rotateRight(a, 13) ^ Integer.rotateRight(a, 22);
            int Ma = (a & b) ^ (a & c) ^ (b & c);
            int T_2 = (int) (Sum_0 + Ma % twe_32);
            h = g;
            g = f;
            f = e;
            e = (int) (d + T_1 % twe_32);
            d = c;
            c = b;
            b = a;
            a = (int) (T_1 +T_2 % twe_32);

        }

        h0 += a;
        h1 += b;
        h2 += c;
        h3 += d;
        h4 += e;
        h5 += f;
        h6 += g;
        h7 += h;
    }
    public String gethex(){
        String hex = Integer.toHexString(h0) + Integer.toHexString(h1) + Integer.toHexString(h2) + Integer.toHexString(h3) + Integer.toHexString(h4) + Integer.toHexString(h5) + Integer.toHexString(h6) + Integer.toHexString(h7);
        return hex;
    }
    public int getH0(){
        return h0;
    }
    public int getH1(){
        return h1;
    }

    public int getH2() {
        return h2;
    }

    public int getH3() {
        return h3;
    }

    public int getH4() {
        return h4;
    }

    public int getH5() {
        return h5;
    }

    public int getH6() {
        return h6;
    }

    public int getH7() {
        return h7;
    }
    public BigInteger getInteger(){
        String hex =  gethex();
        BigInteger result = new BigInteger(String.valueOf(0));
        BigInteger element =  new BigInteger(String.valueOf(0));
        String element_str;
        Long SHA_int;
        BigInteger step_16 = new BigInteger(String.valueOf(16));
        for(int i = 0; i < hex.length(); i++){
            element_str = hex.substring(i, i+1);
            SHA_int = Long.parseLong(element_str, 16);
            element_str = SHA_int.toString();
            element = new BigInteger(element_str);
            element = element.multiply(step_16.pow(hex.length() - i - 1));
            result =  result.add(element);
        }
        return result;
    }
    public int getNumber_blocks(){
        return number_blocks;
    }
}
