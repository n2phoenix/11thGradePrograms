import java.io.*;
class num_to_word
{
    static String ones[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String words10[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String tens[] = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"}; 

    public static void main() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        int exit = 0;

        do
        {
            int x;

            do
            {
                System.out.println ("Enter number - max 6 digits: ");
                x = Integer.parseInt (in.readLine());

                if (x < 0 || x > 999999)
                    System.out.println ("Enter a valid number from 0 to 999999");
            } 
            while (x < 0 || x > 999999);

            int ct = 0;
            String s = String.valueOf(x) ;
            ct = s.length();

            int arr[] = new int [ct];
            int temp = -1;
            int d = x;

            while (d != 0)
            {
                temp++;
                arr [temp] = d % 10;
                d /= 10;
            }

            switch (ct)
            {
                case 1:
                System.out.println (ones[x] + " - " + x);
                break;

                case 2:
                int t = arr[1];
                int o = arr[0];
                if (x == 10)
                    System.out.println ("Ten - 10");

                else if (x > 10 && x < 20)
                    System.out.println (words10[x - 11] + " - " + x);

                else if (o == 0)
                    System.out.println (tens [t - 1]);

                else if (x > 19 && x < 100)
                    System.out.println (tens[t - 1] + " " + ones [o] + " - " + x);           
                break;

                case 3:
                int h = arr[2];
                t = arr[1];
                o = arr[0];
                if (x == 100)
                    System.out.println ("One hundred - 100");

                else if (x > 100 && x < 1000)
                {   
                    if (t == 0 && o == 0)
                        System.out.println (ones [h] + " hundred ");
                    else if (t == 1)
                        System.out.println (" hundred and " + words10 [o]);
                    else if (t == 0)
                        System.out.println (" hundred and " + ones [o]);
                    else
                        System.out.println (" hundred and " + tens[t - 1] + " " + ones [o]);
                }
                break;

                case 4:
                int th = arr[3]; h = arr[2]; t = arr[1]; o = arr[0];
                if (x == 1000)
                    System.out.println ("One thousand - 1000");

                else if (h != 0 && t != 0 && o != 0)
                    System.out.println (ones [th] + " thousand " + hundred ((100 * h + 10 * t + o)) + " - " + x);
                    
                else if (h != 0 && o != 0)
                    System.out.println (ones [th] + " thousand " + ones [h] + " hundred and " + ones [o] + " - " + x);
                    
                else if (t != 0 && o != 0)
                    System.out.println (ones [th] + " thousand and " + tens [t - 1] + " " + ones [o] + " - " + x);
                    
                else if (h != 0 && t != 0)
                    System.out.println (ones [th] + " thousand and " + ones [h] + " and " + tens [t - 1] + " - " + x);
                    
                else if (h == 0 && o == 0)    
                    System.out.println (ones [th] + " thousand and " + tens [t - 1] + " - " + x);
                    
                else if (t == 0 && o == 0)
                    System.out.println (ones [th] + " thousand and " + ones [h] + " hundred");
                    
                else if (t == 0)
                    System.out.println (ones [th] + " thousand, " + ones [h] + " hundred and " + ones[o] + " - " + x);
                    
                else
                    System.out.println (ones [th] + " thousand - " + x);
                    
                break;

                case 5:
                int tt = arr[4]; th = arr[3]; h = arr[2]; t = arr[1]; o = arr[0];
                if (x == 10000)
                    System.out.println ("Ten thousand - 10000");

                else if (x > 10000 && x < 100000)
                {   
                    if (th == 0 && h == 0 && t == 0 && o == 0)
                        System.out.println (tens [tt - 1] + " thousand" + " - " + x);

                    else if (h == 0 && t == 0 && o == 0)
                    {
                        if (tt == 1)
                            System.out.println (words10 [th] + " thousand - " + x);
                        else
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand" + " - " + x);
                    }

                    else if (th == 0 && h == 0)
                    {
                        if (t == 0)
                            System.out.println (tens [tt - 1] + " thousand and " + ones [o] + " - " + x);
                        else if (t == 1)
                            System.out.println (tens [tt - 1] + " thousand and " + words10 [o] + " - " + x);
                        else if (t != 0)
                            System.out.println (tens [tt - 1] + " thousand and " + tens [t - 1] + " " + ones [o] + " - " + x);
                    }

                    else if (th == 0)
                    {
                        if (t == 0 && h == 0)
                            System.out.println (tens [tt - 1] + " thousand and " + ones [o] + " - " + x);
                        else if (t == 0 && o == 0)
                            System.out.println (tens [tt - 1] + " thousand and " + ones [h] + " hundred - " + x);
                        else if (t == 0)
                            System.out.println (tens [tt - 1] + " thousand, " + ones [h] + " hundred and " + ones [o] + " - " + x);
                        else if (t == 1)
                            System.out.println (tens [tt - 1] + " thousand, " + ones [h] + " hundred and " + words10 [o] + " - " + x);
                        else
                            System.out.println (tens [tt - 1] + " thousand, " + ones [h] + " hundred and " + tens [t - 1] + " " + ones [o] + " - " + x);
                    }

                    else if (h == 0 && t == 0)
                    {
                        if (tt == 1 && t != 1)
                            System.out.println (words10 [th - 1] + " thousand and " + tens [t - 1] + " " + ones [o] + " - " + x);
                        else if (tt == 1 && t == 1)
                            System.out.println (words10 [th - 1] + " thousand and " + ones[h] + words10 [o - 1] + " - " + x);
                        else
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand and " + ones [o] + " - " + x);
                    }

                    else if (h == 0)
                    {
                        if (tt == 1 && t != 1)
                            System.out.println (words10 [th] + " thousand and " + tens [t - 1] + " " + ones [o] + " - " + x);
                        else if (tt == 1 && t == 1)
                            System.out.println (words10 [th] + " thousand and " + ones[h] + words10 [o] + " - " + x);
                        else if (t == 1 && th != 0)
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand and " + words10 [o] + " - " + x);
                        else if (t == 1 && th == 0)
                            System.out.println (tens [tt - 1] + " thousand and " + words10 [o] + " - " + x);
                        else if (t != 0 && t != 1)
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand and " + tens [t - 1] + " " + ones [o] + " - " + x);
                        else if (t != 0)
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand and " + words10 [o] + " - " + x);
                        else
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand and " + ones [o] + " - " + x);
                    }

                    else if (t == 0)
                    {
                        if (tt == 1)
                            System.out.println (words10 [th - 1] + " thousand, " + ones [h] + " hundred and " + ones [o] + " - " + x);
                        else
                            System.out.println (tens [tt - 1] + " " + ones [th] + " thousand and " + ones [h] + " hundred and " + ones [o] + " - " + x);
                    }
                    else if (tt == 1 && t != 1)
                        System.out.println (words10 [th] + " thousand, " + ones [h] + " hundred and " + tens [t - 1] + " " + ones [o] + " - " + x);

                    else if (tt == 1 && t == 1)
                        System.out.println (words10 [th] + " thousand, " + ones [h] + " hundred and " + words10 [o] + " - " + x);

                    else if (t == 1)
                        System.out.println (tens [tt - 1] + " " + ones [th] + " thousand, " + ones [h] + " hundred and " + words10 [o] + " - " + x);

                    else
                        System.out.println (tens [tt - 1] + " " + ones [th] + " thousand, " + ones [h] + " hundred and " + tens [t - 1] + " " + ones [o] + " - " + x);
                }
                break;

                case 6:
                int h2 = arr [5]; int t2 = arr [4]; int o2 = arr [3]; 
                int h1 = arr [2]; int t1 = arr [1]; int o1 = arr [0];
                if (x == 100000)
                    System.out.println ("One hundred thousand - 100000");
                else if (x > 100000 && x < 999999)
                {   
                    int x1 = (100 * h1) + (10 * t1) + o1;
                    int x2 = (100 * h2) + (10 * t2) + o2;
                    System.out.println (hundred(x2) + " thousand, " + hundred (x1));
                }
                break;
            }
            System.out.println ("Exit? Yes - 1 / No - Any other number: ");
            exit = Integer.parseInt (in.readLine());
            System.out.println ();
        }  while (exit != 1);
    } 

    public static String hundred (int x)
    {
        String ans = "";
        String s = x + "";
        s.trim();
        byte h = (byte) Character.getNumericValue (s.charAt (0));
        byte t = (byte) Character.getNumericValue (s.charAt (1));
        byte o = (byte) Character.getNumericValue (s.charAt (2));
        if (x == 100)
            System.out.println ("One hundred - 100");

        else if (x > 100 && x < 1000)
        {   
            if (t == 0 && o == 0)
                ans += ones [h] + " hundred ";
            else if (t == 1)
                ans += ones [h] + " hundred and " + words10 [o];
            else if (t == 0)
                ans += ones [h] + " hundred and " + ones [o];
            else
                ans += ones [h] + " hundred and " + tens[t - 1] + " " + ones [o];
        }
        return ans;
    }
}