package pieces;

import java.util.List;

import game.*;

public abstract class Piece {
    
    protected final int piecePosition;
    protected final Allegiance pieceAllegiance;
    final Type type;
    
    Piece(final int piecePosition, final Allegiance pieceAllegiance, final Type type) {
        this.piecePosition = piecePosition;
        this.pieceAllegiance = pieceAllegiance;
        this.type = type;
        
    }

    public abstract List<Move> calculateLegalMoves(final Board board);

    public Allegiance getPieceAllegiance() {
        return this.pieceAllegiance;
    }

}
