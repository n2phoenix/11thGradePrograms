class ISPTime
{
    int hh;
    int mm;
    ISPTime()
    {
        hh = 24;
        mm = 59;
    }

    void readtime(int h, int m)
    {
        hh = h;
        mm = m;
    }

    void disptimeansi()
    {
        if (hh < 10 && mm < 10)
            System.out.println ("0" + hh + ":0" + mm);
        else if (hh < 10)
            System.out.println ("0" + hh + ":" + mm);
        else if (mm < 10)
            System.out.println (hh + ":0" + mm);
        else 
            System.out.println (hh + ":" + mm);
    }

    int timetominutes (ISPTime t)
    {
        return (int) (t.hh * 60 + t.mm);
    }

    void minutestotime (int min)
    {
        int h = min / 60;
        int m = min - (h * 60);
        if (h < 10 && m < 10)
            System.out.println ("0" + h + ":0" + m);
        else if (h < 10)
            System.out.println ("0" + h + ":" + m);
        else if (m < 10)
            System.out.println (h + ":0" + m);
        else 
            System.out.println (h + ":" + m);
    }

    ISPTime diff (ISPTime start, ISPTime end)
    {
        ISPTime spentTime;
        int h1 = start.hh; int m1 = start.mm;
        int h2 = end.hh; int m2 = end.mm;
        int h, m;
        if (h2 == h1)
        {
            h = 0; 
            m = m2 - m1;
        }
        else if (m2 == m1)
        {
            h = h2 - h1;
            m = 0;
        }
        else
        {
            h = h2 - h1;
            m = m2 - m1;
        }
        
        spentTime = new ISPTime();
        spentTime.readtime (h, m);
        return spentTime;
    }
}
