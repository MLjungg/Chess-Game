public class main {
    public static void main(String[] args){
        Chess gameLogic = new Chess();
        ViewControl gameGui = new ViewControl(gameLogic,64);
        gameGui.setVisible(true);
    }
}
