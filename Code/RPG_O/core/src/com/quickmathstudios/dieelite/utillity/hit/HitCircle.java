package com.quickmathstudios.dieelite.utillity.hit;

import com.badlogic.gdx.math.Vector2;

public class HitCircle implements Hitable{
    private float radius;
    private Vector2 center;

    public HitCircle(Vector2 c, float r){
        center = c;
        radius = r;
    }


    @Override
    public boolean intersects(Vector2 curs) {
        return center.dst(curs) < radius;
    }
}
