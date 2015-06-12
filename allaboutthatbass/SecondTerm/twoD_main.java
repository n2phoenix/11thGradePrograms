package SecondTerm;

import java.io.*; 
class twoD_main 
{ 
    static twoD matrix = new twoD(); 
    public static void main() throws IOException 
    { 
        DataInputStream in = new DataInputStream (System.in); 
        byte ch = 1; 
        while (ch != 4) 
        { 
            System.out.println ("Matrix manipulation: "); 
            System.out.println ("Choose your preferred option: "); 
            System.out.println ("1. Create a matrix. "); 
            System.out.println ("2. Create a matrix of preferred row and column size. "); 
            System.out.println ("3. Create a matrix with values of my own choosing. "); 
            System.out.println ("4. Exit the program. "); 
            System.out.println (); 
            ch = Byte.parseByte (in.readLine()); 
 
 
            int a1[]; 
            int a2[]; 
 
 
            switch (ch) 
            { 
                case 1: 
                matrix = new twoD(); 
                matrixop(); 
                break; 
 
 
                case 2: 
                System.out.println ("Enter row length: "); 
                int r = Integer.parseInt (in.readLine()); 
                System.out.println ("Enter column length: "); 
                int c = Integer.parseInt (in.readLine()); 
                matrix = new twoD (r, c); 
                matrixop(); 
                break; 
 
 
                case 3: 
                System.out.println ("Enter row length: "); 
                r = Integer.parseInt (in.readLine()); 
                System.out.println ("Enter column length: "); 
                c = Integer.parseInt (in.readLine()); 
                int k[][] = new int [r][c]; 
                 
                for (int i = 0; i < r; i++) 
                { 
                    for (int j = 0; j < c; j++) 
                    { 
                        System.out.println ("Enter value at " + (i + 1) + ", " + (j + 1)); 
                        k[i][j] = Integer.parseInt (in.readLine()); 
                    } 
                } 
                matrix = new twoD (k); 
                matrixop(); 
                break; 
 
 
                case 4: 
                System.out.println ("Program terminated. "); 
            }// end of switch 
        } 
    } 
 
 
    public static void matrixop() throws IOException 
    { 
        DataInputStream in = new DataInputStream (System.in); 
        byte ch = 1; 
        while (ch != 6) 
        { 
            System.out.println ("Choose your preferred matrix operation: "); 
            System.out.println ("WARNING: Do not perform operations 2 - 5 if you have not added values in option 1!"); 
            System.out.println ("1. Add values to the matrix. "); 
            System.out.println ("2. Find the highest value in the matrix. "); 
            System.out.println ("3. Find the lowest value in the matrix. "); 
            System.out.println ("4. Search for an element. "); 
            System.out.println ("5. Multiply the current array with a new array. "); 
            System.out.println ("6. Exit the program. "); 
            ch = Byte.parseByte (in.readLine()); 
 
 
            switch (ch) 
            { 
                case 1: 
                matrix.accept(); 
                break; 
 
 
                case 2: 
                System.out.println ("The highest value is: " + matrix.maxnum()); 
                break; 
 
 
                case 3: 
                System.out.println ("The lowest value is: " + matrix.minnum()); 
                break; 
 
 
                case 4: 
                System.out.println ("Enter value to search: "); 
                int x = Integer.parseInt (in.readLine()); 
                matrix.search (x); 
                break; 
 
 
                case 5: 
                System.out.println ("Enter row length: "); 
                int r = Integer.parseInt (in.readLine()); 
                System.out.println ("Enter column length: "); 
                int c = Integer.parseInt (in.readLine()); 
                int n[][] = new int [r][c]; 
 
 
                System.out.println ("Enter values: "); 
                for (int i = 0; i < r; i++) 
                { 
                    for (int j = 0; j < c; j++) 
                    { 
                        System.out.println ("Position " + (i + 1) + ", " + (j + 1) + ": "); 
                    } 
                } 
                 
                case 6: 
                System.out.println ("Program terminated. "); 
            } 
        } 
    } 
} 
 
 
 
 
 