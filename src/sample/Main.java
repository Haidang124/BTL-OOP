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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
        Config.mediaPlayerBG.setVolume(0.2);
        if(Config.blSound==true) Config.mediaPlayerBG.play();
        Config.mediaPlayerBG.setAutoPlay(true);
        // background
        Config.imgbackground.showBG(primaryStage,0,0);
        Config.imgButtonExit.showBG(primaryStage,540,379);
        Config.imgButtonStart.showBG(primaryStage,76,370);

        Config.imgbackground.getImageView().setFocusTraversable(true);
        Config.imgButtonExit.getImageView().setFocusTraversable(true);
        Config.imgButtonStart.getImageView().setFocusTraversable(true);

        // Exit game
        Config.imgButtonExit.getImageView().setOnMouseDragged(mouseEvent -> {
            Config.mediaPlayerSL.play();
            primaryStage.close();
        });
        // startGame
        Config.imgButtonStart.getImageView().setOnMouseClicked(mouseEvent -> {
            Config.mediaPlayerSL.play();
            primaryStage.setX(70);
            primaryStage.setY(0);
            primaryStage.setResizable(false);


            // menu and sound
            Config.imgMenu.show(primaryStage,936,0);
            Config.imgSound.show(primaryStage,936,0);
            Config.imgPause.show(primaryStage,990,490);
            //heart
            Config.imgHeart1.show(primaryStage,944,370);
            Config.imgHeart2.show(primaryStage,944+44,370);
            Config.imgHeart3.show(primaryStage,944+44*2,370);
            Config.imgHeart4.show(primaryStage,944+44*3,370);
            Config.imgHeart5.show(primaryStage,944+44*4,370);

            //imgbuy
            Config.imgBuy1.show(primaryStage,960,260);
            Config.imgBuy2.show(primaryStage,1040,260);
            Config.imgBuy3.show(primaryStage,1120,260);

            // label
            Config.label1.setTranslateX(985);
            Config.label1.setTranslateY(123);
            Config.label1.setFont(Font.font("Cambria", 20));
            Config.label1.setTextFill(Color.web("#0076a3"));

            Config.label2.setTranslateX(985+80);
            Config.label2.setTranslateY(123);
            Config.label2.setFont(Font.font("Cambria", 20));
            Config.label2.setTextFill(Color.web("#0076a3"));

            Config.label3.setTranslateX(985+80*2);
            Config.label3.setTranslateY(123);
            Config.label3.setFont(Font.font("Cambria", 20));
            Config.label3.setTextFill(Color.web("#0076a3"));

            Config.labelMoney.setText(100+"");
            Config.labelMoney.setTranslateX(1040);
            Config.labelMoney.setTranslateY(295);
            Config.labelMoney.setFont(Font.font("Cambria", 44));
            Config.labelMoney.setTextFill(Color.YELLOW);

            Config.pane.getChildren().addAll(Config.label1,Config.label2,Config.label3,Config.labelMoney);
            Config.imgBuy1.getImageView().setOnMouseClicked(mouseEvent1 -> {
               if(Config.Money >=10)
               {
                   if(Config.blSound==true)
                   {
                       Config.mediaPlayerSL.stop();
                       Config.mediaPlayerSL.play();
                   }
                   Config.slTower1++;
                   Config.Money-=10;
                   Config.labelMoney.setText(Config.Money+"");
                   Config.label1.setText(Config.slTower1+"");
               }
            });
            Config.imgBuy2.getImageView().setOnMouseClicked(mouseEvent1 -> {
                if(Config.Money >=20)
                {
                    if(Config.blSound==true)
                    {
                        Config.mediaPlayerSL.stop();
                        Config.mediaPlayerSL.play();
                    }
                    Config.slTower2++;
                    Config.Money-=20;
                    Config.labelMoney.setText(Config.Money+"");
                    Config.label2.setText(Config.slTower2+"");
                }
            });
            Config.imgBuy3.getImageView().setOnMouseClicked(mouseEvent1 -> {
                if(Config.Money >=50)
                {
                    if(Config.blSound==true)
                    {
                        Config.mediaPlayerSL.stop();
                        Config.mediaPlayerSL.play();
                    }
                    Config.slTower3++;
                    Config.Money-=50;
                    Config.labelMoney.setText(Config.Money+"");
                    Config.label3.setText(Config.slTower3+"");
                }
            });


            Config.pane.setOnMouseClicked(mouseEvent1 ->
            {
                if(mouseEvent1.getSceneX() >=936 && mouseEvent1.getSceneX() <= 936+44 && mouseEvent1.getSceneY() >= 0 && mouseEvent1.getSceneY() <= 44)
                {
                    if(Config.blSound==true)
                    {
                       if(Config.pane.getChildren().contains(Config.imgNoSound.getImageView())) Config.pane.getChildren().remove(Config.imgNoSound.getImageView());
                        Config.imgNoSound.show(primaryStage,936,0);
//                        Config.mediaPlayerSL.stop();
//                        Config.mediaPlayerSL.play();
                        Config.blSound = false;
                        Config.mediaPlayerBG.stop();
                    }
                    else
                    {
                        if(Config.pane.getChildren().contains(Config.imgSound.getImageView())) Config.pane.getChildren().remove(Config.imgSound.getImageView());
                        {
                            Config.imgSound.show(primaryStage,936,0);
                            Config.blSound = true;
                            Config.mediaPlayerBG.stop();
                            Config.mediaPlayerBG.play();
                        }
                    }
                }
                else if(mouseEvent1.getSceneX() >=990 && mouseEvent1.getSceneX() <= 990+133 && mouseEvent1.getSceneY() >= 490 && mouseEvent1.getSceneY() <= 490+30)
                {
                    if(Config.blPause==false)
                    {
                        if(Config.blSound==true)
                        {
                            Config.mediaPlayerSL.stop();
                            Config.mediaPlayerSL.play();
                        }
                        if(Config.pane.getChildren().contains(Config.imgPause.getImageView())) Config.pane.getChildren().remove(Config.imgPause.getImageView());
                         Config.imgResume.show(primaryStage,990,490);
                         Config.blPause=true;
                    }
                    else
                    {
                        if(Config.blSound==true)
                        {
                            Config.mediaPlayerSL.stop();
                            Config.mediaPlayerSL.play();
                        }
                        if(Config.pane.getChildren().contains(Config.imgResume.getImageView())) Config.pane.getChildren().remove(Config.imgResume.getImageView());
                        Config.imgPause.show(primaryStage,990,490);
                        Config.blPause=false;
                    }
                }
            });
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
            Config.imgMenu.getImageView().setOnMouseClicked(mouseEvent1 -> {
                System.out.println(mouseEvent1.getSceneX()+" "+mouseEvent1.getSceneY());
                if(mouseEvent1.getSceneX() >=975 && mouseEvent1.getSceneX() <= 1135 && mouseEvent1.getSceneY() >= 535 && mouseEvent1.getSceneY() <= 570)
                {
                    if(Config.blSound==true)
                    {
                        Config.mediaPlayerSL.stop();
                        Config.mediaPlayerSL.play();
                    }
                   if(Config.blStart==false)
                   {
                       Config.mediaPlayerMinion.play();
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
                       Config.blStart=true;
                       timeline.setCycleCount(Animation.INDEFINITE);
                       timeline.play();
                   }
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