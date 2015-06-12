package SecondTerm;

public class RingGame
{
    int Ring1[] = new int [10], Ring2[] = new int [10], Upper1, Upper2;
    RingGame() 
    {
    Upper1 = Upper2 = -1;
    }
    
    
    void push (int n) 
    {
    System.out.println ("Taking number " + n);
    if (Upper1 == Ring1.length - 1) // Full check
    {
        gameover();
        return;
    }
    
    if (Upper1 == -1 || n <= Ring1[Upper1]) // Empty check OR added value which is
    {   
        Upper1++;
        Ring1[Upper1] = n;
        System.out.println ("Added ring " + n + " to set!");
        return;
    }

    while (Upper1 != -1 && n > Ring1 [Upper1]) //Places smaller values in Ring2
    {
        Upper2++;
        Ring2 [Upper2] = Ring1 [Upper1];
        Upper1--;
    }
    Upper1++;
    Ring1 [Upper1] = n;
    System.out.println ("Added ring " + n + " to set!");
    
    while (Upper2 != -1) //Returns values to rings
    {
        Upper1++;
        Ring1 [Upper1] = Ring2 [Upper2];
        Upper2--;
    }
    System.out.println();
    gameover(); //To print final values
    }
    
    void gameover()
    {
        System.out.println ("Game over; the rings are full!");
        int sum = 0;
        while (Upper1 != -1)
        {
        System.out.println (Ring1[Upper1]);
        sum += Ring1[Upper1];
        Upper1--;
        }
        System.out.println ("The score obtained is: " + sum);
        return;
    }
    }