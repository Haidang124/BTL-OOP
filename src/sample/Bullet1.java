package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Bullet1 extends GameEntity {
    private int speed;
    private int dame;
    private int range;

    public Bullet1(image img, int speed, int dame, int range) {
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
    public void shoot(Stage stage, double x, double y, double x_target, double y_target)
    {
        double k =Math.abs(x-x_target)/75;
        image.show(stage,x,y);
        if(y != y_target) {
            double angle =Math.abs((x-x_target)/(y-y_target));
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(3),
                    (evt)->{
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
                        if(image.getImageView().getX() < x_target)  image.getImageView().setX(image.getImageView().getX()+k);
                        else if(image.getImageView().getX() > x_target)  image.getImageView().setX(image.getImageView().getX()-k);
                    }
            ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }
}
