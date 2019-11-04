package sample;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy(int speed, int health, int armor, int bonus) {
        super(new image("file:images\\Enemy8.png"),speed,new Health(health),armor,bonus);
    }
}
