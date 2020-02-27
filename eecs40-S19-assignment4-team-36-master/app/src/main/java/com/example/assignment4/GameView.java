package com.example.assignment4;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private mainThread thread;
    private Background backgroudSprite;
    private Bitmap[] bgSprites = new Bitmap[3];
    private Bitmap deadBlockSprite, coinSprite, enemiesSprite, mushroomSprite, starSprite, plantSprite;
    private Mario marioSprite;
    private int currentLevel;
    LevelOne levelOne;
    LevelTwo levelTwo;
    LevelThree levelThree;



    //Initialize Game View
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new mainThread(getHolder(), this);
        setFocusable(true);
    }

    //Listen for touches, so we can know if button clicked
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float tx = event.getX();
        float ty = event.getY();
        //Click Detected
        if(event.getAction()==(0)) {
            //Detect Jump
            if ((tx > 50)&&(tx < 450)&&(ty > 850)&&(ty < 1050) && marioSprite.canJump()){
                marioSprite.jumping = true;
                marioSprite.stopJumping = false;
                marioSprite.standing = false;
                if(currentLevel == 3){
                    currentLevel = 0;
                    newGame();
                }
            }
            //Move Left
            else if (tx < 960) {

                marioSprite.movingRight = false;
                marioSprite.standing = false;
                marioSprite.movingLeft = true;
            }
            //Move Right
            else if (tx > 959) {

                marioSprite.movingRight = true;
                marioSprite.standing = false;
                marioSprite.movingLeft = false;
            }
        }
        //Reset
        else if((event.getAction() == 1)){

            marioSprite.movingRight = false;
            if(!marioSprite.jumping) {
                marioSprite.standing = true;
            }
            marioSprite.movingLeft = false;
            //Reset to standing and not moving

        }
        return true;
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    //Initialize all the sprites and the game
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
        bgSprites[0] = BitmapFactory.decodeResource(getResources(),R.drawable.firstlevel);
        bgSprites[1] = BitmapFactory.decodeResource(getResources(),R.drawable.leveltwo);
        bgSprites[2] = BitmapFactory.decodeResource(getResources(),R.drawable.levelthree);
        deadBlockSprite = BitmapFactory.decodeResource(getResources(),R.drawable.block);
        coinSprite = BitmapFactory.decodeResource(getResources(),R.drawable.coin);
        enemiesSprite = BitmapFactory.decodeResource(getResources(),R.drawable.enemies);
        mushroomSprite = BitmapFactory.decodeResource(getResources(),R.drawable.mushroom);
        starSprite = BitmapFactory.decodeResource(getResources(),R.drawable.star);
        plantSprite = BitmapFactory.decodeResource(getResources(),R.drawable.plant);
        newGame();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    @Override
    //Draw mario and draw background images
    public void draw(Canvas canvas) {
        super.draw(canvas);
        backgroudSprite.draw(canvas, levelOne, levelTwo, levelThree, marioSprite);
        marioSprite.draw(canvas);

    }
    //Restart and initialize game
    private void newGame(){
        levelOne = new LevelOne();
        levelTwo = new LevelTwo();
        levelThree = new LevelThree();
        backgroudSprite = new Background(bgSprites, deadBlockSprite, coinSprite, enemiesSprite, mushroomSprite, starSprite, plantSprite);
        marioSprite = new Mario(BitmapFactory.decodeResource(getResources(),R.drawable.mario));

    }
    //Game loop update
    public void update(){
            if (marioSprite.checkDeath()) {
                backgroudSprite.deathOccurred();
            }
            if(marioSprite.getLives()==0){
                //Game over
                backgroudSprite.setCurrentLevel(3);
            }
            currentLevel = backgroudSprite.getCurrentLevel();
            levelOne.goombaMove();
            levelThree.goombaMove();
            marioSprite.checkUpDown(currentLevel, levelOne, levelTwo, levelThree, backgroudSprite);
            backgroudSprite.checkSidetoSide(currentLevel, levelOne, levelTwo, levelThree, marioSprite);
            backgroudSprite.update(marioSprite.movingLeft, marioSprite.movingRight);//take in the x and y position of mario
            marioSprite.gravity();//Call gravity first
            marioSprite.update(); //Input 2d Array of Level Elements;

    }
}
