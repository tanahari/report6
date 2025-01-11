package jp.ac.uryukyu.ie.e245709;

public class Board {
    private static final int BOARD_SIZE = 9; // 9x9の盤
    private char[][] board; // 盤面

     // コンストラクタ
     public Board() {
        board = new char [BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                switch (i) {
                    case 0, 8:  // １列目と９列目
                        board[i][j] = switch (j) {
                            case 0, 8 -> '香'; //香車配置
                            case 1, 7 -> '桂'; //桂馬配置
                            case 2, 6 -> '銀'; //銀将配置
                            case 3, 5 -> '金'; //金将配置
                            default   -> '王'; //王将配置
                        };
                        break;
                    case 1,7:  // ２列目と８列目
                        board[i][j] = switch (j) {
                            case 1  -> (i == 1) ? '飛' : '角'; //飛車または角行配置
                            case 7  -> (i == 7) ? '飛' : '角'; //角行または飛車配置
                            default -> '・'; //'.' は空いている場所を示す
                        };
                        break;
                    case 2, 6:  // ３列目と７列目
                        board[i][j] = '歩';
                        break;
                    default:  // ４～６列目
                        board[i][j] = '・'; //'.' は空いている場所を示す
                        break;
                }
            }
        }
    }
    
    // 盤面を表示するメソッド
    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //i行j列目のマスをspaceに変更するためのメソッド
    public void setSpace(int i, int j, char space) {
        this.board[i][j] = space;
    }
}
