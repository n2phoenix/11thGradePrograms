package SecondTerm;

    import java.io.*;
    class date_main
    {
        public static void main() throws IOException
        {
            DataInputStream in = new DataInputStream (System.in);
            System.out.println ("Enter your date in one format: ");
            System.out.println ("1. To default values - 1/1/1990.");
            System.out.println ("2. Enter days, month and year as numbers individually. ");
            System.out.println ("3. Enter date in the format dd/mm/yyyy.");
            byte ch = Byte.parseByte (in.readLine());
            boolean check = false;
            date dmy = new date();
            switch (ch)
            {
                case 1: 
                dmy = new date();
                System.out.println ("Default values set!");
                break;
    
                case 2:
                while (!check)
                {
                    System.out.println ("Enter days: ");
                    int d = Integer.parseInt (in.readLine());
    
                    System.out.println ("Enter month: ");
                    int m = Integer.parseInt (in.readLine());
    
                    System.out.println ("Enter year: ");
                    int y = Integer.parseInt (in.readLine());
    
                    dmy = new date(d, m, y);
    
                    if (dmy.validate())
                    {
                        System.out.println ("Date has been set!");
                        check = true;
                    }
                    else
                        System.out.println ("Enter a valid date! ");
                }
                break;
    
                case 3:
                while (!check)
                {
                    System.out.println ("Enter date in the format: dd/mm/yyyy: ");
                    System.out.println ("Example - 1st March 2013 - 01/03/2013");
                    String sentdate = in.readLine();
    
                    dmy = new date (sentdate);
                    if (dmy.validate())
                    {
                        System.out.println ("Date has been set!");
                        check = true;
                    }
                    else
                        System.out.println ("Enter a valid date! ");
                }
                break;
    
                default: 
                System.out.println ("Enter a default option. ");
                break;
            }
    
            System.out.println ("Choose an operation to perform: ");
            System.out.println ("1. Add days to the date. ");
            System.out.println ("2. Subtract days from the date. ");
            System.out.println ("3. Find difference between two dates. ");
            ch = Byte.parseByte (in.readLine());
    
            switch (ch)
            {
                case 1:
                int d, m, y;
                System.out.println ("Enter number of days to be added: ");
                int n = Integer.parseInt (in.readLine());
                date newSet = dmy.addDays(n);
                System.out.println ("The new date is: " + newSet.dt + "/" + newSet.mn + "/" + newSet.yr + ".");
                break;
    
                case 2:
                System.out.println ("Enter number of days to be subtracted: ");
                n = Integer.parseInt (in.readLine());
                newSet = dmy.subDays(n);
                System.out.println ("The new date is: " + newSet.dt + "/" + newSet.mn + "/" + newSet.yr + ".");
                break;
    
                case 3:
                System.out.println ("Enter days: ");
                d = Integer.parseInt (in.readLine());
    
                System.out.println ("Enter month: ");
                m = Integer.parseInt (in.readLine());
    
                System.out.println ("Enter year: ");
                y = Integer.parseInt (in.readLine());
    
                date parDate = new date (d, m, y);
                System.out.println ("The difference in days is: " + Math.abs (dmy.diff (parDate)));
            }
        }
    }
