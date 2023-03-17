import java.util.ArrayList;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Vigenere Cipher World");
        VigenereCipher cipher = new VigenereCipher();
        VigenereCipher_2 cipher_42 = new VigenereCipher_2();
//        cipher.readfile("./src/encrypt_check.txt");
//        cipher_42.encrypt("encrypt_check.txt", "key_check.txt");
//        cipher_42.decrypt("decrypt_check.txt", "key_check.txt");
        ArrayList<Double> test_vals = new ArrayList<Double>();
        //9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0
        test_vals.add(9.0);test_vals.add(8.0);test_vals.add(7.0);test_vals.add(6.0);test_vals.add(5.0);test_vals.add(4.0);test_vals.add(3.0);test_vals.add(2.0);test_vals.add(1.0);
        System.out.println("Original values: " + test_vals.toString());
        CustomSort ss = new CustomSort();
        ss.setValues(test_vals);
        System.out.println("Sorted values: " + test_vals.toString());
        System.out.println("Gaps used: " + ss.getGaps().toString());
    }
}