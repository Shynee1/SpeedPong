package Main;

import Utils.Constants;
import Utils.KeyListener;
import Utils.RepeatingTimer;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame{

    private MenuWindow menuWindow;
    private GameWindow gameWindow;
    private KeyListener kl;
    private Thread gameThread;
    private Container contentPane;

    public Window(){
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        kl = new KeyListener();
        this.addKeyListener(kl);
        contentPane = this.getContentPane();

        gameWindow = new GameWindow(kl, this);
        gameThread = new Thread(gameWindow);
        this.add(gameWindow);

        menuWindow = new MenuWindow(this);
        this.add(menuWindow);

        this.setVisible(true);

    }

    public void changeState(int newState){
        switch (newState) {
            case Constants.MENU_STATE -> {
                gameWindow.stop();
                contentPane.remove(gameWindow);
                contentPane.add(menuWindow);
                menuWindow.repaint();

            }
            case Constants.GAME_STATE -> {
                contentPane.remove(menuWindow);
                gameThread = new Thread(gameWindow);
                contentPane.add(gameWindow);
                gameWindow.startGame();
                gameThread.start();
            }
            case Constants.EXIT_STATE -> {
                gameWindow.stop();
                System.exit(0);
            }
        }
        this.revalidate();
    }


}
