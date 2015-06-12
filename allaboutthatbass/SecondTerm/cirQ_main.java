package SecondTerm;

import java.util.*;
class cirQ_main
{
public static void main()
{
Scanner in = new Scanner (System.in);
cirQ list = new cirQ();
System.out.println ("Enter a custom queue size? Y/N");
char c = in.next().charAt(0);

switch (c)
{
case 'Y':
case 'y':
System.out.println ("Enter size: ");
int y = Integer.parseInt (in.nextLine());
list = new cirQ(y);
break;

default:
System.out.println ("Enter a default value.");
break;
}
int a;

do
{
System.out.println ("Choose option: ");
System.out.println ("1. Add an entry. ");
System.out.println ("2. Delete an entry. ");
System.out.println ("3. Display the queue. ");
System.out.println ("4. Exit program. ");
a = Integer.parseInt (in.nextLine());


switch (a)
{
case 1:
System.out.println ("Enter value to be added: ");
list.add (Integer.parseInt (in.nextLine()));
break;

case 2:
System.out.println ("Entry " + list.del() + " deleted.");
break;

case 3:
System.out.println ("The following entries are included in this queue: ");
list.display();
break;

case 4:
list.destroy();
break;

default:
System.out.println ("Enter a value listed in the menu!");
}
} while (a != 4);
}
}