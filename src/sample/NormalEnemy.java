package sample;

public class NormalEnemy extends Enemy {

    public NormalEnemy(int speed, int health, int armor, int bonus) {
         super(new image("file:enemy6.png"),speed,new Health(health),armor,bonus);
    }
}
