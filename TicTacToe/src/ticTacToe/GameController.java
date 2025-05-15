package ticTacToe;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import java.util.Random;

public class GameController {
	private GameBoard gameBoard;

	private boolean playerTurn = true;
	
	
	public GameController(GameBoard board) {
		this.gameBoard = board;
	}
	
	
	public void onCellClicked(int index) {
		if(!gameBoard.isCellEmpty(index)) {
			return;
		}
		
		String currentMark;
		if(playerTurn == true) {
			currentMark = "X";
		}
		else {
			currentMark = "O";
		}
		
		gameBoard.markCell(index, currentMark);
		
		boolean win = checkWin(currentMark);
		if(win) {
			return;
		}
		boolean draw = isDraw();
		if(draw) {
			return;
		}
		
		playerTurn = false;
		
		aiMove();

		
	}
	
	public void aiMove() {
		Random random = new Random();
		int randomNumber = random.nextInt(8 - 0 + 1) + 0;
		System.out.println(randomNumber);
		while(true) {
			if(gameBoard.isCellEmpty(randomNumber)) {
				gameBoard.markCell(randomNumber, "O");
				playerTurn = true;
				break;
			}
			else {
				randomNumber = random.nextInt(8 - 0 + 1) + 0;
			}
		}

		boolean win = checkWin("O");
		if(win) {
			return;
		}
		boolean draw = isDraw();
		if(draw) {
			return;
		}
	}
	
	private void winMessage(String player) {
		Alert a = new Alert(AlertType.INFORMATION);
		if(player.equals("user")) {
			a.setContentText("You Won!");
		} else {
			a.setContentText("Sorry, better luck next time");
		}
		
		a.showAndWait();
		gameBoard.resetBoard();
		
	}
	
	private boolean checkWin(String mark) {
		String player;
		if(mark.equals("X")) {
			player = "user";
		} else {
			player = "computer";
		}
		
		if(!gameBoard.isCellEmpty(0) && !gameBoard.isCellEmpty(1) && !gameBoard.isCellEmpty(2)) {
			if(gameBoard.getCurrentMark(0).equals(mark) && gameBoard.getCurrentMark(1).equals(mark) 
					&& gameBoard.getCurrentMark(2).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(0) && !gameBoard.isCellEmpty(3) && !gameBoard.isCellEmpty(6)) {
			if(gameBoard.getCurrentMark(0).equals(mark) && gameBoard.getCurrentMark(3).equals(mark) 
					&& gameBoard.getCurrentMark(6).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(0) && !gameBoard.isCellEmpty(4) && !gameBoard.isCellEmpty(8)) {
			if(gameBoard.getCurrentMark(0).equals(mark) && gameBoard.getCurrentMark(4).equals(mark) 
					&& gameBoard.getCurrentMark(8).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(1) && !gameBoard.isCellEmpty(4) && !gameBoard.isCellEmpty(7)) {
			if(gameBoard.getCurrentMark(1).equals(mark) && gameBoard.getCurrentMark(4).equals(mark) 
					&& gameBoard.getCurrentMark(7).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(2) && !gameBoard.isCellEmpty(5) && !gameBoard.isCellEmpty(8)) {
			if(gameBoard.getCurrentMark(2).equals(mark) && gameBoard.getCurrentMark(5).equals(mark) 
					&& gameBoard.getCurrentMark(8).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(3) && !gameBoard.isCellEmpty(4) && !gameBoard.isCellEmpty(5)) {
			if(gameBoard.getCurrentMark(3).equals(mark) && gameBoard.getCurrentMark(4).equals(mark) 
					&& gameBoard.getCurrentMark(5).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(6) && !gameBoard.isCellEmpty(7) && !gameBoard.isCellEmpty(8)) {
			if(gameBoard.getCurrentMark(6).equals(mark) && gameBoard.getCurrentMark(7).equals(mark) 
					&& gameBoard.getCurrentMark(8).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		if(!gameBoard.isCellEmpty(2) && !gameBoard.isCellEmpty(4) && !gameBoard.isCellEmpty(6)) {
			if(gameBoard.getCurrentMark(2).equals(mark) && gameBoard.getCurrentMark(4).equals(mark) 
					&& gameBoard.getCurrentMark(6).equals(mark)) {
				winMessage(player);
				return true;
			}
		}
		return false;
	}
	
	
	private void drawMessage() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("It's a draw");
		a.showAndWait();
		gameBoard.resetBoard();
	}
	
	private boolean isDraw() {
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if(gameBoard.isCellEmpty(i) == false) {
				count++;
			}
		}
		if(count == 9) {
			drawMessage();
			return true;
		}
		return false;
	}
}
