package com.tengwang.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tengwang.game.JumpingGDemo;

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManger gam) {
        super(gam);
        background = new Texture("background.png");//in assets folder
        playBtn = new Texture("play.png");
    }

    @Override
    public void handleInput(){
        if(Gdx.input.justTouched()){
            gam.set(new PlayState(gam));

        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, JumpingGDemo.WIDTH, JumpingGDemo.HEIGHT);
        sb.draw(playBtn, (JumpingGDemo.WIDTH / 2) - (playBtn.getWidth() / 2), (JumpingGDemo.HEIGHT / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
