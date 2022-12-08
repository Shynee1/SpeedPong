package Main;

import Utils.Constants;
import Utils.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JPanel implements ActionListener {
    JButton startButton;
    JButton exitButton;
    Text title;
    Window window;

    public MenuWindow(Window window){
        this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        this.setLayout(null);
        this.window = window;

        setupStartButton();
        this.add(startButton);

        setupExitButton();
        this.add(exitButton);

        this.setVisible(true);
    }


    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        Font font = new Font("Impact", Font.PLAIN, 125);
        FontMetrics fm = g2d.getFontMetrics(font);
        title = new Text("Speed Pong", font, Color.white, Constants.SCREEN_WIDTH/2-(fm.stringWidth("Speed Pong")/2), 250);

        title.draw(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton){
            window.changeState(Constants.GAME_STATE);
        } else if (e.getSource() == exitButton){
            window.changeState(Constants.EXIT_STATE);
        }
    }

    public void setupStartButton(){
        startButton = new JButton("Start Game");
        startButton.setBounds(Constants.SCREEN_WIDTH/2-100, 350, 200, 100);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setOpaque(false);
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        startButton.setFont(new Font("Impact", Font.PLAIN, 35));
        startButton.setBorder(new LineBorder(Color.white, 5));
    }

    public void setupExitButton(){
        exitButton = new JButton("Exit Game");
        exitButton.setBounds(Constants.SCREEN_WIDTH/2-100, 500, 200, 100);
        exitButton.setFocusable(false);
        exitButton.setOpaque(false);
        exitButton.addActionListener(this);
        exitButton.setForeground(Color.white);
        exitButton.setBackground(Color.black);
        exitButton.setFont(new Font("Impact", Font.PLAIN, 35));
        exitButton.setBorder(new LineBorder(Color.white, 5));
    }
}
