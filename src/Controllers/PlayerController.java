package Controllers;

import Objects.Rect;
import Utils.Constants;
import Utils.KeyListener;

import java.awt.event.KeyEvent;

public class PlayerController {

    public Rect rect;
    public KeyListener keyListener = null;

    public PlayerController(Rect rect, KeyListener keyListener){
        this.rect = rect;
        this.keyListener = keyListener;
    }

    public PlayerController(Rect rect){
        this.rect = rect;
    }

    public void update(double dt){
        if (keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN) || keyListener.isKeyPressed(KeyEvent.VK_S)) {
                moveUp(dt);
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP) || keyListener.isKeyPressed(KeyEvent.VK_W)) {
                moveDown(dt);
            }
        }

    }

    public void moveUp(double dt){
        double newY = rect.y + Constants.PADDLE_SPEED * dt;
        if ((newY > 0) && (newY+ Constants.PADDLE_HEIGHT < Constants.SCREEN_HEIGHT- Constants.INSETS_BOTTOM)){
            rect.y = newY;
        }
    }

    public void moveDown(double dt){
        double newY = rect.y - Constants.PADDLE_SPEED * dt;
        if ((newY > 0) && (newY+ Constants.PADDLE_HEIGHT < Constants.SCREEN_HEIGHT- Constants.INSETS_BOTTOM)){
            rect.y = newY;
        }
    }


}
