package com.tengwang.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.tengwang.game.JumpingGDemo;
import com.tengwang.game.sprites.Grid;
import com.tengwang.game.sprites.Piggy;

public class PlayState extends State {
    private static final int Grid_Spacing=125;
    private static final int Grid_Count=4;
    private Piggy piggy;
    private Texture bg;
    private Grid grid;
    private Texture ground;
    private Vector2 groundPos1,groundPos2;
    private com.badlogic.gdx.utils.Array<Grid> grids;
    public PlayState(GameStateManger gam) {
        super(gam);
        piggy=new Piggy(50,300);
        cam.setToOrtho(false, JumpingGDemo.WIDTH / 2,JumpingGDemo.HEIGHT / 2);
        bg=new Texture("background.png");
        ground=new Texture("ground.png");
        groundPos1=new Vector2(cam.position.x-cam.viewportWidth/2,0);
        groundPos2=new Vector2((cam.position.x-cam.viewportWidth/2)+ground.getWidth(),0);
        grid=new Grid(100);

       grids=new Array<Grid>();
       for(int i=1;i<=Grid_Count;i++){
           grids.add(new Grid(i*Grid_Spacing+Grid.Grid_Width));
       }
    }

    @Override
    public  void handleInput() {
     if(Gdx.input.justTouched()){
         piggy.jump();
     }
    }

    @Override

    public void update(float dt) {
        handleInput();
        piggy.update(dt);
        cam.position.x=piggy.getPosition().x+80;

      for(int i=0;i<grid.size;i++){
          Grid grid=grids.get(i);
           if((cam.position.x-(cam.viewportWidth/2)>grid.getPosFirstGrid().x+grid.getFirstGrid().getWidth())){
               grid.reposition(grid.getPosFirstGrid().x+(Grid.Grid_Width+Grid_Spacing)*Grid_Count);
           }
           if(grid.collides(piggy.getBounds())){
               gam.set(new PlayState(gam));
           }
       }
       cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x-(cam.viewportWidth/2),0);
        sb.draw(piggy.getPiggy(),piggy.getPosition().x,piggy.getPosition().y);
        sb.draw(grid.getFirstGrid(),grid.getPosFirstGrid().x,grid.getPosFirstGrid().y);
        sb.draw(grid.getSecondGrid(),grid.getPosSecondGrid().x,grid.getPosSecondGrid().y);
        sb.end();

    }

    @Override
    public void dispose() {
        bg.dispose();
        piggy.dispose();
        for(Grid grid:grids)
            grid.dispose();
        System.out.println("Play State Disposed");

    }
}
