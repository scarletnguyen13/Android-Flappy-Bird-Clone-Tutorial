package com.scarletnguyen.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by user on 2017-08-28.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse; //Vector3 is an XYZ Coordinate system
    protected GameStateManager gsm;

    //Instructor
    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt); //dt = delta time --> Delta time: differences between 1 frame rendered and the next frame rendered
    public abstract void render(SpriteBatch sb); //sb = spritebatch --> SpriteBatch: a container for everything that we need to render to the screen (texture, etc.)
    public abstract void dispose();
}
