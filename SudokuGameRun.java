package p1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SudokuGameRun extends Application {

	@Override
	public void start(Stage primaryStage) {
	    
	    Scene game = new Scene(new SudokuPane(), 360, 520);
	    
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(game);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
