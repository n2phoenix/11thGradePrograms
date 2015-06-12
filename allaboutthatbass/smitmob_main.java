import java.io.*;
class smitmob_main
{
    public static void main() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        System.out.println ("Enter number: ");
        int n = Integer.parseInt (in.readLine());

        System.out.println ("Enter choice: ");
        System.out.println ("1. Smith function ");
        System.out.println ("2. Mobius function ");
        byte ch = Byte.parseByte (in.readLine());
        smithmobius num = new smithmobius();

        switch (ch)
        {
            case 1: //Smith function
            if (num.prime (n)) //Returns true if n = composite number
            {
                int sum1 = num.digitch1 (n);
                String sumstr = num.primefact (n);
                int sum2 = 0;
                sumstr = sumstr.substring(0, sumstr.length()-1);
                for (int i = 0; i < sumstr.length(); i++)
                {
                    char c = sumstr.charAt (i);
                    if (Character.isDigit (c))
                        sum2 += Character.getNumericValue (c);
                }
                if (sum1 == sum2)
                {
                    System.out.println (n + " is a Smith number. ");
                    System.out.println ("Factors: " + sumstr);
                }
                else
                    System.out.println (n + " is not a Smith number. ");
            }

            else
                System.out.println ("Number is already prime - smith function not applicable");
            break;

            case 2: //Mobius function
            {
                String x = "";
                if (n == 1)
                    System.out.println ("M(n) = 1");
                else
                    x = num.primefact (n);
                int mob = -1;
                String xt = x.replace ("*", " ");
                String[] res = xt.split("\\s");
                
                for (int i = 0; i < res.length; i++)
                {
                    for (int j = i + 1; j < res.length; j++)
                    {
                        int a = Integer.parseInt (res[i]);
                        int b = Integer.parseInt (res[j]);
                        if (a == b)
                        {
                            mob = 0;
                            break;
                        }
                    }
                    if (mob == 0)
                    break;
                }
                
                x = n + " = " + x.substring (0, x.length() - 1);
                x = x.replace ("*", " * ");
                if (mob == 0)
                System.out.println ("M(n) = 0 --> (" + x + ")");
                else if (mob == -1)
                System.out.println ("M(n) = -1 --> (" + x + ")");
            }
        }
    }
}