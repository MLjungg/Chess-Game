import javax.swing.*;
import java.awt.*;

class ChessPiece {

    // Static variabel - chessPieces
    private ImageIcon[] icons = {
            new ImageIcon("./ChessPieces/Black/Pawn.png", "blackPawn"),
            new ImageIcon("./ChessPieces/Black/Bishop.png", "blackBishop"),
            new ImageIcon("./ChessPieces/Black/King.png", "blackKing"),
            new ImageIcon("./ChessPieces/Black/Queen.png", "blackQueen"),
            new ImageIcon("./ChessPieces/Black/Rook.png", "blackRook"),
            new ImageIcon("./ChessPieces/Black/Knight.png", "blackKnight"),
            new ImageIcon("./ChessPieces/White/Pawn.png", "whitePawn"),
            new ImageIcon("./ChessPieces/White/Bishop.png", "whiteBishop"),
            new ImageIcon("./ChessPieces/White/King.png", "whiteKing"),
            new ImageIcon("./ChessPieces/White/Queen.png", "whiteQueen"),
            new ImageIcon("./ChessPieces/White/Rook.png", "whiteRook"),
            new ImageIcon("./ChessPieces/White/Knight.png", "whiteKnight")
    };

    //Deklarerar instansvariabler
    String piece;
    String color;
    Icon image;

    ChessPiece() {
        this.piece = null;
        this.color = null;
        this.image = null;
    }

    ChessPiece(String color, String piece) {
        this.piece = piece;
        this.color = color;
        this.image = setImage();
    }

       Icon setImage() {
        for (int i = 0; i < this.icons.length; i++) {
            if (this.icons[i].getDescription().equals(color+piece)) {
                return this.icons[i];
            }
        }
        return null;
    }
}