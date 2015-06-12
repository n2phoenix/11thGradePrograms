import java.io.*;
class ISP_main
{
    public static void main() throws IOException
    {
        int x = 2;
        while (x == 2)
        {
            DataInputStream in = new DataInputStream (System.in);
            System.out.println ("Enter hours: ");
            int h = Integer.parseInt (in.readLine());
            System.out.println ("Enter minutes: ");
            int m = Integer.parseInt (in.readLine());

            ISPTime startTime = new ISPTime();
            startTime.readtime (h, m);

            System.out.println ("Enter option: ");
            System.out.println ("1. Display time in minutes.");
            System.out.println ("2. Display minutes in time.");
            System.out.println ("3. Accept end time and find total time used. ");
            System.out.println ("4. Exit.");
            byte ch = Byte.parseByte (in.readLine());

            while (ch < 1 || ch > 4)
            {
                System.out.println ("ENTER A VALID OPTION!");
                ch = Byte.parseByte (in.readLine());
            }

            switch (ch)
            {
                case 1:
                System.out.println ("Time in minutes: " + startTime.timetominutes (startTime));
                break;

                case 2:
                System.out.println ("Enter minutes: ");
                m = Integer.parseInt (in.readLine());
                startTime.minutestotime (m);
                break;

                case 3:
                System.out.println ("Enter hours: ");
                h = Integer.parseInt (in.readLine());
                System.out.println ("Enter minutes: ");
                m = Integer.parseInt (in.readLine());
                ISPTime endTime = new ISPTime();            
                endTime.readtime (h, m);
                ISPTime internetTime = startTime.diff (startTime, endTime);

                internetTime.disptimeansi();
                break;
                
                case 4:
                System.out.println ("Closing methods and cleaning up....");
                break;
                
                default:
                System.out.println ("Enter a valid value!");
            }
            
            System.out.println ("Do you want to terminate? ");
            System.out.println ("1. Yes");
            System.out.println ("2. No");
            x = Integer.parseInt (in.readLine());
        }
    }
}
