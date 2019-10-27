import java.util.Collections;

public class Chess implements Boardgame {

    //Deklarerar instansvariabler
    private String currentMessage;
    private ChessPiece[][] board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean squareReserved; //Håller koll på om en ruta markerats för att flyttas

    Chess() {
        //Ger värde till instansvariabler
        this.initializeBoard();
        this.player1 = new Player("white");
        this.player2 = new Player( "black");
        this.currentPlayer = this.player1;
        this.currentMessage = this.currentPlayer.color + ": your turn";
        this.squareReserved = false;
    }

    private void initializeBoard(){
        // Setup gameboard
        board = new ChessPiece[8][8];

        //White Pawns
        for (int i = 0; i < 8; i++) {
            this.board[1][i] = new ChessPiece("white", "Pawn");
        }

        // Black Pawns
        for (int i = 0; i < 8; i++) {
            this.board[6][i] = new ChessPiece("black", "Pawn");
        }

        //Rooks
        board[0][0] = new ChessPiece("white", "Rook");
        board[0][7] = new ChessPiece("white", "Rook");
        board[7][7] = new ChessPiece("black", "Rook");
        board[7][0] = new ChessPiece("black", "Rook");

        //Knights
        board[0][1] = new ChessPiece("white", "Knight");
        board[0][6] = new ChessPiece("white", "Knight");
        board[7][6] = new ChessPiece("black", "Knight");
        board[7][1] = new ChessPiece("black", "Knight");

        //Bishops
        board[0][2] = new ChessPiece("white", "Bishop");
        board[0][5] = new ChessPiece("white", "Bishop");
        board[7][2] = new ChessPiece("black", "Bishop");
        board[7][5] = new ChessPiece("black", "Bishop");

        //Queens
        board[0][3] = new ChessPiece("white", "Queen");
        board[7][3] = new ChessPiece("black", "Queen");

        //Kings
        board[0][4] = new ChessPiece("white", "King");
        board[7][4] = new ChessPiece("black", "King");

        //The rest
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++)
            this.board[i][j] = new ChessPiece();
        }
    }

    public boolean move(int i, int j) {
        if (getStatus(i, j).color == (this.currentPlayer.color)) {
            this.squareReserved = true;
            this.currentPlayer.reservCoordinates(i,j);
            this.currentMessage = this.currentPlayer.color + " choose an empty box to move to";
            return true;
        }
        //Om man markerat en ruta att flytta och sedan trycker på en tom ruta --> byter plats på pjäser
        else if (getStatus(i, j).color == null && this.squareReserved) {

            ChessPiece temporary = this.board[i][j];
            this.board[i][j] = this.board[this.currentPlayer.reservedCoordinates[0]][this.currentPlayer.reservedCoordinates[1]];
            this.board[this.currentPlayer.reservedCoordinates[0]][this.currentPlayer.reservedCoordinates[1]] = temporary;
            this.squareReserved = false;
            this.togglePlayer();
            this.currentMessage = this.currentPlayer.color + ": your turn";
            return true;
        }
        // Om man klickat på en pjäs med fel färg
        else {
            this.currentMessage = "Choose a " + this.currentPlayer.color + " piece to move";
            return false;
        }
    }

    public ChessPiece getStatus (int i, int j){
       return board[i][j];
    }

    public String getMessage () {
        return this.currentMessage;
    }

    private void togglePlayer() {
        if (this.currentPlayer == this.player1) {
                this.currentPlayer = this.player2;
        } else {
                this.currentPlayer = this.player1;
        }
    }
}




