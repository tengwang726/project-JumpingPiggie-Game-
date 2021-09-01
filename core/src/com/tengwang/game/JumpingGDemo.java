package com.tengwang.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tengwang.game.states.GameStateManger;
import com.tengwang.game.states.MenuState;

public class JumpingGDemo extends ApplicationAdapter {
	public static final int WIDTH=480;
	public static final int HEIGHT=480;

	public static final String TITLE="Jumping Piggie";
	private GameStateManger gam;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gam= new GameStateManger();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gam.push(new MenuState(gam));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gam.update(Gdx.graphics.getDeltaTime());
		gam.render(batch);

	}
	

}
