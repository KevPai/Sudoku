package p1;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SolvePuzzle {

	Rectangle myButton;
	Label result;
	int[][] solution;
	int[][] current;
	GridPane popup;
	
	public SolvePuzzle(Rectangle button, int[][] currentGrid, int[][] solutionGrid) {
		
		current = currentGrid;
		solution = solutionGrid;
		
		myButton = button;
		
		//SudokuSolver.printBoard(solution);
		
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
				
				if (checkSolution(current, solution)) {
					result = new Label("Congrats! You solved the puzzle!");
				} else {
					result = new Label("Wrong answer! Try again!");
				}
				
				popup = new GridPane();
				
                ColumnConstraints column = new ColumnConstraints(250);
                column.setHalignment(HPos.CENTER);
                popup.getColumnConstraints().add(column);
                RowConstraints row = new RowConstraints(100);
                row.setValignment(VPos.CENTER);
                popup.getRowConstraints().add(row);
                
                
                
				popup.add(result, 0, 0);
				
				Stage popstage = new Stage();
		        Scene popscene = new Scene(popup, 250, 100);
		        popstage.setScene(popscene);
		        popstage.show();
			}
        });
	}
	
	public boolean checkSolution (int[][] question, int[][] answer) {
		
		if (question.length == answer.length && question[0].length == answer[0].length) {
	    	for(int x = 0; x < answer.length; x++) {
	    		  for(int y = 0; y < answer[x].length; y++) {
		    		    if (question[x][y] != answer[x][y]) {
		    		    	return false;
		    		    }
	    		  }
	    	}
	    	return true;
		}
		return false;
	}
	
}
