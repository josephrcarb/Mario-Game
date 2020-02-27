package com.example.assignment4;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class mainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView game;
    private boolean running;
    public static Canvas canvas;

    public  mainThread(SurfaceHolder surfaceHolder, GameView game) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.game = game;

    }
    @Override
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder) {
                    //MAIN GAME LOOP
                    this.game.update();
                    this.game.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

}
