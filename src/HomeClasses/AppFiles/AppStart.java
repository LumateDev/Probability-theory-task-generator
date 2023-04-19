package HomeClasses.AppFiles;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.*;
import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;

public class AppStart {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            setDefaultLookAndFeelDecorated(true);
            ex.printStackTrace();
        }
        new App();
    }
}
