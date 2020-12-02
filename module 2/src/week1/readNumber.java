package week1;

import java.io.CharArrayReader;
import java.util.Scanner;

public class readNumber {
    public static void main(String[] args) {
        String numberStringHunderes = "";
        String numberStringTen = "";
        String numberStringOne= "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number :");
        int number = scanner.nextInt();
        // đọc 1 chữ số
        if (number < 10 && number >= 0) {
            switch (number) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number < 20) {
            switch (number) {
                case 10:
                    System.out.println("ten");
                    break;
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("twelve");
                    break;
                case 13:
                    System.out.println("thirdteen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eightteen");
                    break;
                case 19:
                    System.out.println("nineteen");
                    break;
            }
        }
        else if ( number < 100) {
            String string = String.valueOf(number);
            char[] arrayNumber = string.toCharArray();
                    switch (arrayNumber[0]) {
                        case 50:
                            numberStringTen = "twenty";
                            break;
                        case 51:
                            numberStringTen = "thirty";
                            break;
                        case 52:
                            numberStringTen = "forty";
                            break;
                        case 53:
                            numberStringTen = "fifty";
                            break;
                        case 54:
                            numberStringTen = "sixty";
                            break;
                        case 55:
                            numberStringTen = "seventy";
                            break;
                        case 56:
                            numberStringTen = "eightty";
                            break;
                        case 57:
                            numberStringTen = "ninety";
                            break;
                    }
                    switch (arrayNumber[1]){
                        case 49:
                            numberStringOne="one";
                            break;
                        case 50:
                            numberStringOne="two";
                            break;
                        case 51:
                            numberStringOne="three";
                            break;
                        case 52:
                            numberStringOne="four";
                            break;
                        case 53:
                            numberStringOne="five";
                            break;
                        case 54:
                            numberStringOne="six";
                            break;
                        case 55:
                            numberStringOne="seven";
                            break;
                        case 56:
                            numberStringOne="eight";
                            break;
                        case 57:
                            numberStringOne="nine";
                            break;
                    }
            System.out.println(numberStringTen.concat(numberStringOne));
        }
        else if(number<1000){
            String string = String.valueOf(number);
            char[] arrayNumber = string.toCharArray();
            switch (arrayNumber[0]){
                case 49:
                    numberStringHunderes = "One hundered ";
                    break;
                case 50:
                    numberStringHunderes = "two hundered ";
                    break;
                case 51:
                    numberStringHunderes = "three hundered ";
                    break;
                case 52:
                    numberStringHunderes = "four hundered ";
                    break;
                case 53:
                    numberStringHunderes = "five hundered ";
                    break;
                case 54:
                    numberStringHunderes = "six hundered ";
                    break;
                case 55:
                    numberStringHunderes = "seven hundered ";
                    break;
                case 56:
                    numberStringHunderes = "eight hundered";
                    break;
                case 57:
                    numberStringHunderes = "nine hundered";
                    break;
            }
            switch (arrayNumber[1]) {
                case 50:
                    numberStringTen = "twenty";
                    break;
                case 51:
                    numberStringTen = "thirty";
                    break;
                case 52:
                    numberStringTen = "forty";
                    break;
                case 53:
                    numberStringTen = "fifty";
                    break;
                case 54:
                    numberStringTen = "sixty";
                    break;
                case 55:
                    numberStringTen = "seventy";
                    break;
                case 56:
                    numberStringTen = "eightty";
                    break;
                case 57:
                    numberStringTen = "ninety";
                    break;
            }
            switch (arrayNumber[2]){
                case 49:
                    numberStringOne="one";
                    break;
                case 50:
                    numberStringOne="two";
                    break;
                case 51:
                    numberStringOne="three";
                    break;
                case 52:
                    numberStringOne="four";
                    break;
                case 53:
                    numberStringOne="five";
                    break;
                case 54:
                    numberStringOne="six";
                    break;
                case 55:
                    numberStringOne="seven";
                    break;
                case 56:
                    numberStringOne="eight";
                    break;
                case 57:
                    numberStringOne="nine";
                    break;
            }
            System.out.println(numberStringHunderes.concat(numberStringTen.concat(numberStringOne)));
        }
    }
}

