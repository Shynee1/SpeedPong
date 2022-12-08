package Utils;

import java.awt.*;

public class Constants {
    public final static int SCREEN_HEIGHT = 800;
    public final static int SCREEN_WIDTH = 1000;
    public final static String SCREEN_TITLE = "Pong";

    public final static double PADDLE_WIDTH = 20;
    public final static double PADDLE_HEIGHT = 120;
    public final static double PADDLE_SPEED = 400;
    public final static Color PADDLE_COLOR = Color.white;

    public final static double BALL_SIZE = 20;
    public final static double BALL_SPEED = 1500;
    public final static double BALL_MAX_ANGLE = 45;
    public final static Color BALL_COLOR = Color.white;

    public final static double H_PADDING = 50;
    public final static double V_PADDING = 40;

    public static double INSETS_BOTTOM = 40;

    public final static double AI_BUFFER = 15;

    public final static int WIN_SCORE = 5;

    public final static int MENU_STATE = 0;
    public final static int GAME_STATE = 1;
    public final static int EXIT_STATE = -1;
}
