public class Pidlatin
{    
    int len;
    String txt;
    String txt1;

    Pidlatin() // Your default constructor
    {
        txt = "Sample";
        len = txt.length();
        txt1 = txt;
    }

    void readstring (String t) //First function
    {
        txt = t;
        txt1 = t;
        len = txt.length();
    }

    void convert()
    {
        int pos = 0;
        int i = 0;
        while (pos == 0)
        {
            if (isVowel (txt.charAt (i)))
                pos = i;
            i++;
        }

        txt += txt.substring (0, pos) + "AY";
        txt = txt.substring (pos, txt.length());

        System.out.println ("Modified word: " + txt);
    }

    void consonant()
    {
        int con = 0;
        for (int i = 0; i < txt1.length(); i++)
        {
            if (!isVowel (txt.charAt(i)))
                con++;
        }

        System.out.println ("Number of consonants: " + con);
    }

    boolean isVowel (char c)
    {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else 
            return false;
    }
}

