import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //This is a Calculator app,
        int k = 1;
        System.out.println("Do an arithmetic Calculation: like Addition, multiplication, division or Subtraction: ");
        System.out.println("Enter your input without spaces to get your result follow precedence rule:  ");
        while(k==1) {
            System.out.println("Write an Expression ");
           String input= sc.next();

            System.out.println(input);


                String cPrec = stringConversion(input);

                double result = evaluatingcPrec(cPrec);


            System.out.format("%.2f", result);
            System.out.println();

            System.out.println("Do you want to Exit ?: Enter 0 ");
            int c = sc.nextInt();
           if(c==0)
               break;


            else k=1;

        }
        System.out.println("Thank you!!!");

    }

    //converting String input into an logical postfix  operation so it can be evaulate easily
    // and to follow precedence rule


    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;


        }
        return -1;
    }

    public static String stringConversion(String input) {
        String result = new String("");

        Deque<Character> stack = new ArrayDeque<Character>();

        //Traversion through string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();

                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }

        return result;

    }

    static double evaluatingcPrec(String exp)
    {

        Stack<Double> stack=new Stack<>();


        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);


            if(Character.isDigit(c))
                stack.push((double) c -'0');


            else
            {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        return stack.pop();
    }


}

