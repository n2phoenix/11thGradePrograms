package SecondTerm;

import java.io.*;
class queue_main
{
public static void main() throws IOException
{
DataInputStream in = new DataInputStream (System.in);
QU list = new QU();
System.out.println ("Enter a custom queue size? Y/N");
char c = (char) in.readChar();


switch (c)
{
case 'Y':
System.out.println ("Enter size: ");
int y = Integer.parseInt (in.readLine());
list = new QU(y);
break;

default:
System.out.println ("Enter a default value.");
break;
}

System.out.println ("Choose option: ");
System.out.println ("1. Add an entry. ");
System.out.println ("2. Delete an entry. ");
System.out.println ("3. Display the queue. ");
System.out.println ("4. Exit program. ");
int a = Integer.parseInt (in.readLine());

do
{
switch (a)
{
case 1:
System.out.println ("Enter value to be added: ");
list.add (Integer.parseInt (in.readLine()));
break;

case 2:
list.del();
break;

case 3:
list.display();
break;

case 4:
list.destroy();
break;
}
} while (a != 4);
}
}