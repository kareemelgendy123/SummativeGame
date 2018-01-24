/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summative.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Kareem
 * @author Arvind
 */

public class Asteroids extends Game{
    
        // Instance variables
	private SpriteBatch batch;
	
	@Override
	public void create () {
            // Initialize the sprite batch
            batch = new SpriteBatch();
            // Create the main game screen we want to use
            MainGame game = new MainGame(this);
            // Set the screen to show it
            this.setScreen(game);
	}

	@Override
	public void render () {
            // This will automatically call render on the screen that is set
            super.render();
	}
	
	@Override
	public void dispose () {
            // Get rid of heavy variables
            batch.dispose();
	}
        
        public SpriteBatch getBatch(){
            // Returns the spritebatch so other screens can use it
            return batch;
        }
    }