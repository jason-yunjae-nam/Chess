package pieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.*;
import game.Move.AttackMove;
import game.Move.JustMove;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    Knight(final int piecePosition, final Allegiance allegiance) {
        super(piecePosition, allegiance, Type.KNIGHT);
    }

    @Override
    public List<Move> calculateLegalMoves (final Board board) {

        List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate = this.piecePosition + currentCandidate;
            if (Board.isValidTileCoordinate(candidateDestinationCoordinate)) {
                if (isFirstColumnExclusion(this.piecePosition, currentCandidate) ||
                    isSecondColumnExclusion(this.piecePosition, currentCandidate) ||
                    isSeventhColumnExclusion(this.piecePosition, currentCandidate) ||
                    isEighthColumnExclusion(this.piecePosition, currentCandidate)) {
                    continue;
                }
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new JustMove(board, this, candidateDestinationCoordinate));
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Allegiance pieceAllegiance = pieceAtDestination.getPieceAllegiance();
                    if (this.pieceAllegiance != pieceAllegiance) {
                        legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }

        return Collections.unmodifiableList(legalMoves);
    }

    private static boolean isFirstColumnExclusion (final int currentPosition, final int candidateOffset) {
        return Board.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 || candidateOffset == 6 || candidateOffset == 15);
    }

    private static boolean isSecondColumnExclusion (final int currentPosition, final int candidateOffset) {
        return Board.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
    }

    private static boolean isSeventhColumnExclusion (final int currentPosition, final int candidateOffset) {
        return Board.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
    }

    private static boolean isEighthColumnExclusion (final int currentPosition, final int candidateOffset) {
        return Board.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6 || candidateOffset == 10 || candidateOffset == 17);
    }
    
}
