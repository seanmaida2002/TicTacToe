package ticTacToe;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class GameBoard {
	private GridPane gridPane;
	private Button[] buttons;
	private GameController controller; 
	
	public GameBoard(GameController controller) {
		this.controller = controller;
		
		// Create a 3x3 GridPane
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0));  
        gridPane.setPrefSize(GridPane.USE_COMPUTED_SIZE, GridPane.USE_COMPUTED_SIZE);
		
		buttons = new Button[9];
        
	}
	
	public void initializeButtons() {
		for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setPrefSize(100, 100);
            final int cellIndex = i;
            buttons[i].setOnAction(e -> {
            	controller.onCellClicked(cellIndex);
            });
        }
        
        // Add buttons to the grid
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gridPane.add(buttons[index++], col, row);
            }
        }
	}
	
	public void markCell(int index, String mark) {
        buttons[index].setText(mark);
        buttons[index].setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR, 40));
        if(mark.equals("X")) {
        	buttons[index].setTextFill(Color.BLUE);

        }
        else if(mark.equals("O")) {
        	buttons[index].setTextFill(Color.RED);

        }
        disableCell(index);
	}
	
	public void disableCell(int index) {
		buttons[index].setDisable(true);
	}
	
	public boolean isCellEmpty(int index) {
		if(buttons[index].getText().equals("")) {
			return true;
		}
		return false;
	}

	public GridPane getGridPane() {
		return gridPane;
	}
	
	public void resetBoard() {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setText("");
			buttons[i].setDisable(false);
		}
	}
	
	public String getCurrentMark(int index) {
		return buttons[index].getText();
	}
	
	public void setController(GameController controller) {
		this.controller = controller;
	}
}
