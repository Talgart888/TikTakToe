package JavaCore.TikTakToe;

import java.util.Random;

public class TikTakToe {
    public static void main(String[] args) {
        System.out.println("Используйте следующие комбинации, чтобы указать ячейку, используя числа от 1 до 9.");
        printTableMapping(); // вывод таблицу соответсвия

        /* определяем кто ходит первым: компьютер или пользователь через Random и через условия boolean,
           если true то ходит компьютер т.к. внутри заложен его функция, если false то условия закрывается и идем к while
           где ходит пользователь
        */
        if (new Random().nextBoolean()) {
            makeComputerMove(); // компьютер делает ход
            printGameTable(); // текущее состояние игрового поля
        }

        // Если никто не выиграл, то игра продолжается через цикл while
        while (true) {
            makeUserMove(); // пользователь делает ход
            printGameTable(); // текущее состояние игрового поля

            // если пользователь выиграл:
            if (isUserWin()) {
                System.out.println("ВЫ ВЫИГРАЛИ!");
                break;
            }
            // Если нечья:
            if (isDraw()) {
                System.out.println("Извините, ничья.");
                break;
            }
            MakeComputerMove(); // компьютер делает ход
            printGameTable(); // текущее состояние игрового поля

            // если компьютер выиграл
            if (isComputerWin()) {
                System.out.println("Компьютер выиграл(");
                break;
            }
            // Если нечья:
            if (isDraw()) {
                System.out.println("Извините, ничья.");
                break;
            }
        }
        System.out.println("Игра завершена.");
    }

    private static void printTableMapping() {
        System.out.println("-------------");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("-------------");
    }

    private static void printGameTable() {

    }

    private static void makeComputerMove() {

    }

    private static void makeUserMove() {

    }

    private static void MakeComputerMove() {

    }

    private static boolean isUserWin() {
        return false;
    }

    private static boolean isComputerWin() {
        return false;
    }

    private static boolean isDraw() {
        return false;
    }
}
