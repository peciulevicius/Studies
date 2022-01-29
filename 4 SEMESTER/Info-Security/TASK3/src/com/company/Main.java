//The message is encrypted using the sender's private key and recipient's public key.
//The message is decrypted with the recipient's private key and sender's public key.
// That's how I understood this.

package com.company;
import java.math.*; // for BigInteger
import java.sql.Connection; // for database
import java.sql.DriverManager; // for database
import java.sql.Statement; // for database
import java.util.*; // for Scanner

/*
    I was doing the program without primes before realising I was doing it wrong and had many problems with this.

    Here is a list of prime numbers: http://compoasso.free.fr/primelistweb/page/prime/liste_online_en.php

    I do not recommend using really big numbers like over 1000 since the program takes a minute to calculate.

    Small numbers don't really work as well. Guessing this is the reason?:
    https://crypto.stackexchange.com/questions/15021/rsa-problem-if-i-choose-two-specific-small-prime-numbers

    Public keys and results are stored as numbers in separate database files.
*/

public class Main {

    public static void main(String args[]) {
        run(); //calling run method
    }

    private static final Scanner scanner = new Scanner(System.in);
    private int p, q, n, z, d = 0, e, i;
    // p and q  -> PRIMES
    // n        -> n = p * q    (module)
    // d        -> PRIVATE KEY
    // z (fi)   -> z = (p - 1)*(q - 1) (how many co-prime numbers)

    // e        -> PUBLIC KEY (1-fi) (cannot be smaller than 1 and be bigger than fi)
    // i        -> looping variable

    private Main() {

        System.out.println("Enter PRIME number p: ");   //taking in user entered primes
        p = scanner.nextInt();
        System.out.println("Enter PRIME number q: ");   //taking in another prime
        q = scanner.nextInt();

        n = p * q;                                      //computing n
        z = (p - 1) * (q - 1);                          //computing z(fi)
        System.out.println("the value of z = (p - 1) * (q - 1)  = " + z);

        for (e = 2; e < z; e++) {
            if (gcd(e , z) == 1) {
                break;
            }
        }
        System.out.println("the value of e (public key) = " + e);

        /*=========== CALCULATING D (PRIVATE KEY) ===========*/
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("Private key (d) is = " + d);
    }


    /*=========== e range - 1-z ===========*/
    //computing the greatest common divisor
    private static int gcd(int e, int z) {
        if (e == 0) {
            return z;
        } else {
            return gcd(z % e, e);
        }
    }

    /*=========== Returning encrypted C = message ^e mod n ===========*/
    private double encrypt(int message) {
        return (Math.pow(message, e)) % n;
    }

    /*=========== Encrypt accepts String and returns double[] ===========*/
    private double[] encrypt(String message) {
        int[] charactersAsNumbers = new int[message.length()];
        for(int i = 0; i < message.length(); i++) {
            charactersAsNumbers[i] = message.codePointAt(i);
        }
        System.out.println("Plaintext as sequence of numbers: " + Arrays.toString(charactersAsNumbers));

        double[] encryptedMessage = new double[message.length()];
        for(int i = 0; i < charactersAsNumbers.length; i++) {
            encryptedMessage[i] = encrypt(charactersAsNumbers[i]);
        }
        return encryptedMessage;
    }

    /*=========== Decrypt accepts double[] and returns String ===========*/
    private BigInteger decrypt(double encrypted) {
        BigInteger N = BigInteger.valueOf(n);                           //converting int value of n to BigInteger
        BigInteger C = BigDecimal.valueOf(encrypted).toBigInteger();    //converting float value of c to BigInteger
        return (C.pow(d)).mod(N);                                       //Decrypt , P = Cˆd mod N , messageDecrypted = P
    }


    private String decrypt(double[] encrypted) {
        StringBuilder builder = new StringBuilder();
        for(double encryptedCharacter: encrypted) {
            BigInteger decryptedCharacter = decrypt(encryptedCharacter);
            builder.append(Character.toChars(decryptedCharacter.intValue()));
        }
        return builder.toString();
    }


    private static void run() {
        System.out.println("Hello, please enter the message you want to encrypt and decrypt ");
        String message = scanner.nextLine();
        Main main = new Main();

        double[] c = main.encrypt(message);
        System.out.println("Encrypted message: " + Arrays.toString(c));

        String messageDecrypted = main.decrypt(c);
        System.out.println("Decrypted message: " + messageDecrypted);
        try{
            Connection keyConn = null;
            Connection resultConn = null;
            Statement statement = null;
            Class.forName("org.sqlite.JDBC");

            /*=========== Storing information into two different databases ===========*/
            /*== It should be stored in separate databases if I understood it correctly from the lecture? ==*/

            /*=========== STORING PUBLIC KEY ===========*/
            keyConn = DriverManager.getConnection
                    ("jdbc:sqlite:D:\\MY FILES\\Studies\\4 SEMESTER" +
                            "\\Information-Security\\TASK3\\src\\com\\company\\key.db");
            statement = keyConn.createStatement();
            statement.executeUpdate("INSERT INTO KeyTable ('public_key') VALUES ('" + main.e + "')");

            /*=========== STORING ENCRYPTED MESSAGE ===========*/
            resultConn = DriverManager.getConnection
                    ("jdbc:sqlite:D:\\MY FILES\\Studies\\4 SEMESTER" +
                            "\\Information-Security\\TASK3\\src\\com\\company\\result.db");
            statement = resultConn.createStatement();
            statement.executeUpdate("INSERT INTO TextTable ('finalMessage') VALUES ('" + Arrays.toString(c) + "')");

            keyConn.close();
            resultConn.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}