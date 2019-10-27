import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;

class ViewControl extends JFrame implements ActionListener{

    // Instance variables
    private Boardgame game;
    private Buttons[] buttonArray;
    private JLabel mess = new JLabel();

    ViewControl (Boardgame gameLogic, int n){

        //Declaring values to attributes
        this.game = gameLogic;
        this.buttonArray = new Buttons[n];

        //Setting up window
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating a panel that holds all the buttons in a grid layout.
        int side = (int)(Math.sqrt(n));
        JPanel buttonPanel = new JPanel(new GridLayout(side,side,5, 5)); //side anger hur många rader/columner hgap/vgap hur muycket mellanrum.
        buttonPanel.setBackground(Color.GRAY);


        //Adding buttons to the buttonPanel
        Color color = Color.DARK_GRAY;
        for (int i = side-1; i >= 0; i--) {
            for (int j = side-1; j >= 0; j--) {
                int currentIndex = side*i+j;
                this.buttonArray[currentIndex] = new Buttons(game.getStatus(i,j).image,i, j);
                this.buttonArray[currentIndex].setBackground(color);
                this.buttonArray[currentIndex].setOpaque(true);
                this.buttonArray[currentIndex].setBorderPainted(false);
                this.buttonArray[currentIndex].addActionListener(this);
                buttonPanel.add(this.buttonArray[currentIndex]);
                if (j != 0) {
                    if (color == Color.DARK_GRAY) {
                        color = Color.WHITE;
                    } else {
                        color = Color.DARK_GRAY;
                    }
                }
            }
        }

        //Adding panel to window
        this.add(buttonPanel);

        //Adding label to the window (not the panel)
        this.mess.setHorizontalAlignment(JLabel.CENTER);
        this.mess.setText(game.getMessage());
        this.mess.setOpaque(true);  //To get colors on Mac
        this.add(this.mess, BorderLayout.SOUTH);
        }

    public void actionPerformed(ActionEvent event) {
        //Check if move is possible. If possible -> label.color = green. Else -> red. Change text in label either way.
        for (Buttons button : this.buttonArray)
            if (button == event.getSource()) {
                if (this.game.move(button.i, button.j)) {
                    this.mess.setBackground(Color.green);
                }
                else{this.mess.setBackground(Color.red);}

                this.mess.setText(this.game.getMessage());
                // return
            }

        //Uppdatera alla knappar
        for (Buttons button : this.buttonArray){
            button.setIcon(this.game.getStatus(button.i, button.j).image);
        }
    }
}

