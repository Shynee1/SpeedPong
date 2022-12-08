package Controllers;

import Objects.Ball;
import Utils.Constants;

public class AIController {

    Ball ball;
    PlayerController playerController;

    public AIController(PlayerController c, Ball ball){
        this.playerController = c;
        this.ball = ball;
    }

    public void update(double dt){

        if (ball.y < playerController.rect.y+Constants.AI_BUFFER){
            playerController.moveDown(dt);
        } else if (ball.y + ball.size > playerController.rect.y + playerController.rect.height-Constants.AI_BUFFER){
            playerController.moveUp(dt);
        }
    }
}
