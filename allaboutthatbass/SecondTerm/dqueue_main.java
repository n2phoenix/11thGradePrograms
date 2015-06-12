package SecondTerm;

import java.io.*;
class dqueue_main
{
public static void main() throws IOException
{
DataInputStream in = new DataInputStream (System.in);
dqueue set = new dqueue();
int a;

do
{
System.out.println ("Choose option: ");
System.out.println ("1. Add an entry to the rear. ");
System.out.println ("2. Add an entry to the front. ");
System.out.println ("3. Display the queue. ");
System.out.println ("4. Exit program. ");
a = Integer.parseInt (in.readLine());

switch (a)
{
case 1:
System.out.println ("Enter value to be added to the rear: ");
set.addrear (Integer.parseInt (in.readLine()));
break;

case 2:
System.out.println ("Enter value to be added to the front: ");
set.addfront (Integer.parseInt (in.readLine()));
break;

case 3:
System.out.println ("The following entries are included in this queue: ");
set.display();
break;

case 4:
set.destroy();
break;

default:
System.out.println ("Enter a value listed in the menu!");
}
} while (a != 4);
}
}