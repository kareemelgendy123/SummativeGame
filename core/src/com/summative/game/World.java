/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summative.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    
    // The player
    private final Player player;
    
    // Background Images
    private final float backgroundX; // X Coordinate of the backgrounds
    private float backgroundY; 
    private float backgroundY2;
    private float backgroundY3;

    // Creating an array of asteroids
    float[] asteroidX = new float[18];
    float[] asteroidY = new float[18];

    // Displacement of the background
    private final float backgroundDY;
    
    // Displacement of the asteroids
    private double asteroidDY;
    
    // Collision
    private boolean collided;
    
    // Game status
    private boolean status;
    
    // Points
    private int points;

    // Constructor
    public World() {
        
        // Creating new player
        player = new Player(375, 25);

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
        
        // Game status
        this.status = status;
        
        // Collision status
        this.collided = collided;

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
    
    // Update
    public void update(float deltaTime) {
        
        this.status = true;
        this.collided = false;

        // If status is true then
        if (status) {

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

            // Looping through the asteroids
            for (int i = 0; i < asteroidY.length; i++) {
                // Making the asteroids fall
                asteroidY[i] += asteroidDY; 
                // Checking for collisions
//                checkCollisions();

                // Restart the for loop
                if (i == asteroidY.length) {
                    // Resetting the i value
                    i = 0;
                }

            }
            // Increasing the speed of the asteroids
            asteroidDY = asteroidDY - 0.0031;
            
            // If collided
            if (collided = true){
                // Game status 
                status = false;
            }
        }  
    }

    public void render(SpriteBatch batch) {
        // Draws the background
        batch.draw(background, backgroundX, backgroundY);
        batch.draw(background, backgroundX, backgroundY2);
        batch.draw(background, backgroundX, backgroundY3);

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
        }
        BitmapFont font = new BitmapFont();
        font.draw(batch, "" + points, 25, 575);
    }
}
