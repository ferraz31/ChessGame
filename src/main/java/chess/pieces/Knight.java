package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }
}
