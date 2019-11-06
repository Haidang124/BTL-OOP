package sample;

public class TankerEnemy extends Enemy {

    public TankerEnemy() {
         super(new image("file:images\\superEnemy.png"),100, new Health(100),100,100);
    }
}
