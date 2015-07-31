/* C202/Summer 2015
 * Lab2Program.java
 * Written By   : Farhad Amiri
 * Date Written : 7/31/2015
 * Purpose      : JavaFx Move the ball
 */
package pkg202lab10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab10 extends Application {

    CirclePane circlePane = new CirclePane();
    Button btUp = new Button("Up");
    Button btLeft = new Button("Left");
    Button btRight = new Button("Right");
    Button btDown = new Button("Down");

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Text t = new Text("Hi");
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        
        btLeft.setOnAction(new EventHandler<ActionEvent> () {
        @Override
        public void handle(ActionEvent e) {
            circlePane.left();
        }// Handle Event
    });// Left Handler Method
        
        btRight.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                circlePane.right();
            } // Handle
        });// Right Handler
        
        btUp.setOnAction (new EventHandler<ActionEvent> () {
        @Override
        public void handle(ActionEvent e) {
            circlePane.up();
            ///btUp.setDisable(true);
        }
    });// UpHandler event handler
        
    btDown.setOnAction(new EventHandler<ActionEvent>  () {
        @Override
        public void handle(ActionEvent e) {
            circlePane.down();
            //  btDown.setDisable(true);
        }// Handle Event
    } );// Handler Down
        
        primaryStage.setResizable(false);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        Scene scene = new Scene(borderPane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }// Start

    class CirclePane extends Pane {

        Circle circle = new Circle(50);

        public CirclePane() {
            getChildren().add(circle);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.RED);
            circle.setCenterX(50);
            circle.setCenterY(300);

        }// Circle pane 

        public void left() {
            if (circle.getCenterX() - 60 > 0) {
                circle.setCenterX(circle.getCenterX() - 50);
            }// if 
        }// Left Method

        public void right() {
            if (circle.getCenterX() <= 540) {
                circle.setCenterX(circle.getCenterX() + 50);
            }// if Statement
        }// Right Method

        public void up() {
            if (circle.getCenterY() - 60 > 0) {
                circle.setCenterY(circle.getCenterY() - 50);
            }// if Statement
        }// up method

        public void down() {
            if (circle.getCenterY() - 60 < 300) {
                circle.setCenterY(circle.getCenterY() + 50);
            }// if statement
        }// down
    }// Circle pane

    public static void main(String[] args) {
        launch(args);
    }// main launch 

}// class
