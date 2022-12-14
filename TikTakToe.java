package JavaCore.TikTakToe;

import java.util.Random;
import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {
        System.out.println("Используйте следующие комбинации, чтобы указать ячейку, используя числа от 1 до 9.");
        printTableMapping(); // вывод таблицу соответсвия

        // создаем переменнную игрового поля
        char[][] gameTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
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

    private static void makeComputerMove(char[][] gameTable) {
        Random random = new Random();
        // через while компьютер будет заполнять пустые ячейки до тех пор пока не будет полностью заполнена
        while (true) {
            int row = random.nextInt(3); // bound 3 - возвращает случайное число в строку от 0 до 2
            int col = random.nextInt(3); // bound 3 - возвращает случайное число в столбцу от 0 до 2
            // если игровое поле по индексу row, col пуста, то в эту ячейку записываем 0
            if (gameTable[row][col] == ' ') {
                gameTable[row][col] = '0';
                return;
            }
        }
    }

    private static void printTableMapping() {
        char[][] mappingTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        printGameTable(mappingTable);
    }

    // текущее состояние игрового поля
    private static void printGameTable(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }


    private static void makeUserMove(char[][] gameTable) {
        while (true) {
            System.out.println("Используйте следующие комбинации, чтобы указать ячейку, используя числа от 1 до 9.");
            String string = new Scanner(System.in).nextLine();
            if (string.length() == 1) {
                char digit = string.charAt(0);
                if (digit >= '1' && digit <= '9') {
                    if (makeUserMoveToCell(gameTable, digit)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean makeUserMoveToCell(char[][] gameTable, char digit) {
        char[][] mappingTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        for (int i = 0; i < mappingTable.length; i++) {
            for (int j = 0; j < mappingTable[i].length; j++) {
                if (mappingTable[i][j] == digit) {
                    if (gameTable[i][j] == ' ') {
                        gameTable[i][j] = 'X';
                        return true;
                    } else {
                        System.out.println("Невозможно сделать ход т.к. ячейка занята");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    // компьютер делает ход, заполняет пустые ячейки printGameTable ноликом '0'
    private static void MakeComputerMove(char[][] gameTable) {
        Random random = new Random();
        // через while компьютер будет заполнять пустые ячейки до тех пор пока не будет полностью заполнена
        while (true) {
            int row = random.nextInt(3); // bound 3 - возвращает случайное число в строку от 0 до 2
            int col = random.nextInt(3); // bound 3 - возвращает случайное число в столбцу от 0 до 2
            // если игровое поле по индексу row, col пуста, то в эту ячейку записываем 0
            if (gameTable[row][col] == ' ') {
                gameTable[row][col] = '0';
                return;
            }
        }
    }

    private static boolean isUserWin(char[][] gameTable) {
        return isWinner(gameTable, 'X');
    }

    private static boolean isComputerWin(char[][] gameTable) {
        return isWinner(gameTable, '0');
    }

    private static boolean isWinner(char[][] gameTable, char ch) {
        for (int i = 0; i < 3; i++) {
            {
                if (gameTable[i][0] == gameTable[i][1] && gameTable[i][0] == gameTable[i][2] && gameTable[i][0] == ch) {
                    return true;
                }
            }
        }
        // проверяем ячейки по столбцам
        for (int i = 0; i < 3; i++) {
            {
                if (gameTable[0][i] == gameTable[1][i] && gameTable[0][i] == gameTable[2][i] && gameTable[0][i] == ch) {
                    return true;
                }
            }
        }
        // проверяем ячейки по диоганали
        if (gameTable[0][0] == gameTable[1][1] && gameTable[0][0] == gameTable[2][2] && gameTable[0][0] == ch) {
            return true;
        }
        if (gameTable[0][2] == gameTable[1][1] && gameTable[0][2] == gameTable[2][0] && gameTable[0][2] == ch) {
            return true;
        }
        return false;
    }

    private static boolean isDraw(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
