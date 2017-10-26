//This code is mostly taken from page 112 in chapter 5 of Head First Java
import java.io.*;
public class IO
{
    public static String getUserInput(String prompt)
    {
        String inputLine = null;
        System.out.print(prompt + " ");
        try
        {
            BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0){return null;}
        }
        catch(IOException e)
        {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}