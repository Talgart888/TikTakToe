package JavaCore.TikTakToe;

import java.util.Random;

public class TikTakToe {
    public static void main(String[] args) {
        System.out.println("Используйте следующие комбинации, чтобы указать ячейку, используя числа от 1 до 9.");
        printTableMapping(); // вывод таблицу соответсвия

        // создаем переменнную игрового поля
        char[][] gameTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        }
        /* определяем кто ходит первым: компьютер или пользователь через Random и через условия boolean,
           если true то ходит компьютер т.к. внутри заложен его функция, если false то условия закрывается и идем к while
           где ходит пользователь
        */
        if (new Random().nextBoolean()) {
            makeComputerMove(gameTable); // компьютер делает ход
            printGameTable(gameTable); // текущее состояние игрового поля
        }

        // Если никто не выиграл, то игра продолжается через цикл while
        while (true) {
            makeUserMove(gameTable); // пользователь делает ход
            printGameTable(gameTable); // текущее состояние игрового поля

            // если пользователь выиграл:
            if (isUserWin(gameTable)) {
                System.out.println("ВЫ ВЫИГРАЛИ!");
                break;
            }
            // Если нечья:
            if (isDraw(gameTable)) {
                System.out.println("Извините, ничья.");
                break;
            }
            MakeComputerMove(gameTable); // компьютер делает ход
            printGameTable(gameTable); // текущее состояние игрового поля

            // если компьютер выиграл
            if (isComputerWin(gameTable)) {
                System.out.println("Компьютер выиграл(");
                break;
            }
            // Если нечья:
            if (isDraw(gameTable)) {
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

    private static void printGameTable(char[][] gameTable) {

    }

    private static void makeComputerMove(char[][] gameTable) {

    }

    private static void makeUserMove(char[][] gameTable) {

    }

    private static void MakeComputerMove(char[][] gameTable) {

    }

    private static boolean isUserWin(char[][] gameTable) {
        return false;
    }

    private static boolean isComputerWin(char[][] gameTable) {
        return false;
    }

    private static boolean isDraw(char[][] gameTable) {
        return false;
    }
}
