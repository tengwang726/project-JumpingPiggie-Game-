package com.tengwang.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Piggy {
    private static final int GRAVITY=-15;
    private static final int Movement=100;//horizontal movement
    private Vector3 position;
    private Vector3 velocity;
    private Texture piggy;
    private Rectangle bounds;
    public Piggy(int x, int y){
        position=new Vector3(x,y,0);
        velocity=new Vector3(0,0,0);
        piggy=new Texture(("piggy.png"));
        bounds=new Rectangle(x,y, piggy.getWidth(), piggy.getHeight());
    }
    //reset position and velocity
    public void update(float dt){
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(Movement*dt,velocity.y,0);
        if(position.y<0)
            position.y=0;

        velocity.scl(1/dt);
        bounds.setPosition(position.x,position.y);

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPiggy() {
        return piggy;
    }

    public void jump(){
        velocity.y=250;

    }

    public Rectangle getBounds(){
        return bounds;
    }
    public void dispose(){
        piggy.dispose();
    }
}
