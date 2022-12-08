package Controllers;

import Main.Window;
import Objects.Ball;
import Objects.Rect;
import Utils.Constants;
import Utils.Text;

import java.util.Random;

public class BallController {

    private Rect player, ai;
    private Ball ball;
    private double velocityX = 300;
    private double velocityY = -20;
    Text leftScore, rightScore;
    Window window;
    Random random;

    public BallController(Rect player, Rect ai, Ball ball, Text leftScore, Text rightScore, Window window){
        this.player = player;
        this.ai = ai;
        this.ball = ball;
        this.leftScore = leftScore;
        this.rightScore = rightScore;
        this.window = window;
        random = new Random();
    }

    public void update(double dt){
       checkPaddleCollision();

       if (screenCollision()){
           velocityY *= -1;
       }

        //position = position + velocity
        //velocity = velocity + acceleration
        ball.x += velocityX*dt;
        ball.y += velocityY*dt;
    }

    public void checkPaddleCollision(){
        if (velocityX < 0){ //moving left
            if ((ball.x <= player.x+player.width && ball.x+ball.size >= player.x) && (ball.y >= player.y && ball.y <= player.y+player.height)){
                setVelocity(player);
            } else if (ball.x+ball.size<player.x){
                rightScore.text = String.valueOf(Integer.parseInt(rightScore.text)+1);
                reset();
            }
        } else if (velocityX > 0){ //moving right
            if ((ball.x+ball.size >= ai.x && ball.x <= ai.x+ai.width) && (ball.y >= ai.y && ball.y <= ai.y+ai.height)){
                setVelocity(ai);
            } else if (ball.x + ball.size > ai.x+ai.width){
                leftScore.text = String.valueOf(Integer.parseInt(leftScore.text)+1);
                reset();
            }
        }
    }

    public boolean screenCollision(){
        if (velocityY > 0){ //moving down
            return ball.y + ball.size > Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM;
        } else if (velocityY < 0){ //moving up
            return ball.y < 0;
        }
        return false;
    }

    //Calculate the angle the ball should be bouncing at relative to its intersection point on the paddle
    public double calculateNewAngle(Rect paddle){
        //Find ball intersection
        double relativeIntersectY = (paddle.y + (paddle.height/2.0) - (ball.y + (ball.size/2.0)));
        //Normalize value to a range of {1, -1}
        double normalIntersectY = relativeIntersectY / (paddle.height/2.0);
        //Find and return bounce angle
        return Math.toRadians(normalIntersectY * Constants.BALL_MAX_ANGLE);
    }

    //Use trigonometry to get new velocities from the angle
    public void setVelocity(Rect paddle){
        //Calculate angle
        double angle = calculateNewAngle(paddle);
        //Use trigonometry to get new velocity
        double newVX = Math.abs(Math.cos(angle) * Constants.BALL_SPEED);
        double newVY = (-Math.sin(angle)) * Constants.BALL_SPEED;
        //Use sign (?) to do some math shit idk it works
        double oldSign = Math.signum(velocityX);
        velocityX = newVX * (-1.0 * oldSign);
        velocityY = newVY;
    }

    public void reset(){
        if (Integer.parseInt(rightScore.text) == Constants.WIN_SCORE || Integer.parseInt(leftScore.text) == Constants.WIN_SCORE){
            window.changeState(Constants.MENU_STATE);
            return;
        }

        ball.x = (float) Constants.SCREEN_WIDTH/2;
        ball.y = (float) Constants.SCREEN_HEIGHT/2;
        velocityX = 300;
        velocityY = 20 * randomNegative();
    }

    public Integer randomNegative(){
        int number = random.nextInt(2);
        if (number == 0){
            return 1;
        } else {
            return -1;
        }
    }
}
