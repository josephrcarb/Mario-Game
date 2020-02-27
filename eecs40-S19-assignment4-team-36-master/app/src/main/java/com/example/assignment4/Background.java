package com.example.assignment4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class Background {
    private Bitmap[] image;
    private Bitmap deadBlockIMAGE, coinIMAGE, enemiesIMAGE, mushroomIMAGE, starIMAGE, plantIMAGE;
    private int x, y, xSpeed, currentLevel;
    private boolean canMoveRight = true, canMoveLeft = true;
    int srcX, srcGx;
    public Background(Bitmap[] sprite, Bitmap blockSprite, Bitmap coinSprite, Bitmap enemiesSprite, Bitmap mushroomSprite, Bitmap starSprite, Bitmap plantSprite){
        image = sprite;
        plantIMAGE = plantSprite;
        deadBlockIMAGE = blockSprite;
        enemiesIMAGE = enemiesSprite;
        mushroomIMAGE = mushroomSprite;
        starIMAGE = starSprite;
        coinIMAGE = coinSprite;
        x = 0;
        xSpeed = 5;
        y = 0;
        srcX = 0;
        srcGx = 0;
        currentLevel = 0;
    }
    public void setCurrentLevel(int i){
        currentLevel = i;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }
    public void deathOccurred(){
        srcX = 0;
    }
    //Mario's X
    public int getSrcX(){
        return srcX;
    }
    //Draw function that draws everything except Mario and some HUD items
    public void draw(Canvas canvas, LevelOne lvlo, LevelTwo lvlt, LevelThree lvlth, Mario mario){
        //FIX DRAWING OF LEVELS
        Paint paint = new Paint(Color.BLACK);
        Rect srcB = new Rect(0, 0, deadBlockIMAGE.getWidth(), deadBlockIMAGE.getHeight());
        Rect srcG = new Rect(srcGx, 0, srcGx+40, 100);
        Rect srcP = new Rect(0,0,plantIMAGE.getWidth(),plantIMAGE.getHeight());
        Rect srcC = new Rect(50, 50, coinIMAGE.getWidth()-50, coinIMAGE.getHeight()-50);
        Rect srcS = new Rect(0, 0, starIMAGE.getWidth(), starIMAGE.getHeight());
        Rect srcM = new Rect(0, 0, mushroomIMAGE.getWidth(), mushroomIMAGE.getHeight());
        switch(currentLevel){
            case 0:
                Rect src0 = new Rect(srcX, 0, srcX + 900, 580);
                Rect dst0 = new Rect(x, y, x + 1920, y + 1080);
                canvas.drawBitmap(image[currentLevel], src0, dst0, null);
                if(lvlo.getDeadBlocks() != null) {
                    for (int i = 0; i < lvlo.getDeadBlocks().length; i++) {
                        double dstBxf = 2.13*lvlo.getDeadBlock(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlo.getDeadBlock(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 80, dstBy+80);
                        canvas.drawBitmap(deadBlockIMAGE , srcB, dstB, null);
                    }
                }
                if(lvlo.getCoins() != null) {
                    for (int i = 0; i < lvlo.getCoins().length; i++) {
                        double dstBxf = 2.13*lvlo.getCoin(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlo.getCoin(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(coinIMAGE , srcC, dstB, null);
                    }
                }
                if(lvlo.getStars() != null) {
                    for (int i = 0; i < lvlo.getStars().length; i++) {
                        double dstBxf = 2.13*lvlo.getStar(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlo.getStar(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(starIMAGE , srcS, dstB, null);
                    }
                }
                if(lvlo.getMushrooms() != null) {
                    for (int i = 0; i < lvlo.getMushrooms().length; i++) {
                        double dstBxf = 2.13*lvlo.getMushroom(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlo.getMushroom(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(mushroomIMAGE , srcM, dstB, null);
                    }
                }
                if(lvlo.getGoombas() != null){
                    for (int i = 0; i < lvlo.getGoombas().length; i++) {
                        if(lvlo.getGoomba(i).goombaState) {
                            double dstBxf = 2.13 * lvlo.getGoomba(i).getX() - 2.13 * srcX;
                            int destBx = Math.round((float) dstBxf) + 915;
                            int dstBy = lvlo.getGoomba(i).getY();
                            Rect dstB = new Rect(destBx, dstBy, destBx + 80, dstBy + 110);
                            canvas.drawBitmap(enemiesIMAGE, srcG, dstB, null);
                        }
                    }
                }
                break;

            case 1:
                Rect src1 = new Rect(srcX, 0, srcX + 700, 390);
                Rect dst1 = new Rect(x, y, x + 1920, y + 1080);
                canvas.drawBitmap(image[currentLevel], src1, dst1, null);
                if(lvlt.getDeadBlocks() != null) {
                    for (int i = 0; i < lvlt.getDeadBlocks().length; i++) {
                        double dstBxf = 2.74*lvlt.getDeadBlock(i).getX() - 2.74*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlt.getDeadBlock(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 80, dstBy+80);
                        canvas.drawBitmap(deadBlockIMAGE , srcB, dstB, null);

                    }
                }
                if(lvlt.getStars() != null) {
                    for (int i = 0; i < lvlt.getStars().length; i++) {
                        double dstBxf = 2.74*lvlt.getStar(i).getX() - 2.74*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlt.getStar(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(starIMAGE , srcS, dstB, null);
                    }
                }
                if(lvlt.getCoins() != null) {
                    for (int i = 0; i < lvlt.getCoins().length; i++) {
                        double dstBxf = 2.74*lvlt.getCoin(i).getX() - 2.74*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlt.getCoin(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(coinIMAGE , srcC, dstB, null);
                    }
                }
                if(lvlt.getMushrooms() != null) {
                    for (int i = 0; i < lvlt.getMushrooms().length; i++) {
                        double dstBxf = 2.74*lvlt.getMushroom(i).getX() - 2.74*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlt.getMushroom(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(mushroomIMAGE , srcM, dstB, null);
                    }
                }
                break;
            case 2:
                Rect src2 = new Rect(srcX, 0, srcX + 900, 395);
                Rect dst2 = new Rect(x, y, x + 1920, y + 1080);
                canvas.drawBitmap(image[currentLevel], src2, dst2, null);
                if(lvlth.getDeadBlocks() != null) {
                    for (int i = 0; i < lvlth.getDeadBlocks().length; i++) {
                        double dstBxf = 2.13*lvlth.getDeadBlock(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlth.getDeadBlock(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 80, dstBy+80);
                        canvas.drawBitmap(deadBlockIMAGE , srcB, dstB, null);

                    }
                }
                if(lvlth.getStars() != null) {
                    for (int i = 0; i < lvlth.getStars().length; i++) {
                        double dstBxf = 2.13*lvlth.getStar(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlth.getStar(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(starIMAGE , srcS, dstB, null);
                    }
                }
                if(lvlth.getCoins() != null) {
                    for (int i = 0; i < lvlth.getCoins().length; i++) {
                        double dstBxf = 2.13*lvlth.getCoin(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlth.getCoin(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(coinIMAGE , srcC, dstB, null);
                    }
                }
                if(lvlth.getMushrooms() != null) {
                    for (int i = 0; i < lvlth.getMushrooms().length; i++) {
                        double dstBxf = 2.13*lvlth.getMushroom(i).getX() - 2.13*srcX;
                        int destBx = Math.round((float)dstBxf) + 915;
                        int dstBy = lvlth.getMushroom(i).getY();
                        Rect dstB = new Rect(destBx, dstBy, destBx + 50, dstBy+50);
                        canvas.drawBitmap(mushroomIMAGE , srcM, dstB, null);
                    }
                }
                if(lvlth.getGoombas() != null){
                    for (int i = 0; i < lvlth.getGoombas().length; i++) {
                        if(lvlth.getGoomba(i).goombaState) {
                            double dstBxf = 2.13 * lvlth.getGoomba(i).getX() - 2.13 * srcX;
                            int destBx = Math.round((float) dstBxf) + 915;
                            int dstBy = lvlth.getGoomba(i).getY();
                            Rect dstB = new Rect(destBx, dstBy, destBx + 80, dstBy + 110);
                            canvas.drawBitmap(enemiesIMAGE, srcG, dstB, null);
                        }
                    }
                }
                if(lvlth.getPlants() != null){
                    for (int i = 0; i < lvlth.getPlants().length; i++) {
                        if(lvlth.getPlant(i).plantState) {
                            double dstBxf = 2.13 * lvlth.getPlant(i).getX() - 2.13 * srcX;
                            int destBx = Math.round((float) dstBxf) + 915;
                            int dstBy = lvlth.getPlant(i).getY();
                            Rect dstB = new Rect(destBx, dstBy, destBx + 80, dstBy + 100);
                            canvas.drawBitmap(plantIMAGE, srcP, dstB, null);
                        }
                    }
                }
                break;
            case 3:
                //Draw end screen
                Rect GAMEOVER = new Rect(0, 0, 1920,1080);
                paint.setColor(Color.BLACK);
                canvas.drawRect(GAMEOVER, paint);
                paint.setColor(Color.WHITE);
                paint.setTextSize(40);
                canvas.drawText("SCORE",180,190, paint);
                paint.setColor(Color.WHITE);
                paint.setTextSize(40);
                String scoreText = Integer.toString(mario.getScore());
                canvas.drawText(scoreText,180,120, paint);
                paint.setTextSize(130);
                canvas.drawText("RESTART", 80, 1000, paint);
                canvas.drawText("GAME OVER", 600, 500, paint);
                break;
        }
        //Jump button
        if(currentLevel != 3) {
            Rect JUMP = new Rect(50, 850, 450, 1050);
            canvas.drawRect(JUMP, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(130);
            canvas.drawText("JUMP", 80, 1000, paint);
        }
    }
    //One of main functions which checks if mario can go side to side, detects if walks into enemy or powerup
    public void checkSidetoSide(int currentLevel, LevelOne lvlO, LevelTwo lvlTw, LevelThree lvlTh, Mario mario){ //Check if Mario is colliding with anything
        canMoveRight = true;
        canMoveLeft = true;
        switch(currentLevel){
            case 0:
                for(int i=0; i<lvlO.getBricks().length; i++){//Cycles through all the bricks
                    int elementX = lvlO.getBrick(i).getX();
                    int elementY = lvlO.getBrick(i).getY();
                    int elementH = lvlO.getBrick(i).getHeight();
                    int elementW = lvlO.getBrick(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+mario.getOneHeight()>=elementY)&&(mario.getY()+mario.getOneHeight()<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                           canMoveRight = false;
                        }
                        if(srcX == elementX + elementW + 5){
                            canMoveLeft = false;
                        }
                    }
                }
                for(int i=0; i<lvlO.getBoxes().length; i++){//Cycles through all the boxes
                    int elementX = lvlO.getBox(i).getX();
                    int elementY = lvlO.getBox(i).getY();
                    int elementH = lvlO.getBox(i).getHeight();
                    int elementW = lvlO.getBox(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+80>=elementY)&&(mario.getY()+80<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW){
                            canMoveLeft = false;
                        }
                    }
                }
                for(int i=0; i<lvlO.getBlocks().length; i++){//Cycles through all the blocks
                    int elementX = lvlO.getBlock(i).getX();
                    int elementY = lvlO.getBlock(i).getY();
                    int elementH = lvlO.getBlock(i).getHeight();
                    int elementW = lvlO.getBlock(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+mario.getOneHeight()>=elementY)&&(mario.getY()+mario.getOneHeight()<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW){
                            canMoveLeft = false;
                        }
                    }
                }
                for(int i=0; i<lvlO.getGoombas().length; i++){//Cycles through all the goombas
                    int elementX = lvlO.getGoomba(i).getX();
                    int elementY = lvlO.getGoomba(i).getY();
                    int elementH = lvlO.getGoomba(i).getHeight();
                    int elementW = lvlO.getGoomba(i).getWidth();
                    boolean elementS = lvlO.getGoomba(i).goombaState;
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+mario.getOneHeight()>=elementY)&&(mario.getY()+mario.getOneHeight()<=elementY+elementH))){
                        if(elementS){
                            if(srcX == elementX - mario.getOneWidth()){ //Collides with Goomba from the Side
                                if(!mario.isSuperForm() && !mario.isInvicible()){//Dies on Impact
                                    //he deaded
                                    srcX = 0;
                                    mario.died();
                                }
                                if(mario.isSuperForm()&&!mario.isInvicible()){ //Kills the Goomba but loses SUPER FORM
                                    lvlO.getGoomba(i).goombaState = false;
                                    mario.addScore(100);
                                    mario.offSuper();
                                }
                                if(mario.isInvicible()){ //Kills Goomba but keeps inviciblity
                                    lvlO.getGoomba(i).goombaState = false;
                                    mario.addScore(100);
                                }
                            }
                            if(srcX == elementX + elementW){
                                if(!mario.isSuperForm() && !mario.isInvicible()){ // Dies on Impact
                                    //he deaded
                                    srcX = 0;
                                    mario.died();
                                }
                                if(mario.isSuperForm()&&!mario.isInvicible()){ //Kills the Goomba but loses SUPER FORM
                                    lvlO.getGoomba(i).goombaState = false;
                                    mario.addScore(100);
                                    mario.offSuper();
                                }
                                if(mario.isInvicible()){ //Kills Goomba but keeps inviciblity
                                    lvlO.getGoomba(i).goombaState = false;
                                    mario.addScore(100);
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i=0; i<lvlTw.getBlocks().length; i++){//Cycles through all the blocks
                    int elementX = lvlTw.getBlock(i).getX();
                    int elementY = lvlTw.getBlock(i).getY();
                    int elementH = lvlTw.getBlock(i).getHeight();
                    int elementW = lvlTw.getBlock(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+80>=elementY)&&(mario.getY()+80<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW){
                            canMoveLeft = false;
                        }
                    }
                }
                for(int i=0; i<lvlTw.getBoxes().length; i++){//Cycles through all the boxes
                    int elementX = lvlTw.getBox(i).getX();
                    int elementY = lvlTw.getBox(i).getY();
                    int elementH = lvlTw.getBox(i).getHeight();
                    int elementW = lvlTw.getBox(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+mario.getOneHeight()>=elementY)&&(mario.getY()+mario.getOneHeight()<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW){
                            canMoveLeft = false;
                        }
                    }
                }
                break;
            case 2:
                for(int i=0; i<lvlTh.getBricks().length; i++){//Cycles through all the bricks
                    int elementX = lvlTh.getBrick(i).getX();
                    int elementY = lvlTh.getBrick(i).getY();
                    int elementH = lvlTh.getBrick(i).getHeight();
                    int elementW = lvlTh.getBrick(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+mario.getOneHeight()>=elementY)&&(mario.getY()+mario.getOneHeight()<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW + 5){
                            canMoveLeft = false;
                        }
                    }
                }
                for(int i=0; i<lvlTh.getBlocks().length; i++){//Cycles through all the blocks
                    int elementX = lvlTh.getBlock(i).getX();
                    int elementY = lvlTh.getBlock(i).getY();
                    int elementH = lvlTh.getBlock(i).getHeight();
                    int elementW = lvlTh.getBlock(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+80>=elementY)&&(mario.getY()+80<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW){
                            canMoveLeft = false;
                        }
                    }
                }
                for(int i=0; i<lvlTh.getBoxes().length; i++){//Cycles through all the boxes
                    int elementX = lvlTh.getBox(i).getX();
                    int elementY = lvlTh.getBox(i).getY();
                    int elementH = lvlTh.getBox(i).getHeight();
                    int elementW = lvlTh.getBox(i).getWidth();
                    if(((mario.getY()>=elementY)&&(mario.getY()<=elementY+elementH))||((mario.getY()+80>=elementY)&&(mario.getY()+80<=elementY+elementH))){
                        if(srcX == elementX - mario.getOneWidth()){
                            canMoveRight = false;
                        }
                        if(srcX == elementX + elementW){
                            canMoveLeft = false;
                        }
                    }
                }
                if(lvlTh.getGoombas() != null) {
                    for (int i = 0; i < lvlTh.getGoombas().length; i++) {//Cycles through all the goombas
                        int elementX = lvlTh.getGoomba(i).getX();
                        int elementY = lvlTh.getGoomba(i).getY();
                        int elementH = lvlTh.getGoomba(i).getHeight();
                        int elementW = lvlTh.getGoomba(i).getWidth();
                        boolean elementS = lvlTh.getGoomba(i).goombaState;
                        if (((mario.getY() >= elementY) && (mario.getY() <= elementY + elementH)) || ((mario.getY() + mario.getOneHeight() >= elementY) && (mario.getY() + mario.getOneHeight() <= elementY + elementH))) {
                            if (elementS) {
                                if (srcX == elementX - mario.getOneWidth()) { //Collides with Goomba from the Side
                                    if (!mario.isSuperForm() && !mario.isInvicible()) {//Dies on Impact
                                        //he deaded
                                        srcX = 0;
                                        mario.died();
                                    }
                                    if (mario.isSuperForm() && !mario.isInvicible()) { //Kills the Goomba but loses SUPER FORM
                                        lvlTh.getGoomba(i).goombaState = false;
                                        mario.addScore(100);
                                        mario.offSuper();
                                    }
                                    if (mario.isInvicible()) { //Kills Goomba but keeps inviciblity
                                        lvlTh.getGoomba(i).goombaState = false;
                                        mario.addScore(100);
                                    }
                                }
                                if (srcX == elementX + elementW) {
                                    if (!mario.isSuperForm() && !mario.isInvicible()) { // Dies on Impact
                                        //he deaded
                                        srcX = 0;
                                        mario.died();
                                    }
                                    if (mario.isSuperForm() && !mario.isInvicible()) { //Kills the Goomba but loses SUPER FORM
                                        lvlTh.getGoomba(i).goombaState = false;
                                        mario.addScore(100);
                                        mario.offSuper();
                                    }
                                    if (mario.isInvicible()) { //Kills Goomba but keeps inviciblity
                                        lvlTh.getGoomba(i).goombaState = false;
                                        mario.addScore(100);
                                    }
                                }
                            }
                        }
                    }

                }
                for (int i = 0; i < lvlTh.getPlants().length; i++) {//Cycles through all the plants
                    int elementX = lvlTh.getPlant(i).getX();
                    int elementY = lvlTh.getPlant(i).getY();
                    int elementH = lvlTh.getPlant(i).getHeight();
                    int elementW = lvlTh.getPlant(i).getWidth();
                    boolean elementS = lvlTh.getPlant(i).plantState;
                    if (((mario.getY() >= elementY) && (mario.getY() <= elementY + elementH)) || ((mario.getY() + mario.getOneHeight() >= elementY) && (mario.getY() + mario.getOneHeight() <= elementY + elementH))) {
                        if (elementS) {
                            if (srcX == elementX - mario.getOneWidth()) { //Collides with plant from the Side
                                if (!mario.isSuperForm() && !mario.isInvicible()) {//Dies on Impact
                                    //he deaded
                                    srcX = 0;
                                    mario.died();
                                }
                                if (mario.isSuperForm() && !mario.isInvicible()) { //Kills the plant but loses SUPER FORM
                                    lvlTh.getPlant(i).plantState = false;
                                    mario.addScore(200);
                                    mario.offSuper();
                                }
                                if (mario.isInvicible()) { //Kills plant but keeps inviciblity
                                    lvlTh.getPlant(i).plantState = false;
                                    mario.addScore(200);
                                }
                            }
                            if (srcX == elementX + elementW) {
                                if (!mario.isSuperForm() && !mario.isInvicible()) { // Dies on Impact
                                    //he deaded
                                    srcX = 0;
                                    mario.died();
                                }
                                if (mario.isSuperForm() && !mario.isInvicible()) { //Kills the plant but loses SUPER FORM
                                    lvlTh.getPlant(i).plantState = false;
                                    mario.addScore(100);
                                    mario.offSuper();
                                }
                                if (mario.isInvicible()) { //Kills Goomba but keeps inviciblity
                                    lvlTh.getPlant(i).plantState = false;
                                    mario.addScore(100);
                                }
                            }
                        }
                    }
                }
                break;
        }

    }
    public void update(Boolean movingLeft, Boolean movingRight){
        //Move the background as mario moves left or right
            if (movingLeft && canMoveLeft){
                if(srcX != 0) {
                    srcX -= xSpeed;
                }
            }
            else if (movingRight && canMoveRight){
                switch(currentLevel){
                    case 0:
                        if(srcX !=7895) {
                            srcX += xSpeed;
                        }
                        if(srcX == 7895){
                            //Next level
                            srcX = 0;
                            currentLevel++;
                        }
                        break;
                    case 1:
                        if(srcX !=4000) {
                            srcX += xSpeed;
                        }
                        if(srcX == 3930){
                            //Next level
                            srcX = 0;
                            currentLevel++;
                        }
                        break;
                    case 2:
                        if(srcX !=5225) {
                            srcX += xSpeed;
                        }
                        if(srcX == 5225){
                            //Next level
                            srcX = 0;
                            currentLevel++;
                        }
                        break;
                }

            }
    }

}
