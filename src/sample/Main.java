
import java.util.Random;
import java.util.Scanner;

public class Main {

    // 3. Определяем размеры массива
    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;
    static final int WIN_NUMS = 4;

    // 1. Создаем двумерный массив
    static char[][] field = new char[SIZE_X][SIZE_Y];

    // 2. Обозначаем кто будет ходить какими фишками
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = '0';
    static final char EMPTY_DOT = '.';

    // 8. Создаем сканер
    static Scanner scanner = new Scanner(System.in);
    // 12. Создаем рандом
    static final Random rand = new Random();

    // 4. Заполняем на массив
    private static void initField() {
        for(int i = 0; i < SIZE_X; i++) {
            for(int j = 0; j < SIZE_Y; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 5. Выводим на массив на печать
    private static void printField() {
        //6. украшаем картинку
        System.out.println("---------");
        for(int i = 0; i < SIZE_X; i++) {
            System.out.print("|");
            for(int j = 0; j < SIZE_Y; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        //6. украшаем картинку
        System.out.println("---------");
    }

    // 7. Метод который устанавливает символ
    private static void setSym(int x, int y, char sym){
        field[x][y] = sym;
    }

    // 9. Ход игрока
    private static void playerStep() {
        // 11. с проверкой
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X Y (1-5)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x,y));
        setSym(x, y, PLAYER_DOT);

    }

    // 13. Ход ПК
    private static void aiStep() {
        int x;
        int y;
        do{
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while(!isCellValid(x,y));
        setSym(x, y, AI_DOT);
    }

    // 14. Проверка победы
    private static boolean checkHoriz(char sym){
        int hor;
        for (int i=0; i< field.length; i++) {
            hor = 0;
            for (int j = 0; j < field.length; j++){
                if (field[i][j] == sym)
                {
                    hor++;
                }
                else if ((field[i][j] != sym) && (hor < WIN_NUMS))
                {
                    hor = 0;
                }
            }
            if (hor == WIN_NUMS)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean checkVert(char sym){
        int vert;
        for (int j=0; j< field.length; j++) {
            vert = 0;
            for (int i = 0; i < field.length; i++){
                if (field[i][j] == sym)
                {
                    vert++;
                }
                else if ((field[i][j] != sym) && (vert < WIN_NUMS))
                {
                    vert = 0;
                }
            }
            if (vert == WIN_NUMS)
            {
                return true;
            }
        }
        return false;
    }

    //проверка главной диагонали и параллеьных главной
    private static boolean checkMainDiag(char sym) {
        int mainDiag;
        mainDiag = 0;
        for (int i = 0, j = 0; i < field.length && j < field.length; i++, j++) {

            if (field[i][j] == sym) {
                mainDiag++;
            } else if ((field[i][j] != sym) && (mainDiag < WIN_NUMS)) {
                mainDiag = 0;
            }
        }
        if (mainDiag == WIN_NUMS) {
            return true;
        }

        //ниже главной
        for (int k = SIZE_X - 1, n = 0; k >= 0; k--) {
            for (int i = k, j = n; i < field.length && j < field.length; i++, j++) {

                if (field[i][j] == sym) {
                    mainDiag++;
                } else if ((field[i][j] != sym) && (mainDiag < WIN_NUMS)) {
                    mainDiag = 0;
                }
            }
            if (mainDiag == WIN_NUMS) {
                return true;
            }
        }

        //выше главной
        for (int k= 0, n= 1; n< field.length; n++){
            for (int i = k, j = n; i < field.length && j < field.length; i++, j++) {

                if (field[i][j] == sym) {
                    mainDiag++;
                } else if ((field[i][j] != sym) && (mainDiag < WIN_NUMS)) {
                    mainDiag = 0;
                }
            }
            if (mainDiag == WIN_NUMS) {
                return true;
            }
        }
        return false;
    }

    //проверка побочной диагонали и параллельных ей
    private static boolean checkSideDiag(char sym) {
        int mainDiag;
        mainDiag = 0;

            for (int i = 0, j = SIZE_Y-1; i < field.length && j >=0; i++, j--) {

                if (field[i][j] == sym) {
                    mainDiag++;
                } else if ((field[i][j] != sym) && (mainDiag < WIN_NUMS)) {
                    mainDiag = 0;
                }
            }
            if (mainDiag == WIN_NUMS) {
                return true;
            }

        // ниже побочной
        for (int k = SIZE_X - 1, n = SIZE_Y-1; k >=0; k--) {
            for (int i = k, j = n; i < field.length && j>0; i++, j--) {

                if (field[i][j] == sym) {
                    mainDiag++;
                } else if ((field[i][j] != sym) && (mainDiag < WIN_NUMS)) {
                    mainDiag = 0;
                }
            }
            if (mainDiag == WIN_NUMS) {
                return true;
            }
        }

        // выше побочной
        for (int k = 0, n = SIZE_Y-2; n >=0; n--) {
            for (int i = k, j = n; i < field.length && j>=0; i++, j--) {

                if (field[i][j] == sym) {
                    mainDiag++;
                } else if ((field[i][j] != sym) && (mainDiag < WIN_NUMS)) {
                    mainDiag = 0;
                }
            }
            if (mainDiag == WIN_NUMS) {
                return true;
            }
        }

        return false;
    }



//    private static boolean checkWin(char sym) {
//        if (field[0][0] == sym && field[0][1] == sym && field[0][2] == sym) {
//            return true;
//        }
//        if (field[1][0] == sym && field[1][1] == sym && field[1][2] == sym) {
//            return true;
//        }
//        if (field[2][0] == sym && field[2][1] == sym && field[2][2] == sym) {
//            return true;
//        }
//
//        if (field[0][0] == sym && field[1][0] == sym && field[2][0] == sym) {
//            return true;
//        }
//        if (field[0][1] == sym && field[1][1] == sym && field[2][1] == sym) {
//            return true;
//        }
//        if (field[0][2] == sym && field[1][2] == sym && field[2][2] == sym) {
//            return true;
//        }
//
//
//        if (field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) {
//            return true;
//        }
//        if (field[2][0] == sym && field[1][1] == sym && field[0][2] == sym) {
//            return true;
//        }
//        return false;
//    }

    // 16. Проверка полное ли поле? возможно ли ходить?
    private static boolean isFieldFull() {
        for (int i = 0; i < SIZE_X; i++) {
            for(int j = 0; j < SIZE_Y; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // 10. Проверяем возможен ли ход
    private static boolean isCellValid(int x, int y) {
        // если вываливаемся за пределы возвращаем false
        if(x < 0 || y < 0 || x > SIZE_X -1 || y > SIZE_Y - 1) {
            return false;
        }
        // если не путое поле тоже false
        return (field[x][y] == EMPTY_DOT);
    }

    public static void main(String[] args) {
        // 1 - 1 иницируем и выводим на печать
        initField();
        printField();
        // 1 - 1 иницируем и выводим на печать

        // 15 Основной ход программы

        while (true) {
            playerStep();
            printField();
            if((checkHoriz(PLAYER_DOT))
                    || (checkVert(PLAYER_DOT))
                    || (checkMainDiag(PLAYER_DOT))
                    || (checkSideDiag(PLAYER_DOT))) {
                System.out.println("Player WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiStep();
            printField();
            if((checkHoriz(PLAYER_DOT))
                    || (checkVert(PLAYER_DOT))
                    || (checkMainDiag(PLAYER_DOT))
                    || (checkSideDiag(PLAYER_DOT))) {
                System.out.println("Win SkyNet!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }
        }

    }
}