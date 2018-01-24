/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summative.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Kareem
 * @author Arvind
 */

public class MainMenu implements Screen{

    // Game Manager
    private Asteroids gameManager;
    
    //Sprite Batch
    private SpriteBatch batch;
    
    // Play Button
    private Texture play;
    
    // Controls Button 
    private Texture controls;
    
    // Exit Game Button
    private Texture quit;


    // Constructor
    public MainMenu (Asteroids gameManager){
        //Initialzation of varaibles
        this.gameManager = gameManager; 
        this.batch = gameManager.getBatch();
        
        // Getting the play buttons
        play = new Texture("start.png");
        controls = new Texture("controls.png");
        quit = new Texture("quit.png");
    }
       
    public void update() {
        
    }

    @Override
    public void render(float f) {
        
        // Plain Black Screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Beginning Spritebatch
        batch.begin();
        
        // Buttons
        //batch.draw(play, x, y, x, y); // Play    
        //batch.draw(controls, x, y, x, y); // Controls
        //batch.draw(quit, x, y, x, y); // Quit
            
        // Ending Spritebatch
        batch.end();
        
    }

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        
    }

    @Override
    public void show() {
        
    }
    
}