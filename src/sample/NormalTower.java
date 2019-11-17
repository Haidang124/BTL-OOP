package sample;

import javafx.scene.paint.Color;

public class NormalTower extends  Tower {
    public NormalTower(int x, int y) {
        super(new image("file:images\\NormalTower.png"), x, y, new Bullet(Color.RED,x,y,null,100,120,72*2.5));
    }
}
