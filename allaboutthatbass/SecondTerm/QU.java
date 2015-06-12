package SecondTerm;

class QU
{
int n[];
int r, f;

QU() //default constructor
{
r = f = -1;
n = new int [10];
}

QU (int x) //parameterized constructor
{
r = f = -1;
n = new int [x];
}

public void add (int a) //add values to queue
{
if (r == -1)
{
f = r = 0;
n[f] = a;
return;
}
r++;
n[r] = a;
}

public int del() //Deletes the last value from the queue if applicable
{
if (f == -1)
{
System.out.println ("Empty");
return -1;
}

if (f == r)
{
int g = n[f];
f = r = -1;
return g;
}
int g = n[f];

for (int i = f; i <= r; i++)
n[i] = n[i + 1];

return g;
}

public void display() //Displays all values in queue
{
if (f == -1)
  System.out.println ("Empty");
else
for (int i = f; i <= r; i++)
System.out.print (n[i] + " "); 
}

public void destroy() //To terminate the program
{
System.out.println ("Program terminated.");
}
}
