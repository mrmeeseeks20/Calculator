import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SearchRomanNumber extends Exception {
    static HashMap<Integer, String> tableRoman = new HashMap<>();

    static String getResult(String input) throws Exception {

        int num1 = 0;
        int num2 = 0;
        String oper = null;
        String result = null;

        String[] list = input.replaceAll(" ", "").split("[+\\-*/]");
        //создам таблицу Roman
        getTableRoman();

        if (list.length == 2) {

            //ищем key по value
            for (Map.Entry<Integer, String> entry : tableRoman.entrySet()) {
                if (entry.getValue().equals(list[0])) {
                    num1 = entry.getKey();
                    break;
                }
            }

            //знак операции
            oper = getOperation(input);

            for (Map.Entry<Integer, String> entry : tableRoman.entrySet()) {
                if (entry.getValue().equals(list[1])) {
                    num2 = entry.getKey();
                    break;
                }
            }

            if (num1 > 0 && num2 > 0 && num1 <= 10 && num2 <= 10) {
                // вызываем калькультор
                String mathResult = String.valueOf(Main.Calc(num1, oper, num2));

                int newResult = Integer.parseInt(mathResult);

                //переводим результат из арабской в римской
                if (newResult > 0) {
                    result = tableRoman.get(newResult);
                } else if (newResult <= 0) {
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
            } else throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
        } else
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        return result;
    }

    static String getOperation(String oper) throws ArithmeticException {
        if (oper.contains("+")) return "+";
        else if (oper.contains("-")) return "-";
        else if (oper.contains("*")) return "*";
        else if (oper.contains("/")) return "/";
        else return null;
    }

    static void getTableRoman() {
        int N = 100;
        String romanResult = null;

        for (int i = 1; i <= N; i++) {
            romanResult = RoManiac.convert(i);
            tableRoman.put(i, romanResult);
        }

//        Iterator iter = tableRoman.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
//        }
    }


    public class RoManiac {
        public static String convert(int in) {
            StringBuffer a = new StringBuffer("");
            // Выделяем сотни из остатка
            int c1 = in / 100;
            a.append(C(c1));
            // остаток из сотен
            int c2 = in % 100;

            // Выделяем полсотни
            int l1 = c2 / 50;
            a.append(L(l1));
            // остаток
            int l2 = c2 % 50;

            // Выделяем десятки
            int x1 = l2 / 10;
            a.append(X(x1));
            // остаток
            int x2 = l2 % 10;

            // Выделяем то что осталось
            a.append(basic(x2));
            return a.toString();
        }

        private static String C(int in) {
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < in) {
                a.append("C");
                i++;
            }
            return a.toString();
        }

        // целые десятки
        private static String X(int in) {
            if (in == 4) return "XL"; // если 40, то 50-10
            else if ((in != 0) && (in < 4)) {
                StringBuffer a = new StringBuffer("");
                int i = 0;
                while (i < in) {
                    a.append("X");
                    i++;
                }
                return a.toString();
            } else return "";
        }

        private static String L(int in) {
            if (in == 4) return "XC"; // если 90, то 90-100
            else if ((in != 0) && (in < 4)) {
                StringBuffer a = new StringBuffer("");
                int i = 0;
                while (i < in) {
                    a.append("L");
                    i++;
                }
                return a.toString();
            } else return "";
        }

//        private static String L(int in) {
//            if (in == 4) return "XC"; // если90 то100 - 10
//            return "L";
//        }

        // От 1 до 9, то что осталось
        private static String basic(int in) {
            String[] a = {
                    "",
                    "I",
                    "II",
                    "III",
                    "IV",
                    "V",
                    "VI",
                    "VII",
                    "VIII",
                    "IX"
            };
            return a[in];
        }
    }

}
