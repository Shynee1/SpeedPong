package Utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private boolean[] keysPressed = new boolean[128];

    @Override
    public void keyPressed(KeyEvent e){
        keysPressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e){
        keysPressed[e.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int keyCode){
        return keysPressed[keyCode];
    }
}
