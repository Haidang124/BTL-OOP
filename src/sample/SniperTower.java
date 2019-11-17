package sample;

import javafx.scene.paint.Color;

public class SniperTower extends Tower {
    public SniperTower(int x, int y) {
        super(new image("file:images\\SniperTower.png"), x, y, new Bullet(Color.BLUE,x,y,null,100,120,72*3));
    }
}
