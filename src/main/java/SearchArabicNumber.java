public class SearchArabicNumber {

    static String getResult(String input) {

        int num1 = 0;
        int num2 = 0;
        String oper = null;

        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray.length == 3) {
                num1 = Integer.parseInt(String.valueOf(charArray[0]));
                oper = String.valueOf(charArray[1]);
                num2 = Integer.parseInt(String.valueOf(charArray[2]));
            } else if (charArray.length == 4 && charArray[0] == '-') {
                num1 = Integer.parseInt(String.valueOf(charArray[1]));
                num1 = num1 * (-1);
                oper = String.valueOf(charArray[2]);
                num2 = Integer.parseInt(String.valueOf(charArray[3]));
            } else if (charArray.length == 4 && charArray[0] == '1' && charArray[1] == '0') {
                num1 = 10;
                oper = String.valueOf(charArray[2]);
                num2 = Integer.parseInt(String.valueOf(charArray[3]));
            } else if (charArray.length == 4 && charArray[2] == '-') {
                num1 = Integer.parseInt(String.valueOf(charArray[0]));
                oper = String.valueOf(charArray[1]);
                num2 = Integer.parseInt(String.valueOf(charArray[3]));
                num2 = num2 * (-1);
            } else if (charArray.length == 4 && charArray[2] == '1' && charArray[3] == '0') {
                num1 = Integer.parseInt(String.valueOf(charArray[0]));
                oper = String.valueOf(charArray[1]);
                num2 = 10;
            } else if (charArray.length == 5 && charArray[0] == '1' & charArray[1] == '0' && charArray[3] == '-') {
                num1 = 10;
                oper = String.valueOf(charArray[2]);
                num2 = Integer.parseInt(String.valueOf(charArray[4]));
                num2 = num2 * (-1);
            } else if (charArray.length == 5 && charArray[0] == '-' && charArray[1] == '1' & charArray[2] == '0') {
                num1 = 10 * (-1);
                oper = String.valueOf(charArray[3]);
                num2 = Integer.parseInt(String.valueOf(charArray[4]));
            } else if (charArray.length == 5 && charArray[2] == '-' && charArray[3] == '1' && charArray[4] == '0') {
                num1 = Integer.parseInt(String.valueOf(charArray[0]));
                oper = String.valueOf(charArray[1]);
                num2 = 10 * (-1);
            } else if (charArray.length == 5 && charArray[0] == '-' && charArray[3] == '1' && charArray[4] == '0') {
                num1 = Integer.parseInt(String.valueOf(charArray[1]));
                num1 = num1 * (-1);
                oper = String.valueOf(charArray[2]);
                num2 = 10;
            } else if (charArray.length == 5 && charArray[0] == '-' && charArray[3] == '-') {
                num1 = Integer.parseInt(String.valueOf(charArray[1]));
                num1 = num1 * (-1);
                oper = String.valueOf(charArray[2]);
                num2 = Integer.parseInt(String.valueOf(charArray[4]));
                num2 = num2 * (-1);
            } else if (charArray.length == 5 && charArray[0] == '1' && charArray[1] == '0' && charArray[3] == '1' && charArray[4] == '0') {
                num1 = 10;
                oper = String.valueOf(charArray[2]);
                num2 = 10;
            } else if (charArray.length == 6 && charArray[0] == '-' && charArray[3] == '-' && charArray[4] == '1' && charArray[5] == '0') {
                num1 = Integer.parseInt(String.valueOf(charArray[1]));
                num1 = num1 * (-1);
                oper = String.valueOf(charArray[2]);
                num2 = 10 * (-1);
            } else if (charArray[0] == '-' && charArray[1] == '1' && charArray[2] == '0' && charArray[4] == '-' && charArray[5] == '1' && charArray[6] == '0') {
                num1 = 10 * (-1);
                oper = String.valueOf(charArray[3]);
                num2 = 10 * (-1);
            } else
                System.out.println("bagArabic");
        }

        return String.valueOf(Main.Calc(num1, oper, num2));
    }
}
