package SecondTerm;

import java.io.*;
public class RingGame_main
{
    public static void main() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        RingGame play = new RingGame();
        
        System.out.println ("Enter loop iterations for entering a number: ");
        int n = Integer.parseInt (in.readLine());
        
        for (int i = 1; i <= n; i++)
        {
            play.push ((int) (Math.random() * 100));
        }
    }
}
