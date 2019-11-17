package sample;

import javafx.scene.paint.Color;

public class MachineGunTower extends  Tower {
    public MachineGunTower( int x, int y) {
        super(new image("file:images\\MGTower.png"), x, y, new Bullet(Color.YELLOW,x,y,null,100,120,72*2));
    }
}
