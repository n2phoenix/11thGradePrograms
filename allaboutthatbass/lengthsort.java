import java.io.*;
class lengthsort
{
    public static void main() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        System.out.println ("Enter a sentence: (max 80 chars): ");
        String s = in.readLine();
        
        while (s.length() > 80)
        {
            System.out.println ("Error: Enter a sentence of less than 80 chars!");
            s = in.readLine();
        }
        s = s.replace (".", " ");
        String[] set = s.split ("\\s");
        
        String maxl[] = set;
        int k = 0;
        
        for (int i = 0; i < set.length - 1; i++)
        {
            for (int j = i + 1; j < set.length; j++)
            {
            if (set[i].length() > set[j].length())
            maxl[k] = i + "";
            else
            maxl[k] = j + "";
            k++;
            }
        }
    }
}
