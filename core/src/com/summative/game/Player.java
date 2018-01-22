package com.summative.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Player extends ApplicationAdapter {

    // Instance variables
    // Sprite batch
    private SpriteBatch batch;
    // Player image - spaceship
    private Texture spaceship;
    
    // Location of the player
    private float x;
    private float y;
    
    // Displacement of the player
    private float dx;

    // Player 
    public Player() {
        this.x = 375;
        this.y = 25;
        
        // Displacement of X 
        // Moving the character left and right
        this.dx = 0;
        
        // The sapceship
        spaceship = new Texture("spaceship.png");  
    }
 
    public void update(float deltaTime) {
        // Player movement
        // If the right key is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            // Move right
            this.dx = 8;
            
        // If the left key is pressed
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // Move left
            this.dx = -8;
        
        // If no keys are pressed
        }else{
            // Stand still
            this.dx = 0;
        }
        
        // Moving the player
        this.x += this.dx;
        
        // Boundaries
        // Left side of the screen
        if (this.x <= 25){
            this.x = 25;
        }
        
        // Right side of the screen
        if (this.x > 710){
            this.x = 710;
        }
    }

    public void render(SpriteBatch batch) {
        // Draws the player
        batch.draw(spaceship, x, y);
    }
}
