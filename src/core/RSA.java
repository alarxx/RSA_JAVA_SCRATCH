package core;

import java.math.BigInteger;

public class RSA {

    protected BigInteger n, phi, e, d;

    public void printParams(){
        System.out.println("n=" + n);
        System.out.println("e=" + e);
        System.out.println("d=" + d);
    }

    public RSA(BigInteger n, BigInteger e, BigInteger d){
//        setPhi(phi);
        setN(n);
        setE(e);
        setD(d);
    }

    public RSA(long n, long e, long d){
        this(BigInteger.valueOf(n), BigInteger.valueOf(e), BigInteger.valueOf(d));
    }

    public static RSA generateKeys(){
        BigInteger p1 = Prime.generatePrime(13, 100);
        BigInteger p2;
        do{
            p2 = Prime.generatePrime(13, 100);
        }while(p2.equals(p1));

        BigInteger n = p1.multiply(p2);

        BigInteger  p1_1 = p1.subtract(BigInteger.ONE),
                    p2_2 = p2.subtract(BigInteger.ONE);

        BigInteger phi = p1_1.multiply(p2_2);

        BigInteger e = generate_e(phi);

        // d = (k*phi(n)+1) / e
        BigInteger d = generate_d(phi, e);

        System.out.println("n = " + p1 + " x " + p2 + " = " + n);
        System.out.println("phi(n) = " + phi +", \ne = " + e);
        System.out.println("d=" + d + ", \nk="+d.multiply(e).subtract(BigInteger.ONE).divide(phi));

        return new RSA(n, e, d);
    }

    protected static BigInteger generate_e(BigInteger phi){
        BigInteger e = BigInteger.valueOf(3);
        while(!Euclid.GCD(e, phi).equals(BigInteger.ONE)){
            e = e.add(BigInteger.TWO);
        }
        return e;
    }

    protected static BigInteger generate_d(BigInteger phi, BigInteger e){
        BigInteger k = BigInteger.valueOf(1);

        while(!k.multiply(phi).add(BigInteger.ONE)
                .mod(e)
                .equals(BigInteger.ZERO)
        ){
            k = k.add(BigInteger.ONE);
        }
        return (k.multiply(phi).add(BigInteger.ONE)).divide(e);
//        return e.modInverse(phi);
    }


    public BigInteger encode(BigInteger value, BigInteger power){
        return value.modPow(power, n);
    }
    public String encode(String msg){
        return encode(msg, e);
    }
    public String encode(String msg, BigInteger power){
        StringBuilder sb = new StringBuilder();
        byte[] bytes = msg.getBytes();
        for(int i=0; i<bytes.length; i++){
            int ascii = bytes[i];
            BigInteger enc = encode(BigInteger.valueOf(ascii), power);
            sb.append(enc).append(' ');
        }
        return sb.toString().trim();
    }



    public BigInteger decode(BigInteger value, BigInteger power){
        return value.modPow(power, n);
    }
    public String decode(String cipher){
        return decode(cipher, d);
    }
    public String decode(String cipher, BigInteger power){
        StringBuilder result = new StringBuilder();

        StringBuilder letter = new StringBuilder();

        char[] bytes = cipher.toCharArray();

        for(int i=0; i<bytes.length; i++){
            int ascii = bytes[i];
//            System.out.println(i + ", " + bytes.length);
            if(ascii != (int)(' ')){
//                System.out.println((char)ascii);
                letter.append((char) ascii); // if ascii = character? 123ha13 например
                if(i != bytes.length - 1) {
                    continue;
                }
            }

            BigInteger value = new BigInteger(letter.toString());
            BigInteger dec = decode(value, power);
//                System.out.println("letter="+letter+", dec=" + dec);
            result.append((char)dec.intValue());
            letter.setLength(0); // clear word
        }

        return result.toString();
    }

    public String sign(String msg){
        return msg + "\n(" + encode(msg, d) + ")";
    }
    public boolean verify(String signedMsg) {
        // Найти начало и конец зашифрованного сообщения в скобках
        int startIndex = signedMsg.lastIndexOf("(");
        int endIndex = signedMsg.lastIndexOf(")");

        // Извлечь сообщение msg
        String msg = signedMsg.substring(0, startIndex - 1);

        // Извлечь зашифрованное сообщение
        String encodedMsg = signedMsg.substring(startIndex + 1, endIndex);

        System.out.println(msg);
        System.out.println(encodedMsg);
        String decoded = decode(encodedMsg, e);
        System.out.println(decoded);

        // Вернуть сообщение или что-то еще в зависимости от логики
        return msg.equals(decoded);
    }


    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getPhi() {
        return phi;
    }

    public void setPhi(BigInteger phi) {
        this.phi = phi;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }
}
