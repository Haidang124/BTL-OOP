package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Stack;

public class Tower extends GameEntity {
    private Bullet bullet;
    private boolean enemyTarget=false;
    public static ArrayList<Enemy> arrayList = new ArrayList<>();
    private static  int count=0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Tower.count = count;
    }

    public boolean isEnemyTarget() {
        return enemyTarget;
    }

    public void setEnemyTarget(boolean enemyTarget) {
        this.enemyTarget = enemyTarget;
    }

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
    public static int getTarget ()
    {
        for(int i=0;i<count;i++)
        {
            //System.out.println(arrayList.get(i).isDanger()+" ");
            if(arrayList.get(i).isDanger()==true)
            {
               // System.out.println(i+" "+"getTarget");
                return i;
                //return arrayList.get(i);
            }
        }
        return -1;
    }
    public static void addTarget (Enemy enemy)
    {
      //  System.out.println(count);
        for(int i=0;i<count;i++)
        {
            if(arrayList.get(i)==enemy) return;
        }
        if(Tower.canShoot2(72*4.5, 72*4.5, 72*4,enemy)) {
            arrayList.add(enemy);
            enemy.setDanger(true);
            count++;
        }
        else
        {
            enemy.setDanger(false);
        }
        getTarget();
    }
    public static void addTarget1 (Enemy enemy)
    {
        if(enemy.getimage().getImageView() != null)
        {
            if(canShoot1(72*4.5,72*4.5,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5))
            {
                if(enemy.isDanger() == false) {
                    int index=-1;
                    int me=-1;
                    for(int i=0;i<count;i++)
                    {
                        if(arrayList.get(i).isDanger()==true)
                        {
                            index=i;
                        }
                        if(arrayList.get(i) == enemy)
                        {
                            me=i;
                        }
                    }
                    if(index == -1){
                        arrayList.add(enemy);
                        enemy.setDanger(true);
                        count++;
                    }
                    else
                    {
                        if(me > index)  arrayList.get(me).setDanger(true);
                    }

                }

            }
            else {
                for(int i=0;i<count;i++)
                {
                    if(arrayList.get(i) == enemy)
                    {
                        arrayList.get(i+1).setDanger(true);
                        arrayList.get(i).setDanger(false);
                    }
                }
            }
        }
    }
    public static void built()
    {

    }

    public void shoot(Stage stage ,Enemy enemy) throws NullPointerException
    {

        //Enemy enemy = enemyTarget(GameStage.stackEnemy,this);
       if(enemy.checkNull() == true) {
           Timeline timeline1 = new
                   Timeline(new KeyFrame(Duration.millis(1000),
                   (evt)->{
                      try {
                          if (this.canShoot(72 * 4.5, 72 * 4.5, 72 * 4, enemy.getimage().getImageView().getX() + 12.5, enemy.getimage().getImageView().getY() + 12.5)) {
                              //System.out.println(this.canShoot(72*4.5,72*4.5,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5));
                              // build tower
                              Bullet bullet3 = new Bullet(new image("file:images\\bullet.png"), 100, 100, 100);
                              bullet3.shoot(stage, 72 - 15, 72 + 30, enemy);
                               Bullet bullet4 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                               bullet4.shoot(stage,72*3-15,72*3,enemy);
                               Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                               bullet5.shoot(stage,72*4,72*1,enemy);
                          }
                      }
                      catch (NullPointerException e){};
                      }
           ));
           timeline1.setCycleCount(Animation.INDEFINITE);
           timeline1.play();
        }
    }
    public static boolean canShoot1(double x ,double y , double range,double x_target,double y_target)
    {
        double  distance = Math.sqrt((x-x_target)*(x-x_target)+(y-y_target)*(y-y_target));
        return distance < range;
    }
    public static boolean canShoot2(double x ,double y , double range,Enemy enemy)
    {
        double distance=0;
        if(enemy.getimage().getImageView() != null)   {
            distance = Math.sqrt((x-enemy.getimage().getImageView().getX())*(x-enemy.getimage().getImageView().getX())+(y-enemy.getimage().getImageView().getY())*(y-enemy.getimage().getImageView().getY()));
            return distance < range;
        }
       return false;
    }
    public boolean canShoot(double x ,double y , double range,double x_target,double y_target)
    {
        double  distance = Math.sqrt((x-x_target)*(x-x_target)+(y-y_target)*(y-y_target));
        return distance < range;
    }

}
