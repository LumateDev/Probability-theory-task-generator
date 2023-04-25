package HomeClasses.ActionPerformedClasses;

import HomeClasses.ConfigurationClasses.FontFamilyWRC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FontFamilyListener implements ActionListener {
    FontFamilyWRC fontFamilyWRC = new FontFamilyWRC();
    String fontFamily;

    {
        try {
            fontFamily = fontFamilyWRC.readFromTxt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox fontFamilyBox = (JComboBox)e.getSource();
        fontFamily = (String)fontFamilyBox.getSelectedItem();
        System.out.println(fontFamily);
        fontFamilyWRC.writeInTxt(fontFamily);
    }

    public String getFontFamily() {
        return fontFamily;
    }
}
