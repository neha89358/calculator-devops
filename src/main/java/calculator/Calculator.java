package calculator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        while (true) {
            System.out.println("---------------Scientific Calculator---------------");
            System.out.println("What do you want to use?");
            System.out.println("Press 1 for square root function.\n" +
                    "Press 2 for factorial function.\n" +
                    "Press 3 for natural log (base e) function.\n" +
                    "Press 4 for power function.\n" +
                    "Press any other key to exit\n");
            int ch;
            try {
                ch = sc.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            if (ch == 1 || ch == 2 || ch == 3) {
                try {
                    System.out.print("Enter the number : ");
                    num1 = sc.nextDouble();
                } catch (InputMismatchException error) {
                    logger.error("Invalid input");
                    return;
                }
            } else if (ch == 4) {
                try {
                    System.out.print("Enter base value: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter exponent value: ");
                    num2 = sc.nextDouble();
                } catch (InputMismatchException error) {
                    logger.error("Invalid input, Entered input is not a number");
                    return;
                }
            }
            switch (ch) {
                case 1: // Sq. root function
                    System.out.println("The square root of " + num1 + "  is: " + calc.sqrt(num1)+"\n\n");
                    break;
                case 2: // Factorial function
                    System.out.println("The factorial of " + num1 + " is: " + calc.fact(num1)+"\n\n");
                    break;
                case 3: // Natural log function
                    System.out.println("The natural log (base e) of " + num1 + " is: " + calc.nlog(num1)+"\n\n");
                    break;
                case 4: // Power function
                    System.out.println(num1 + "^" + num2 + " is: " + calc.pow(num1, num2)+"\n\n");
                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        }
    }

    public double sqrt(double num1){
        double res = 0;
        try{
            logger.info("SQUARE ROOT FUNCTION");
            if(num1<0){
                res=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                res = Math.sqrt(num1);
            }
        } catch (ArithmeticException error){
            logger.error("Square root of negative number cannot be found.");
        } finally {
            logger.info("Square root of "+num1+" is: "+res);
        }
        return res;
    }

    public double fact(double num1){
        double res = 1;
        try{
            logger.info("FACTORIAL FUNCTION");
            if(num1<0){
                res=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                double i;
                for (i=2; i<=num1; i++)
                    res *= i;
                return res;
            }
        } catch (ArithmeticException error){
            logger.error("Factorial of negative number cannot be found.");
        } finally {
            logger.info("Factorial of "+num1+" is: "+res);
        }
        return res;
    }

    public double nlog(double num1){
        double res = 0;
        try{
            logger.info("NATURAL LOG (BASE e) FUNCTION");
            if(num1<=0){
                res=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                res= Math.log(num1);
            }
        } catch (ArithmeticException error){
            logger.error("Natural log of negative number or zero cannot be found.");
        } finally {
            logger.info("Natural log of "+num1+" is: "+res);
        }
        return res;
    }

    public double pow(double num1, double num2){
        double res = 0;
        try{
            logger.info("POWER FUNCTION");
            if(num1 == 0 && num2 == 0){
                res=Double.NaN;
                throw new ArithmeticException();
            }
            else{
                res = Math.pow(num1,num2);
            }
        } catch (ArithmeticException error){
            logger.error("0^0 is undefined.");
        } finally {
            logger.info(num1 + "^"+ num2 +" is: "+res);
        }
        return res;
    }
}