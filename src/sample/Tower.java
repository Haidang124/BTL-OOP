package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Stack;

public class Tower extends GameEntity {
    Bullet bullet;
    public Tower(sample.image image, Bullet bullet) {
        super(image);
        this.bullet = bullet;
    }
    // getter && setter
    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Tower(sample.image image, int x, int y, Bullet bullet) {
        super(image, x, y);
        this.bullet = bullet;
    }

    // Method
    /*public double findTargetX(Enemy enemy)
    {
          return enemy.getimage().getImageView().getX();
    }
    public double findTargetY (Enemy enemy)
    {
        return enemy.getimage().getImageView().getY();
    }*/
    public void shoot(Stage stage ,Enemy enemy)
    {

        Timeline timeline1 = new
                Timeline(new KeyFrame(Duration.millis(1000),
                (evt)->{
                    if(this.canShoot(72*4,72*2,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5))
                    {
                        System.out.println(this.canShoot(72*4,72*2,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5));
                        Bullet bullet3 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                        bullet3.shoot(stage,72*4,72*2,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5);
                    }
                }
        ));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
    }
    public boolean canShoot(double x ,double y , double range,double x_target,double y_target)
    {
        double  distance = Math.sqrt((x-x_target)*(x-x_target)+(y-y_target)*(y-y_target));
        return distance < range;
    }

}
