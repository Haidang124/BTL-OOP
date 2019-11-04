package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.Stack;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        /*image img = new image("file:3.jpg");
        img.show(primaryStage,scene,pane,50,50);*/
        GameField gameField = new GameField();
        gameField.loadMapfromfile("input.txt");
        gameField.loadImageMap();
        gameField.rendermap(primaryStage,0,0);
        GameStage gameStage = new GameStage(14);
        gameStage.loadArrayEnemy("arrEnemy.txt");
        /*Image image = new Image("file:blood.png");
        ImageView imageView = new ImageView(image);
        imageView = new ImageView(image);
        Config.pane.getChildren().add(imageView);
        imageView.setX(gameStage.x);
        imageView.setY(gameStage.y);
        primaryStage.setScene(Config.scene);
        primaryStage.show();*/
        /*Stack<String> stringStack = new Stack<>();
        stringStack.push("right");
        NormalEnemy normalEnemy = new NormalEnemy(100,100,100,100);
        normalEnemy.Run(primaryStage,0,gameStage.y,stringStack);*/

       Timeline timeline = new
                Timeline(new KeyFrame(Duration.millis(1000),
                (evt)->{
                    if(gameStage.stackEnemy.isEmpty() == false)
                    {
                        if(gameStage.stackEnemy.peek().equals("1"))
                        {
                            gameStage.stackEnemy.pop() ;
                            Stack<String> stringStack = new Stack<>();
                            stringStack.push("right");
                            TankerEnemy tankerEnemy = new TankerEnemy(100,100,100,100);
                            tankerEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                        else if(gameStage.stackEnemy.peek().equals("2"))
                        {
                            gameStage.stackEnemy.pop();
                            Stack<String> stringStack = new Stack<>();
                            stringStack.push("right");
                            SmallerEnemy smallerEnemy = new SmallerEnemy(100,100,100,100);
                            smallerEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                        else
                        {
                            if(gameStage.stackEnemy.peek().equals("3"))
                            {
                                gameStage.stackEnemy.pop();
                                Stack<String> stringStack = new Stack<>();
                                stringStack.push("right");
                                NormalEnemy normalEnemy = new NormalEnemy(100,100,100,100);
                                normalEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                            }
                        }
                    }

                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


    }


    public static void main(String[] args) {
        launch(args);
    }
}