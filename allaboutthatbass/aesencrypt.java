import java.io.*;
public class aesencrypt
{
    static DataInputStream in = new DataInputStream (System.in);
    public static void main() throws IOException //Accepting data
    {
        System.out.println ("Enter the message to encrypt/decrypt: ");
        String s = in.readLine(); //Storing message
        s.trim();

        System.out.println ("Choose technique: ");
        System.out.println ("1. Shift Technique ");
        System.out.println ("2. ASCII Technique ");
        byte ch = Byte.parseByte (in.readLine());
        System.out.println ();

        switch (ch)
        {
            case 1: //Shift Technique
            System.out.println ("Shift value? ");
            byte x = Byte.parseByte (in.readLine()); //byte preserves memory, expected values are 1 - 26
            System.out.println();

            System.out.println ("1. Encrypt or 2. Decrypt?");
            byte de = Byte.parseByte (in.readLine());

            System.out.println();
            String ans = techniqueA (s, x, de);
            if (de == 1)
                System.out.println ("The encrypted string is " + ans);
            else if (de == 2)
                System.out.println ("The decrypted string is " + ans);
            else
                System.out.println ("Enter a valid value!");
            break;

            case 2: //ASCII Technique
            System.out.println ("1. Encrypt or 2. Decrypt?");
            de = Byte.parseByte (in.readLine());
            x = 0;
            ans = techniqueB (s, de);
            if (de == 1)
                System.out.println ("The encrypted string is " + ans);
            else if (de == 2)
                System.out.println ("The decrypted string is " + ans);
            else
                System.out.println ("Enter a valid value!");
            break;

            default:
            System.out.println ("Enter a valid option! ");
        }
    }

    static String techniqueA (String s, byte x, byte de) //Technique 1 - Shifting letters
    {
        String ans = "";
        s = s.trim();
        s += " ";
        int l = s.length();

        switch (de) //Choosing between encrypting or decrypting according to choice variable de
        {
            case 1: //Encrypting given string
            for (int i = 0; i < l; i++)
            {
                char c = s.charAt (i);
                int a = (int) c;

                if (a >= 65 && a <= 90) //For A - Z
                {
                    a -= (x - 1); //To apply the difference in ASCII
                    if (a < 65)
                        a = 91 - (65 - a); //If ASCII goes before 'A', the letter goes backwards through Z, Y etc.
                    ans += (char) a;       //Adds letter to string ans
                }
                else if (a >= 97 && a <= 122) //For a - z
                {
                    a -= (x - 1); //To apply the difference in ASCII
                    if (a < 97)
                        a = 123 - (97 - a); 
                    ans += (char) a;
                }
                else if (a == 32) //Substituting spaces for double Q
                    ans += "QQ";
                else
                    ans += c; //Special characters are added directly
            }
            String temp = new String();
            for (int i = 0; i < ans.length(); i++) //Separating encrypted letters into blocks of six
            {
                if (i == 6 || (i % 6 == 0 && i > 7))
                    temp += " ";
                temp += ans.charAt (i);
            }
            ans = temp;
            break;

            case 2: //Decoding given string
            s = s.replace(" ", "");
            int len = s.length();
            String dletter = s.charAt (len - 1) + ""; 
            dletter += dletter;

            s = s.replace (dletter, " ");
            len = s.length();
            for (int i = 0; i < len; i++)
            {
                char c = s.charAt (i);
                int a = (int) c;
                if (a >= 65 && a <= 90)
                {
                    a += (x - 1);
                    if (a > 90)
                        a = 64 + (a - 90);
                    ans += (char) a;
                }
                else if (a >= 97 && a <= 122)
                {
                    a += (x - 1);
                    if (a > 122)
                        a = 96 + (a - 122);
                    ans += (char) a;
                }

                else
                    ans += c;
            }
            break;
        }
        return ans;
    }

    static String techniqueB (String s, byte de)
    {
        s = s.trim();
        String ans = "";

        switch (de)
        {
            case 1: //encrypt
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt (i);
                int a = (int) c;
                ans += a + "";
            }
            String temp = "";
            ans += "32";

            for (int i = ans.length() - 1; i >= 0; i--) //For reversing the string
                temp += ans.charAt (i);
            ans = temp;
            break;

            case 2: //decrypt
            s = s.replace (" ", "");
            s = s.trim();
            int len = s.length();
            ans = "";
            temp = "";
            for (int i = s.length() - 1; i >= 0; i--) //For reversing the string
                temp += s.charAt (i);
            s = temp;
            s = s.trim();
            for (int i = 0; i < len; i++)
            {
                int d = 0;
                int j = 0;
                if (i != len - 1)
                {
                    d = Character.getNumericValue (s.charAt (i));
                    j = Character.getNumericValue (s.charAt (i + 1));
                }
                else
                    break;

                if (d == 6 || d == 7 || d == 8) //For all capital letters except Z
                {
                    int x = (d * 10) + j;
                    char c = (char) x;
                    ans += c;
                    i++;
                }
                else if (d == 9) //For Z, a, b and c (last three are small letters)
                {
                    if (j == 0)
                        ans += "Z";
                    else if (j == 7)
                        ans += "a";
                    else if (j == 8)
                        ans += "b";
                    else if (j == 9)
                        ans += "c";
                    i++;
                }
                else if (d == 1)
                {
                    int x = 0;
                    int k = Character.getNumericValue (s.charAt (i + 2));
                    if (j == 0)
                    {
                        x = 100 + k;
                    }
                    else if (j == 1)
                    {
                        x = 110 + k;
                    }
                    else if (j == 2)
                    {
                        x = 120 + k;
                    }
                    char c = (char) x;
                    ans += c;
                    i += 2;
                }
                else if (d == 3 && j == 2)
                    ans += " ";
            }   
            break;
        }
        return ans;
    }
}