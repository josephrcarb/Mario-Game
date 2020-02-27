package com.example.assignment4;
//Name: Joseph Carbone
//Team: "jrcarbon" team 36
//ID: 46146768
//DATE: 6/7/2019
//UCInetID: jrcarbon
public class LevelThree{
    private Blocks[] deadBlocks;
    private Star[] stars = new Star[1];
    private Coins[] coins = new Coins[14];
    private Brick[] bricks = new Brick[21]; //Bricks that break
    private Boxes[] boxes = new Boxes[11]; //Mystery Boxes
    private Blocks[] blocks = new Blocks[14]; //Elements that are fixed.
    private Goomba[] goombas = new Goomba[6];
    private Plant[] plants = new Plant[6];
    private Mushroom[] mushrooms = new Mushroom[1];
    public LevelThree(){
        //Hardcoded Position of every elements that makes up level 3
        /////////Coins///////////
        coins[0] = new Coins(315,885, 15, 40);
        coins[1] = new Coins(495,885, 15, 40);
        coins[2] = new Coins(1120,885, 15, 40);
        coins[3] = new Coins(1480,585, 15, 40);
        coins[4] = new Coins(1525,265, 15, 40);
        coins[5] = new Coins(1595,265, 15, 40);
        coins[6] = new Coins(395,885, 15, 40);
        coins[7] = new Coins(1895,265, 15, 40);
        coins[8] = new Coins(2200,585, 15, 40);
        coins[9] = new Coins(2435,885, 15, 40);
        coins[10] = new Coins(3605,885, 15, 40);
        coins[11] = new Coins(3765,885, 15, 40);
        coins[12] = new Coins(4240,265, 15, 40);
        coins[13] = new Coins(4395,265, 15, 40);
        /////////Goombas////////////
        goombas[0] = new Goomba(315, 885, 40, 80, 30);
        goombas[1] = new Goomba(1005, 885, 40, 80, 75);
        goombas[2] = new Goomba(1505, 885, 40, 80, 75);
        goombas[3] = new Goomba(1855, 265, 40, 80, 10);
        goombas[4] = new Goomba(3555, 885, 40, 80, 40);
        goombas[5] = new Goomba(4130, 885, 40, 80, 100);
        /////////PLANTS////////////////////
        plants[0] = new Plant (815,885,40, 160);
        plants[1] = new Plant (1710,885,40, 160);
        plants[2] = new Plant (2515,885,40, 160);
        plants[3] = new Plant (2770,885,40, 160);
        plants[4] = new Plant (3275,885,40, 160);
        plants[5] = new Plant (4470,885,40, 160);
        /////////STARS//////////////
        stars[0] = new Star(15,585, 15, 40);
        /////////MUSHROOMS///////////
        mushrooms[0] = new Mushroom(50,585, 15, 40);
        ////////////Floors//////////////////
        blocks[0] = new Blocks(0, 985,2155,160);
        blocks[1] = new Blocks(2260, 985,280,160);
        blocks[2] = new Blocks(2620, 985,850,160);
        blocks[3] = new Blocks(3550, 985,280,160);
        blocks[4] = new Blocks(3890, 985,2000,320);
        blocks[5] = new Blocks(140, 905,60,320);
        blocks[6] = new Blocks(165, 825,60,320);
        blocks[7] = new Blocks(195, 745,30,320);
        blocks[8] = new Blocks(215, 665,40,320);
        blocks[9] = new Blocks(255, 585,60,320);
        blocks[10] = new Blocks(530, 585,40,320);
        blocks[11] = new Blocks(560, 825,30,320);
        blocks[12] = new Blocks(3890, 745,40,320);
        blocks[13] = new Blocks(4900, 665,60,1000);
        /////Bricks//////
        bricks[0] = new Brick(0,665,40,80);
        bricks[1] = new Brick(40,665,40,80);
        bricks[2] = new Brick(390,365,40,80);
        bricks[3] = new Brick(430,365,40,80);
        bricks[4] = new Brick(1480,665,40,80);
        bricks[5] = new Brick(1520,365,40,80);
        bricks[6] = new Brick(1560,365,40,80);
        bricks[7] = new Brick(1600,365,40,80);
        bricks[8] = new Brick(1850,365,40,80);
        bricks[9] = new Brick(1890,365,40,80);
        bricks[10] = new Brick(1930,365,40,80);
        bricks[11] = new Brick(2155,365,60,80);
        bricks[12] = new Brick(2215,365,60,80);
        bricks[13] = new Brick(3080,365,60,80);
        bricks[14] = new Brick(3140,365,60,80);
        bricks[15] = new Brick(4085,665,40,80);
        bricks[16] = new Brick(4170,365,40,80);
        bricks[17] = new Brick(4210,365,40,80);
        bricks[18] = new Brick(4250,365,50,80);
        bricks[19] = new Brick(4400,365,40,80);
        bricks[20] = new Brick(4760,665,50,80);
        ///////////////BOXES/////////////
        boxes[0] = new Boxes(1065,665,40,80);
        boxes[1] = new Boxes(1105,665,40,80);
        boxes[2] = new Boxes(1145,665,55,80);
        boxes[3] = new Boxes(1065,365,40,80);
        boxes[4] = new Boxes(1105,365,40,80);
        boxes[5] = new Boxes(1145,365,55,80);
        boxes[6] = new Boxes(1790,665,50,80);
        boxes[7] = new Boxes(1840,665,50,80);
        boxes[8] = new Boxes(1960,665,40,80);
        boxes[9] = new Boxes(2000,665,40,80);
        boxes[10] = new Boxes(4340,665,35,80);
    }
    Brick getBrick(int i){
        return bricks[i];
    }
    Brick[] getBricks(){
        return bricks;
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
    Plant getPlant(int i){
        return plants[i];
    }
    Plant[] getPlants(){
        return plants;
    }
    public void goombaMove(){
        for(int i =0; i<goombas.length; i++){
            goombas[i].update();
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
    Blocks getBlock(int i){
        return blocks[i];
    }
    Blocks[] getBlocks(){
        return blocks;
    }
    Boxes getBox(int i){
        return boxes[i];
    }
    Boxes[] getBoxes(){
        return boxes;
    }
}
