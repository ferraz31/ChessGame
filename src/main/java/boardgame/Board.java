package boardgame;

public class Board {

    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board() {

    }

    public Board(Integer rows, Integer columns) {
        if (rows != 8 || columns != 8) {
            throw new BoardException("Error creating the board! It must be an 8 by 8 board!");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }


    public Piece piece(int row, int column) {
        if (!positionExists(row,column)) {
            throw new BoardException("You are trying to put a piece outside the matrix!");
        }
        return pieces[row][column];

    }

    public Piece piece (Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position out of boundaries!");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is a piece in that position already: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }


    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position out of boundaries!");
        }
        return piece(position) != null;
    }


}
