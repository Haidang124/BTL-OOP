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

public class Bullet1 extends GameEntity {
   private Circle bullet = new Circle(5);
   private Line path = new Line();
   private int speed;
   private int dame;
   private int range;
    // getter setter


    public Bullet1( Color color,int x, int y, Line path, int speed, int dame, int range) {
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

    public void setPath(Line path) {
        this.path = path;
    }
    public void shoot (Stage stage,Enemy enemy)
    {
        Line line = new Line(0,0,72,72);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(300));
        pathTransition.setNode(bullet);
        pathTransition.setPath(line);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        Config.group.getChildren().add(bullet);
        if(Config.pane.getChildren().contains(Config.group)==false) Config.pane.getChildren().add(Config.group);
        stage.setScene(Config.scene);
        stage.show();
        if(enemy instanceof NormalEnemy)
        {
            enemy.getHealth().setBlood(enemy.getHealth().getBlood()-110+enemy.getArmor());
        }
        else if (enemy instanceof SmallerEnemy)
        {
            enemy.getHealth().setBlood(enemy.getHealth().getBlood()-110+enemy.getArmor());

        }
        else if (enemy instanceof TankerEnemy)
        {
            enemy.getHealth().setBlood(enemy.getHealth().getBlood()-110+enemy.getArmor());

        }
        if(enemy.getHealth().getBlood() <= 0) enemy.die();
        if(bullet.getCenterX() == 30) {
            System.out.println("den chua");
        }
    }
}
