package sample;

public class SniperTower extends Tower {
    public SniperTower(int x, int y) {
        super(new image("file:images\\SniperTower.png"), x, y, new Bullet(new image("file:images\\bullet1.png"),100,120,100));
    }
}
