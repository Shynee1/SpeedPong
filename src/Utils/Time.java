package Utils;

public class Time {
    public static double timeStarted = System.nanoTime();

    public static double getElapsedTime(){return (System.nanoTime() - timeStarted) * 1E-9;}
}
