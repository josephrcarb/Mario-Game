package com.example.assignment4;


//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class LevelTwo{
    private Blocks[] deadBlocks = new Blocks[4];
    private Star[] stars = new Star[1];
    private Coins[] coins = new Coins[15];
    private Boxes[] boxes = new Boxes[2]; //Mystery Boxes
    private Blocks[] blocks = new Blocks[21]; //Elements that are fixed.
    private Mushroom[] mushrooms = new Mushroom[1];
    public LevelTwo(){
        //HardCode Every Item's Location
        stars[0] = new Star(50,885, 15, 40);
        mushrooms[0] = new Mushroom(80, 885, 15, 40);
        ///////////////////BLOCKS///////////
        blocks[0] = new Blocks(0, 965,120,160);
        blocks[1] = new Blocks(3285, 965,900,160);
        blocks[2] = new Blocks(180, 885,105,60);
        blocks[3] = new Blocks(570, 885,80,60);
        blocks[4] = new Blocks(345, 665,220,60);
        blocks[5] = new Blocks(400, 365,140,60);
        blocks[6] = new Blocks(645, 585,150,60);
        blocks[7] = new Blocks(790, 285,200,60);
        blocks[8] = new Blocks(1060, 965,130,60);
        blocks[9] = new Blocks(1325, 965,305,60);
        blocks[10] = new Blocks(1345, 365,125,60);
        blocks[11] = new Blocks(1635, 665,80,60);
        blocks[12] = new Blocks(1800, 425,170,60);
        blocks[13] = new Blocks(2410, 825,125,60);
        blocks[14] = new Blocks(2585, 505,225,60);
        blocks[15] = new Blocks(2845, 965,75,60);
        blocks[16] = new Blocks(2920, 665,120,60);
        blocks[17] = new Blocks(3090, 665,110,60);
        blocks[18] = new Blocks(3535, 665,65,400);
        blocks[19] = new Blocks(3600, 505,65,700);
        blocks[20] = new Blocks(3650, 345,65,900);
        //////BOXES//////
        boxes[0] = new Boxes(1325, 745,30,60);
        boxes[1] = new Boxes(2125, 745,120,60);
        /////Deadblocks///
        deadBlocks[0] = new Blocks(2125, 745,30,60);
        deadBlocks[1] = new Blocks(2155, 745,30,60);
        deadBlocks[2] = new Blocks(2185, 745,30,60);
        deadBlocks[3] = new Blocks(2215, 745,30,60);
        ///COINS/////
        coins[0] = new Coins(190, 835,15,40);
        coins[1] = new Coins(590, 835,15,40);
        coins[2] = new Coins(355, 615,15,40);
        coins[3] = new Coins(410, 315,15,40);
        coins[4] = new Coins(665, 535,15,40);
        coins[5] = new Coins(810, 235,15,40);
        coins[6] = new Coins(1080, 915,15,40);
        coins[7] = new Coins(1365, 915,15,40);
        coins[8] = new Coins(1655, 315,15,40);
        coins[9] = new Coins(1820, 615,15,40);
        coins[10] = new Coins(2430, 375,15,40);
        coins[11] = new Coins(2605, 455,15,40);
        coins[12] = new Coins(2865, 915,15,40);
        coins[13] = new Coins(2940, 615,15,40);
        coins[14] = new Coins(3100, 615,15,40);
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
}
