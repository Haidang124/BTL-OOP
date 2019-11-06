package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.Iterator;
import java.util.Stack;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower Defense");
        GameField gameField = new GameField();
        gameField.loadMapfromfile("input.txt");
        gameField.loadImageMap();
        gameField.rendermap(primaryStage,0,0);
        GameStage gameStage = new GameStage(13);
        gameStage.loadArrayEnemy("arrEnemy.txt");

        Bullet bullet2 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
        Tower tower = new Tower(null,bullet2);

        Circle path = new Circle(72*4, 72*2, 72*4);
        path.setFill(null);
        path.setStroke(Color.RED);
        Config.group.getChildren().add(path);
        Config.pane.getChildren().add(Config.group);
        primaryStage.setScene(Config.scene);
        primaryStage.show();

        Stack<Enemy> newStack =gameStage.getStackEnemy();
        Stack<String> stringStack1 = new Stack<>();
        stringStack1.push("right");
        NormalEnemy normalEnemy = new NormalEnemy();
        normalEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack1);
        Timeline timeline = new
                Timeline(new KeyFrame(Duration.millis(4000),
                (evt)->{
                        Stack<String> stringStack = new Stack<>();
                        stringStack.push("right");
                        if(newStack.isEmpty() == false) newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        //if(tower.canShoot(72*4,72*2,72*2,normalEnemy.getimage().getImageView().getX(),normalEnemy.getimage().getImageView().getY())) bullet2.shoot(primaryStage,72*4,72*2,bullet2.findTargetX(normalEnemy),bullet2.findTargetY(normalEnemy));

                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        //bullet2.shoot(primaryStage,72*4,72*2,normalEnemy.getimage().getImageView().getX(),normalEnemy.getimage().getImageView().getY());
        //if(tower.canShoot(72*4,72*2,72*4,normalEnemy.getimage().getImageView().getX()+12.5,normalEnemy.getimage().getImageView().getY()+12.5)==true) tower.shoot(primaryStage,normalEnemy);
        tower.shoot(primaryStage,normalEnemy);

    }


    public static void main(String[] args) {
        launch(args);

    }
}