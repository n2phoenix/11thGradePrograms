import java.io.*;
class primepalin_main
{    
    public static void main() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        int m = 0;
        int n = 0;
        while (!(m >= 100 && n <= 3000))
        {
        System.out.println ("Enter lower limit: ");
        m = Integer.parseInt (in.readLine());
        System.out.println ("Enter upper limit: ");
        n = Integer.parseInt (in.readLine());
        if (!(m >= 100 && n <= 3000))
        System.out.println ("Enter valid values! ");
        }
        
        primepalin num = new primepalin();
        
        System.out.print ("Output: ");
        String s = "";
        for (int i = m; i <= n; i++)
        {
            if (num.prime (i) && num.palin (i))
            s += i + ", ";
        }
        
        s = s.substring (0, s.length() - 2);
        System.out.print (s);
        System.out.println ();
    }
}
