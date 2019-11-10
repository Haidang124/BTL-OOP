package sample;

public class NormalTower extends  Tower {
    public NormalTower(double x, double y) {
        super(new image("file:images\\2.png"), x, y, new Bullet(new image("file:images\\bullet.png"),100,10,72*2));
    }
}
