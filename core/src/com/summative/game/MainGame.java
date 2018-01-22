package com.summative.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGame implements Screen{

    // Instance variables
    
    // we want to keep track of the game manager
    // this way we could make methods to switch screens!
    private Platform gameManager;
    
    // The player
    private Player player;
    
    // The world 
    private World world;    
    
    // Sprite Batch
    private SpriteBatch batch;
    
    // View Port
    private Viewport view;

    // Game Units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    // the constructor for our maingame needs to know what made it
    // this is what the game variable is
    public MainGame(Platform game){
        // we save this so we can talk to it later
        this.gameManager = game;
        
        // Creating the player
        player = new Player();
        
        // Generating the world
        world = new World();
        
        // initialize the spritebatch
        this.batch = game.getBatch();
        
        // viewport
        this.view = new FitViewport(WIDTH, HEIGHT);
        view.apply();
    }
  
    @Override
    public void show() {
        // this would be what happens when the game wakes up from being hidden
        // i.e. when you minimized the game and reopenned it
    }

    // the main game loop for this screen
    public void render(float deltaTime) {
        
        // Updating the player
        player.update(deltaTime);
        
        // clears the screen in a black colour
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // ask the SpriteBatch to start taking notes of what to draw
        batch.begin();
        
        // Rendering the world and player
        world.render(batch);
        player.render(batch);

        // tell the SpriteBatch we are good to draw everything now
	batch.end();
        
        // Updating the world
        world.update(deltaTime);

    }

    // if the game could pause, what do you need to happen?
    @Override
    public void pause() {
        
    }

    // when the game is unpaused, what do you need to happen?
    @Override
    public void resume() {
        
    }

    // when the game needs to be minimized, what needs to happen?
    @Override
    public void hide() {
        
    }

    // get rid of heavy objects...
    @Override
    public void dispose() {
        
    }

 

    @Override
    public void resize(int width, int height) {
        view.update(width, height);
    }
}