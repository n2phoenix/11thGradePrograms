import java.util.Scanner;
import java.io.*;
public class emp_main
{
    public static void main() throws IOException
    {
        Scanner in = new Scanner (System.in);
        employee emp[] = new employee [2];

        for (int i = 0; i < 2; i++)
        {
            emp[i] = new employee();
            emp[i].accept();
        }

        for (int i = 0; i < 1; i++)
        {
            for (int j = i + 1; j < 2; j++)
            {
                if (emp[i].name.compareTo (emp[j].name) > 0)
                {
                    employee temp = emp[i];
                    emp[i] = emp[j];
                    emp[j] = temp;
                }
            }
        }

        for (int i = 0; i < 2; i++)
            emp[i].display();
    }
}