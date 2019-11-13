package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.zip.CheckedOutputStream;
import java.util.*;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower Defense");
        // background
        Config.imgbackground.showBG(primaryStage,0,0);
        Config.imgButtonExit.showBG(primaryStage,540,379);
        Config.imgButtonStart.showBG(primaryStage,76,370);

        Config.imgbackground.getImageView().setFocusTraversable(true);
        Config.imgButtonExit.getImageView().setFocusTraversable(true);
        Config.imgButtonStart.getImageView().setFocusTraversable(true);

        // Exit game
        Config.imgButtonExit.getImageView().setOnMouseEntered(mouseEvent -> {
            primaryStage.close();
        });
        // startGame
        Config.imgButtonStart.getImageView().setOnMouseClicked(mouseEvent -> {
            primaryStage.setX(70);
            primaryStage.setY(30);
            primaryStage.setResizable(false);
            Config.imgMenu.show(primaryStage,936,0);
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
            Tower.towerSpawn(primaryStage);
//            Stack<String> stringStack = new Stack<>();
//            stringStack.push("right");
//            NormalEnemy normalEnemy = new NormalEnemy();
//            normalEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack);
            Config.imgMenu.getImageView().setOnMouseClicked(mouseEvent1 -> {
               // System.out.println(mouseEvent1.getSceneX()+" "+mouseEvent1.getSceneY());
                if(mouseEvent1.getSceneX() >=975 && mouseEvent1.getSceneX() <= 1135 && mouseEvent1.getSceneY() >= 535 && mouseEvent1.getSceneY() <= 570)
                {
                    Timeline timeline = new
                            Timeline(new KeyFrame(Duration.millis(2000),
                        (evt)->{
                            Stack<String> stringStack = new Stack<>();
                            stringStack.push("right");
                            if(newStack.isEmpty() == false) {
                                System.out.println(GameStage.stackEnemy.size()+"  "+GameStage.enemyArrayList.size());
                                newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                            }
                        }
                      ));
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                }
                });
            });

//        AnimationTimer animationTimer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                //System.out.println(GameEntity.towerArrayList.size()+"  dang");
//                for(int i=0;i<GameEntity.towerArrayList.size();i++)
//                {
//                    GameEntity.towerArrayList.get(i).getimage().show(primaryStage,GameEntity.towerArrayList.get(i).getx(),GameEntity.towerArrayList.get(i).gety());
//                }
//            }
//        };
//        animationTimer.start();
        Timeline timeline2 = new
                Timeline(new KeyFrame(Duration.millis(500),
                (evt)->{
                        for(int i=0;i<GameEntity.towerArrayList.size();i++)
                        {
                            GameEntity.towerArrayList.get(i).findTarget(primaryStage);
                        }
                    }
        ));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }
    public static void main(String[] args) {
        launch(args);

    }
}