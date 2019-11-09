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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower Defense");
        // background
        Config.imgbackground.showBG(primaryStage,0,0);
        Config.imgButtonExit.showBG(primaryStage,540,379);
        Config.imgButtonStart.showBG(primaryStage,76,370);
        // Exit game
        Config.imgButtonExit.getImageView().setOnMouseClicked(mouseEvent -> {
            primaryStage.close();
        });
        // startGame
        Config.imgButtonStart.getImageView().setOnMouseClicked(mouseEvent -> {
            GameField gameField = new GameField();
            try
            {
                gameField.loadMapfromfile("input.txt");
            }
            catch (Exception e)
            {

            }
            gameField.loadImageMap();
            gameField.rendermap(primaryStage,0,0);
            GameStage gameStage = new GameStage(13);
            try {
                gameStage.loadArrayEnemy("arrEnemy.txt");
            }
            catch (Exception e) {}
            Stack<Enemy> newStack =gameStage.getStackEnemy();
            // show tower
            image image2 = new image("file:images\\SpinerTower.png");
            image2.show(primaryStage,72-15,72+30);
            image image = new image("file:images\\MGTower.png");
            image.show(primaryStage,72*3-15,72*3);
            image image1 = new image("file:images\\NormalTower.png");
            image1.show(primaryStage,72*4,72*1);
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(2000),
                    (evt)->{
                        Stack<String> stringStack = new Stack<>();
                        stringStack.push("right");
                        if(newStack.isEmpty() == false) {
                            newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                        image2.show(primaryStage,72-15,72+30);
                        image.show(primaryStage,72*3-15,72*3);
                        image1.show(primaryStage,72*4,72*1);
                    }
            ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });
    }
    public static void main(String[] args) {
        launch(args);

    }
}