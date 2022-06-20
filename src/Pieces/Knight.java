package Pieces;
import Game.*;

public class Knight extends Piece {

    Type type;

    public Knight(int x, int y) {
        super(x, y);
        type = Type.KNIGHT;
    }

    public Type getType() {return Type.KNIGHT;}

    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = Math.abs(finalX - this.x);
        int y_diff = Math.abs(finalY - this.y);

        return Math.abs(x_diff - y_diff) == 1;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pathLen = 3;

        int lenX = Math.abs(finalX - startX);
        int lenY = Math.abs(finalY - startY);

        int x_dir = 1, y_dir = 1;
        if (finalX - startX < 0) x_dir = -1;
        if (finalY - startY < 0) y_dir = -1;

        int [][] path = new int [2][pathLen - 1];

        for (int i = 0; i < pathLen - 1; i++) {
            if (i < lenX) path[0][i] = startX + x_dir*i;
            else path[0][i] = startX + x_dir*lenX;
            if (i < lenY) path[1][i] = startY + y_dir*i;
            else path[1][i] = startY + y_dir*lenY;
        }

        return path;
    }
    
}
