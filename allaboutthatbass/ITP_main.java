import java.io.*;
class ITP_main
{
    public static void main () throws IOException 
    {
        DataInputStream in = new DataInputStream (System.in);
        System.out.println ("Enter expression: ");
        String infix = in.readLine();
        String postfix;
        
        System.out.println ("Infix expression: " + infix);
        infix = infix.replace (" ", "");
        infix = infix.replace ("[", "(");
        infix = infix.replace ("{", "(");
        infix = infix.replace ("]", ")");    
        infix = infix.replace ("}", ")");
        ITP exp = new ITP (infix);
        postfix = exp.doTrans(); 
        
        postfix = postfix.replace (" ", "");
        System.out.println ("Postfix expression: " + postfix);
    }
}