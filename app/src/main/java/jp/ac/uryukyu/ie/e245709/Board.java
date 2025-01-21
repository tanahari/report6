package jp.ac.uryukyu.ie.e245709;

public class Board {
    private static final int BOARD_SIZE = 9; // 9x9の盤
    private String[][] initBoard; // 初期盤面
    private String[][] board;
    Koma koma = new Koma();

    public Board() {
        initBoard = new String [BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                switch (i) {
                    case 0, 8:  // １列目と９列目
                        initBoard[i][j] = switch (j) {
                            case 0, 8 -> (i == 0) ? "香・" : "香"; //香車配置, "."がついている駒は敵であることを示している
                            case 1, 7 -> (i == 0) ? "桂・" : "桂"; //桂馬配置
                            case 2, 6 -> (i == 0) ? "銀・" : "銀"; //銀将配置
                            case 3, 5 -> (i == 0) ? "金・" : "金"; //金将配置
                            default   -> (i == 0) ? "王・" : "王"; //王将配置
                        };
                        break;
                    case 1,7:  // ２列目と８列目
                        initBoard[i][j] = switch (j) {
                            case 1  -> (i == 1) ? "飛・" : "角"; //飛車または角行配置
                            case 7  -> (i == 7) ? "飛" : "角・"; //角行または飛車配置
                            default -> "・"; //"." は空いている場所を示す
                        };
                        break;
                    case 2, 6:  // ３列目と７列目
                        initBoard[i][j] = (i == 2) ? "歩・" : "歩"; //歩兵配置
                        break;
                    default:  // ４～６列目
                        initBoard[i][j] = "・"; // . は空いている場所を示す
                        break;
                }
            }
        }
    }

    public void setBoard() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = initBoard[i][j]; 
            }
        }
    }
    
    // 盤面を表示するメソッド
    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].length() == 2) {
                    board[i][j] = board[i][j].substring(0, 1);
                    System.out.print("\033[31m" + board[i][j] + "\033[0m" + " ");
                    board[i][j]  = board[i][j] + "・";
                }else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //i行j列目のマスをspaceに変更するためのメソッド
    public void changeSpace(int[] point, String space) {
        int x = point[0], y = point[1];
        this.board[y][x] = space;
    }

    //i行j列目のマスの情報を取り出すメソッド
    public String getSpace(int[] point) {
        int x = point[0], y = point[1];
        return board[y][x];
    }

    public boolean isInRange(int[] point) {
        int x = point[0], y = point[1];

        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isAlly(int[] point) {

        int x = point[0], y = point[1];
        if (board[y][x].endsWith("・") == true) {
            System.out.println("味方の駒しか動かせません。");
            return false;
        }else {
            return true;
        }
    }
    public boolean isMoveable(int[] beforepoint, int[] afterPoint) {
        int xb = beforepoint[0], yb = beforepoint[1];
        int xa = afterPoint[0], ya = afterPoint[1];
        String allyKoma = board[yb][xb];

        if (!board[ya][xa].endsWith("・")) {
            System.out.println("味方の駒は取れません。");
            return false;
        } 
        switch (allyKoma) {
            case "歩" :
                return koma.moveableFu(xa, ya, xb, yb);

            case "桂":
                return koma.moveableKei(xa, ya, xb, yb);
    
            case "銀":
                return koma.moveableGin(xa, ya, xb, yb);
    
            case "金":
                return koma.moveableKin(xa, ya, xb, yb);
    
            case "王":
                return koma.moveableOu(xa, ya, xb, yb);

            case "飛":
                return koma.moveableHi(xa, ya, xb, yb);

            case "角":
                return koma.moveableKaku(xa, ya, xb, yb);
        }
        return true;    
    }  
}
