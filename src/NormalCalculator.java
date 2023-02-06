import java.util.Scanner;

public class NormalCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do calculation by writing a digit ");
        System.out.println();
        boolean a = true;

        double input = sc.nextDouble();
        double result =0;
        while(a){
            String s = sc.next();
            char operand = s.charAt(0);
            double input2 = sc.nextDouble();
            int k =1;

            switch(operand){
                case '+':
                    if(k==1) {
                        result = input + input2;
                        k=2;
                    }
                    else
                        result +=input2;

                    System.out.println(result);
                    break;

                case '-':
                    if(k==1){
                        result = input-input2;
                        k=2;
                    }
                    else
                        result -=input2;

                    System.out.println(result);
                    break;

                case '*':
                    if(k==1){
                        result = input*input2;
                        k=2;
                    }
                    else
                        result = result* input2;
                    System.out.println(result);
                    break;
                case '/':
                    if(k==1){
                        result = input/input2;
                        k=2;
                    }
                    else
                        result =result/input2;
                    System.out.println(result);
                    break;
                default:
                    System.out.println("Enter a valid operand ");
            }
        }
    }
}
