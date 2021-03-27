package Servlet.Controller;

public class Calculator {
    public static double Calculator_Operator(double first_number, double second_number, String operator){
        switch (operator){
            case "+":
                return first_number+second_number;
            case "-":
                return first_number-second_number;
            case "*":
                return first_number*second_number;
            case "/":
                try{
                    return first_number/second_number;
                }catch (ArithmeticException e){
                    System.out.println("Kiem tra lai mau so!");
                }
            default:
                return -1;
        }
    }
}
