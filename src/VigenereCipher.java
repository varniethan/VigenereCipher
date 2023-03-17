import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
//                data += "\n";
                data_String.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
         var filePath = Paths.get("./src/"+filename);

        try{

            String content = Files.readString(filePath);
            System.out.println("String Present:"+content);
            content = content.toUpperCase();
            for (int i = 0; i < content.length(); i++)
            {
                System.out.print(content.charAt(i));
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
//        System.out.println(data);
        return data_String;
    }
    @Override
    public String encrypt(String message_filename, String key_filename)
    {
        //Split the message
        ArrayList<String> message_string = this.readfile(message_filename);
        ArrayList<String> key_string = this.readfile(key_filename);
        StringBuilder builder = new StringBuilder(key_string.size());
        for(String ch: key_string)
        {
            builder.append(ch);
        }
        int key_length = builder.length();
        String key = builder.toString();
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
        String result = "";
//        StringBuilder result = new StringBuilder(key_string.size());
        int j = 0;
        for (ArrayList line: splited_line)
        {
            for (Object word: line)
            {
//                System.out.println(word);
//                System.out.println(word.toString().length());
                String word_to_decrypt = word.toString();
                for (int i = 0; i < word_to_decrypt.length(); i++)
                {
                    char message_letter = word_to_decrypt.charAt(i);
                    System.out.println("Mletter: "+message_letter);
                    System.out.println("J: "+j);
                    if (i == 0 && Character.isWhitespace(message_letter))
                        continue;
                    if (Character.isLetter(message_letter))
                    {
                        char key_letter = key.charAt(j);
                        int message_letter_index = (int) message_letter - 65;
                        int key_letter_index = (int) key_letter - 65;
                        System.out.println("M: "+message_letter+" : "+message_letter_index+" K: "+key_letter+" : "+key_letter_index);
                        int number = (message_letter_index + key_letter_index) % 26;
                        System.out.println("EXP :"+(message_letter_index + key_letter_index));
                        System.out.println(number);
                        System.out.println("Encrypted: "+(char) (number+65));
                        result += ((char) (number+65));
                    }
                    else
                    {
                        result += message_letter;
                    }
                    j = (j+1) % key_length;

//                    j++;
//                    if (j >= key_length-1)
//                    {
//                        j = 0;
//                    }
                }
                System.out.println(result);
            }
            j++;
        }
        return null;
    }

    @Override
    public String decrypt(String message_filename, String key_filename)
    {
        return null;
    }
}
