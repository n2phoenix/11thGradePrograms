import java.io.*;
class wordextract
{
    int n; String sen[]; 
    String words[][];
    
    void accept() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        System.out.println ("Enter number of sentences: ");
        int n = Integer.parseInt (in.readLine());
        
        while (n < 1 || n > 4)
        {
            System.out.println ("Enter a valid value! ");
            n = Integer.parseInt (in.readLine());
        }
        
        sen = new String [n];
        for (int i = 0; i < n; i++)
        {
            System.out.println ("Enter a sentence ending with a full stop or exclamation mark: ");
            sen[i] = in.readLine();
        }
    }
    
    void extract() 
    {
        words = new String [n][longsen()];
        
        for (int i = 0; i < n; i++)
        {
            String temp = sen [i];
            String[] set;
            temp = temp.replaceAll (",", "");
            temp = temp.replaceAll (".", "");
            temp = temp.replaceAll ("!", "");
            set = temp.split ("\\s");
            words[i] = set;
        }
    }
    
    int longsen ()
    {
        int var = words[0].length;
        for (int i = 1; i < n; i++)
        {
            if (var < words [i].length)
            var = words[i].length;
        }
        
        return var;
    }
}
