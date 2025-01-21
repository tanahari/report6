package jp.ac.uryukyu.ie.e245709;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

class BoardTest {
    /**
     * 本来は移動できない場所に駒が移動していないかを確かめることを検証
     * 検証手順
     * (1)移動させる駒を決める
     * (2)移動先を決める
     * isMoveableがfalseならばその駒は移動先へ移動できないを意味する。
     */
    @Test
    void isMoveableTest() {
        Board board = new Board();
        board.setBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int[] point = {i, j};
                if (i == 4 && j == 4) {
                    board.changeSpace(point, "金"); // <- 検証対象の配置
                } else {
                    board.changeSpace(point, "・");
                }
            }
        }

        int[] afterPoint = {3,5};// <-　移動先の決定
        int[] beforePoint = {4,4};

        assertEquals(false, board.isMoveable(beforePoint, afterPoint));
    }
    
}
