import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Input:");
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
            System.out.println("Output:");
            System.out.println(Calculator(s) + "\n");
        }
    }

    public static String Calculator(String input) throws Exception {

        String result = null;
        String regexArabic = "^((\\s|-)?([0-9]{1}|10)(\\s?)([+\\-*/]{1})(\\s|-)?([0-9]{1}|10))";
        String regexRoman = "^([IVX]*[+\\-*/][IVX]*)";
        String regexMix = "^([0-9][+\\-*/][IVX]*)|^([IVX]*[+\\-*/][0-9])";

        boolean isArabic = input.matches(regexArabic);
        boolean isRoman = input.matches(regexRoman);
        boolean isMix = input.matches(regexMix);

        if (isArabic) {
            result = SearchArabicNumber.getResult(input);
        } else if (isRoman) {
            result = SearchRomanNumber.getResult(input);
        } else if (isMix) {
            result = "null";
            throw new Exception("используются одновременно разные системы счисления");
        } else {
            result = "null";
            throw new Exception("строка не является математической операцией - два операнда и один оператор (+, -, /, *)");
        }
        return result;
    }


    static int Calc(int val1, String oper, int val2) throws ArithmeticException {
        if (oper.equals("+")) return val1 + val2;
        else if (oper.equals("-")) return val1 - val2;
        else if (oper.equals("*")) return val1 * val2;
        else if (oper.equals("/")) return val1 / val2;
        else return Integer.parseInt(null);
    }

}
