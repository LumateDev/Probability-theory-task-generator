package HomeClasses.ActionPerformedClasses;

import HomeClasses.ConfigurationClasses.FontFamilyWRC;
import HomeClasses.ConfigurationClasses.FontSizeWRC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FontSizeListener implements ActionListener {
    FontSizeWRC fontSizeWRC = new FontSizeWRC();
    //String fontSize = "14";
    String fontSize;

    {
        try {
            fontSize = fontSizeWRC.readFromTxt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox fontSizeBox = (JComboBox)e.getSource();
        fontSize = (String)fontSizeBox.getSelectedItem();
        System.out.println(fontSize);
        fontSizeWRC.writeInTxt(fontSize);
    }

    public String getFontSize() {
        return fontSize;
    }
}
