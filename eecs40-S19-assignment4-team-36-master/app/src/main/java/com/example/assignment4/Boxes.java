package com.example.assignment4;
//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class Boxes {
    boolean boxState;
    private int x, y, width, height;
    public Boxes(int X, int Y, int Width, int Height){
        x = X;
        y = Y;
        width = Width;
        height = Height;
        boxState = true;
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
        boxState = false;
    }
}
