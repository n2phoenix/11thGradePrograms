package SecondTerm;

import java.io.*;
public class TIME
{
    int hh; //Data Members
    int mn;
    int ss;
    TIME() //Default constructor
    {
        hh=mn=ss=0;
    }

    TIME (int hr,int mr,int sr) //Paramterized constructor
    {
        hh = hr; 
        mn = mr;
        ss = sr;

        if(!validate()) //To check if time is valid
            hh = mn = ss = 0;
    }

    TIME (String Time) //Parsing required data from the Time object into hours, minutes and seconds
    {
        hh = Integer.parseInt(Time.substring(0 , Time.indexOf(':'))); 
        mn = Integer.parseInt(Time.substring(Time.indexOf(':')+1 , Time.lastIndexOf(':')));
        ss = Integer.parseInt(Time.substring(Time.lastIndexOf(':')+1 , Time.length()));

        if(!validate()) //To check if time is valid
            hh = mn = ss = 0;
    }

    TIME (int seconds)
    {
        hh = seconds % 3600; 
        seconds -= (hh * 3600);
        mn = seconds % 60; 
        seconds -= (mn * 60);
        ss = seconds; 

        if(!validate())
            hh = mn = ss = 0;
    }

    boolean validate() //For checking the time when parsed from respective constructors
    {
        if((hh <= 23 && hh >=0) && (mn <= 59 && mn >= 0) && (ss <= 59 && ss >= 0)) //CHECKING WHETHER hh , mn and ss ARE VALID
            return true;
        else
            return false;
    }

    void display() //Display time from calling object
    {
        System.out.println(hh + ":" + mn + ":" + ss);
    }

    TIME addtime (TIME obj) //Creating object and adding hours, minutes and seconds
    {
        TIME obj2 = new TIME(); 
        //For extracting seconds
        obj2.ss = obj.ss+this.ss; 
        if(obj2.ss > 59) 
        {            
            obj2.mn = 1; 
            obj2.ss -= 60;
        }
        
        //For extracting minutes
        obj2.mn += (obj.mn + this.mn); 
        if(obj2.mn > 59) 
        {
            obj2.hh = 1; 
            obj2.mn -= 60;
        }
        
        //For extracting hours
        obj2.hh += (obj.hh + this.hh); 
        if(obj2.hh > 23) 
        obj2.hh -= 24;
            
        return obj2; 
    }

    TIME difftime (TIME obj) //To find the difference between the calling time and the time parameter
    {
        TIME obj2 = new TIME();
        //Difference by the seconds
        obj2.ss = obj.ss-this.ss; 
        if(obj2.ss < 0) 
        {            
            obj2.mn = -1;
            obj2.ss = 0;
        }
        
        //Difference by the minutes
        obj2.mn += (obj.mn - this.mn);
        if(obj2.mn < 0)
        {
            obj2.hh = -1;
            obj2.mn = 0;
        }
        
        //Difference by the hours
        obj2.hh += (obj.hh - this.hh); 
        if(obj2.hh < 0)
            obj2.hh = 0;
            
        return obj2;
    }

    void DispTime()
    {
        if(this.hh > 12) //To check if hours are already more than 12 and in 24-hour format
            System.out.print((24 - this.hh) + "/ ");
        else
            System.out.print(hh + "/ ");
        System.out.print(mn + "/ " + ss);  //Displaying time in 24 hour format
    }
    
    void destroy()
    {
        System.out.println ("Program terminated. ");
    }
}