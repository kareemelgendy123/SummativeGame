package com.summative.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author Kareem
 * @author Arvind
 */

public class MainGame implements Screen{

    // Sound

    
// Instance variables
    // we want to keep track of the game manager
    // this way we could make methods to switch screens!
    private final Asteroids gameManager;
    
    // The player
    private final Player player;
    
    // The world 
    private final World world;    
    
    // Sprite Batch
    SpriteBatch batch;
    
    // View Port
    private final Viewport view;

    // Game Units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    // the constructor for our maingame needs to know what made it
    // this is what the game variable is
    public MainGame(Asteroids game){
        // we save this so we can talk to it later
        this.gameManager = game;
        
        // Creating the player
        player = new Player(375, 25);
        
        // Generating the world
        world = new World();
        
        // initialize the spritebatch
        this.batch = game.getBatch();
        
        // viewport
        this.view = new FitViewport(WIDTH, HEIGHT);
        view.apply();
        
        // Calling the music file - background music
        Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
        
        // Looping the background music
        backgroundMusic.setLooping(true);
        
        // Playing the background music
        backgroundMusic.play();
    }
  
    @Override
    public void show() {
        // this would be what happens when the game wakes up from being hidden
        // i.e. when you minimized the game and reopenned it
    }

    // the main game loop for this screen
    @Override
    public void render(float deltaTime) {
        
        // Updating the player
        player.update(deltaTime);

        // Asking the SpriteBatch to start taking notes of what to draw
        batch.begin();
        
        // Rendering
        // Rendering the world
        world.render(batch);
        
        // Rendering the player
        player.render(batch);

        // Tell the SpriteBatch that we're good
        // Draw everything
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