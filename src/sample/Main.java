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

        Stack<String> stringStack1 = new Stack<>();
        stringStack1.push("right");
        TankerEnemy tankerEnemy1 = new TankerEnemy();
        tankerEnemy1.Run(primaryStage,gameStage.x,gameStage.y,stringStack1);



       /* Timeline timeline = new
                Timeline(new KeyFrame(Duration.millis(10000),
                (evt)->{
                  //  Bullet1 bullet2 = new Bullet1(new image("file:images\\bullet.png"),100,100,100);
                   // bullet2.shoot(primaryStage,0,0,gameStage.stackEnemy1.peek().getimage().getImageView().getX(),gameStage.stackEnemy1.peek().getimage().getImageView().getY());

                    if(gameStage.stackEnemy.isEmpty() == false)
                    {

                        if(gameStage.stackEnemy.peek().equals("1"))
                        {
                            gameStage.stackEnemy.pop() ;
                            Stack<String> stringStack = new Stack<>();
                            stringStack.push("right");
                            TankerEnemy tankerEnemy = new TankerEnemy();
                            tankerEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                        else if(gameStage.stackEnemy.peek().equals("2"))
                        {
                            gameStage.stackEnemy.pop();
                            Stack<String> stringStack = new Stack<>();
                            stringStack.push("right");
                            SmallerEnemy smallerEnemy = new SmallerEnemy();
                            smallerEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                        else
                        {
                            if(gameStage.stackEnemy.peek().equals("3"))
                            {
                                gameStage.stackEnemy.pop();
                                Stack<String> stringStack = new Stack<>();
                                stringStack.push("right");
                                NormalEnemy normalEnemy = new NormalEnemy();
                                normalEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                            }
                        }
                    }

                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/

    }


    public static void main(String[] args) {
        launch(args);

    }
}