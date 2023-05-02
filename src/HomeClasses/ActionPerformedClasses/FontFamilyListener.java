package HomeClasses.ActionPerformedClasses;

import HomeClasses.ConfigurationClasses.FontFamilyWRC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

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
        JComboBox fontFamilyBox = (JComboBox) e.getSource();
        fontFamily = (String)fontFamilyBox.getSelectedItem();
        if(Objects.equals(fontFamily, "<default>")){fontFamily = "Tames New Roman";}
        System.out.println(fontFamily);
        fontFamilyWRC.writeInTxt(fontFamily);
    }

    public String getFontFamily() {
        return fontFamily;
    }
}
