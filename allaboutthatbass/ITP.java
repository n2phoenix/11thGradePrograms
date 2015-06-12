import java.io.*;

public class ITP 
{
    Stack charSet;
    String infix;
    String postfix = "";
    
    public ITP (String in) 
    {
        infix = in;
        int stackSize = infix.length();
        int ct = 0;
        for (int i = 0; i < stackSize; i++)
        {
            if (!(Character.isDigit (infix.charAt(i))))
            ct++;
        }
        charSet = new Stack (ct);
    }

    public String doTrans() 
    {
        for (int j = 0; j < infix.length(); j++) 
        {
            char ch = infix.charAt(j);
            switch (ch) {
                case '+': 
                case '-':
                gotOper(ch, 1); 
                break; 
                case '*': 
                case '/':
                gotOper(ch, 2); 
                break; 
                case '(': 
                charSet.push(ch);
                break;
                case ')': 
                gotParen(ch); 
                break;
                default: 
                postfix = postfix + ch; 
                break;
            }
        }
        while (!charSet.isEmpty()) {
            postfix = postfix + charSet.pop();
        }
        return postfix; 
    }

    public void gotOper (char opThis, int prec1) 
    {
        while (!charSet.isEmpty()) 
        {
            char opTop = charSet.pop();
            if (opTop == '(') 
            {
                charSet.push(opTop);
                break;
            }
            else 
            {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                    
                if (prec2 < prec1) 
                { 
                    charSet.push(opTop);
                    break;
                }
                else
                    postfix = postfix + opTop;
            }
        }
        charSet.push(opThis);
    }

    public void gotParen(char ch)
    { 
        while (!charSet.isEmpty()) 
        {
            char chx = charSet.pop();
            if (chx == '(') 
                break; 
            else
                postfix = postfix + chx; 
        }
    }

    class Stack 
    {
        private int maxSize;
        private char[] stackArray;
        private int top;
        public Stack(int max) {
            maxSize = max;
            stackArray = new char[maxSize];
            top = -1;
        }

        public void push(char j) {
            stackArray[++top] = j;
        }

        public char pop() {
            return stackArray[top--];
        }

        public char peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }
}