
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
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 5. Выводим на массив на печать
    private static void printField() {
        //6. украшаем картинку
        System.out.println("---------");
        for (int i = 0; i < SIZE_X; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_Y; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        //6. украшаем картинку
        System.out.println("---------");
    }

    // 7. Метод который устанавливает символ
    private static void setSym(int x, int y, char sym) {
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
        } while (!isCellValid(x, y));
        setSym(x, y, PLAYER_DOT);

    }


//    // 13. Ход ПК
//    private static void aiStep() {
//        int x;
//        int y;
//        do{
//            x = rand.nextInt(SIZE_X);
//            y = rand.nextInt(SIZE_Y);
//        } while(!isCellValid(x,y));
//        setSym(x, y, AI_DOT);
//    }

    // 13. Ход ПК
    private static boolean aiStep(char sym) {
        int x, y;
        //блокировка ходов человека

        for (int v = 0; v < SIZE_X; v++) {
            for (int h = 0; h < SIZE_Y; h++) {

                if (h + WIN_NUMS <= SIZE_Y) {
                    if (v - WIN_NUMS > -2) {                            //вверх по диагонали
                        if (checkUpDiag(v, h, PLAYER_DOT) == WIN_NUMS - 1) {
                            if (moveAIUpDiag(v, h, AI_DOT)) return true;
                        }
                    }
                    if (v + WIN_NUMS <= SIZE_X) {                       //вниз по диагонали
                        if (checkDownDiag(v, h, PLAYER_DOT) == WIN_NUMS - 1) {
                            if (moveAIDownDiag(v, h, AI_DOT)) return true;
                        }
                    }
                }
                if (h + WIN_NUMS <= SIZE_Y) {
                    if (checkVert(v, h, PLAYER_DOT) == WIN_NUMS - 1) {
                        if (moveAIVert(AI_DOT)) return true;
                    }
                }
                if (v + WIN_NUMS <= SIZE_X) {
                    if (checkHoriz(v, h, PLAYER_DOT) == WIN_NUMS - 1) {
                        if (moveAIHoriz(AI_DOT)) return true;
                    }
                }
            }
        }

        //игра на победу

        for (int v = 0; v < SIZE_X; v++) {
            for (int h = 0; h < SIZE_Y; h++) {

                if (h + WIN_NUMS <= SIZE_Y) {
                    if (v - WIN_NUMS > -2) {
                        if (checkUpDiag(v, h, AI_DOT) == WIN_NUMS - 1) {
                            if (moveAIUpDiag(v, h, AI_DOT)) return true;
                        }
                    }
                    if (v + WIN_NUMS <= SIZE_X) {
                        if (checkDownDiag(v, h, AI_DOT) == WIN_NUMS - 1) {
                            if (moveAIDownDiag(v, h, AI_DOT)) return true;
                        }
                    }
                }
                if (h + WIN_NUMS <= SIZE_Y) {
                    if (checkVert(v, h, PLAYER_DOT) == WIN_NUMS - 1) {
                        if (moveAIVert(AI_DOT)) return true;
                    }
                }
                if (v + WIN_NUMS <= SIZE_X) {
                    if (checkHoriz(v, h, PLAYER_DOT) == WIN_NUMS - 1) {
                        if (moveAIHoriz(AI_DOT)) return true;
                    }
                }
            }
        }

        //случайный ход
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while(!isCellValid(x,y));
        setSym(x, y, AI_DOT);
        return false;
    }

    // ход ПК по горизонтали
    private static boolean moveAIHoriz(char sym) {
        int hor = 0;
        for (int i = 0; i < field.length; i++) {
            hor = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    field[i][j] = sym;
                    return true;
                }
            }
        }
        return false;
    }

    // ход ПК  по вертикали
    private static boolean moveAIVert(char sym) {
        int vert = 0;
        for (int j = 0; j < field.length; j++) {
            vert = 0;
            for (int i = 0; i < field.length; i++) {
                if (field[i][j] == EMPTY_DOT) {
                    field[i][j] = sym;
                    return true;
                }
            }
        }
        return false;
    }

    //ход ПК  по диагонали вверх

    private static boolean moveAIUpDiag(int v, int h, char sym) {
        int count=0;
        for (int i = 0, j = 0; j < WIN_NUMS; i--, j++) {
            if ((field[v+i][h+j] == EMPTY_DOT)){
                field[i+v][i+h] = sym;
                return true;
            }
        }
        return false;
    }

    //ход ПК  по диагонали вниз

    private static boolean moveAIDownDiag(int v, int h, char sym) {
        int count=0;
        for (int i = 0; i < WIN_NUMS; i++) {
            if ((field[i+v][i+h] == EMPTY_DOT)) {
                field[i+v][i+h] = sym;
                return true;
            }
        }
        return false;
    }


    // 14. Проверка победы
    private static boolean checkWin(char sym) {

        for (int v = 0; v<SIZE_X; v++){
            for (int h= 0; h<SIZE_Y; h++) {
                //анализ наличие поля для проверки
                if (h + WIN_NUMS <= SIZE_Y) {                           //по горизонтале

                    if (v - WIN_NUMS > -2) {                            //вверх по диагонале
                        if (checkUpDiag(v, h, sym) >= WIN_NUMS) return true;
                    }
                    if (v + WIN_NUMS <= SIZE_X) {                       //вниз по диагонале
                        if (checkDownDiag(v, h, sym) >= WIN_NUMS) return true;
                    }

                }
                if (checkHoriz(v, h, sym) >= WIN_NUMS)
                {
                    return true;
                }
                if (checkVert(v, h, sym) >= WIN_NUMS)
                {
                    return true;
                }

            }
        }

        return false;
    }

    // проверка победы игрока по горизонтали
    private static int checkHoriz(int v, int h, char sym){
        int hor = 0;
        for (int i=0; i< field.length; i++) {
            hor = 0;
            for (int j = 0; j < field.length; j++){
                if (field[i][j] == sym)
                {
                    hor++;
                    if (hor >=WIN_NUMS) return hor;
                }
                else if ((field[i][j] != sym) && (hor < WIN_NUMS))
                {
                    hor = 0;
                }
            }
        }
        return hor;
    }

    // проверка победы игрока по вертикали
    private static int checkVert(int v, int h, char sym){
        int vert = 0;
        for (int j=0; j< field.length; j++) {
            vert = 0;
            for (int i = 0; i < field.length; i++){
                if (field[i][j] == sym)
                {
                    vert++;
                    if (vert >= WIN_NUMS) return vert;
                }
                else if ((field[i][j] != sym) && (vert < WIN_NUMS))
                {
                    vert = 0;
                }
            }
        }
        return vert;
    }

    //проверка победы игрока по диагонали вверх

    private static int checkUpDiag(int v, int h, char sym) {
        int count=0;
        for (int i = 0, j = 0; j < WIN_NUMS; i--, j++) {
            if ((field[v+i][h+j] == sym)) count++;
        }
        return count;
    }

    //проверка победы игрока по диагонали вниз

    private static int checkDownDiag(int v, int h, char sym) {
        int count=0;
        for (int i = 0; i < WIN_NUMS; i++) {
            if ((field[i+v][i+h] == sym)) count++;
        }
        return count;
    }

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
            if((checkWin(PLAYER_DOT))) {
                System.out.println("Player WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiStep(PLAYER_DOT);
            printField();
            if((checkWin(PLAYER_DOT))) {
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
