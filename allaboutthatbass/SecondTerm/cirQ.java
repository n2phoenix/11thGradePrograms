package SecondTerm;

class cirQ
{
int f, r;
int a[];

cirQ() //default constructor
{
r = f = -1;
a = new int [10];
}

cirQ (int x) //paramterized constructor
{
r = f = -1;
a = new int [x];
}

void add (int x) //add values to circular queue
{
if (f == -1 && r == -1)
{
f = r = 0;
a[r] = x;
return;
}

if (f == 0 && r == a.length - 1 && f - r == 1)
{
System.out.println ("Full");
return;
}

if (f > 0 && r == a.length - 1)
{
r = 0;
a[r] = x;
return;
}
r++;
a [r] = x;
}

int del() //Delete value from circular queue
{
int g;
if (f == -1)
{
System.out.println ("Empty");
return 0;
}

if (f == r)
{
g = a [f];
f = r = -1;
return g;
}

if (f == a.length - 1)
{
g = a[f];
f = 0;
return g;
}

g = a[f];
f++;
return g;
}

public void display() //Display all values in queue
{
if (f == -1)
  System.out.println ("Empty");
else
for (int i = f; i <= r; i++)
System.out.print (a[i] + " "); 
System.out.println();
}

public void destroy() //Terminate the program
{
System.out.println ("Program terminated.");
}

}