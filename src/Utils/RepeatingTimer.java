package Utils;

import Main.GameWindow;

import java.util.Timer;
import java.util.TimerTask;

public class RepeatingTimer extends TimerTask {

    private GameWindow gameWindow;
    private int delay;
    private int time;
    private Timer timer;

    public RepeatingTimer(GameWindow gameWindow, int delay, int time){
        this.gameWindow = gameWindow;
        this.delay = delay;
        this.time = time;
    }

    @Override
    public void run() {
        gameWindow.run();
    }

    public void cancelTimer(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }

    }

    public void startTimer(){
        if (timer == null){
            timer = new Timer();
            timer.scheduleAtFixedRate(this, delay, time);
        }
    }

    public Timer getTimer(){
        return timer;
    }
}
