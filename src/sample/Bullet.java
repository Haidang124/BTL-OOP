package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Stack;

public class Bullet extends GameEntity {
    private Circle bullet = new Circle(5);
    private Line path = new Line();
    private int speed;
    private int dame;
    private double range;
    // getter setter


    public Bullet( Color color,int x, int y, Line path, int speed, int dame, double range) {
        super(null, x, y);
        bullet.setFill(color);
        this.path = path;
        this.speed = speed;
        this.dame = dame;
        this.range = range;
    }

    public Circle getBullet() {
        return bullet;
    }

    public void setBullet(Circle bullet) {
        this.bullet = bullet;
    }

    public Line getPath() {
        return path;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setPath(Line path) {
        this.path = path;
    }
    public void shoot (Stage stage,Enemy enemy)
    {
        //Line line = new Line(0,0,72,72);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(300));
        pathTransition.setNode(bullet);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        Config.group.getChildren().add(bullet);
        Timeline timeline = new
                Timeline(new KeyFrame(Duration.millis(300),
                (evt)->{
                    bullet.setFill(Color.TRANSPARENT);
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        if(Config.pane.getChildren().contains(Config.group)==false) Config.pane.getChildren().add(Config.group);
        stage.setScene(Config.scene);
        stage.show();
        if(enemy instanceof NormalEnemy)
        {
            enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
        }
        else if (enemy instanceof SmallerEnemy)
        {
            enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);

        }
        else if (enemy instanceof TankerEnemy)
        {
            enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);

        }
        if(enemy.getHealth().getBlood() <= 0)
        {
            if(enemy instanceof NormalEnemy)
            {
                Config.Money+=10;
                Config.labelMoney.setText(Config.Money+"");
            }
            else  if( enemy instanceof SmallerEnemy)
            {
                Config.Money+=5;
                Config.labelMoney.setText(Config.Money+"");
            }
            else if(enemy instanceof TankerEnemy)
            {
                Config.Money+=20;
                Config.labelMoney.setText(Config.Money+"");
            }
            enemy.die(stage);
        }
    }
}
