package com.example.assignment4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;
//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon

public class Mario {
    private Bitmap image;
    private int x, lives, floorY, y, count, time, jumpCount;
    private int srcX, srcY, score, invicibleTimer;
    private int height, width, spriteSize;
    boolean superForm;
    boolean invicible;
    boolean stopJumping = true;
    private boolean falling = false;
    boolean standing;
    boolean movingLeft;
    boolean movingRight;
    boolean jumping;
    private boolean canMarioJump;

//MAIN CLASS
    public Mario(Bitmap sprite){
        lives = 3;
        image = sprite;
        x = 850;
        floorY = 1085; //Default Floor level
        y = 885; //Default Spawn location level
        invicibleTimer = 500;
        srcX = 350;
        srcY = 0;
        spriteSize = 50;
        superForm = false;
        invicible = false;
        height = sprite.getHeight();
        width = sprite.getWidth();
        standing = true;
        movingLeft = false;
        movingRight = false;
        jumping = false;
        canMarioJump = true;
        score = 0;
    }
    //Checks if in Super Form
    public boolean isSuperForm(){
        return superForm;
    }
    //Checks if in Invincible Form
    public boolean isInvicible(){
        return invicible;
    }
    //Takes Mario off Super Form mode
    public void offSuper(){
        superForm = false;
    }
    //Add scores from background class
    public void addScore(int amount){
        score += amount;
    }
    //Get score so background class can draw
    public int getScore() {
        return score;
    }
    //Marios y position
    public int getY() {
        return y;
    }
    //gets Marios current lives
    public int getLives(){
        return lives;
    }
    //height
    public int getOneHeight() {
        return 90;
    }
    //width
    public int getOneWidth() {
        return 35;
    }
    //returns if Mario is allowed to jump, stops double jumping
    public boolean canJump(){ //Returns if Mario can jump, this is for no double jumping
        return canMarioJump;
    }
    //Main function that checks if mario hits head on block, breaks it, if feet hit block, that is the floor
    public void checkUpDown(int currentLevel, LevelOne lvlO, LevelTwo lvlTw, LevelThree lvlTh, Background background){ //Check if Mario is colliding with anything
        boolean onTopBlock = false;
        switch(currentLevel){
            case 0: //Level 1
                //Checks collision with Coins
                if(lvlO.getCoins() != null) {
                    for (int i = 0; i < lvlO.getCoins().length; i++) {//Cycles through all the coins
                        int elementX = lvlO.getCoin(i).getX();
                        int elementY = lvlO.getCoin(i).getY();
                        int elementH = lvlO.getCoin(i).getHeight();
                        int elementW = lvlO.getCoin(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 35) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 35) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlO.delCoin(elementX, elementY);
                                score += 200;
                            }
                        }
                    }
                }
                //Checks collision with stars
                if(lvlO.getStars() != null) {
                    for (int i = 0; i < lvlO.getStars().length; i++) {//Cycles through all the stars
                        int elementX = lvlO.getStar(i).getX();
                        int elementY = lvlO.getStar(i).getY();
                        int elementH = lvlO.getStar(i).getHeight();
                        int elementW = lvlO.getStar(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 35) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 35) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlO.delStar(elementX, elementY);
                                score += 1000;
                                invicible = true;
                                y -= 80;
                            }
                        }
                    }
                }
                //Checks collision with mushrooms
                if(lvlO.getMushrooms() != null) {
                    for (int i = 0; i < lvlO.getMushrooms().length; i++) {//Cycles through all the mushrooms
                        int elementX = lvlO.getMushroom(i).getX();
                        int elementY = lvlO.getMushroom(i).getY();
                        int elementH = lvlO.getMushroom(i).getHeight();
                        int elementW = lvlO.getMushroom(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 35) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 35) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlO.delMushroom(elementX, elementY);
                                score += 1000;
                                superForm = true;
                                y-=80;
                            }
                        }
                    }
                }
                //checks collision with brick blocks
                for(int i=0; i<lvlO.getBricks().length; i++){//Cycles through all the bricks
                    int elementX = lvlO.getBrick(i).getX();
                    int elementY = lvlO.getBrick(i).getY();
                    int elementH = lvlO.getBrick(i).getHeight();
                    int elementW = lvlO.getBrick(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+35 > elementX)&&(background.getSrcX()+35 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            if (lvlO.getBrick(i).brickState){
                                lvlO.addDeadBlock(elementX, elementY, elementW, elementH);
                                score+=10;
                            }
                            lvlO.getBrick(i).onCollision();
                            jumping = false;
                            jumpCount = 0;

                        }
                        //stands on bricks
                        if(y == elementY-100){
                            onTopBlock = true;
                            floorY = y;

                        }
                    }
                }
                //checks collision with ? blocks
                for(int i=0; i<lvlO.getBoxes().length; i++){//Cycles through all the boxes
                    int elementX = lvlO.getBox(i).getX();
                    int elementY = lvlO.getBox(i).getY();
                    int elementH = lvlO.getBox(i).getHeight();
                    int elementW = lvlO.getBox(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+35 > elementX)&&(background.getSrcX()+35 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break box
                            if (lvlO.getBox(i).boxState){
                                lvlO.addDeadBlock(elementX, elementY, elementW, elementH);
                                Random rand = new Random();
                                int n = rand.nextInt(100);
                                n++;//(1-100)
                                if(n<71) { //70%
                                    lvlO.addCoin(elementX, elementY - 80, 15, 40);
                                }
                                if(n>70 && n<86){ // 15%
                                    lvlO.addStar(elementX, elementY-80,15,40);
                                }
                                if(n>85){ // 15%
                                    lvlO.addMushroom(elementX, elementY-80,15,40);
                                }
                            }
                            lvlO.getBox(i).onCollision();
                            jumping = false;
                            jumpCount = 0;
                        }
                        if(y == elementY-100){
                            onTopBlock = true;
                            floorY = y;
                        }
                    }
                }
                //Checks collision with blocks
                for(int i=0; i<lvlO.getBlocks().length; i++){//Cycles through all the blocks
                    int elementX = lvlO.getBlock(i).getX();
                    int elementY = lvlO.getBlock(i).getY();
                    int elementH = lvlO.getBlock(i).getHeight();
                    int elementW = lvlO.getBlock(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+35 > elementX)&&(background.getSrcX()+35 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            jumping = false;
                            jumpCount = 0;
                        }
                        if(y == elementY-100){
                            onTopBlock = true;
                            floorY = y;
                        }
                    }
                }
                //checks collision with goombas
                if(lvlO.getGoombas() != null) {
                    for (int i = 0; i < lvlO.getGoombas().length; i++) {//Cycles through all the bricks
                        int elementX = lvlO.getGoomba(i).getX();
                        int elementY = lvlO.getGoomba(i).getY();
                        int elementH = lvlO.getGoomba(i).getHeight();
                        int elementW = lvlO.getGoomba(i).getWidth();
                        if (((background.getSrcX() > elementX) && (background.getSrcX() < elementX + elementW)) || ((background.getSrcX() + 35 > elementX) && (background.getSrcX() + 35 < elementX + elementW))){
                            if (y == elementY - 100) {
                                if (lvlO.getGoomba(i).goombaState) {
                                    lvlO.getGoomba(i).goombaState = false;
                                    score += 200;
                                }
                            }
                        }
                    }
                }
                if(!onTopBlock){
                    floorY = 1085;
                }
                break;
            case 1:
                //checks collision with brick blocks
                for(int i=0; i<lvlTw.getBlocks().length; i++){//Cycles through all the blocks
                    int elementX = lvlTw.getBlock(i).getX();
                    int elementY = lvlTw.getBlock(i).getY();
                    int elementH = lvlTw.getBlock(i).getHeight();
                    int elementW = lvlTw.getBlock(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+25 > elementX)&&(background.getSrcX()+25 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            jumping = false;
                            jumpCount = 0;
                        }
                        if(y == elementY-80){
                            onTopBlock = true;
                            floorY = y;
                        }
                    }
                }
                //checks collision with ? blocks
                for(int i=0; i<lvlTw.getBoxes().length; i++){//Cycles through all the boxes
                    int elementX = lvlTw.getBox(i).getX();
                    int elementY = lvlTw.getBox(i).getY();
                    int elementH = lvlTw.getBox(i).getHeight();
                    int elementW = lvlTw.getBox(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+25 > elementX)&&(background.getSrcX()+25 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            if (lvlTw.getBox(i).boxState){
                                lvlTw.addDeadBlock(elementX, elementY, elementW, elementH);
                                Random rand = new Random();
                                int n = rand.nextInt(100);
                                n++;//(1-100)
                                if(n<71) { //70%
                                    lvlTw.addCoin(elementX, elementY - 80, 15, 40);
                                }
                                if(n>70 && n<86){ // 15%
                                    lvlTw.addStar(elementX, elementY-80,15,40);
                                }
                                if(n>85){ // 15%
                                    lvlTw.addMushroom(elementX, elementY-80,15,40);
                                }
                            }
                            lvlTw.getBox(i).onCollision();
                            jumping = false;
                            jumpCount = 0;
                        }
                        if(y == elementY-80){
                            onTopBlock = true;
                            floorY = y;
                        }
                    }
                }
                //Checks collision with Coins
                if(lvlTw.getCoins() != null) {
                    for (int i = 0; i < lvlTw.getCoins().length; i++) {//Cycles through all the coins
                        int elementX = lvlTw.getCoin(i).getX();
                        int elementY = lvlTw.getCoin(i).getY();
                        int elementH = lvlTw.getCoin(i).getHeight();
                        int elementW = lvlTw.getCoin(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 25) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 25) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlTw.delCoin(elementX, elementY);
                                score += 200;
                            }
                        }
                    }
                }
                //Checks collision with stars
                if(lvlTw.getStars() != null) {
                    for (int i = 0; i < lvlTw.getStars().length; i++) {//Cycles through all the stars
                        int elementX = lvlTw.getStar(i).getX();
                        int elementY = lvlTw.getStar(i).getY();
                        int elementH = lvlTw.getStar(i).getHeight();
                        int elementW = lvlTw.getStar(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 25) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 25) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlTw.delStar(elementX, elementY);
                                score += 1000;
                                invicible = true;
                                y -= 80;
                            }
                        }
                    }
                }
                //Checks collision with mushrooms
                if(lvlTw.getMushrooms() != null) {
                    for (int i = 0; i < lvlTw.getMushrooms().length; i++) {//Cycles through all the mushrooms
                        int elementX = lvlTw.getMushroom(i).getX();
                        int elementY = lvlTw.getMushroom(i).getY();
                        int elementH = lvlTw.getMushroom(i).getHeight();
                        int elementW = lvlTw.getMushroom(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 25) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 25) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlTw.delMushroom(elementX, elementY);
                                score += 1000;
                                superForm = true;
                                y-=80;
                            }
                        }
                    }
                }
                if(!onTopBlock){
                    floorY = 1085;
                }
                break;
            case 2:
                //Checks collision with Coins
                if(lvlTh.getCoins() != null) {
                    for (int i = 0; i < lvlTh.getCoins().length; i++) {//Cycles through all the coins
                        int elementX = lvlTh.getCoin(i).getX();
                        int elementY = lvlTh.getCoin(i).getY();
                        int elementH = lvlTh.getCoin(i).getHeight();
                        int elementW = lvlTh.getCoin(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 35) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 35) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlTh.delCoin(elementX, elementY);
                                score += 200;
                            }
                        }
                    }
                }
                //Checks collision with stars
                if(lvlTh.getStars() != null) {
                    for (int i = 0; i < lvlTh.getStars().length; i++) {//Cycles through all the stars
                        int elementX = lvlTh.getStar(i).getX();
                        int elementY = lvlTh.getStar(i).getY();
                        int elementH = lvlTh.getStar(i).getHeight();
                        int elementW = lvlTh.getStar(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 35) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 35) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlTh.delStar(elementX, elementY);
                                score += 1000;
                                invicible = true;
                                y -= 80;
                            }
                        }
                    }
                }
                //Checks collision with mushrooms
                if(lvlTh.getMushrooms() != null) {
                    for (int i = 0; i < lvlTh.getMushrooms().length; i++) {//Cycles through all the mushrooms
                        int elementX = lvlTh.getMushroom(i).getX();
                        int elementY = lvlTh.getMushroom(i).getY();
                        int elementH = lvlTh.getMushroom(i).getHeight();
                        int elementW = lvlTh.getMushroom(i).getWidth();
                        if ((elementX >= background.getSrcX()) && (elementX <= background.getSrcX() + 35) && (elementY >= y) && (elementY <= y + 80)) {
                            if ((elementX + elementW >= background.getSrcX()) && (elementX + elementW <= background.getSrcX() + 35) && (elementY + elementH >= y) && (elementY + elementH <= y + 80)) {
                                lvlTh.delMushroom(elementX, elementY);
                                score += 1000;
                                superForm = true;
                                y-=80;
                            }
                        }
                    }
                }
                //checks collision with blocks
                for(int i=0; i<lvlTh.getBlocks().length; i++){//Cycles through all the blocks
                    int elementX = lvlTh.getBlock(i).getX();
                    int elementY = lvlTh.getBlock(i).getY();
                    int elementH = lvlTh.getBlock(i).getHeight();
                    int elementW = lvlTh.getBlock(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+35 > elementX)&&(background.getSrcX()+35 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            jumping = false;
                            jumpCount = 0;
                        }
                        if(y == elementY-100){
                            onTopBlock = true;
                            floorY = y;
                        }
                    }
                }
                //checks collision with brick blocks
                for(int i=0; i<lvlTh.getBricks().length; i++){//Cycles through all the bricks
                    int elementX = lvlTh.getBrick(i).getX();
                    int elementY = lvlTh.getBrick(i).getY();
                    int elementH = lvlTh.getBrick(i).getHeight();
                    int elementW = lvlTh.getBrick(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+35 > elementX)&&(background.getSrcX()+35 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            if (lvlTh.getBrick(i).brickState){
                                lvlTh.addDeadBlock(elementX, elementY, elementW, elementH);
                                score+=10;
                            }
                            lvlTh.getBrick(i).onCollision();
                            jumping = false;
                            jumpCount = 0;

                        }
                        if(y == elementY-100){
                            onTopBlock = true;
                            floorY = y;

                        }
                    }
                }
                //checks collision with box
                for(int i=0; i<lvlTh.getBoxes().length; i++){//Cycles through all the boxes
                    int elementX = lvlTh.getBox(i).getX();
                    int elementY = lvlTh.getBox(i).getY();
                    int elementH = lvlTh.getBox(i).getHeight();
                    int elementW = lvlTh.getBox(i).getWidth();
                    if(((background.getSrcX() > elementX)&&(background.getSrcX() < elementX+elementW))||((background.getSrcX()+35 > elementX)&&(background.getSrcX()+35 < elementX+elementW))){
                        if(y == elementY + elementH){
                            //Break bricks
                            if (lvlTh.getBox(i).boxState){
                                lvlTh.addDeadBlock(elementX, elementY, elementW, elementH);
                                Random rand = new Random();
                                int n = rand.nextInt(100);
                                n++;//(1-100)
                                if(n<71) { //70%
                                    lvlTh.addCoin(elementX, elementY - 80, 15, 40);
                                }
                                if(n>70 && n<86){ // 15%
                                    lvlTh.addStar(elementX, elementY-80,15,40);
                                }
                                if(n>85){ // 15%
                                    lvlTh.addMushroom(elementX, elementY-80,15,40);
                                }
                            }
                            lvlTh.getBox(i).onCollision();
                            jumping = false;
                            jumpCount = 0;
                        }
                        if(y == elementY-100){
                            onTopBlock = true;
                            floorY = y;
                        }
                    }
                }
                //checks collision with goombas
                if(lvlTh.getGoombas() != null) {
                    for (int i = 0; i < lvlTh.getGoombas().length; i++) {//Cycles through all the bricks
                        int elementX = lvlTh.getGoomba(i).getX();
                        int elementY = lvlTh.getGoomba(i).getY();
                        int elementH = lvlTh.getGoomba(i).getHeight();
                        int elementW = lvlTh.getGoomba(i).getWidth();
                        if (((background.getSrcX() > elementX) && (background.getSrcX() < elementX + elementW)) || ((background.getSrcX() + 35 > elementX) && (background.getSrcX() + 35 < elementX + elementW))) {

                            if (y == elementY - 100) {
                                if (lvlTh.getGoomba(i).goombaState) {
                                    lvlTh.getGoomba(i).goombaState = false;
                                    score += 200;
                                }

                            }
                        }
                    }
                }
                //checks collision with plants
                if(lvlTh.getPlants() != null) {
                    for (int i = 0; i < lvlTh.getPlants().length; i++) {//Cycles through all the bricks
                        int elementX = lvlTh.getPlant(i).getX();
                        int elementY = lvlTh.getPlant(i).getY();
                        int elementH = lvlTh.getPlant(i).getHeight();
                        int elementW = lvlTh.getPlant(i).getWidth();
                        if (((background.getSrcX() > elementX) && (background.getSrcX() < elementX + elementW)) || ((background.getSrcX() + 35 > elementX) && (background.getSrcX() + 35 < elementX + elementW))){
                            if (y == elementY - 100) {
                                lives--;
                                background.deathOccurred();
                            }
                        }
                    }
                }
                if(!onTopBlock){
                    floorY = 1085;
                }
                break;
            case 3:
                floorY = 885;
                break;
        }
    }
    //Kill mario
    public void died(){
        lives--;
        y = 885;
    }
    //Checks if he fell under the map
    public boolean checkDeath(){
        if(y >= 1085){
            if(!superForm && !invicible){
                lives--;

            }
            superForm = false;
            y = 885;
            return true;
        }
        return false;
    }
    //decrease y coord to the floor value after jump
    public void gravity(){
        if (y < floorY){
            canMarioJump = false;
            falling = true;
            y += 20;
            if(y >= floorY){
                standing = true;
                y = floorY;
                falling= false;
            }
        }
        else{
            canMarioJump = true;
           falling = false;
        }
    }
    //Draws mario and some HUD
    public void draw(Canvas canvas){
        Rect src = new Rect(srcX,srcY, srcX + width/14,srcY + spriteSize);
        Rect srcLives = new Rect(350, 0,  350 + width/14, spriteSize);
        Rect dst = new Rect(x,y, x + 3*(width/14)  , y + 3*(height/6)  );
        int livesX = 1400;
        for(int i = 0;i<lives;i++){
            Rect dstLives = new Rect(livesX,50, livesX + 3*(width/14)  , 50 + 3*(height/6)  );
            livesX += 100;
            canvas.drawBitmap(image, srcLives, dstLives, null);
        }
        Paint paint = new Paint(Color.BLACK);
        canvas.drawBitmap(image, src, dst, null);
        Rect JUMP = new Rect(1450, 150, 1735,200);
        canvas.drawRect(JUMP, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        canvas.drawText("LIVES",1550,190, paint);
        Rect SCORE = new Rect(100, 150, 385,200);
        paint.setColor(Color.BLACK);
        canvas.drawRect(SCORE, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        canvas.drawText("SCORE",180,190, paint);
        Rect SCOREboard = new Rect(100, 50, 385,140);
        paint.setColor(Color.BLACK);
        canvas.drawRect(SCOREboard, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        String scoreText = Integer.toString(score);
        canvas.drawText(scoreText,180,120, paint);
        if(invicible){
            Rect INVb = new Rect(800, 150, 1125,200);
            paint.setColor(Color.BLACK);
            canvas.drawRect(INVb, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(40);
            canvas.drawText("INVINCIBLE!!",850,190, paint);
            Rect INVcounter = new Rect(900, 200, 1025,250);
            paint.setColor(Color.BLACK);
            canvas.drawRect(INVcounter, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(40);
            String invCountText = Integer.toString(invicibleTimer);
            canvas.drawText(invCountText,930,240, paint);
        }
        else if(superForm){
            Rect supb = new Rect(800, 150, 1125,200);
            paint.setColor(Color.BLACK);
            canvas.drawRect(supb, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(40);
            canvas.drawText("SUPER!!!!!!!!!!!!!",850,190, paint);
        }
    }
    //Mario animation
    public void update(){
        if(invicible){
            if(invicibleTimer == 0){
                invicibleTimer = 500;
                invicible = false;
            }
            invicibleTimer--;
        }
        int frame;
        if(falling){
            srcX = 610;
        }
        if(standing){
            srcX = 350;
            count = 0;
            time = 0;
            jumpCount =0;
        }
        if(jumping){
            srcX = 610; // Frame image
            canMarioJump = false;
            y -= 40;
            jumpCount++;
            if(jumpCount == 20){
                jumping=false;
                jumpCount=0;
            }
        }
        if(movingLeft){
            if (time % 5 == 0) {
                count++;
                frame = count % 5;
                srcX = 300 - (frame * 50);
            }
            time++;
        }
        if(movingRight){
            if (time % 5 == 0) {
                count++;
                frame = count % 5;
                srcX = 360 + (frame * 50);
            }
            time++;
        }
    }
}
