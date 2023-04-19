package HomeClasses.ActionPerformedClasses;

import javax.swing.*;
import java.awt.*;

public class ButtonProperties {
    private final JButton[] buttons;
    ColorListener colorListener;
    public ButtonProperties(ColorListener colorListener, JButton[] buttons){
        this.colorListener = colorListener;
        this.buttons = buttons;
    }
    public void buttonPropertiesRun(){

        for (JButton button : buttons) {
            button.addActionListener(colorListener);
            button.setFont(new Font("Verdana", Font.PLAIN, 18));
        }
    }
}
