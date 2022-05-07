package testfield;

import java.util.Scanner;

public class Test3 {
    public static void main(String args[])
            throws java.io.IOException {
        int     a, b;

        a = 1000;
        do {
            a = get_num();
            if (a > 100 && a != 1000) {
                a = 1000;
                System.out.println("Слишком большое число. Введите заново.");
            }
        } while(a == 1000);

        b = 1000;
        do {
            b = get_num();
            if (b > 100 && b != 1000) {
                b = 1000;
                System.out.println("Слишком большое число. Введите заново.");
            }
        } while(b == 1000);

        System.out.println(a + b);
    }


    //Функция для получения десятичного числа при вводе римского числа в пределах 100
    static int get_num() {
        int num = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите римское число (I, V, X, L, C) не больше 100 (С)");
        String s = in.nextLine();

        num = convert_roman_num(s);
        return num;
    }


    //Функция, возвращающая десятичное значение римского числа, в случае ошибки ввода возвращается 1000
    static int convert_roman_num(String s) {
        int     n = 0;
        int     l = s.length();
        int[]   arr = get_num_array(s, l);

        if (arr == null || !check_error_input(arr, l)) {
            System.out.println("Error input. Try again.");
            return 1000;
        }
        fix_minus_positions(arr, l);
        for (int i = 0; i < l; i++) {
            n = arr[i] + n;
        }
        return n;
    }


    //Функция, возвращающая массив целочисленных значений вместо введенных римских символов соотвтетственно их значениям
    static int[] get_num_array(String s, int l) {
        char[]  ch = s.toCharArray();
        int[]   arr = new int[l];
        int     i = 0;

        for (i = 0; i < l; i++) {
            if (ch[i] == 'I')
                arr[i] = 1;
            else if (ch[i] == 'V')
                arr[i] = 5;
            else if (ch[i] == 'X')
                arr[i] = 10;
            else if (ch[i] == 'L')
                arr[i] = 50;
            else if (ch[i] == 'C')
                arr[i] = 100;
            else
                return null;
        }
        return arr;
    }


    /*Функция возвращает false в случая некорректного ввода:
    1) если следующий разряд больше предыдущего, за исключением случаев IX(1 10), IV(1 5), XL(10 50), XC (10 100)
    2) если подряд больше трех I (1) или больше трех Х (10)
    3) если подряд два V (5), L (50), C (100)
     */
    static boolean check_error_input(int[] arr, int l) {
        for (int i = 0; i < l - 1; i++) {
            if (arr[i] < arr[i + 1] && (arr[i] == 1 || arr[i] == 10) &&
                    arr[i + 1] / arr[i] != 5 && arr[i + 1] / arr[i] != 10)
                return false;
            if (i < l - 3 && (arr[i] == 1 || arr[i] == 10) && arr[i] == arr[i + 1] && arr[i] == arr[i + 2] && arr[i] == arr[i + 3])
                return false;
            if ((arr[i] == 5 || arr[i] == 50 || arr[i] == 100) && arr[i] <= arr[i + 1])
                return false;
        }
        return true;
    }


    //Функция меняет в массиве знаки I(1) и X(10), если следующий элемент больше
    static void fix_minus_positions(int[] arr, int l) {
        for (int i = 0; i < l - 1; i++) {
            if (arr[i] < arr[i + 1])
                arr[i] *= -1;
        }
    }
}