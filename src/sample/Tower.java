package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Tower extends GameEntity {
    private Bullet bullet;
   // private Bullet bullet;
    private boolean enemyTarget=false;
    public static ArrayList<Enemy> arrayList = new ArrayList<>();
    private static  int count=0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Tower.count = count;
    }

    public boolean isEnemyTarget() {
        return enemyTarget;
    }

    public void setEnemyTarget(boolean enemyTarget) {
        this.enemyTarget = enemyTarget;
    }

    public Tower(sample.image image, Bullet bullet) {
        super(image);
        this.bullet = bullet;

    }
    // getter && setter
    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Tower(sample.image image, int x, int y, Bullet bullet) {
        super(image, x, y);
        this.bullet = bullet;
    }
    public static void build(Stage stage,int x, int y,int type)
    {
        if(type ==1)
        {
            MachineGunTower machineGunTower = new MachineGunTower(x,y);
            GameEntity.towerArrayList.add(machineGunTower);
            machineGunTower.getimage().show(stage, x - (machineGunTower.getimage().getImage().getWidth()-Config.sizeimageMap),
                    y - (machineGunTower.getimage().getImage().getHeight()-Config.sizeimageMap));
            Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                    72*2, Color.color(0.192, 0.192, 0.192, 0.1));
            Config.pane.getChildren().add(circle);
//            Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(2.5),
//                        event -> { Config.pane.getChildren().remove(circle); }));
//            timeline.setCycleCount(Animation.INDEFINITE);
//            timeline.play();
        }
        else if(type ==2)
        {
            NormalTower normalTower = new NormalTower(x,y);
            GameEntity.towerArrayList.add(normalTower);
            normalTower.getimage().show(stage, x - (normalTower.getimage().getImage().getWidth()-Config.sizeimageMap),
                    y - (normalTower.getimage().getImage().getHeight()-Config.sizeimageMap));
            Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                    72*2.5, Color.color(0.192, 0.192, 0.192, 0.1));
            Config.pane.getChildren().add(circle);
//            Timeline timeline = new Timeline(
//                    new KeyFrame(Duration.seconds(2.5),
//                            event -> { Config.pane.getChildren().remove(circle); }));
//            timeline.setCycleCount(Animation.INDEFINITE);
//            timeline.play();
        }
        else
        {
            SniperTower sniperTower = new SniperTower(x,y);
            GameEntity.towerArrayList.add(sniperTower);
            sniperTower.getimage().show(stage, x - (sniperTower.getimage().getImage().getWidth()-Config.sizeimageMap),
                    y - (sniperTower.getimage().getImage().getHeight()-Config.sizeimageMap));
            Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                    72*3, Color.color(0.192, 0.192, 0.192, 0.1));
            Config.pane.getChildren().add(circle);
//            Timeline timeline = new Timeline(
//                    new KeyFrame(Duration.seconds(2.5),
//                            event -> { Config.pane.getChildren().remove(circle); }));
//            timeline.setCycleCount(Animation.INDEFINITE);
//            timeline.play();
        }
    }
    public void findTarget(Stage primaryStage)
    {
        for(int i=GameStage.enemyArrayList.size()-1;i>=0;i--)
        {
            if(Tower.canShoot2(this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,this.getBullet().getRange(),GameStage.enemyArrayList.get(i)))
            {
                if(this instanceof NormalTower)
                {
                    Line line = new Line(this.getx()+Config.sizeimageMap/2-24,this.gety()+Config.sizeimageMap/2-70,GameStage.enemyArrayList.get(i).getimage().getImageView().getX()+25,GameStage.enemyArrayList.get(i).getimage().getImageView().getY()+25);
                    bullet = new Bullet(Color.BLUE,this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,line,100,100,this.getBullet().getRange());
                    bullet.shoot(primaryStage,GameStage.enemyArrayList.get(i));
                }
                else if(this instanceof MachineGunTower)
                {
                    Line line = new Line(this.getx()+Config.sizeimageMap/2-20,this.gety()+Config.sizeimageMap/2-50,GameStage.enemyArrayList.get(i).getimage().getImageView().getX()+25,GameStage.enemyArrayList.get(i).getimage().getImageView().getY()+25);
                    bullet = new Bullet(Color.BLUE,this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,line,100,100,this.getBullet().getRange());
                    bullet.shoot(primaryStage,GameStage.enemyArrayList.get(i));
                }
                else if(this instanceof SniperTower)
                {
                    Line line = new Line(this.getx()+Config.sizeimageMap/2-12,this.gety()+Config.sizeimageMap/2-40,GameStage.enemyArrayList.get(i).getimage().getImageView().getX()+25,GameStage.enemyArrayList.get(i).getimage().getImageView().getY()+25);
//                line.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
//                if(Config.pane.getChildren().contains(line) == false) Config.pane.getChildren().add(line);
//                else {
//                    System.out.println(123);
//                    Config.pane.getChildren().remove(line);
//                }
                    bullet = new Bullet(Color.BLUE,this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,line,100,100,this.getBullet().getRange());
                    bullet.shoot(primaryStage,GameStage.enemyArrayList.get(i));
                }
                return;
            }
        }
    }
//    public void towerBuild (Stage stage){
//        GameEntity.towerArrayList.add(this);
//        image.show(stage, this.x - (image.getImage().getWidth()-Config.sizeimageMap),
//                this.y - (image.getImage().getHeight()-Config.sizeimageMap));
//
//        Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
//                72*2, Color.color(0.192, 0.192, 0.192, 0.1));
//        Config.pane.getChildren().add(circle);
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(2.5),
//                        event -> { Config.pane.getChildren().remove(circle); }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//    }
    public static boolean canShoot2(double x ,double y , double range,Enemy enemy)
    {
        double distance=0;
        if(enemy.isSurvive() ==true)   {
            if(enemy.getimage().getImageView() != null) {
                distance = Math.sqrt((x - enemy.getimage().getImageView().getX()-25) * (x - enemy.getimage().getImageView().getX()-25) + (y - enemy.getimage().getImageView().getY()-25) * (y - enemy.getimage().getImageView().getY()-25));
                return distance < range;
            }
        }
        return false;
    }
    public static void buy(Stage primaryStage)
    {
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

    }
    public static void towerSpawn(Stage primaryStage){
            Config.pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            Image towerMenu = new Image("file:images\\selTower.png");
            ImageView menuView = new ImageView(towerMenu);
            Image delete = new Image("file:images\\delete.png");
            ImageView deleteview = new ImageView(delete);

            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown()) {
                    Config.x_pos = ((int) event.getX() / Config.sizeimageMap) * Config.sizeimageMap;
                    Config.y_pos = ((int) event.getY() / Config.sizeimageMap) * Config.sizeimageMap;
                   // System.out.println(Config.x_pos + " " + Config.y_pos + " " + GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]);

                    if(event.getSceneX() <=936 && event.getSceneX() >=0)
                    {
                        if (GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) {
                            menuView.setFitHeight(70);
                            menuView.setFitWidth(120);
                            menuView.setX(Config.x_pos - Config.sizeimageMap / 2);
                            menuView.setY(Config.y_pos - (menuView.getFitHeight() / 2));
                            try {
                                Config.pane.getChildren().add(menuView);
                            } catch (IllegalArgumentException e) {
                            }

                            Config.pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                @Override
                                public void handle(KeyEvent event) {
                                    if (event.getCode() == KeyCode.DIGIT2) {
                                        if (Config.slTower2 >0)
                                        {
                                            Config.pane.getChildren().remove(menuView);
                                            if(GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) Tower.build(primaryStage,Config.x_pos, Config.y_pos,2);
                                            GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]="0";
                                            Config.slTower2--;
                                            Config.label2.setText(Config.slTower2+"");
                                        }
                                    }
                                    if (event.getCode() == KeyCode.DIGIT3) {
                                        if(Config.slTower3 > 0)
                                        {
                                            Config.pane.getChildren().remove(menuView);
                                            if(GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) Tower.build(primaryStage,Config.x_pos, Config.y_pos,3);
                                            GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]="0";
                                            Config.slTower3--;
                                            Config.label3.setText(Config.slTower3+"");
                                        }
                                    }
                                    if (event.getCode() == KeyCode.DIGIT1) {
                                        if(Config.slTower1 > 0)
                                        {
                                            Config.pane.getChildren().remove(menuView);
                                            if(GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) Tower.build(primaryStage,Config.x_pos, Config.y_pos,1);
                                            GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]="0";
                                            Config.slTower1--;
                                            Config.label1.setText(Config.slTower1+"");
                                        }
                                    }
                                    if(event.getCode()== KeyCode.ESCAPE)
                                    {
                                        Config.pane.getChildren().remove(menuView);
                                    }
                                }
                            });
                        }
//                        else  if (GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("0"))
//                        {
//                            deleteview.setFitHeight(70);
//                            deleteview.setFitWidth(120);
//                            deleteview.setX(Config.x_pos - Config.sizeimageMap / 2);
//                            deleteview.setY(Config.y_pos - (deleteview.getFitHeight() / 2));
//                            try {
//                                Config.pane.getChildren().add(deleteview);
//                            } catch (IllegalArgumentException e) {
//                            }
//
//                            Config.pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
//                                @Override
//                                public void handle(KeyEvent event) {
//                                    if (event.getCode() == KeyCode.DIGIT1) {
//                                        for(int i=0;i<GameEntity.towerArrayList.size();i++)
//                                        {
//                                           if(GameEntity.towerArrayList.get(i).getimage().getImageView())
//                                        }
//                                        Config.pane.getChildren().remove(deleteview);
//                                    }
//                                    if(event.getCode()== KeyCode.ESCAPE)
//                                    {
//                                        Config.pane.getChildren().remove(deleteview);
//                                    }
//                                }
//                            });
//                        }
                    }
                }
            }
        });

    }

}
