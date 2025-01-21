package jp.ac.uryukyu.ie.e245709;

public class Koma {
    public boolean moveableFu(int xa, int ya, int xb, int yb) {
        if (!(xa - xb == 0 && ya - yb == -1)) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }

    public boolean moveableKei(int xa, int ya, int xb, int yb) {
        if (!(Math.abs(xa - xb) == 1 && ya - yb == -2)) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }

    public boolean moveableGin(int xa, int ya, int xb, int yb) {
        if (!(Math.abs(xa - xb) == 1 && Math.abs(ya - yb) == 1) && !(xa - xb == 0 && ya - yb == -1)) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }

    public boolean moveableKin(int xa, int ya, int xb, int yb) {
        if (!(Math.abs(xa - xb) <= 1 && (ya - yb == 0 || ya - yb == -1))) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }

    public boolean moveableOu(int xa, int ya, int xb, int yb) {
        if (!(Math.abs(xa - xb) <= 1 && Math.abs(ya - yb) <= 1)) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }

    public boolean moveableHi(int xa, int ya, int xb, int yb) {
        if (!(xa == xb || ya == yb)) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }

    public boolean moveableKaku(int xa, int ya, int xb, int yb) {
        if (!(Math.abs(xa - xb) == Math.abs(ya - yb))) {
            System.out.println("ここには動かせません");
            return false;
        }
        return true;
    }
}
