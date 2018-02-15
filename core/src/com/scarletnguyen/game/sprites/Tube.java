package com.scarletnguyen.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import java.util.*;

/**
 * Created by user on 2017-08-28.
 */

public class Tube {
    public static final int TUBE_WIDTH = 52;

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100; //Diffrence between the top and bottom tube (middle gap)
    private static final int LOWEST_OPENING = 120;

    private Texture topTube, bottomTube;
    private Vector2 postTopTube, postBotTube;
    private Rectangle boundsTop, boundsBot;
    private Random rand;

    public Tube(float x) {
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();

        postTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        postBotTube = new Vector2(x, postTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(postTopTube.x, postTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(postBotTube.x, postBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPostTopTube() {
        return postTopTube;
    }

    public Vector2 getPostBotTube() {
        return postBotTube;
    }

    public void reposition(float x) {
        postTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        postBotTube.set(x, postTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(postTopTube.x, postTopTube.y);
        boundsBot.setPosition(postBotTube.x, postBotTube.y);
    }

    public boolean collide(Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();
    }
}
