package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.Stack;

public class Bullet extends GameEntity {
    private int speed;
    private int dame;
    private int range;

    public Bullet(image img, int speed, int dame, int range) {
        this.image = img;
        this.speed = speed;
        this.dame = dame;
        this.range = range;
    }

    // getter setter
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    // method
    public boolean shoot(Stage stage, double x, double y, Enemy enemy)
    {
        double x_target = enemy.getimage().getImageView().getX();
        double y_target = enemy.getimage().getImageView().getY();
       /* double k =Math.abs(x-x_target)/200;
        image.show(stage,x,y);
        if(y != y_target) {
            double angle =Math.abs((x-x_target)/(y-y_target));
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        System.out.println(image.getImageView().getX()+" "+image.getImageView().getY());
                        if(image.getImageView().getX() < x_target)
                        {
                            image.getImageView().setX(image.getImageView().getX()+k);
                            if(y < y_target) image.getImageView().setY(image.getImageView().getY()+(k/angle));
                            else if(y > y_target)image.getImageView().setY(image.getImageView().getY()-(k/angle));
                        }
                        else if(image.getImageView().getX() > x_target)
                        {
                            image.getImageView().setX(image.getImageView().getX()-k);
                            if(y < y_target) image.getImageView().setY(image.getImageView().getY()+(k/angle));
                            else if(y > y_target) image.getImageView().setY(image.getImageView().getY()-(k/angle));
                        }
                        else {
                            if(image.getImageView().getY() < y_target) image.getImageView().setY(image.getImageView().getY()+k);
                            else if(image.getImageView().getY() > y_target) image.getImageView().setY(image.getImageView().getY()-k);
                        }

                    }
            ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
        else {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(4*Math.sqrt(2)),
                    (evt)->{
                        if((Math.round(image.getImageView().getX()*100000)/10000)==x_target && (Math.round(image.getImageView().getY()*100000)/10000)==y_target)  image.remote();
                        if(image.getImageView().getX() < x_target)  image.getImageView().setX(image.getImageView().getX()+k);
                        else if(image.getImageView().getX() > x_target)  image.getImageView().setX(image.getImageView().getX()-k);
                    }
            ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
        System.out.println("dang");*/
        int k=0;
        if(x < x_target && y  > y_target) k=9;
        else if(x < x_target && y  < y_target) k=3;
        else if(x > x_target && y  > y_target) k=7;
        else if(x > x_target && y  < y_target) k=1;
        else if(x == x_target && y  > y_target) k=8;
        else if(x == x_target && y  < y_target) k=2;
        else if(x < x_target && y  == y_target) k=6;
        else if(x > x_target && y  == y_target) k=4;
        double distance =Math.abs(x-x_target)/150;
        double angle =Math.abs((x-x_target)/(y-y_target));
        image.show(stage,x,y);
        if(k==3)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                            if(image.getImageView().getX() >= x_target && image.getImageView().getY()  >= y_target ) {
                                image.remote();
                                if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                                else enemy.die(stage);
                                return;
                            }
                            image.getImageView().setX(image.getImageView().getX()+distance);
                            image.getImageView().setY(image.getImageView().getY()+(distance/angle));
                        }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==9)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if(image.getImageView().getX() >= x_target && image.getImageView().getY() <= y_target ) {
                            image.remote();
                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                            else enemy.die(stage);
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()+distance);
                        image.getImageView().setY(image.getImageView().getY()-(distance/angle));
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==7)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if(image.getImageView().getX() <= x_target && image.getImageView().getY() <= y_target ) {
                            image.remote();
                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                            else enemy.die(stage);
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()-distance);
                        image.getImageView().setY(image.getImageView().getY()-(distance/angle));
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==1)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if(image.getImageView().getX() <= x_target && image.getImageView().getY() >= y_target ) {
                            image.remote();
                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                            else enemy.die(stage);
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()-distance);
                        image.getImageView().setY(image.getImageView().getY()+(distance/angle));
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==8)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getY() <= y_target ) {
                            image.remote();
                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                            else enemy.die(stage);
                            return;
                        }
                        image.getImageView().setY(image.getImageView().getY()-distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==2)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getY() >= y_target ) {
                            image.remote();
                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                            else enemy.die(stage);
                            return;
                        }
                        image.getImageView().setY(image.getImageView().getY()+distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==6)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getX() >= x_target ) {
                            image.remote();
                           if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
                           else enemy.die(stage);

                        }
                        image.getImageView().setX(image.getImageView().getX()+distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==4)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getX() <= x_target ) {
                            image.remote();
                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-10);
                            else enemy.die(stage);
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()-distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        return false;
    }
    public boolean shoot1(Stage stage, double x, double y,  double x_target, double y_target)
    {
        int k=0;
        if(x < x_target && y  > y_target) k=9;
        else if(x < x_target && y  < y_target) k=3;
        else if(x > x_target && y  > y_target) k=7;
        else if(x > x_target && y  < y_target) k=1;
        else if(x == x_target && y  > y_target) k=8;
        else if(x == x_target && y  < y_target) k=2;
        else if(x < x_target && y  == y_target) k=6;
        else if(x > x_target && y  == y_target) k=4;
        double distance =Math.abs(x-x_target)/150;
        double angle =Math.abs((x-x_target)/(y-y_target));
        image.show(stage,x,y);
        if(k==3)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                            if(image.getImageView().getX() >= x_target && image.getImageView().getY()  >= y_target ) {
                                image.remote();
//                                if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                                else enemy.die();
                                return;
                            }
                            image.getImageView().setX(image.getImageView().getX()+distance);
                            image.getImageView().setY(image.getImageView().getY()+(distance/angle));
                        }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==9)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if(image.getImageView().getX() >= x_target && image.getImageView().getY() <= y_target ) {
                            image.remote();
//                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                            else enemy.die();
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()+distance);
                        image.getImageView().setY(image.getImageView().getY()-(distance/angle));
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==7)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if(image.getImageView().getX() <= x_target && image.getImageView().getY() <= y_target ) {
                            image.remote();
//                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                            else enemy.die();
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()-distance);
                        image.getImageView().setY(image.getImageView().getY()-(distance/angle));
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==1)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if(image.getImageView().getX() <= x_target && image.getImageView().getY() >= y_target ) {
                            image.remote();
//                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                            else enemy.die();
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()-distance);
                        image.getImageView().setY(image.getImageView().getY()+(distance/angle));
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==8)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getY() <= y_target ) {
                            image.remote();
//                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                            else enemy.die();
                            return;
                        }
                        image.getImageView().setY(image.getImageView().getY()-distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==2)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getY() >= y_target ) {
                            image.remote();
//                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                            else enemy.die();
                            return;
                        }
                        image.getImageView().setY(image.getImageView().getY()+distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==6)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getX() >= x_target ) {
                            image.remote();
//                           if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-5);
//                           else enemy.die();
                        }
                        image.getImageView().setX(image.getImageView().getX()+distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        else if(k==4)
        {
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
                        if( image.getImageView().getX() <= x_target ) {
                            image.remote();
//                            if(enemy.getHealth().getBlood() != 0) enemy.getHealth().setBlood(enemy.getHealth().getBlood()-10);
//                            else enemy.die();
                            return;
                        }
                        image.getImageView().setX(image.getImageView().getX()-distance);
                    }
            ));
            timeline.setCycleCount(155);
            timeline.play();
        }
        return false;
    }
}


