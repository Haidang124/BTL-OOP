package sample;

public class SniperTower extends Tower {
    public SniperTower(double x, double y) {
        super(new image("file:images\\3.png"), x, y, new Bullet(new image("file:images\\bullet.png"),100,30,72*3));
    }
}
