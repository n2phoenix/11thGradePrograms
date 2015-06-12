package SecondTerm;

class prime_queue
{
    int q[];
    int f;
    int r;
    prime_queue() //default constructor
    {
        q = new int[20];
        f=r=-1;
    }

    void push_prime (int m, int n)
    {
        for(int i = m; i <= n; i++) 
        {
            if(check_prime(i)) //checking if number is prime
            {
                if(f==-1) 
                {
                    f=r=0;
                    q[r] = i;
                }
                else if(f == 0 && r == q.length-1)
                {
                    System.out.println("full");
                    break;
                }
                else
                {
                    r++;
                    q[r] = i;
                }
            }
            else
            continue;
        }
    }

    boolean check_prime (int n)
    {
        int flag = 0;
        for(int i = 2;i<n;i++)
        {
            if(n % i == 0) //Looking for prime factors and incrementing flag if found
                flag++;
            else
                continue;
        }
        if(flag > 0) //If flag has been thrown for factors
            return false;
        else
            return true;
    }

    void display()
    {
        if(f == -1)
        System.out.println ("No primes added to queue. Try adding a few numbers.");
        else
        {
        System.out.println ("The following primes in the queue are: ");
        for(int i = f;i<=r;i++)
        System.out.println(q[i]);
        }
    }
    
    void destroy()
    {
        System.out.println ("Program terminated. ");
    }
}