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
        return (curs.x >= start.x && curs.x <= end.x && curs.y >= start.y && curs.y <= end.y);
    }

    public boolean intersects(HitBox other){
        return overlap1d(start.x,end.x,other.getUL().x,other.getOR().x)&&
                overlap1d(start.y,end.y,other.getUL().y,other.getOR().y);
    }

    private boolean overlap1d(float xmin1,float xmax1, float xmin2, float xmax2){
        return (xmax1 > xmin2) && (xmax2 >= xmin1);
    }

    public Vector2 getOR() {
        return end;
    }

    public Vector2 getUL() {
        return start;
    }
}
