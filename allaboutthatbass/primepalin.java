class primepalin
{
    public boolean prime (int n)
    {
        boolean b = true;
        for (int i = 2; i <= n/2; i++)
        {
            if (n % i == 0)
            {
                b = false;
                break;
            }
        }
        return b;
    }
    
    public boolean palin (int n)
    {
        String y = new StringBuilder(n + "").reverse().toString();
        int x = Integer.parseInt (y);
        if (n == x)
        return true;
        else
        return false;
    }
}
