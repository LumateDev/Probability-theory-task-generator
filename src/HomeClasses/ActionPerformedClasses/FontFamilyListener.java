package HomeClasses.ActionPerformedClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontFamilyListener implements ActionListener {
    String fontFamily = "Tames New Roman";
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox fontFamilyBox = (JComboBox)e.getSource();
        fontFamily = (String)fontFamilyBox.getSelectedItem();
        System.out.println(fontFamily);
    }

    public String getFontFamily() {
        return fontFamily;
    }
}
