package sample;

public class NormalTower extends  Tower {
    public NormalTower(int x, int y) {
        super(new image("file:images\\NormalTower.png"), x, y, new Bullet(new image("file:images\\bullet.png"),100,120,100));
    }
}
