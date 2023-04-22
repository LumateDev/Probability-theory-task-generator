package HomeClasses.ActionPerformedClasses;

import HomeClasses.AppFiles.ThemesDesign;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;

public class RadioListener implements ActionListener {
    private final JRadioButton radioButtonLight;
    private final JRadioButton radioButtonDark;
    private final JRadioButton radioButtonContrast;
    private final JPanel page1Panel;
    private final JPanel pageSettings;

    ThemesDesign themesDesign;

    public RadioListener(JRadioButton radioButtonLight, JRadioButton radioButtonDark,
                         JRadioButton radioButtonContrast, JPanel page1Panel,
                         JPanel pageSettings, ThemesDesign themesDesign)
    {
        this.radioButtonLight = radioButtonLight;
        this.radioButtonDark = radioButtonDark;
        this.radioButtonContrast = radioButtonContrast;
        this.page1Panel = page1Panel;
        this.pageSettings = pageSettings;
        this.themesDesign = themesDesign;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (radioButtonLight.isSelected()) {
            try{

                UIManager.setLookAndFeel(new FlatMacLightLaf());
            }
            catch (Exception ex){
                setDefaultLookAndFeelDecorated(true);
                ex.printStackTrace();
            }
            themesDesign.initPropertiesLight();
            SwingUtilities.updateComponentTreeUI(page1Panel);
            SwingUtilities.updateComponentTreeUI(pageSettings);
        }
        else if (radioButtonDark.isSelected())
        {
            try{
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
            }
            catch (Exception ex){
                setDefaultLookAndFeelDecorated(true);
                ex.printStackTrace();
            }
            themesDesign.initPropertiesBlack();
            SwingUtilities.updateComponentTreeUI(page1Panel);
            SwingUtilities.updateComponentTreeUI(pageSettings);
        }
        else if(radioButtonContrast.isSelected()){
            try{
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }
            catch (Exception ex){
                setDefaultLookAndFeelDecorated(true);
                ex.printStackTrace();
            }
            themesDesign.initPropertiesContrast();
            SwingUtilities.updateComponentTreeUI(page1Panel);
            SwingUtilities.updateComponentTreeUI(pageSettings);
        }
    }
}
