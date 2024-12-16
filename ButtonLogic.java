package p1;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ButtonLogic {
    
    Rectangle[][] storedBoxes;
   
    public ButtonLogic (Rectangle[][] myBoxes) {
        storedBoxes = myBoxes;
        
        for (int count1 = 0; count1 < 9; count1++) {
            for (int count2 = 0; count2 < 9; count2++) {
                
                Rectangle box = storedBoxes[count1][count2];
                
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
            }
        }
        
    }
    
}
