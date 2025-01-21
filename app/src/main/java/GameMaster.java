import java.util.Scanner;

import jp.ac.uryukyu.ie.e245709.Board;
import jp.ac.uryukyu.ie.e245709.Player;

public class GameMaster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player = new Player();

        board.setBoard();
        board.printBoard();
        for (int i = 0; i < 2; i++) {
            
            int[] beforePoint = player.specifyBeforePoint();
            int[] afterPoint = player.specifyAfterPoint(beforePoint);

            System.out.println(board.getSpace(beforePoint));
            System.out.println(board.getSpace(afterPoint));

            String beforespaceInfo = board.getSpace(beforePoint);
            String afterspaceInfo = board.getSpace(afterPoint);

            board.changeSpace(beforePoint, afterspaceInfo);
            board.changeSpace(afterPoint, beforespaceInfo);

            System.out.println(board.getSpace(beforePoint));
            System.out.println(board.getSpace(afterPoint));
            
            board.printBoard();
            
            }
        scanner.close();
    }
}
