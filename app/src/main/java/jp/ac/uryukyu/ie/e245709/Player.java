package jp.ac.uryukyu.ie.e245709;
import java.util.Scanner;

public class Player {
    Board board = new Board();
    
    public int[] specifyComponent() {
        board.setBoard();

        Scanner scanner = new Scanner(System.in);
        int[] point = new int[2];

        boolean flag = true;
        while (flag) {
            for (int i = 0; i < 2; i++) {
                point[i] = scanner.nextInt();
            }
            if (board.isInRange(point) == false) {
                System.out.println("範囲外です。もう一度入力してください。");
            }
            flag = !board.isInRange(point);
        }
        return point;
    }   

    public int[] specifyBeforePoint() {
        int[] beforePoint = new int[2];
        
        boolean flag = true;
        while(flag) {
            beforePoint = specifyComponent();
            flag = !board.isAlly(beforePoint);
        }
        return beforePoint;
    }

    public int[] specifyAfterPoint(int[] beforePoint) {
        int[] afterPoint = new int[2];
        
        boolean flag = true;
        while(flag) {
            afterPoint = specifyComponent();
            flag = !board.isMoveable(beforePoint, afterPoint);
        }
        return afterPoint;
    }
}
