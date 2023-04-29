package HomeClasses.AppFiles;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ThemesDesign{
    private final JTextField textFieldCountVar;
    private final JLabel labelInputCountVar;
    private final JPanel lowPanel;
    private final JButton buttonCreateVar;
    private final JCheckBox checkAllTask;
    private final JLabel labelChoseTask;
    private final JPanel topPanel;
    private final JTabbedPane tabPane1;
    private final JPanel page1Panel;
    private final JPanel pageSettings;
    private final JRadioButton radioButtonLight;
    private final JRadioButton radioButtonDark;
    private final JRadioButton radioButtonContrast;
    private final JLabel labelChooseTheme;
    private final JPanel settingsTopPanel;
    private final JPanel settingsTreePanel;
    private final JLabel labelChoosePath;
    private final JPanel mainPanel;
    private final JPanel buttonPanel;
    private final JLabel labelChoseFontFamily;
    private final JLabel labelChoseFontSize;

    public ThemesDesign(JTextField textFieldCountVar, JLabel labelInputCountVar, JPanel lowPanel,
                        JButton buttonCreateVar, JCheckBox checkAllTask, JLabel labelChoseTask, JPanel topPanel,
                        JTabbedPane tabPane1, JPanel page1Panel, JPanel pageSettings, JRadioButton radioButtonLight,
                        JRadioButton radioButtonDark, JRadioButton radioButtonContrast, JLabel labelChooseTheme,
                        JPanel settingsTopPanel, JPanel settingsTreePanel, JLabel labelChoosePath, JPanel mainPanel, JPanel buttonPanel, JLabel labelChoseFontFamily, JLabel  labelChoseFontSize)
    {
        this.textFieldCountVar = textFieldCountVar;
        this.labelInputCountVar = labelInputCountVar;
        this.lowPanel = lowPanel;
        this.buttonCreateVar = buttonCreateVar;
        this.checkAllTask = checkAllTask;
        this.labelChoseTask = labelChoseTask;
        this.topPanel = topPanel;
        this.tabPane1 = tabPane1;
        this.page1Panel = page1Panel;
        this.pageSettings = pageSettings;
        this.radioButtonLight = radioButtonLight;
        this.radioButtonDark = radioButtonDark;
        this.radioButtonContrast = radioButtonContrast;
        this.labelChooseTheme = labelChooseTheme;
        this.settingsTopPanel = settingsTopPanel;
        this.settingsTreePanel = settingsTreePanel;
        this.labelChoosePath = labelChoosePath;
        this.mainPanel = mainPanel;
        this.buttonPanel = buttonPanel;
        this.labelChoseFontFamily = labelChoseFontFamily;
        this.labelChoseFontSize = labelChoseFontSize;
    }

    public void initPropertiesBlack() {

        tabPane1.setBackground(new Color(26, 26, 26));
        page1Panel.setBackground(new Color(194, 194, 194));
        topPanel.setBackground(new Color(184, 184, 184));
        buttonPanel.setBackground(new Color(194, 194, 194));
        lowPanel.setBackground(new Color(184, 184, 184));
        mainPanel.setBackground(new Color(81, 81, 81));
        pageSettings.setBackground(new Color(194, 194, 194));
        settingsTopPanel.setBackground(new Color(216, 216, 216));
        settingsTreePanel.setBackground(new Color(194, 194, 194));
        labelInputCountVar.setFont(new Font("Verdana", Font.PLAIN, 28));
        labelInputCountVar.setForeground(new Color(1,1,1));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setFont(new Font("Verdana", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setForeground(new Color(24,24,24));
        textFieldCountVar.setForeground(new Color(44, 44, 44));
        textFieldCountVar.setBackground(new Color(160, 160, 160));
        textFieldCountVar.setFont(new Font("Verdana" , Font.PLAIN, 16));
        textFieldCountVar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Verdana" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(44,44,44));
        buttonCreateVar.setFont(new Font("Verdana" , Font.PLAIN , 20));
        labelChooseTheme.setForeground(new Color(1, 1, 1));
        labelChooseTheme.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonLight.setForeground(new Color(1, 1, 1));
        radioButtonLight.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonDark.setForeground(new Color(1, 1, 1));
        radioButtonDark.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonContrast.setForeground(new Color(1, 1, 1));
        radioButtonContrast.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoseFontFamily.setForeground(new Color(1, 1, 1));
        labelChoseFontFamily.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoseFontSize.setForeground(new Color(1, 1, 1));
        labelChoseFontSize.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoosePath.setForeground(new Color(44, 44, 44));
        labelChoosePath.setFont(new Font("Verdana" , Font.PLAIN, 15));
    }

    public void initPropertiesLight(){
        page1Panel.setBackground(new Color(245, 245, 245));
        tabPane1.setBackground(new Color(150, 150, 150));
        topPanel.setBackground(new Color(235, 235, 235));
        buttonPanel.setBackground(new Color(245, 245, 245));
        lowPanel.setBackground(new Color(235, 235, 235));
        mainPanel.setBackground(new Color(190, 190, 190));
        pageSettings.setBackground(new Color(230, 230, 230));
        settingsTopPanel.setBackground(new Color(245, 245, 245));
        settingsTreePanel.setBackground(new Color(230, 230, 230));
        labelInputCountVar.setFont(new Font("Verdana", Font.PLAIN, 28));
        labelInputCountVar.setForeground(new Color(30,30,30));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setFont(new Font("Verdana", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setForeground(new Color(50,50,50));
        textFieldCountVar.setForeground(new Color(24, 24, 24));
        textFieldCountVar.setBackground(new Color(250, 250, 250));
        textFieldCountVar.setFont(new Font("Verdana" , Font.PLAIN, 16));
        textFieldCountVar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Verdana" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(50,50,50));
        labelChooseTheme.setForeground(new Color(24, 24, 24));
        labelChooseTheme.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonLight.setForeground(new Color(24, 24, 24));
        radioButtonLight.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonDark.setForeground(new Color(24, 24, 24));
        radioButtonDark.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonContrast.setForeground(new Color(24, 24, 24));
        radioButtonContrast.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoseFontFamily.setForeground(new Color(24, 24, 24));
        labelChoseFontFamily.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoseFontSize.setForeground(new Color(24, 24, 24));
        labelChoseFontSize.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoosePath.setForeground(new Color(44,44,44));
        labelChoosePath.setFont(new Font("Verdana" , Font.PLAIN, 15));
    }

    public void initPropertiesContrast() {
        tabPane1.setBackground(new Color(25, 25, 25));
        page1Panel.setBackground(new Color(30, 30, 30));
        topPanel.setBackground(new Color(35, 35, 35));
        buttonPanel.setBackground(new Color(30, 30, 30));
        lowPanel.setBackground(new Color(35, 35, 35));
        mainPanel.setBackground(new Color(50, 50, 50));
        pageSettings.setBackground(new Color(30, 30, 30));
        settingsTopPanel.setBackground(new Color(40, 40, 40));
        settingsTreePanel.setBackground(new Color(30, 30, 30));
        labelInputCountVar.setFont(new Font("Verdana", Font.PLAIN, 28));
        labelInputCountVar.setForeground(new Color(170,170,170));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setFont(new Font("Verdana", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setForeground(new Color(170,170,170));
        textFieldCountVar.setForeground(new Color(180, 180, 180));
        textFieldCountVar.setBackground(new Color(30, 30, 30));
        textFieldCountVar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textFieldCountVar.setFont(new Font("Verdana" , Font.PLAIN, 16));
        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Verdana" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(133,133,133));
        labelChooseTheme.setForeground(new Color(150, 150, 150));
        labelChooseTheme.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonLight.setForeground(new Color(150, 150, 150));
        radioButtonLight.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonDark.setForeground(new Color(150, 150, 150));
        radioButtonDark.setFont(new Font("Verdana" , Font.PLAIN, 15));
        radioButtonContrast.setForeground(new Color(150, 150, 150));
        radioButtonContrast.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoseFontFamily.setForeground(new Color(150, 150, 150));
        labelChoseFontFamily.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoseFontSize.setForeground(new Color(150, 150, 150));
        labelChoseFontSize.setFont(new Font("Verdana" , Font.PLAIN, 15));
        labelChoosePath.setForeground(new Color(133,133,133));
        labelChoosePath.setFont(new Font("Verdana" , Font.PLAIN, 15));

    }
}
