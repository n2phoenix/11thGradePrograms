package SecondTerm;

class Stringfun
{
    String togglecase (String S) //For toggling cases of all letters in the sentence
    {
        String str =  new String(); 
        for(int i = 0;i<S.length();i++)
        { 
            //Now checking respective cases and toggling them
            if((int) S.charAt(i) >= 97 && (int)S.charAt(i) <= 122) 
                str+=(char)(S.charAt(i) - 32); 
            else if((int) S.charAt(i) >= 65 && (int)S.charAt(i) <= 90)
                str+=(char)(S.charAt(i) + 32); 
        }
        return str; 
    }

    String capitalcase(String S) //For capitalizing first letters of words in a sentence
    {
        String str = new String();
        String word = new String();
        str = "";
        int x = 0;
        S.trim();
        S+=' ';
        int len = S.length();
        for(int i = 0;i<len;i++)
        {
            x = S.indexOf(' ' , i);
            word = S.substring(i,x);
            //Checking if first character of the word is uppercase
            if ((int) word.charAt(0) >= 97 && (int) word.charAt(0) <= 122) 
                word=((char)(word.charAt(0)-32)) + word.substring(1,word.length()); 
                
            str += word + " ";
            i = x;
            x++;
        }
        return str;
    }

    String sentencecase(String S) //to convert first letter of the sentence to uppercase
    {
        String str = new String();
        str = "";
        if ((int) S.charAt(0) >= 97 && (int) S.charAt(0) <= 122)
            str += ((char)(S.charAt(0)-32));
        else
            str+= S.charAt(0);
            
        for(int i = 1; i < S.length(); i++)
        {
            if((int)S.charAt(i) >=65 && (int)S.charAt(i) <= 90)
                str += ((char) (S.charAt(i) + 32));
            else
                str += S.charAt(i);
        }
        return str;
    }
    
    int Countwrd(String s, String wrd) //to count number of words in the sentence
    {
        int count = 0; 
        String word = new String();
        int x = 0;
        s.trim();
        s+=" ";
        for(int i = 0;i<s.length();i++)
        {
            x = s.indexOf(' ',i);
            word = s.substring(i,x); 
            if(word.equals(wrd)) 
                count++;
            i = x;
            x++;
        }
        return count;
    }

    void frequency (String s) //To find occurences of letters in a sentence
    {
        int count = 0;
        s = s.toUpperCase();
        for(char c = 'A'; c <= 'Z'; c++)
        {
            for(char j = 0;j < s.length();j++)
            {
                if(s.charAt(j)== c)
                    count++;
            }
            if(count != 0)
            System.out.println("Frequency of " + c + " is " + count);
            count = 0;
        }
    }
    
    void destroy()
    {
        System.out.println ("Program terminated. ");
    }
}