package pieces;
import game.*;

public class Bishop extends Piece {
    
    Type type;

    public Bishop(int x, int y) {
        super(x, y);
        type = Type.BISHOP;
    }

    public Type getType() {return Type.BISHOP;}

    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = Math.abs(finalX - this.x);
        int y_diff = Math.abs(finalY - this.y);

        return x_diff == y_diff;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs = Math.abs(finalX - startX);

        int x_dir = 1, y_dir = 1;
        if (finalX - startX < 0) x_dir = -1;
        if (finalY - startY < 0) y_dir = -1;

        int [][] path = new int [2][pairs - 1];

        if (pairs - 1 > 0) {
            for (int i = 0; i < pairs - 1; i++) {
                path[0][i] = startX + x_dir*i;
                path[1][i] = startY + y_dir*i;
            }
        }

        return path;
    }

}
