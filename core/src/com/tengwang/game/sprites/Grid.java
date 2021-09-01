package com.tengwang.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Grid  {
    private static final int FLUCTUATION=130;
    private static final int Grid_Gap=100;
    private static final int Lowest_Opening = 120;
  public static final int Grid_Width =52;
    public int size;
    private Texture firstGrid,secondGrid;
    private Vector2 posFirstGrid,posSecondGrid;
    private Random rand;
    private Rectangle boundsTop,boundsBot;

    public Grid(float x){
        firstGrid=new Texture("c1.png");
        secondGrid=new Texture("c2.png");
        rand=new Random();
        posFirstGrid=new Vector2(x,rand.nextInt(FLUCTUATION)+Grid_Gap+Lowest_Opening);
        posSecondGrid=new Vector2(x,posFirstGrid.y-Grid_Gap-secondGrid.getHeight());

        boundsTop=new Rectangle(posFirstGrid.x,posSecondGrid.y, firstGrid.getWidth(), firstGrid.getWidth());
        boundsBot=new Rectangle(posSecondGrid.x,posSecondGrid.y, secondGrid.getWidth(), secondGrid.getWidth());

    }

    public Texture getFirstGrid() {
        return firstGrid;
    }

    public Texture getSecondGrid() {
        return secondGrid;
    }

    public Vector2 getPosFirstGrid() {
        return posFirstGrid;
    }

    public Vector2 getPosSecondGrid() {
        return posSecondGrid;
    }

    public void reposition(float x){
        posFirstGrid.set(x,rand.nextInt(FLUCTUATION)+Grid_Gap+Lowest_Opening);
        posSecondGrid.set(x,posFirstGrid.y-Grid_Gap-secondGrid.getHeight());
        boundsTop.setPosition(posFirstGrid.x,posFirstGrid.y);
        boundsBot.setPosition(posSecondGrid.x,posSecondGrid.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) && player.overlaps(boundsBot);
    }

    public void dispose(){
        firstGrid.dispose();
        secondGrid.dispose();
    }
}
