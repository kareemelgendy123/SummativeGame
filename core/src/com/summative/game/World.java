/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summative.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Kareem
 * @author Arvind
 */

public class World {

    // Instance variables
    // Sprite Batch
    private SpriteBatch batch;
    private final Texture background;
    private final Texture asteroid;
    private BitmapFont font;
    
    // Background Images
    private final float backgroundX; // X Coordinate of the backgrounds
    private float backgroundY; 
    private float backgroundY2;
    private float backgroundY3;

    // Creating an array of asteroids
    float[] asteroidX = new float[18];
    float[] asteroidY = new float[18];

    // Displacement of the background
    private float backgroundDY;
    
    // Displacement of the asteroids
    private double asteroidDY;
    
    // Collision
    private boolean collided;
    
    // Game status
    private boolean status;
    
    // Points
    private int points;
    
    private Rectangle[] asteroidRect;
    private Rectangle playerRect;
     
    // Player image - spaceship
    private Texture spaceship;
    
    // Location of the player
    private float playerX;
    private float playerY;
    
    // Displacement of the player
    private float playerDX;
    
    private Texture title;
    private Texture playButton; // Game
    private Texture quitButton; // Quit
    
    // Constructor
    public World() {
                
        playerRect = new Rectangle();
        asteroidRect = new Rectangle[18];
        
        // Coordinates of the background images
        // X Coordinates       
        this.backgroundX = 0;
        
        // Y Coordinates
        this.backgroundY = 0;
        this.backgroundY2 = 450;
        this.backgroundY3 = 900;
        
        // Displacement of Y
        this.backgroundDY = -2;
        this.asteroidDY = -3;
        
        // Player points
        this.points = 0;
        
        this.playerX = 375;
        this.playerY = 25;
        
        // Displacement of X 
        // Moving the character left and right
        this.playerDX = 0;

        // The spaceship
        spaceship = new Texture("spaceship.png");  
        
        title = new Texture("title.png");
        playButton = new Texture("play.png");
        quitButton = new Texture("quit.png");
        
        // Collision status
        this.collided = false;

        // Getting the images
        background = new Texture("background.png"); // Background
        asteroid = new Texture("asteroid.png"); // Asteroid
        
        
        // Generating coordinates for the array of asteroids
        for (int i = 0; i < asteroidX.length; i++) {
            // Randomly generating x coordinates for the variables
            asteroidX[i] = (int) (Math.random() * 775 + 5);
            
            // Assigning a y coordinate to each of the asteroids in the array
            asteroidY[i] = 650 + (75 * i);
        }
    }
    
    // Collision Detection
    public boolean checkCollision(){
        
        // Loooping through the asteroids
        for(int i = 0; i < asteroidY.length; i++){

            // Player Rectangle
            // playerRect = new Rectangle(player.getX(), player.getY(), 50, 48);
            
            // Asteroid Rectangle
            asteroidRect[i] = new Rectangle(asteroidX[i], asteroidY[i], 55, 55);
            playerRect = new Rectangle(playerX, playerY, 50, 50);
            
                    //shape.begin(ShapeRenderer.ShapeType.Line);
                    //shape.rect(player.getX(), player.getY(), 50, 50); // Play
                    //shape.rect(asteroidX[i], asteroidY[i], 60, 60); // quit
                    //shape.end();
            
            // If the collide
            if (asteroidRect[i].overlaps(playerRect)){
                collided = true;
            }
            
            // Restarting the for loop once it reaches the end of the array
            if (i == asteroidY.length){
                i = 0;
            } 
        }
        return collided;
    }
    
    // Update
    public void update(float deltaTime) {
                
            // Moving the background down by the assigned displacement
            this.backgroundY += backgroundDY;
            this.backgroundY2 += backgroundDY;
            this.backgroundY3 += backgroundDY;
            
            // Looping through the backgrounds
            // Looping the first background image
            if (this.backgroundY <= -450) {
                this.backgroundY = 900;   
                
            // Looping the second background image
            } else if (this.backgroundY2 <= -450) {
                this.backgroundY2 = 900;
                
            // Looping the third background image
            } else if (this.backgroundY3 <= -450) {
                this.backgroundY3 = 900;
            }
            
        ///////////////////
            
        // Player movement
        // If the right key is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            // Move right
            this.playerDX = 8;
            
        // If the left key is pressed
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // Move left
            this.playerDX = -8;
        
        // If no keys are pressed
        }else{
            // Stand still
            this.playerDX = 0;
        }
        
        // Moving the player
        this.playerX += this.playerDX;
        
        // Boundaries
        // Left side of the screen
        if (this.playerX <= 25){
            this.playerX = 25;
        }
        
        // Right side of the screen
        if (this.playerX > 710){
            this.playerX = 710;
        }
            
            ///////////////////

            checkCollision();
            
            // Looping through the asteroids
            for (int i = 0; i < asteroidY.length; i++) {

                // Making the asteroids fall
                asteroidY[i] += asteroidDY;

                // Restart the for loop
                if (i == asteroidY.length) {
                    // Resetting the i value
                    i = 0;
                }
                                    
                if (collided){
                    backgroundDY = 0;
                    asteroidDY = 0;
                    playerDX = 0;
                    playerX = 900;
                }
            }

            // Increasing the speed of the asteroids
            asteroidDY -= 0.0031; 
        
    }

    public void render(SpriteBatch batch) {
        // Draws the background
        batch.draw(background, backgroundX, backgroundY);
        batch.draw(background, backgroundX, backgroundY2);
        batch.draw(background, backgroundX, backgroundY3);
        
        BitmapFont font = new BitmapFont();

        // Drawing the array of asteroids
        for (int i = 0; i < asteroidY.length; i++) {
            // Draw the asteroids
            batch.draw(asteroid, asteroidX[i], asteroidY[i]);

            // Change while value once they reach the value
            if (asteroidY[i] <= -50) {
                asteroidY[i] = 650 + (75 * i);
                points++;
            }

            // Restart the for loop
            if (i == asteroidX.length) {
                i = 0;
            }
            
            if (collided){              
                    Gdx.gl.glClearColor(0, 0, 0, 1);
                    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                    
                    font.draw(batch, "ur score is " + points, 365, 300);
            }
        }
        
        // Draws the player
        batch.draw(spaceship, playerX, playerY);
        
        font.draw(batch, "" + points, 25, 575);
    }
}
