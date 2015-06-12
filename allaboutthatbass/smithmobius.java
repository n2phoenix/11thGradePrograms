import java.io.*;
class smithmobius
{
    public boolean prime (int n)
    {
        boolean b = false;
        for (int i = 2; i <= n/2; i++)
        {
            if (n % i == 0)
            {
                b = true;
                break;
            }
        }
        return b;
    }

    public int digitch1 (int n)
    {
        int n1 = n;
        int sum = 0;
        if (n < 10 && n > 0)
            sum = n;
        else
        {
            while (n1 != 0)
            {
                sum += n1 % 10; 
                n1 /= 10;
            }
        } 
        return sum;
    }

    public String primefact (int n)
    {
        int n1 = n;
        int n2 = n/2;
        String str = "";
        for (int i = 2; i <= n2; i++)
        {
            if (n1 % i == 0 && !(prime (i)))
            {
                while (n1 != 0 && n1 % i == 0)
                {
                    str += i + "*";
                    n1 /= i;
                }
            }
        }
        return str;
    }
}