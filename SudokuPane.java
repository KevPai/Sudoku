package p1;

import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SudokuPane extends GridPane{
    
    private Font font = Font.font("Verdana", FontWeight.BOLD, 16);
    private int[][] newGrid;
    private int[][] solutionGrid;
    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();
    Line line4 = new Line();
    SudokuSolver solution = new SudokuSolver();
    SudokuScrambler scramble;
    Rectangle visualBoxes[][] = new Rectangle[9][9];
    ButtonLogic sudokuButtons;
    
    int currentInput = 0;
    
    SolvePuzzle solve;
    Rectangle solveButton;
    Label solveText = new Label();
    StackPane solveStack = new StackPane();
    
    public SudokuPane() {
        for (int x = 0; x < 9; x++) {
                ColumnConstraints column = new ColumnConstraints(40);
                getColumnConstraints().add(column);
        }

        for (int x = 0; x < 13; x++) {
                RowConstraints row = new RowConstraints(40);
                getRowConstraints().add(row);
        }
        
        
        setNewGrid(solution.getBoard());
        solutionGrid = copyArray(newGrid);
        scramble = new SudokuScrambler(newGrid);
        setBoxes(newGrid);
        
        sudokuButtons = new ButtonLogic(visualBoxes);
        
        setInputNumbers();
        
        line1.setEndX(356); 
        setValignment(line1, VPos.TOP);
        line1.setStrokeWidth(3);
        add(line1, 0, 3);
        
        line2.setEndX(356);
        setValignment(line2, VPos.TOP);
        line2.setStrokeWidth(3);
        add(line2, 0, 6);
        
        line3.setEndY(676);
        line3.setStrokeWidth(3);
        add(line3, 3, 0);
        
        line4.setEndY(676);
        line4.setStrokeWidth(3);
        add(line4, 6, 0);
        
        solveButton = new Rectangle(120,40,Color.WHITE);
        solveButton.setStroke(Color.BLACK);
        solve = new SolvePuzzle(solveButton, newGrid, solutionGrid);
        
        solveText.setText("Try Solution!");
        solveStack.getChildren().addAll(solveButton, solveText);
        add(solveStack, 3, 10);
       
    }
    
    public void setBoxes(int[][] sudokuGrid) {
    	
        int column = 0;
        
        for (int count1 = 0; count1 < 9; count1++) {
            int row = 0;
            for (int count2 = 0; count2 < 9; count2++) {
                
                StackPane stack = new StackPane();
                Label text;
                
                Rectangle box = new Rectangle(40,40,Color.WHITE);
                box.setStroke(Color.BLACK);
                
                if (sudokuGrid[count1][count2] == 0) {
                    text = new Label();
                    
                    box.addEventHandler(MouseEvent.MOUSE_CLICKED,
                            new EventHandler<MouseEvent>()
                    {
                        @Override
                        public void handle(MouseEvent t) {
                        	switch (t.getButton()) {
                            case PRIMARY: //Left button
                            	text.setText(String.valueOf(currentInput));
                                break;
                            case SECONDARY: //Right button
                                text.setText("");
                                break;
                            default:
                                //Ignore
                                break;
                            }
                        }
                    });
                    
                    } else {
                        text = new Label(String.valueOf(sudokuGrid[count1][count2]));
                        //box.setFill(Color.BISQUE);
                }
                
                if (newGrid[count1][count2] != 0) {
                	getPuzzleStyle(text);
                } else {
                	getLabelStyle(text);
                }
                
                setHalignment(text, HPos.CENTER);
                    
                visualBoxes[row][column] = box;
                    
                stack.getChildren().addAll(visualBoxes[row][column], text);
                add(stack, row, column);
                
                row++;
            }
            column++;
        }
    }
    
    public void setInputNumbers() {
        for (int i = 1; i < 10; i++) {
            StackPane stack = new StackPane();
            
            int storedInput = i;
            
            Label text = new Label(String.valueOf(i));
            getLabelStyle(text);
            setHalignment(text, HPos.CENTER);
            
            //InputNumber inputBox = new InputNumber(storedInput);
            
            
            Rectangle box = new Rectangle(38,38,Color.WHITE);
            box.setStroke(Color.BLACK);
            
            box.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    box.setFill(Color.BISQUE);
                }
            });
            
            box.addEventHandler(MouseEvent.MOUSE_EXITED,
                    new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    box.setFill(Color.WHITE);
                }
                
            });
            
            box.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                	currentInput = storedInput;
                	box.setFill(Color.YELLOW);
                }
            });
            
            
            stack.getChildren().addAll(box, text);
            
            add(stack, i-1, 12);
        }       
    }
    
    public int[][] copyArray(int[][] original) {
    	int[][] clone = new int[original.length][original[0].length];
    	
    	for(int i = 0; i < original.length; i++)
    		  for(int j = 0; j < original[i].length; j++)
    		    clone[i][j] = original[i][j];
    	
    	return clone;
    }
    
    public Label getLabelStyle(Label myStyle) {
        myStyle.setFont(font);
        myStyle.setTextFill(Color.NAVY);
        myStyle.prefWidth(40);
        myStyle.prefHeight(40);
        
        return myStyle;
    }
    
    public Label getPuzzleStyle(Label myStyle) {
        myStyle.setFont(font);
        myStyle.setTextFill(Color.FIREBRICK);
        myStyle.prefWidth(40);
        myStyle.prefHeight(40);
        
        return myStyle;
    }
    
    public TextField getFieldstyle(TextField myStyle) {
        myStyle.setFont(font);
        myStyle.prefWidth(40);
        myStyle.prefHeight(40);
        
        return myStyle;
    }
    
    public void setNewGrid(int[][] setGrid) {
        newGrid = setGrid;
    }
}
