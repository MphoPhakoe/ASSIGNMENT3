package com.example.mphoproject;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static javafx.scene.paint.Color.*;

public class HelloApplication extends Application {


    Label mark= new Label("SCORE: 0");


    int w=1;
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        mark.setStyle("-fx-font: normal bold 35px 'san serif' ");
        mark.setTextFill(BURLYWOOD);


        Scene scene = new Scene(root, 700, 450);
        ImageView w =  createFirstEnemy(scene);
        ImageView x =  createSecondEnemy(scene);
        ImageView y =  createThirdEnemy(scene);
        ImageView v =  Point(scene);
        ImageView v1 =  point1(scene);
        ImageView hero = new ImageView(new Image("hero.png"));
        hero.setFitWidth(80);
        hero.setFitHeight(60);
        hero.setY(150);
        hero.setX(10);
        hero.setY(scene.getHeight() - hero.getFitHeight());




        ;
        BackgroundImage background = new BackgroundImage(new Image("mpho.jpg", 700, 455, false,true),
                BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);

        root.setBackground(new Background(background));
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x1 = hero.getX();
            double y1 = hero.getY();

            switch (event.getCode()) {
                case RIGHT -> hero.setX(x1 + 10);
                case LEFT -> hero.setX(x1 - 10);
                case UP -> hero.setY(y1 - 10);
                case DOWN -> hero.setY(y1 + 10);
            }


        });



        root.getChildren().addAll(hero,w,x,y,v,v1,mark);
        stage.setTitle(" My First Collision Avoidance Game Project");

        stage.setScene(scene);
        stage.show();





        AnimationTimer Collision1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                cloudC(hero,w,stage);
                cloudC(hero,x,stage);
                cloudC(hero,y,stage);
                PointCollision(hero,v);
                PointCollision(hero,v1);
            }
        };
        Collision1.start();


    }

    public void cloudC(ImageView hero,ImageView createFirstEnemy, Stage stage){
        if(hero.getBoundsInParent().intersects(createFirstEnemy.getBoundsInParent())){
            hero.setImage(new Image("over.png"));
            PauseTransition p11 =new PauseTransition(Duration.millis(1200));
            p11.setOnFinished(actionEvent -> stage.close());
            p11.play();

        }
    }

    public void PointCollision(ImageView hero,ImageView v){
        if(hero.getBoundsInParent().intersects(v.getBoundsInParent())){
            w=w+1;
            mark.setText("SCORE:" + w);

            v.setImage(null);
        }
        else {
            v.setImage(new Image("point.png"));
        }
    }



    private ImageView createFirstEnemy(Scene scene) {
        Image w = new Image("w.png");
        ImageView w1= new ImageView(w);


        w1.setFitWidth(100);
        w1.setFitHeight(100);
        w1.setX(700);
        w1.setY(200);

        TranslateTransition tt = new TranslateTransition(Duration.millis(12000),  w1);
        tt.setByX(-1000);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();
        return  w1;
    }


    private ImageView createSecondEnemy(Scene scene) {
        Image x = new Image("x.png");
        ImageView x1 = new ImageView(x);


        x1.setFitWidth(100);
        x1.setFitHeight(100);
        x1.setX(700);
        x1.setY(40);

        TranslateTransition tt = new TranslateTransition(Duration.millis(8000),  x1);
        tt.setByX(-1000);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();
        return  x1;
    }


    private ImageView createThirdEnemy(Scene scene) {
        Image   y = new Image("y.png");
        ImageView y1 = new ImageView(y);


        y1.setFitWidth(100);
        y1.setFitHeight(100);
        y1.setX(850);
        y1.setY(400);

        TranslateTransition tt = new TranslateTransition(Duration.millis(7000), y1);
        tt.setByX(-1000);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();
        return  y1;
    }

    private ImageView Point(Scene scene) {
        Image c = new Image("point.png");
        ImageView v = new ImageView(c);


        v.setFitWidth(50);
        v.setFitHeight(50);
        v.setX(700);
        v.setY(140);

        TranslateTransition tt = new TranslateTransition(Duration.millis(7000),  v);
        tt.setByX(-1000);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();
        return  v;
    }


    private ImageView point1(Scene scene) {
        Image p = new Image("point.png");
        ImageView p1 = new ImageView(p);


        p1.setFitWidth(50);
        p1.setFitHeight(50);
        p1.setX(750);
        p1.setY(400);

        TranslateTransition t1 = new TranslateTransition(Duration.millis(50000),p1);
        t1.setByX(-5000);
        t1.setCycleCount(Integer.MAX_VALUE);
        t1.play();
        return p1;
    }



    public static void main(String[] args) {
        launch();
    }
}