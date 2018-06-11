package com.quickmathstudios.dieelite.utillity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface State {

    public void Show();
    public void Render(SpriteBatch batch);
    public void Update(float delta);
    public void dispose();
    public boolean load();
}
