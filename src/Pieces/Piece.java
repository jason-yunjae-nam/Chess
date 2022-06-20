package Pieces;
import Game.*;

public abstract class Piece {
    
    public int x, y;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        
    }

    public abstract boolean isValidPath(int finalX, int finalY);

    public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);

    public abstract Type getType();

}
