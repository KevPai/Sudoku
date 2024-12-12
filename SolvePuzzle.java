package p1;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SolvePuzzle {

	Rectangle myButton;
	int[][] solution;
	
	
	public SolvePuzzle(Rectangle button, int[][] solutionGrid) {
		
		solution = solutionGrid;
		SudokuSolver.printBoard(solution);
		
		myButton = button;
		
        myButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                myButton.setFill(Color.BISQUE);
            }
        });
        
        myButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                myButton.setFill(Color.WHITE);
            }
        });
        
        myButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>()
        {
			@Override
			public void handle(MouseEvent arg0) {
				Stage stage = new Stage();
		        Scene scene = new Scene(new GridPane(), 250, 150);
		        stage.setScene(scene);
		        stage.show();			
			}
        });
	}
	
	public void checkSolution () {
		
		
	}
}
