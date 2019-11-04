package sample;

public class TankerEnemy extends Enemy {

    public TankerEnemy(int speed, int health, int armor, int bonus) {
         super(new image("file:images\\superEnemy.png"),speed, new Health(health),armor,bonus);
    }
}
