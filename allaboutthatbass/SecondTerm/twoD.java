package SecondTerm;

import java.io.*; 
class twoD 
{ 
    int m[][]; 
    int a, b; 
 
 
    twoD() 
    { 
        m = null; 
        a = 0; 
        b = 0; 
    } 
 
 
    twoD (int r, int c) 
    { 
        m = new int [r][c]; 
        a = 0; 
        b = 0; 
    } 
 
 
    twoD (int m1[][]) 
    { 
        m = m1; 
    } 
 
 
    void accept() throws IOException 
    { 
        DataInputStream in = new DataInputStream (System.in); 
 
 
        if (m == null) 
        { 
            System.out.println ("Enter rows: "); 
            a = Integer.parseInt (in.readLine()); 
            System.out.println ("Enter columns: "); 
            b = Integer.parseInt (in.readLine()); 
            m = new int [a][b]; 
        } 
 
 
        System.out.println ("Enter values: "); 
         
        for (int i = 0; i < a; i++) 
        { 
            for (int j = 0; j < b; j++) 
            { 
                System.out.println ("Position " + i + ", " + j + ": "); 
                m[i][j] = Integer.parseInt (in.readLine()); 
            } 
        } 
    } 
 
 
    int maxnum() 
    { 
        int temp = 0; 
        System.out.println (a); 
        for (int i = 0; i < a; i++) 
        { 
            for (int j = 0; j < b; j++) 
            { 
                if (temp < m [i][j]) 
                    temp = m [i][j]; 
            } 
        } 
        return temp; 
    } 
 
 
    int minnum() 
    { 
        int temp = 0; 
        for (int i = 0; i < a; i++) 
        { 
            for (int j = 0; j < b; j++) 
            { 
                if (temp > m [i][j]) 
                    temp = m [i][j]; 
            } 
        } 
        return temp; 
    } 
 
 
    void search (int x) 
    { 
        int row, col; 
        for (int i = 0; i < a; i++) 
        { 
            for (int j = 0; j < b; j++) 
            { 
                if (x == m[i][j]) 
                { 
                    row = i; 
                    col = j; 
                } 
            } 
        } 
    } 
 
 
    twoD multiply (twoD n2) 
    { 
        int fin[][]; 
        if (this.b == n2.a) 
        { 
            fin = new int [this.a][n2.b]; 
            for (int i = 0; i < this.a; i++) 
            { 
                for (int j = 0; j < n2.b; j++) 
                { 
                    for (int k = 0; k < fin.length; k++) 
                        fin [i][k] += m [i][k] * n2.m [k][j]; 
                } 
            } 
        } 
        else 
        { 
            System.out.println ("These two matrices cannot be multiplied as they are incompatible. "); 
            fin = null; 
        } 
 
 
        twoD answer = new twoD (fin); 
        return answer; 
    } 
} 