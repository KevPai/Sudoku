package p1;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InputNumber {
	Rectangle box;
	Label text;
	Boolean selected;
	int currentInput;
	
	public InputNumber(int storedInput) {
		
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
        
	}
	
	public Rectangle getBox() {
		return box;
	}
	
	public Label getText() {
		return text;
	}
}
