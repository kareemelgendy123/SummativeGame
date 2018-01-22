/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summative.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.Graphics2D;

/**
 *
 * @author Kareem
 */
public class World {

    // Instance variables
    // Sprite Batch
    private SpriteBatch batch;
    private Texture background;
    private Texture asteroid;
    
    // First Background Image Coordinates
    private float backgroundX;
    private float backgroundY;
    
    // Second Background Image Coordinates
    private float backgroundX2;
    private float backgroundY2;

    // Creating an arry of asteroids
    float[] asteroidX = new float[14];
    float[] asteroidY = new float[14];

    // Displacement - Alien and Asteroids
    private float dx;
    private float dy;

    public World() {
        // First background image
        this.backgroundX = 0;
        this.backgroundY = 0;

        // Second background image
        this.backgroundX2 = 0;
        this.backgroundY2 = 450;

        // Displacement of Y
        this.dy = -2;

        // Getting the images
        background = new Texture("background.png"); // Background
        asteroid = new Texture("asteroid.png"); // Asteroid

        // Generating coordinates for the array of asteroids
        for (int i = 0; i < asteroidX.length; i++) {
            asteroidX[i] = (int) (Math.random() * 625 + 50);
            asteroidY[i] = 650 + (75 * i);

        }

    }

    public void update(float deltaTime) {

        // Boolean variable for the status of the game
        boolean status = true;

        // If status is true then
        if (status) {

            // Moving background down
            this.backgroundY += dy;
            this.backgroundY2 += dy;

            // Looping the first background image
            if (this.backgroundY <= -450) {
                this.backgroundY = 450;

            // Looping the second background image
            } else if (this.backgroundY2 <= -450) {
                this.backgroundY2 = 450;
            }

            // Looping the asteroids
            for (int i = 0; i < asteroidY.length; i++) {
                asteroidY[i] += dy;

                // Restard the for loop
                if (i == asteroidY.length) {
                    i = 0;
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        // Draws the background
        batch.draw(background, backgroundX, backgroundY);
        batch.draw(background, backgroundX2, backgroundY2);

        // Drawing the array of asteroids
        for (int i = 0; i < asteroidY.length; i++) {
            // Draw the asteroids
            batch.draw(asteroid, asteroidX[i], asteroidY[i]);

            // Change while value once they reach the value
            if (asteroidY[i] <= -50) {
                asteroidY[i] = 650 + (75 * i);
            }

            // Restart the for loop
            if (i == asteroidX.length) {
                i = 0;
            }
        }
    }
}
