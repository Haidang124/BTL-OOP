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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Tower extends GameEntity {
    private Bullet bullet;
    private Bullet1 bullet1;
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
//    public static int getTarget ()
//    {
//        for(int i=0;i<count;i++)
//        {
//            //System.out.println(arrayList.get(i).isDanger()+" ");
//            if(arrayList.get(i).isDanger()==true)
//            {
//               // System.out.println(i+" "+"getTarget");
//                return i;
//                //return arrayList.get(i);
//            }
//        }
//        return -1;
//    }
//    public static void addTarget (Enemy enemy)
//    {
//      //  System.out.println(count);
//        for(int i=0;i<count;i++)
//        {
//            if(arrayList.get(i)==enemy) return;
//        }
//        if(Tower.canShoot2(72*4.5, 72*4.5, 72*4,enemy)) {
//            arrayList.add(enemy);
//            enemy.setDanger(true);
//            count++;
//        }
//        else
//        {
//            enemy.setDanger(false);
//        }
//        getTarget();
//    }
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
        }
        else if(type ==2)
        {
            NormalTower normalTower = new NormalTower(x,y);
            GameEntity.towerArrayList.add(normalTower);
            normalTower.getimage().show(stage, x - (normalTower.getimage().getImage().getWidth()-Config.sizeimageMap),
                    y - (normalTower.getimage().getImage().getHeight()-Config.sizeimageMap));

            Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                    72*2, Color.color(0.192, 0.192, 0.192, 0.1));
            Config.pane.getChildren().add(circle);
        }
        else
        {
            SniperTower sniperTower = new SniperTower(x,y);
            GameEntity.towerArrayList.add(sniperTower);
            sniperTower.getimage().show(stage, x - (sniperTower.getimage().getImage().getWidth()-Config.sizeimageMap),
                    y - (sniperTower.getimage().getImage().getHeight()-Config.sizeimageMap));

            Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                    72*2, Color.color(0.192, 0.192, 0.192, 0.1));
            Config.pane.getChildren().add(circle);
        }
    }
    public void findTarget(Stage primaryStage)
    {
        for(int i=GameStage.enemyArrayList.size()-1;i>=0;i--)
        {
            if(Tower.canShoot2(this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,72*2,GameStage.enemyArrayList.get(i)))
            {
                Line line = new Line(this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,GameStage.enemyArrayList.get(i).getimage().getImageView().getX()+25,GameStage.enemyArrayList.get(i).getimage().getImageView().getY()+25);
                bullet1 = new Bullet1(Color.BLUE,this.getx()+Config.sizeimageMap/2,this.gety()+Config.sizeimageMap/2,line,100,100,72*2);
                bullet1.shoot(primaryStage,GameStage.enemyArrayList.get(i));
                return;
            }
        }
    }
    public void towerBuild (Stage stage){
        GameEntity.towerArrayList.add(this);
        image.show(stage, this.x - (image.getImage().getWidth()-Config.sizeimageMap),
                this.y - (image.getImage().getHeight()-Config.sizeimageMap));

        Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                72*2, Color.color(0.192, 0.192, 0.192, 0.1));
        Config.pane.getChildren().add(circle);
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(2.5),
//                        event -> { Config.pane.getChildren().remove(circle); }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
    }

    public static void shoot(Stage stage ,Enemy enemy) throws NullPointerException
    {
//        Bullet bullet2 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
//        NormalTower tower = new NormalTower(72,72*2,bullet2);
//        Config.pane.setOnMousePressed(new EventHandler<MouseEvent>() {
//            Image towerMenu = new Image("file:images\\selTower.png");
//            ImageView menuView = new ImageView(towerMenu);
//
//            @Override
//            public void handle(MouseEvent event) {
//                if (event.isPrimaryButtonDown()) {
//                    System.out.println("mouse pressed");
//                    Config.x_pos = ((int) event.getX() / Config.sizeimageMap) * Config.sizeimageMap;
//                    Config.y_pos = ((int) event.getY() / Config.sizeimageMap) * Config.sizeimageMap;
//                    System.out.println(Config.x_pos + " " + Config.y_pos + " " + GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]);
//                    if (GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) {
//                        menuView.setFitHeight(70);
//                        menuView.setFitWidth(120);
//                        menuView.setX(Config.x_pos - Config.sizeimageMap / 2);
//                        menuView.setY(Config.y_pos - (menuView.getFitHeight() / 2));
//                        try {
//                            Config.pane.getChildren().add(menuView);
//                        } catch (IllegalArgumentException e) {
//                        }
//
//                        Config.pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
//                            @Override
//                            public void handle(KeyEvent event) {
//                                if (event.getCode() == KeyCode.DIGIT2) {
//                                    Config.pane.getChildren().remove(menuView);
//                                    NormalTower tower = new NormalTower(Config.x_pos, Config.y_pos, bullet2);
//                                    tower.towerBuild(stage);
//                                    Timeline timeline1 = new
//                                            Timeline(new KeyFrame(Duration.millis(1000),
//                                            (evt)->{
//                                                try {
//                                                    if(Tower.getCount() >=1)
//                                                    {
//                                                        if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX() , Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY())) {
//                                                            Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
//                                                            bullet5.shoot(stage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
//                                                        }
//                                                    }
//                                                }
//                                                catch (NullPointerException e){}
//                                            }
//                                    ));
//                                    timeline1.setCycleCount(Animation.INDEFINITE);
//                                    timeline1.play();
//                                }
//                                if (event.getCode() == KeyCode.DIGIT3) {
//                                    Config.pane.getChildren().remove(menuView);
//                                    SniperTower tower = new SniperTower(Config.x_pos, Config.y_pos, bullet2);
//                                    tower.towerBuild(stage);
//                                    Timeline timeline1 = new
//                                            Timeline(new KeyFrame(Duration.millis(1000),
//                                            (evt)->{
//                                                try {
//                                                    if(Tower.getCount() >=1)
//                                                    {
//                                                        if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX(), Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY() )) {
//                                                            Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
//                                                            bullet5.shoot(stage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
//                                                        }
//                                                    }
//                                                }
//                                                catch (NullPointerException e){}
//                                            }
//                                    ));
//                                    timeline1.setCycleCount(Animation.INDEFINITE);
//                                    timeline1.play();
//                                }
//                                if (event.getCode() == KeyCode.DIGIT1) {
//                                    Config.pane.getChildren().remove(menuView);
//                                    MachineGunTower tower = new MachineGunTower(Config.x_pos, Config.y_pos, bullet2);
//                                    tower.towerBuild(stage);
//                                    Timeline timeline1 = new
//                                            Timeline(new KeyFrame(Duration.millis(1000),
//                                            (evt)->{
//                                                try {
//                                                    if(Tower.getCount() >=1)
//                                                    {
//                                                        if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX(), Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY())) {
//                                                            Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
//                                                            bullet5.shoot(stage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
//                                                        }
//                                                    }
//                                                }
//                                                catch (NullPointerException e){}
//                                            }
//                                    ));
//                                    timeline1.setCycleCount(Animation.INDEFINITE);
//                                    timeline1.play();
//                                }
//                            }
//                        });
//                    }
//                }
//            }
//        });
    }
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
    public static void towerSpawn(Stage primaryStage){
        Config.pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            Image towerMenu = new Image("file:images\\selTower.png");
            ImageView menuView = new ImageView(towerMenu);

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
                                        Config.pane.getChildren().remove(menuView);
                                        if(GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) Tower.build(primaryStage,Config.x_pos, Config.y_pos,2);
                                        GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]="0";
//                                    NormalTower tower = new NormalTower(Config.x_pos, Config.y_pos);
//                                    tower.towerBuild(primaryStage);
//                                    Timeline timeline1 = new
//                                            Timeline(new KeyFrame(Duration.millis(1000),
//                                            (evt)->{
//                                                try {
//                                                    if(Tower.getCount() >=1)
//                                                    {
//                                                        if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX() , Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY())) {
//                                                            Bullet bullet5 = new Bullet(new image("file:images\\bullet2.png"),100,100,100);
//                                                            bullet5.shoot(primaryStage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
//                                                        }
//                                                    }
//                                                }
//                                                catch (NullPointerException e){}
//                                            }
//                                    ));
//                                    timeline1.setCycleCount(Animation.INDEFINITE);
//                                    timeline1.play();
                                    }
                                    if (event.getCode() == KeyCode.DIGIT3) {
                                        Config.pane.getChildren().remove(menuView);
                                        if(GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) Tower.build(primaryStage,Config.x_pos, Config.y_pos,3);
                                        GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]="0";
//                                    SniperTower tower = new SniperTower(Config.x_pos, Config.y_pos);
//                                    tower.towerBuild(primaryStage);
//                                    Timeline timeline1 = new
//                                            Timeline(new KeyFrame(Duration.millis(1000),
//                                            (evt)->{
//                                                try {
//                                                    if(Tower.getCount() >=1)
//                                                    {
//                                                        if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX(), Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY() )) {
//                                                            Bullet bullet5 = new Bullet(new image("file:images\\bullet1.png"),100,100,100);
//                                                            bullet5.shoot(primaryStage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
//                                                        }
//                                                    }
//                                                }
//                                                catch (NullPointerException e){}
//                                            }
//                                    ));
//                                    timeline1.setCycleCount(Animation.INDEFINITE);
//                                    timeline1.play();
                                    }
                                    if (event.getCode() == KeyCode.DIGIT1) {
                                        Config.pane.getChildren().remove(menuView);
                                        if(GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) Tower.build(primaryStage,Config.x_pos, Config.y_pos,1);
                                        GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]="0";
//                                    MachineGunTower tower = new MachineGunTower(Config.x_pos, Config.y_pos);
//                                    tower.towerBuild(primaryStage);
//                                    Timeline timeline1 = new
//                                            Timeline(new KeyFrame(Duration.millis(1000),
//                                            (evt)->{
//                                                try {
//                                                    if(Tower.getCount() >=1)
//                                                    {
//                                                        if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX(), Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY())) {
//                                                            Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
//                                                            bullet5.shoot(primaryStage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
//                                                        }
//                                                    }
//                                                }
//                                                catch (NullPointerException e){}
//                                            }
//                                    ));
//                                    timeline1.setCycleCount(Animation.INDEFINITE);
//                                    timeline1.play();
                                    }
                                    if(event.getCode()== KeyCode.ESCAPE)
                                    {
                                        Config.pane.getChildren().remove(menuView);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });

    }

}
