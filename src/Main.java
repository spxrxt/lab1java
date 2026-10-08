import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Лабораторная работа №1 (вариант 2).
 * Задание 1: 6,7,8,9,10; Задание 2: 6,7,8,9,10; Задание 3: 6,7,8,9,10; Задание 4: 6,7,8,9,10.
 */
public class Main {

    private static final Scanner SC = new Scanner(System.in);

    // =====================================================================
    // ЗАДАНИЕ 1. Методы
    // =====================================================================

    /** 1.6 Большая буква. */
    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    /** 1.7 Диапазон (границы могут идти в любом порядке). */
    public boolean isInRange(int a, int b, int num) {
        return num >= Math.min(a, b) && num <= Math.max(a, b);
    }

    /** 1.8 Делитель: одно из чисел делит другое нацело. */
    public boolean isDivisor(int a, int b) {
        return (b != 0 && a % b == 0) || (a != 0 && b % a == 0);
    }

    /** 1.9 Равенство трёх чисел. */
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    /** 1.10 Сумма цифр разряда единиц двух чисел. */
    public int lastNumSum(int a, int b) {
        return Math.abs(a % 10) + Math.abs(b % 10);
    }

    // =====================================================================
    // ЗАДАНИЕ 2. Условия
    // =====================================================================

    /** 2.6 Тройная сумма. */
    public boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }

    /** 2.7 Двойная сумма. */
    public int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        }
        return sum;
    }

    /** 2.8 Возраст: число + "год" / "года" / "лет". */
    public String age(int x) {
        int n = Math.abs(x);
        int last = n % 10;
        int lastTwo = n % 100;
        String word;
        if (lastTwo >= 11 && lastTwo <= 14) {
            word = "лет";
        } else if (last == 1) {
            word = "год";
        } else if (last >= 2 && last <= 4) {
            word = "года";
        } else {
            word = "лет";
        }
        return x + " " + word;
    }

    /** 2.9 День недели (switch). */
    public String day(int x) {
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default: return "это не день недели";
        }
    }

    /** 2.10 Вывод дней недели начиная с переданного (switch с проваливанием). */
    public void printDays(String x) {
        switch (x.trim().toLowerCase()) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    // =====================================================================
    // ЗАДАНИЕ 3. Циклы
    // =====================================================================

    /** 3.6 Одинаковость всех цифр числа. */
    public boolean equalNum(int x) {
        long n = Math.abs((long) x);
        long last = n % 10;
        while (n > 0) {
            if (n % 10 != last) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    /** 3.7 Квадрат из '*'. */
    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    /** 3.8 Левый треугольник. */
    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    /** 3.9 Правый треугольник. */
    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int s = 0; s < x - i; s++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    /** 3.10 Угадайка. */
    public void guessGame() {
        int secret = new Random().nextInt(10);
        int attempts = 0;
        System.out.println("Я загадал число от 0 до 9. Попробуйте угадать!");
        while (true) {
            int guess = readIntInRange("Введите число от 0 до 9: ", 0, 9);
            attempts++;
            if (guess == secret) {
                System.out.println("Вы угадали!");
                break;
            }
            System.out.println("Вы не угадали.");
        }
        System.out.println("Вы отгадали число за " + attempts + " " + attemptsWord(attempts));
    }

    private String attemptsWord(int n) {
        int lastTwo = n % 100;
        int last = n % 10;
        if (lastTwo >= 11 && lastTwo <= 14) {
            return "попыток";
        } else if (last == 1) {
            return "попытку";
        } else if (last >= 2 && last <= 4) {
            return "попытки";
        }
        return "попыток";
    }

    // =====================================================================
    // ЗАДАНИЕ 4. Массивы
    // =====================================================================

    /** 4.6 Реверс на месте. */
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    /** 4.7 Реверс в новый массив. */
    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    /** 4.8 Объединение двух массивов. */
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }

    /** 4.9 Индексы всех вхождений x. */
    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int value : arr) {
            if (value == x) {
                count++;
            }
        }
        int[] result = new int[count];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[pos++] = i;
            }
        }
        return result;
    }

    /** 4.10 Массив без отрицательных элементов. */
    public int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value >= 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int pos = 0;
        for (int value : arr) {
            if (value >= 0) {
                result[pos++] = value;
            }
        }
        return result;
    }

    // =====================================================================
    // Вспомогательные методы ввода (с проверкой)
    // =====================================================================

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (SC.hasNextInt()) {
                return SC.nextInt();
            }
            System.out.println("Ошибка! Нужно ввести целое число.");
            SC.next();
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка! Число должно быть от " + min + " до " + max + ".");
        }
    }

    private static char readChar(String prompt) {
        while (true) {
            System.out.print(prompt);
            String token = SC.next();
            if (token.length() == 1) {
                return token.charAt(0);
            }
            System.out.println("Ошибка! Нужно ввести ровно один символ.");
        }
    }

    private static String readWord(String prompt) {
        System.out.print(prompt);
        return SC.next();
    }

    private static int[] readArray(String name) {
        int size = readIntInRange("Сколько элементов в массиве " + name + " (0..100): ", 0, 100);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = readInt(name + "[" + i + "] = ");
        }
        return arr;
    }

    // =====================================================================
    // Демонстрация (дружественный интерфейс)
    // =====================================================================

    private void runTask1(int k) {
        switch (k) {
            case 1: {
                char c = readChar("Введите символ: ");
                System.out.println("Большая латинская буква? " + isUpperCase(c));
                break;
            }
            case 2: {
                int a = readInt("Левая граница a: ");
                int b = readInt("Правая граница b: ");
                int num = readInt("Число num: ");
                System.out.println("Число входит в диапазон? " + isInRange(a, b, num));
                break;
            }
            case 3: {
                int a = readInt("Первое число: ");
                int b = readInt("Второе число: ");
                System.out.println("Одно делит другое нацело? " + isDivisor(a, b));
                break;
            }
            case 4: {
                int a = readInt("Первое число: ");
                int b = readInt("Второе число: ");
                int c = readInt("Третье число: ");
                System.out.println("Все три числа равны? " + isEqual(a, b, c));
                break;
            }
            case 5: {
                System.out.println("Введите пять чисел, они будут последовательно сложены по цифрам разряда единиц.");
                int result = readInt("Число 1: ");
                for (int i = 2; i <= 5; i++) {
                    int next = readInt("Число " + i + ": ");
                    int sum = lastNumSum(result, next);
                    System.out.println(result + "+" + next + " это " + sum);
                    result = sum;
                }
                System.out.println("Итого " + result);
                break;
            }
            default:
                break;
        }
    }

    private void runTask2(int k) {
        switch (k) {
            case 1: {
                int x = readInt("x = ");
                int y = readInt("y = ");
                int z = readInt("z = ");
                System.out.println("Два числа можно сложить и получить третье? " + sum3(x, y, z));
                break;
            }
            case 2: {
                int x = readInt("x = ");
                int y = readInt("y = ");
                System.out.println("Результат: " + sum2(x, y));
                break;
            }
            case 3: {
                int x = readInt("Введите возраст: ");
                System.out.println(age(x));
                break;
            }
            case 4: {
                int x = readInt("Введите номер дня недели (1-7): ");
                System.out.println(day(x));
                break;
            }
            case 5: {
                String s = readWord("Введите название дня недели (строчными буквами): ");
                printDays(s);
                break;
            }
            default:
                break;
        }
    }

    private void runTask3(int k) {
        switch (k) {
            case 1: {
                int x = readInt("Введите целое число: ");
                System.out.println("Все цифры одинаковы? " + equalNum(x));
                break;
            }
            case 2:
                square(readIntInRange("Размер квадрата (1..50): ", 1, 50));
                break;
            case 3:
                leftTriangle(readIntInRange("Высота треугольника (1..50): ", 1, 50));
                break;
            case 4:
                rightTriangle(readIntInRange("Высота треугольника (1..50): ", 1, 50));
                break;
            case 5:
                guessGame();
                break;
            default:
                break;
        }
    }

    private void runTask4(int k) {
        switch (k) {
            case 1: {
                int[] arr = readArray("arr");
                reverse(arr);
                System.out.println("После reverse: " + Arrays.toString(arr));
                break;
            }
            case 2: {
                int[] arr = readArray("arr");
                System.out.println("Новый массив: " + Arrays.toString(reverseBack(arr)));
                System.out.println("Исходный массив: " + Arrays.toString(arr));
                break;
            }
            case 3: {
                int[] a1 = readArray("arr1");
                int[] a2 = readArray("arr2");
                System.out.println("Результат: " + Arrays.toString(concat(a1, a2)));
                break;
            }
            case 4: {
                int[] arr = readArray("arr");
                int x = readInt("Искомое число x: ");
                System.out.println("Индексы вхождений: " + Arrays.toString(findAll(arr, x)));
                break;
            }
            case 5: {
                int[] arr = readArray("arr");
                System.out.println("Без отрицательных: " + Arrays.toString(deleteNegative(arr)));
                break;
            }
            default:
                break;
        }
    }

    private static final String[][] MENU = {
            {"Большая буква", "Диапазон", "Делитель", "Равенство", "Многократный вызов"},
            {"Тройная сумма", "Двойная сумма", "Возраст", "День недели", "Вывод дней недели"},
            {"Одинаковость", "Квадрат", "Левый треугольник", "Правый треугольник", "Угадайка"},
            {"Реверс", "Возвратный реверс", "Объединение", "Все вхождения", "Удалить негатив"}
    };

    public static void main(String[] args) {
        Main program = new Main();
        System.out.println("=== Лабораторная работа №1 (вариант 2) ===");
        while (true) {
            System.out.println();
            System.out.println("Выберите задание:");
            System.out.println("  1 - Методы");
            System.out.println("  2 - Условия");
            System.out.println("  3 - Циклы");
            System.out.println("  4 - Массивы");
            System.out.println("  0 - Выход");
            int group = readIntInRange("Ваш выбор: ", 0, 4);
            if (group == 0) {
                System.out.println("До свидания!");
                return;
            }
            System.out.println();
            System.out.println("Задание " + group + ", выберите задачу:");
            for (int i = 0; i < 5; i++) {
                System.out.println("  " + (i + 1) + " - " + MENU[group - 1][i]);
            }
            int task = readIntInRange("Ваш выбор: ", 1, 5);
            System.out.println();
            switch (group) {
                case 1: program.runTask1(task); break;
                case 2: program.runTask2(task); break;
                case 3: program.runTask3(task); break;
                case 4: program.runTask4(task); break;
                default: break;
            }
        }
    }
}