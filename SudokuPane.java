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

public class SudokuPane extends GridPane{
    
    private Font font = new Font(16);
    private int[][] newGrid;
    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();
    Line line4 = new Line();
    SudokuSolver solution = new SudokuSolver();
    SudokuScrambler scramble;
    Rectangle visualBoxes[][] = new Rectangle[9][9];
    ButtonLogic sudokuButtons;
    
    public SudokuPane() {
        for (int x = 0; x < 9; x++) {
                ColumnConstraints column = new ColumnConstraints(40);
                getColumnConstraints().add(column);
        }

        for (int x = 0; x < 12; x++) {
                RowConstraints row = new RowConstraints(40);
                getRowConstraints().add(row);
        }
        
        
        setNewGrid(solution.getBoard());
        
        SudokuSolver.printBoard(newGrid);
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
       
    }
    
    public void setBoxes(int[][] sudokuGrid) {
        
        int column = 0;
        
        for (int count1 = 0; count1 < 9; count1++) {
            int row = 0;
            for (int count2 = 0; count2 < 9; count2++) {
                
                StackPane stack = new StackPane();
                Label text;
                
                if (sudokuGrid[count1][count2] == 0) {
                    text = new Label();
                    } else {
                        text = new Label(String.valueOf(sudokuGrid[count1][count2]));
                    }
                    
                    getLabelstyle(text);
                    setHalignment(text, HPos.CENTER);
                    
                    Rectangle box = new Rectangle(40,40,Color.WHITE);
                    box.setStroke(Color.BLACK);
                    
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
            
            Label text = new Label(String.valueOf(i));
            getLabelstyle(text);
            setHalignment(text, HPos.CENTER);
            
            Rectangle box = new Rectangle(38,38,Color.WHITE);
            box.setStroke(Color.BLACK);
            
            box.addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    box.setFill(Color.BISQUE);
                }
            });
            
            box.addEventHandler(MouseEvent.MOUSE_RELEASED,
                    new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent t) {
                    box.setFill(Color.WHITE);
                }
            });
            
            stack.getChildren().addAll(box, text);
            
            add(stack, i-1, 11);
        }       
    }
    
    public Label getLabelstyle(Label myStyle) {
        myStyle.setFont(font);
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
