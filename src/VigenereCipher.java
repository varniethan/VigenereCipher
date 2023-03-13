import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VigenereCipher implements Cipher
{

    public ArrayList<String> readfile(String filename)
    {
        String data;
        ArrayList<String> data_String = new ArrayList<String>();
        try
        {
            File file = new File("./src/"+filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
            {
                data = reader.nextLine();
                data_String.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data_String;
    }
    @Override
    public String encrypt(String message_filename, String key_filename)
    {
        //Split the message
        ArrayList<String> message_string = this.readfile(message_filename);
        ArrayList<String> key_string = this.readfile(key_filename);
        int key_size = key_string.size();
        String key = (this.readfile(key_filename)).toString();
        StringBuilder builder = new StringBuilder(key_string.size());
        for(String ch: key_string)
        {
            builder.append(ch);
        }
        builder.toString();
        int key_length = builder.length();
        ArrayList<ArrayList> splited_line = new ArrayList<>();
        for (String message: message_string)
        {
            int counter = 0;
            ArrayList<String> splited_word = new ArrayList<>();
            for (int i = 0; i < message.length(); i = counter)
            {
                String temp_word = "";
                int limit = i+key_length;
                for (int j = i; j < limit; j++)
                {
                    if (j+1 <= message.length())
                    {
                        temp_word += Character.toUpperCase((message.charAt(j)));
                        if (!Character.isLetter(message.charAt(j)))
                        {
                            limit += 1;
//                            counter += 1;
                        }
                    }
                    counter = j+1;
                }
                splited_word.add(temp_word);
            }
            splited_line.add(splited_word);
        }
        System.out.println(splited_line);

        for (ArrayList line: splited_line)
        {
            for (Object word: line)
            {

            }
        }
        return null;
    }

    @Override
    public String decrypt(String message_filename, String key_filename)
    {
        return null;
    }
}
