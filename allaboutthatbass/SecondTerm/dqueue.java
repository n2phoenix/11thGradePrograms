package SecondTerm;

class dqueue
{
int N[];
int F, R;

dqueue() //Default constructor
{
F = R = -1;
N = new int [100];
}

int addfront (int n) //Add values from the front
{
if (F == -1) //If queue is empty
{
F = R = 0;
N[F] = n;
return 1;
}

if (F == 0) //if pointer is at first position
{
return 0;
}

//default addition
F--; 
N[F] = n;
return 1;
}

int addrear (int n) //Add values from the rear
{
if (R == -1)
{
F = R = 0;
N[R] = n;
return 1;
}

if (R == N.length - 1)
return 0;

R++;
N[R] = n;
return 1;
}

int delfront() //Delete values from the front
{
if (F == -1)
return 0;
int g;

if (F == R)
{
g = N [F];
F = R = -1;
return g;
}

g = N[F];
F++;
return g;
}

int delrear() //Delete values from the rear
{
if (R == -1)
return 0;
int g;

if (F == R)
{
g = N [R];
F = R = -1;
return g;
}

g = N[R];
R--;
return g;
}

void display() //Display all values in queue
{
if (F == -1)
  System.out.println ("Dqueue is Empty!");
else
for (int i = F; i <= R; i++)
System.out.print (N[i] + " "); 
System.out.println();
}

void destroy() //Terminate the program
{
System.out.println ("Program terminated.");
}
}
