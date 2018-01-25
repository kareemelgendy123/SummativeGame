package com.summative.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author Kareem
 * @author Arvind
 */
public class MainGame implements Screen {

    // Instance variables
    // we want to keep track of the game manager
    // this way we could make methods to switch screens!
    private final Asteroids gameManager;

    // The player
    private final Player player;

    // The world 
    private final World world;
    
    private ShapeRenderer shape;
    
    private Texture spaceship;
    private Texture asteroid;
    
    private Music backgroundMusic;

    // Sprite Batch
    SpriteBatch batch;
    
    BitmapFont font;

    // View Port
    private final Viewport view;

    // Game Units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    // Screens
    private boolean menuScreen; // Menu
    private Texture playButton; // Game
    private Texture quitButton; // Quit
    
    private boolean playScreen; // Game
    private boolean quitScreen; // Quit
    
    private Texture title;

    // the constructor for our maingame needs to know what made it
    // this is what the game variable is
    public MainGame(Asteroids game) {

        //Initialzation of varaibles
        this.batch = game.getBatch();

        // we save this so we can talk to it later
        this.gameManager = game;
        
        // Screens
        this.menuScreen = true;
        this.playScreen = false;
        this.quitScreen = false;
        
        BitmapFont font = new BitmapFont();
        
        player = new Player();

        // Generating the world
        world = new World();

        // initialize the spritebatch
        this.batch = game.getBatch();

        // viewport
        this.view = new FitViewport(WIDTH, HEIGHT);
        view.apply();

        // Calling the music file - background music
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));

        shape = new ShapeRenderer();
        
        // The spaceship
        spaceship = new Texture("spaceship.png"); 
        asteroid = new Texture("asteroid.png");
        
                

    }

    // the main game loop for this screen
    @Override
    public void render(float deltaTime) {
        
//         // Mouse Input
//        if (Gdx.input.isTouched()) {
//            
//            // Getting mouse coordinates
//            int mouseX = Gdx.input.getX();
//            int mouseY = Gdx.input.getY();
//
//            if (mouseX >= 275 && mouseX <= 525 && menuScreen == true) {
//                // Play Button
//                if (mouseY >= 250 && mouseY <= 325) {
//                    menuScreen = false;
//                    playScreen = true;
//                    
//                // Controls Button
//                }else if (mouseY >= 350 && mouseY <= 425) {
//                    Gdx.app.exit();
//                }
//            }
//        }
//
//        // Black background
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        // Buttons
//        // batch.draw(title, 100, 100);
//
//        shape.begin(ShapeRenderer.ShapeType.Filled);
//        shape.rect(275, 275, 250, 75); // Play  
//
//        shape.rect(275, 175, 250, 75); // quit
//
//        shape.end();
//  
//        // If play button is pressed
//        if (menuScreen == false && playScreen == true && quitScreen == false) {
//            
            // Asking the SpriteBatch to start taking notes of what to draw
            batch.begin();

            // Rendering
            // Rendering the world
            world.render(batch);

            //Tell the SpriteBatch that we're good
            //Draw everything
            batch.end();
            
            // Updating the world
            world.update(deltaTime);
            
            // Looping the background music
            backgroundMusic.setLooping(true);
            // Playing the background music
            backgroundMusic.play();
        //}
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

    @Override
    public void show() {

    }
}
