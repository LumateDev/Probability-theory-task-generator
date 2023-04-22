package HomeClasses.ActionPerformedClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontSizeListener implements ActionListener {
    String fontSize = "14";
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox fontSizeBox = (JComboBox)e.getSource();
         fontSize = (String)fontSizeBox.getSelectedItem();
        System.out.println(fontSize);
    }

    public String getFontSize() {
        return fontSize;
    }
}
