package ticTacToe;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tic-Tac-Toe");
        GameBoard board = new GameBoard(null);
        GameController controller = new GameController(board);
        board.setController(controller);
        board.initializeButtons();
        
        GridPane gridPane = board.getGridPane();
 
        StackPane root = new StackPane(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        // Set scene to full screen size
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
    
        
        primaryStage.setScene(scene);
        primaryStage.setX(screenBounds.getMinX());
        primaryStage.setY(screenBounds.getMinY());
        primaryStage.setWidth(screenBounds.getWidth());
        primaryStage.setHeight(screenBounds.getHeight());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}