package Main;

import Controllers.AIController;
import Controllers.BallController;
import Controllers.PlayerController;
import Objects.Ball;
import Objects.Rect;
import Utils.Constants;
import Utils.KeyListener;
import Utils.Text;
import Utils.Time;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel implements Runnable{
    private final KeyListener keyListener;
    private final Window window;
    private Rect player, ai;
    private Ball ball;
    private PlayerController playerController;
    private AIController aiController;
    private BallController ballController;
    private Text leftScoreText, rightScoreText;

    private boolean isRunning = false;

    public GameWindow(KeyListener kl, Window window){
        this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        this.keyListener = kl;
        this.window = window;
    }

    public void update(double dt){
        aiController.update(dt);
        playerController.update(dt);
        ballController.update(dt);
        repaint();
    }

    public void stop(){
        isRunning=false;
    }

    public void run() {
        double lastFrameTime = 0.0;

        while (isRunning) {
            double time = Time.getElapsedTime();
            //Calculate delta time (time between frames)
            double dt = time - lastFrameTime;
            update(dt);

            lastFrameTime = time;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        leftScoreText.draw(g2d);
        rightScoreText.draw(g2d);

        player.draw(g2d);
        ai.draw(g2d);
        ball.draw(g2d);
    }

    public void startGame(){

        leftScoreText = new Text("0", new Font("Impact", Font.PLAIN, 150), Color.decode("#292928"), 10, 135);
        rightScoreText = new Text("0", new Font("Impact", Font.PLAIN, 150), Color.decode("#292928"), Constants.SCREEN_WIDTH-10-100, 135);

        player = new Rect(Constants.H_PADDING, Constants.V_PADDING, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerController = new PlayerController(player, keyListener);
        ai = new Rect(Constants.SCREEN_WIDTH-Constants.PADDLE_WIDTH-Constants.H_PADDING, Constants.V_PADDING, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ball = new Ball(Constants.SCREEN_WIDTH/2.0, Constants.SCREEN_HEIGHT/2.0, Constants.BALL_SIZE, Constants.BALL_COLOR);
        ballController = new BallController(player, ai, ball, leftScoreText, rightScoreText, window);
        aiController = new AIController(new PlayerController(ai), ball);
        isRunning = true;

        this.setVisible(true);
    }

}
