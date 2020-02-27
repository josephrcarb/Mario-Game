package com.example.assignment4;


//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class Goomba {
    boolean goombaState, movingLeft;
    private int x, y, width, height, time, count, amountCanMove;
    public Goomba(int X, int Y, int Width, int Height, int Count){
        x = X;
        y = Y;
        width = Width;
        height = Height;
        goombaState = true;
        time = 0;
        count = 0;
        amountCanMove = Count;

        movingLeft = true; //if false moving right
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void onCollision(){
        goombaState = false;
    }
    //Goomba move function
    public void update(){
        //Make the goomba move
        if (movingLeft){
            if(time%3==0) {
                count++;
                x += 5;
                if (count % amountCanMove == 0) {
                    movingLeft = false;
                    time = 0;
                }
            }
            time++;
        }
        if(!movingLeft){
            if(time%3==0) {
                count++;
                x -= 5;
                if (count % amountCanMove == 0) {
                    movingLeft = true;
                    time=0;
                }
            }
            time++;
        }

    }

}

