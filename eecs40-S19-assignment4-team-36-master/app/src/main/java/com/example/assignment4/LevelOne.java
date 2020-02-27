package com.example.assignment4;

//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class LevelOne {
    private Blocks[] deadBlocks;
    private Star[] stars = new Star[1];
    private Coins[] coins = new Coins[14];
    private Brick[] bricks = new Brick[30]; //Bricks that break
    private Boxes[] boxes = new Boxes[13]; //Mystery Boxes
    private Blocks[] blocks = new Blocks[30]; //Elements that are fixed.
    private Goomba[] goombas = new Goomba[6];
    private Mushroom[] mushrooms = new Mushroom[1];

    public LevelOne() {
        //HardCode Every Item's Location
        /////////STARS//////////////
        stars[0] = new Star(600,885, 15, 40);
        /////////MUSHROOMS///////////
        mushrooms[0] = new Mushroom(380,885, 15, 40);
        /////////COINS///////////
        coins[0] = new Coins(415,585, 15, 40);
        coins[1] = new Coins(590,585, 15, 40);
        coins[2] = new Coins(950,885, 15, 40);
        coins[3] = new Coins(1025,885, 15, 40);
        coins[4] = new Coins(2210,885, 15, 40);
        coins[5] = new Coins(2210,785, 15, 40);
        coins[6] = new Coins(2480,785, 15, 40);
        coins[7] = new Coins(2810,585, 15, 40);
        coins[8] = new Coins(3395,265, 15, 40);
        coins[9] = new Coins(3435,265, 15, 40);
        coins[10] = new Coins(3810,585, 15, 40);
        coins[11] = new Coins(3810,265, 15, 40);
        coins[12] = new Coins(5400,385, 15, 40);
        coins[13] = new Coins(7720,885, 15, 40);
        ////////////////GOOMBAS//////////////
        goombas[0] = new Goomba(255, 885, 40, 80, 100);
        goombas[1] = new Goomba(1535, 885, 40, 80, 100);
        goombas[2] = new Goomba(2960, 265, 40, 80, 50);
        goombas[3] = new Goomba(3870, 885, 40, 80, 100);
        goombas[4] = new Goomba(5625, 885, 40, 80, 25);
        goombas[5] = new Goomba(6460, 885, 40, 80, 100);
        ///////////////BRICKS///////////////////
        bricks[0] = new Brick(415,665,40,80);
        bricks[1] = new Brick(495,665,40,80);
        bricks[2] = new Brick(575,665,40,80);
        bricks[3] = new Brick(2810,665,40,80);
        bricks[4] = new Brick(2890,665,40,80);
        bricks[5] = new Brick(2930,365,40,80);
        bricks[6] = new Brick(2970,365,40,80);
        bricks[7] = new Brick(3010,365,40,80);
        bricks[8] = new Brick(3050,365,40,80);
        bricks[9] = new Brick(3090,365,40,80);
        bricks[10] = new Brick(3130,365,40,80);
        bricks[11] = new Brick(3170,365,40,80);
        bricks[12] = new Brick(3210,365,40,80);
        bricks[13] = new Brick(3400,365,40,80);
        bricks[14] = new Brick(3440,365,40,80);
        bricks[15] = new Brick(3480,365,40,80);
        bricks[16] = new Brick(3520,665,40,80);
        bricks[17] = new Brick(3775,665,40,80);
        bricks[18] = new Brick(3815,665,40,80);
        bricks[19] = new Brick(4530,665,40,80);
        bricks[20] = new Brick(4655,365,40,80);
        bricks[21] = new Brick(4695,365,40,80);
        bricks[22] = new Brick(4735,365,40,80);
        bricks[23] = new Brick(4995,665,40,80);
        bricks[24] = new Brick(5035,665,40,80);
        bricks[25] = new Brick(4950,365,40,80);
        bricks[26] = new Brick(5070,365,40,80);
        bricks[27] = new Brick(6630,665,40,80);
        bricks[28] = new Brick(6670,665,40,80);
        bricks[29] = new Brick(6750,665,45,80);
        //////////////////? BOXES/////////////////////////
        boxes[0] = new Boxes(245,665,40,80);
        boxes[1] = new Boxes(455,665,40,80);
        boxes[2] = new Boxes(535,665,40,80);
        boxes[3] = new Boxes(500,365,40,80);
        boxes[4] = new Boxes(2850,665,40,80);
        boxes[5] = new Boxes(3520,365,40,80);
        boxes[6] = new Boxes(4030,665,40,80);
        boxes[7] = new Boxes(4150,665,40,80);
        boxes[8] = new Boxes(4280,665,40,80);
        boxes[9] = new Boxes(4150,365,40,80);
        boxes[10] = new Boxes(4990,365,40,80);
        boxes[11] = new Boxes(5030,365,40,80);
        boxes[12] = new Boxes(6710,665,40,80);
        //////////////BLOCKS/////////////////////
        blocks[0] = new Blocks(0, 985,2470,160);
        blocks[1] = new Blocks(2560, 985,630,160);
        blocks[2] = new Blocks(3315, 985,2685,160);
        blocks[3] = new Blocks(6085, 985,2000,160);
        blocks[4] = new Blocks(5200, 905,45,320);
        blocks[5] = new Blocks(5245, 825,45,320);
        blocks[6] = new Blocks(5290, 745,45,320);
        blocks[7] = new Blocks(5330, 665,40,320);
        blocks[8] = new Blocks(5455, 665,45,320);
        blocks[9] = new Blocks(5500, 745,45,320);
        blocks[10] = new Blocks(5545, 825,45,320);
        blocks[11] = new Blocks(5585, 905,40,320);
        blocks[12] = new Blocks(5790, 905,45,320);
        blocks[13] = new Blocks(5835, 825,45,320);
        blocks[14] = new Blocks(5880, 745,45,320);
        blocks[15] = new Blocks(5925, 665,45,320);
        blocks[16] = new Blocks(5965, 665,45,320);
        blocks[17] = new Blocks(6080, 665,45,320);
        blocks[18] = new Blocks(6125, 745,45,320);
        blocks[19] = new Blocks(6170, 825,45,320);
        blocks[20] = new Blocks(6210, 905,45,320);
        blocks[21] = new Blocks(7170, 905,45,640);
        blocks[22] = new Blocks(7215, 825,45,640);
        blocks[23] = new Blocks(7260, 745,45,640);
        blocks[24] = new Blocks(7305, 665,45,640);
        blocks[25] = new Blocks(7350, 585,45,640);
        blocks[26] = new Blocks(7395, 505,45,640);
        blocks[27] = new Blocks(7440, 425,45,640);
        blocks[28] = new Blocks(7485, 365,45,640);
        blocks[29] = new Blocks(7525, 365,30,640);
    }
    Brick getBrick(int i){
        return bricks[i];
    }
    Brick[] getBricks(){
        return bricks;
    }
    Boxes getBox(int i){
        return boxes[i];
    }
    Boxes[] getBoxes(){
        return boxes;
    }
    Blocks getBlock(int i){
        return blocks[i];
    }
    Blocks[] getBlocks(){
        return blocks;
    }

    public void addDeadBlock(int X, int Y, int Width, int Height){
        Blocks temp = new Blocks(X, Y, Width, Height);
        if (deadBlocks == null){
            deadBlocks = new Blocks[1];
            deadBlocks[0] = temp;
        }
        else{
            Blocks[] tempblocks = new Blocks[deadBlocks.length + 1];
            for (int i = 0; i<deadBlocks.length; i++){
                tempblocks[i] = deadBlocks[i];
            }
            tempblocks[deadBlocks.length] = temp;
            deadBlocks = new Blocks[tempblocks.length];
            deadBlocks = tempblocks;
        }

    }
    public void addCoin(int X, int Y, int Width, int Height){
        Coins temp = new Coins(X, Y, Width, Height);
        if (coins == null){
            coins = new Coins[1];
            coins[0] = temp;
        }
        else{
            Coins[] tempcoins = new Coins[coins.length + 1];
            for (int i = 0; i<coins.length; i++){
                tempcoins[i] = coins[i];
            }
            tempcoins[coins.length] = temp;
            coins = new Coins[tempcoins.length];
            coins = tempcoins;
        }
    }
    public void delCoin(int X, int Y){
        int j = 0;
        if(coins.length-1 == 0){
            coins = new Coins[0];
        }
        else {
            Coins[] tempcoins = new Coins[coins.length - 1];
            for (int i = 0; i < coins.length; i++) {
                if ((coins[i].getX() == X) && (coins[i].getY() == Y)) {
                    continue;
                }
                else {
                    tempcoins[j] = coins[i];
                    j++;
                }
            }
            coins = new Coins[tempcoins.length];
            coins = tempcoins;
        }
    }
    public void addMushroom(int X, int Y, int Width, int Height){
        Mushroom temp = new Mushroom(X, Y, Width, Height);
        if (mushrooms == null){
            mushrooms = new Mushroom[1];
            mushrooms[0] = temp;
        }
        else{
            Mushroom[] tempmushrooms = new Mushroom[mushrooms.length + 1];
            for (int i = 0; i<mushrooms.length; i++){
                tempmushrooms[i] = mushrooms[i];
            }
            tempmushrooms[mushrooms.length] = temp;
            mushrooms = new Mushroom[tempmushrooms.length];
            mushrooms = tempmushrooms;
        }
    }
    public void delMushroom(int X, int Y){
        int j = 0;
        if(mushrooms.length-1 == 0){
            mushrooms = new Mushroom[0];
        }
        else {
            Mushroom[] tempmushrooms= new Mushroom[mushrooms.length - 1];
            for (int i = 0; i < mushrooms.length; i++) {
                if ((mushrooms[i].getX() == X) && (mushrooms[i].getY() == Y)) {
                    continue;
                }
                else {
                    tempmushrooms[j] = mushrooms[i];
                    j++;
                }
            }
            mushrooms = new Mushroom[tempmushrooms.length];
            mushrooms = tempmushrooms;
        }
    }
    Mushroom getMushroom(int i){
        return mushrooms[i];
    }
    Mushroom[] getMushrooms(){
        return mushrooms;
    }
    public void addStar(int X, int Y, int Width, int Height){
        Star temp = new Star(X, Y, Width, Height);
        if (stars == null){
            stars = new Star[1];
            stars[0] = temp;
        }
        else{
            Star[] tempstars = new Star[stars.length + 1];
            for (int i = 0; i<stars.length; i++){
                tempstars[i] = stars[i];
            }
            tempstars[stars.length] = temp;
            stars = new Star[tempstars.length];
            stars = tempstars;
        }
    }
    public void delStar(int X, int Y){
        int j = 0;
        if(stars.length-1 == 0){
            stars = new Star[0];
        }
        else {
            Star[] tempstars = new Star[stars.length - 1];
            for (int i = 0; i < stars.length; i++) {
                if ((stars[i].getX() == X) && (stars[i].getY() == Y)) {
                    continue;
                }
                else {
                    tempstars[j] = stars[i];
                    j++;
                }
            }
            stars = new Star[tempstars.length];
            stars = tempstars;
        }
    }
    Star getStar(int i){
        return stars[i];
    }
    Star[] getStars(){
        return stars;
    }
    Coins getCoin(int i){
        return coins[i];
    }
    Coins[] getCoins(){
        return coins;
    }
    Blocks getDeadBlock(int i){
        return deadBlocks[i];
    }
    Blocks[] getDeadBlocks(){
        return deadBlocks;
    }
    Goomba getGoomba(int i){
        return goombas[i];
    }
    Goomba[] getGoombas(){
        return goombas;
    }
    public void goombaMove(){
        for(int i =0; i<goombas.length; i++){
            goombas[i].update();
        }
    }

}


