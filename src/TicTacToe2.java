import java.util.*;

public class TicTacToe2 {
    final static char SIGN_X = 'X';
    final static char SIGN_O = '0';
    final static char SIGN_EMPTY = ' ';
    static char[][] table;
    Scanner sc;

    public static void main(String[] args) {
        TicTacToe2 game = new TicTacToe2();
        game.play();
    }

    TicTacToe2() {
        sc = new Scanner(System.in);
        table = new char[3][3];
        initTable();
    }

    static void initTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                table[row][col] = SIGN_EMPTY;
                System.out.print("[" + table[row][col] + "]");
            }
            System.out.println();
        }
    }

    static void play() {
        while (true) {
            manWalk(SIGN_X);
            showTable();
            if (checkWin(SIGN_X)) {
                System.out.println("Man1 vu vuigrali!");
                break;
            }
            if (isFullTable()) {
                System.out.println("Tablica zapolnena polnostu.");
                break;
            }
            manWalk(SIGN_O);
            showTable();
            if (checkWin(SIGN_O)) {
                System.out.println("Man2 vu vuigrali!");
                break;
            }
            if (isFullTable()) {
                System.out.println("Tablica zapolnena polnostu.");
                break;
            }
        }
    }

    static void manWalk(char sign) {
        int x;
        int y;
        do {
            System.out.println("Vvedite X i Y (1...3): ");
            x = new Scanner(System.in).nextInt() - 1;
            y = new Scanner(System.in).nextInt() - 1;
        } while (!isCellValidMan(x, y));
        table[x][y] = sign;
    }

    static boolean isCellValidMan(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Chislo ne iz diapazona (1...3)");
            return false;
        }
        return true;
    }

    static void showTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("[" + table[row][col] + "]");
            }
            System.out.println();
        }
    }

    static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == symbol && table[i][1] == symbol && table[i][2] == symbol) ||
                    (table[0][i] == symbol && table[1][i] == symbol && table[2][i] == symbol))
                return true;
        }
        if ((table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol) ||
                (table[2][0] == symbol && table[1][1] == symbol && table[0][2] == symbol))
            return true;
        return false;
    }

    static boolean isFullTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == SIGN_EMPTY) return false;
            }
        }
        return true;
    }
}
