package com.quickmathstudios.dieelite.utillity.hit;

import com.badlogic.gdx.math.Vector2;

import javax.xml.bind.ValidationException;

public class HitBox implements Hitable {
    private Vector2 start;
    private Vector2 end;

    public HitBox(Vector2 cornerUL, Vector2 cornerOR){
        start = cornerUL;
        end = cornerOR;
    }

    @Override
    public boolean intersects(Vector2 curs) {
        return (curs.x > start.x && curs.x < end.x && curs.y > start.y && curs.y < end.y);
    }
}
