import java.io.*;
import SecondTerm.date;
public class employee
{
    int emp_id;
    String name;
    date DOJ;
    
    public void accept() throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        System.out.println ("Enter employee ID: ");
        emp_id = Integer.parseInt (in.readLine());
        System.out.println ("Enter name: ");
        name = in.readLine();
        System.out.println ("Enter date of joining - ");
        System.out.println ("Enter days: ");
        int dt = Integer.parseInt (in.readLine());
        System.out.println ("Enter months: ");
        int mn = Integer.parseInt (in.readLine());
        System.out.println ("Enter year: ");
        int yr = Integer.parseInt (in.readLine());
        DOJ = new date(dt,mn,yr);
    }

    public void display()
    {
        System.out.println (emp_id + "    " + name + "    " + DOJ.dt + "/" + DOJ.mn + "/" + DOJ.yr);
    }
}