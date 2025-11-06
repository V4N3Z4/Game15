import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private final JButton[][] buttons = new JButton[4][4];
    private final  Controller controller = new Controller();

    public Board(){
        setTitle("15 Game Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4,4));
        createButtons(panel);

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(_ -> {
            controller.Newgame();
            updateButtons();
        });

        add(panel,BorderLayout.CENTER);
        add(newGameButton, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    private  void createButtons(JPanel panel){
        for(int row =0; row < 4; row++){
            for(int col = 0; col < 4; col++){
                JButton button = new JButton();
                buttons[row][col] = button;
                int r = row, c = col;
                button.addActionListener(_ ->{
                    if (controller.moveTile(r,c)){
                        updateButtons();
                        if(controller.isGameWon()){
                            JOptionPane.showMessageDialog(this, "Congratulations, you won!");
                        }
                    }
                });
                panel.add(button);
            }
        }
        updateButtons();
    }
    public  void updateButtons(){
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < 4; col++){
                Tile tile = controller.getTile(row,col);
                JButton button = buttons[row][col];
                button.setText(tile.toString());
                button.setEnabled(!tile.isEmpty());
            }
        }
    }

}

