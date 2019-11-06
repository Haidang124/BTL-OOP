package sample;

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Bullet extends GameEntity {
    Circle circle;
    int speed;
    int dame;
    int range;
    public Bullet(int speed, int dame, int range) {
        this.circle = new Circle(5);
        this.speed = speed;
        this.dame = dame;
        this.range = range;
        circle.setFill(Color.RED);
        image = new image("file:images\\enemy6.png");
        getChildren().addAll(circle,image);
    }
    public void shoot (Stage stage, double x , double y, double x_target, double y_target)
    {
        //Double distance = Math.sqrt((x_target-x)*(x_target-x) +(y_target-y)*(y_target-y));
        circle.setFill(Color.BLUE);
        image = new image("file:images\\enemy6.png");
        Path path = new Path();
        MoveTo moveTo = new MoveTo(x, y);
        LineTo line1 = new LineTo(x_target, y_target);
        //getElements
        path.getElements().add(moveTo);
        path.getElements().addAll(line1);
        //PathTransition
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(circle);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(100);

        //Setting auto reverse value to true
        pathTransition.setAutoReverse(false);
        //Playing the animation
        pathTransition.play();

        Config.group.getChildren().add(circle);
        Config.pane.getChildren().add(Config.group);
        stage.setScene(Config.scene);
        stage.show();

    }
}
