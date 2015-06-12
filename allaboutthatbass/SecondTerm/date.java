package SecondTerm;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class date
{
    public int dt;
    public int mn;
    public int yr;

    date()
    {
        dt = 1;
        mn = 9;
        yr = 1990;
    }

    public date (int d1, int m1, int y1)
    {
        dt = d1;
        mn = m1;
        yr = y1;

        if (validate()==false)
            dt = mn = yr = 0;
    }

    date (String n)
    {
        dt = Integer.parseInt(n.substring(0,2));
        mn = Integer.parseInt(n.substring(3,5));
        yr = Integer.parseInt(n.substring(6));

        if(validate()==false)
            dt = mn = yr = 0;
    }
    
    public void assign (int d, int m, int y)
    {
        this.dt = d;
        this.mn = m;
        this.yr = y;
    }

    date addDays (int n)
    {
        int days;
        date d = new date();
        switch (mn)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            if (leap())
            {
                days = yr * 365 + mn * 31 + dt + n;
                d.yr = days / 365;
                days %= 366;
                d.mn = days / 31;
                days %= 31;
                d.dt = days;   
            }
            else
            {
                days = yr * 365 + mn * 31 + dt + n;
                d.yr = days / 365;
                days %= 365;
                d.mn = days / 31;
                days %= 31;
                d.dt = days;  
            }
            break;

            case 4: case 6: case 9: case 11:
            if (leap())
            {
                days = yr * 365 + mn * 30 + dt + n + 1;
                d.yr = days/366;
                days %= 366;
                d.mn = days/30;
                days %= 30;
                d.dt = days;  
            }
            else
            {   days = yr * 365 + mn * 30 + dt + n;
                d.yr = days / 365;
                days%=365; 
                d.mn = days/30;
                days%=30;
                d.dt = days;   
            }
            break;
            
            default:
            if(leap())
            {
                days = yr * 365 + mn * 29 + dt + n + 1;
                d.yr = days/366;
                days%=366;
                d.mn = days/29;
                days%=29;
                d.dt = days;   
            }
            else
            {   days = yr * 365 + mn * 28 + dt + n;
                d.yr = days / 365;
                days %= 365;
                d.mn = days / 28;
                days %= 28;
                d.dt = days;   
            }
            break;
        }
        return d;
    }
    
    int diff (date d1)
    {
        int yrs, mnth, days;
        yrs = mnth = days = 0;
        if (compareTo(d1) == 1)
        {
        yrs = yr - d1.yr;
        mnth = mn - d1.mn;
        days = dt - d1.dt;
        }
        else if (compareTo(d1) == -1)
        {
        yrs = d1.yr - yr;
        mnth = d1.mn - mn;
        days = d1.dt - dt;
        }
        else
        {
        return days;
        }
        
        if (mnth < 0)
        {
            yrs--;
            mnth += 12;
        }
        
        if (days < 0)
        mnth--;
        
        byte lastday[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (mnth == 2 && leap())
        days = 29 - days;
        else
        days = lastday [mnth - 1] + days;
        
        return days;
    }
    
    date subDays (int n)
    {
        int days;
        date d = new date();
        switch (mn)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            if (leap())
            {
                days = yr * 365 + mn * 31 + dt - n + 1;
                d.yr = days / 365;
                days %= 367;
                d.mn = days / 31;
                days %= 31;
                d.dt = days;   
            }
            else
            {
                days = yr * 365 + mn * 31 + dt - n;
                d.yr = days / 365;
                days %= 365;
                d.mn = days / 31;
                days %= 31;
                d.dt = days;  
            }
            break;

            case 4: case 6: case 9: case 11:
            if(leap())
            {
                days = yr * 366 + mn * 30 + dt - n + 1;
                d.yr = days/366;
                days %= 366;
                d.mn = days/30;
                days %= 30;
                d.dt = days;  
            }
            else
            {   days = yr * 365 + mn * 30 + dt - n;
                d.yr = days / 365;
                days%=365; 
                d.mn = days/30;
                days%=30;
                d.dt = days;   
            }
            break;
            
            default:
            if(leap())
            {
                days = yr * 366 + mn * 29 + dt - n + 1;
                d.yr = days/366;
                days%=366;
                d.mn = days/29;
                days%=29;
                d.dt = days;   
            }
            else
            {   days = yr * 365 + mn * 28 + dt - n;
                d.yr = days / 365;
                days %= 365;
                d.mn = days / 28;
                days %= 28;
                d.dt = days;   
            }
            break;
        }
        return d;
    }

    boolean validate()
    {
        byte lastday[] ={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(dt < 1 || dt > 31 || mn < 1 || mn > 12 || yr < 1)
        {
            return false;
        }

        if(leap() == true)
        {
            if(mn == 2 && dt <= 29)
                return true;
            else
                return false;
        }

        if(dt>lastday[mn-1])
            return false;
        else
            return true;
    }

    boolean leap()
    {
        if(yr % 4 == 0 && yr % 100 != 0 || yr % 400 == 0)
            return true;
        else
            return false;
    }     

    public boolean equals(date obj)
    {
        if(this.dt==obj.dt && this.mn==obj.mn && this.yr==obj.yr)
            return true;
        else
            return false;
    }

    public int compareTo(date obj)
    {
        if(this.yr > obj.yr)
            return 1;
        else if(this.yr < obj.yr)
            return -1;
        else
        {
            if(this.mn > obj.mn)
                return 1;
            else if(this.mn < obj.mn)
                return -1;
            else
            {
                if(this.dt > obj.dt)
                    return 1;
                else if(this.dt < obj.dt)
                    return -1;
                else
                    return 0;
            }
        }    
    }

    String mnthname()
    {
        String mnth[]={"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        return mnth[mn - 1];
    }     

    int day()
    { return dt;
    }

    int month()
    { return mn;
    }

    int year()
    { return yr;
    }
}