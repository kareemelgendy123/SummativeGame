package com.summative.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
        private float x;
        private float y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                // placing an image of a spaceship for the player 
		img = new Texture("spaceship.png");
                x = 25;
                y = 25;
	}

	@Override
	public void render () {
            
                            // If statements for keys pressed
                // Once right key pressed, player moves at a speed of 5 units to the right 
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                    x = x + 5; 
                    
                // Once left key is pressed, 
                } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                    x = x - 5;        
                }        
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
