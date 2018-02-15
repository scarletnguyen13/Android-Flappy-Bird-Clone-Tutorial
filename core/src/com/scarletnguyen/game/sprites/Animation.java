package com.scarletnguyen.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by user on 2017-08-28.
 */

public class Animation {

    private Array<TextureRegion> frames; //stores all of our frames
    private float maxFrameTime; // The time it takes a frame to stay in view (before we switch to the next one)
    private float currentFrameTime; // The time animation has been in the frame
    private int frameCount; //Number of frames in our animation
    private int frame; //current frame that we're actually in

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int a = 0; a < frameCount; a++) {
            frames.add(new TextureRegion(region, a * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount; //so each frame will get an equal portion
        frame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }

}
