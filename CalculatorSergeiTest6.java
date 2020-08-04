/**
 * Created by MacminiMaverick on 8/4/20.
 */


import java.util.Scanner;

public class CalculatorSergeiTest6 {

    public static void main(String[] args) {

        int arabNum1 = 0;
        int arabNum2 = 0;
        int romeNum1 = 0;
        int romeNum2 = 0;
        char operator = 0;

        Scanner scanner = new Scanner(System.in);// scan input
        String scan = scanner.nextLine();
        scanner.close();


// clean from extra spaces
        String s1 = scan.replaceAll("\\s+", "");

// ОПЕРАТОР вытаскиваем оператор из строки

        String op = scan.replaceAll("[^+-/*]", "");


// exception for wrong operator

        int opLength = op.length();
        if (opLength != 1) {
            System.out.println("ошибка ввода!Программа остановлена!");
            System.exit(0);
        } else {
            operator = op.charAt(0);
        }

// вытаскиваем ДВЕ очищенные строки v massiv strok : strArrTwoNum

        String[] strArrTwoNum = s1.split("[+-/*]");




// проверяем римские или нет цифры от одного до 10 if yes return integer to romenum

        int[] arabArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] romeArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (int i = 0; i <= 9; i++) {
            if (strArrTwoNum[0].equalsIgnoreCase(romeArray[i])) {
                romeNum1 = arabArray[i];
            }
            if (strArrTwoNum[1].equalsIgnoreCase(romeArray[i])) {
                romeNum2 = arabArray[i];
            }
        }

// PARSIM STROKU v integer ESLI NE RIMSKIE SYMBOLS

        if (romeNum1 == 0 & romeNum2 == 0) {
            arabNum1 = Integer.parseInt(strArrTwoNum[0]);
            arabNum2 = Integer.parseInt(strArrTwoNum[1]);
        }

// PROVERKA NA ODIN TIP DANNYX

        if (romeNum1 == 0 & romeNum2 > 0) {
            System.out.println("ошибка ввода !Программа остановлена!errrrr");
            System.exit(0);
        }
        if (romeNum2 == 0 & romeNum1 > 0) {
            System.out.println("ошибка ввода !Программа остановлена!errrrr");
            System.exit(0);
        }
// PRIVODIM K OBSCHEMU dlya oblegcheniya CALCULYATSII

        int mainNum1 = arabNum1 + romeNum1;
        int mainNum2 = arabNum2 + romeNum2;

// ISKLUCHENIE DLYA TSIFR OT ODNOGO DO DESYATI

        if (mainNum1 <= 10 & mainNum1 >= 1) {

            if (mainNum2 <= 10 & mainNum2 >= 1) {

            } else {
                System.out.println("ошибка ввода!Программа остановлена!");
                System.exit(0);
            }

        } else {
            System.out.println("ошибка ввода!Программа остановлена!");
            System.exit(0);
        }

// VYVODIM RESULTAT CALCULATORA v CONSOL

        if (romeNum1 > 0) {
            System.out.println("The result is "
                    + arabToRoman(calcResult(mainNum1, mainNum2, operator)));
        }
        if (arabNum1 > 0) {
            System.out.println("The result is " + calcResult(mainNum1, mainNum2, operator));
        }
    }

// METHOD FOR CALCULATING

    private static int calcResult(int x, int y, char opera) {
        int result;
        switch (opera) {
            case '+':
                result = (x + y);
                break;
            case '-':
                result = (x - y);
                break;
            case '*':
                result = (x * y);
                break;
            case '/':
                result = (x / y);
                break;
            default:
                throw new IllegalStateException("Unexpected value");

        }
        return result;
    }

// METHOD CONVERTER dlya int ARAB TO string ROMAN

    private static String arabToRoman(int arabIn) {

        StringBuilder roman = new StringBuilder();

        // catch zero for roman numbers
        if (arabIn == 0) {
            roman = new StringBuilder("0");
        }
// make minus for roman numbers
        if (arabIn < 0) {
            arabIn = Math.abs(arabIn);
            roman = new StringBuilder("-");
        }

        int trigger;

        String[] romanSymbol = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabSymbol = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < arabSymbol.length; i++) {
            trigger = arabIn / arabSymbol[i];

            for (int k = 1; k <= trigger; k++) {
                roman.append(romanSymbol[i]);
            }
            arabIn = arabIn % arabSymbol[i];
        }
        return roman.toString();
    }
}