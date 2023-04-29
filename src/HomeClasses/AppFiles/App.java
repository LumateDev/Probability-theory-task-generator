package HomeClasses.AppFiles;

import HomeClasses.ActionPerformedClasses.*;
import HomeClasses.ConfigurationClasses.ThemesWRC;
import HomeClasses.TaskManager.Task;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;

public class App extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton buttonTask1;
    private JButton buttonTask2;
    private JButton buttonTask3;
    private JButton buttonTask4;
    private JButton buttonTask5;
    private JButton buttonTask6;
    private JButton buttonTask7;
    private JButton buttonTask8;
    private JButton buttonTask9;
    private JButton buttonTask10;
    private JButton buttonTask11;
    private JButton buttonTask12;
    private JButton buttonTask13;
    private JButton buttonTask14;
    private JButton buttonTask15;
    private JButton buttonTask16;
    private JButton buttonTask17;
    private JButton buttonTask18;
    private JButton buttonTask19;
    private JButton buttonTask20;
    private JButton buttonTask21;
    private JTextField textFieldCountVar;
    private JLabel labelInputCountVar;
    private JPanel lowPanel;
    private JButton buttonCreateVar;
    private JCheckBox checkAllTask;
    private JLabel labelChoseTask;
    private JPanel topPanel;
    private JTabbedPane tabPane1;
    private JPanel page1Panel;
    private JPanel pageSettings;
    private JRadioButton radioButtonLight;
    private JRadioButton radioButtonDark;
    private JRadioButton radioButtonContrast;
    private JLabel labelChooseTheme;
    private JPanel settingsTopPanel;
    private JPanel settingsTreePanel;
    private JLabel labelChoosePath;
    private JButton buttonChoose;
    private JComboBox comboBoxFontFamily;
    private JComboBox comboBoxFontSize;
    private JLabel labelChoseFontFamily;
    private JLabel labelChoseFontSize;
    final ColorListener colorListener;
    final RadioListener radioListener;
    final PathListener pathListener;
    final CreateVarListener createVarListener;
    final ThemesDesign themesDesign;
    final CheckItemListener checkItemListener;
    final ButtonProperties buttonProperties;
    final FontSizeListener fontSizeListener;
    final FontFamilyListener fontFamilyListener;
    ThemesWRC themesWRC = new ThemesWRC();
    String savedUserTheme;

    {
        try {
            savedUserTheme = themesWRC.readFromTxt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    App(){
        super("Генератора задач по Теории вероятности");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(818, 580);
        setResizable(false);
        setVisible(true);
        Set<Task> taskSet = new HashSet<>();
        JButton[] buttons = new JButton[]
                {
                        buttonTask1, buttonTask2, buttonTask3, buttonTask4, buttonTask5, buttonTask6, buttonTask7,
                        buttonTask8, buttonTask9, buttonTask10, buttonTask11, buttonTask12, buttonTask13, buttonTask14,
                        buttonTask15, buttonTask16, buttonTask17, buttonTask18, buttonTask19, buttonTask20, buttonTask21
                };
        colorListener = new ColorListener(taskSet);
        fontSizeListener = new FontSizeListener();
        fontFamilyListener = new FontFamilyListener();
        createVarListener = new CreateVarListener(colorListener,mainPanel, textFieldCountVar, fontSizeListener, fontFamilyListener);
        String userFilePath = CreateVarListener.getUserFilePath();
        if(userFilePath != null){
            labelChoosePath.setText(userFilePath);
            buttonChoose.setText("Изменить");
        }
        pathListener = new PathListener(labelChoosePath,buttonChoose,createVarListener);
        themesDesign = new ThemesDesign
                (
                    textFieldCountVar, labelInputCountVar, lowPanel, buttonCreateVar,
                    checkAllTask, labelChoseTask, topPanel, tabPane1, page1Panel, pageSettings, radioButtonLight,
                    radioButtonDark, radioButtonContrast, labelChooseTheme, settingsTopPanel, settingsTreePanel,
                    labelChoosePath, mainPanel, buttonPanel, labelChoseFontFamily, labelChoseFontSize
                );
        radioListener = new RadioListener(radioButtonLight, radioButtonDark, radioButtonContrast, mainPanel, themesDesign);
        buttonProperties = new ButtonProperties(colorListener, buttons);
        buttonProperties.buttonPropertiesRun();
        checkItemListener = new CheckItemListener(taskSet, checkAllTask, buttons);
        buttonCreateVar.addActionListener(createVarListener);
        comboBoxFontFamily.addActionListener(fontFamilyListener);
        comboBoxFontSize.addActionListener(fontSizeListener);
        buttonChoose.addActionListener(pathListener);
        radioButtonDark.addActionListener(radioListener);
        radioButtonLight.addActionListener(radioListener);
        radioButtonContrast.addActionListener(radioListener);
        checkAllTask.addItemListener(checkItemListener);
        if(Objects.equals(savedUserTheme, "Original")){
            try {
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
            } catch (Exception ex) {
                setDefaultLookAndFeelDecorated(true);
                ex.printStackTrace();
            }
            themesDesign.initPropertiesBlack();
            SwingUtilities.updateComponentTreeUI(mainPanel);
            radioButtonDark.setSelected(true);
        }
        else if(Objects.equals(savedUserTheme, "Light")){
            try{
                UIManager.setLookAndFeel(new FlatMacLightLaf());
            } catch (Exception ex){
                setDefaultLookAndFeelDecorated(true);
                ex.printStackTrace();
            }
            themesDesign.initPropertiesLight();
            SwingUtilities.updateComponentTreeUI(mainPanel);
            radioButtonLight.setSelected(true);
        }
        else if(Objects.equals(savedUserTheme, "Dark")){
            try{
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (Exception ex){
                setDefaultLookAndFeelDecorated(true);
                ex.printStackTrace();
            }
            themesDesign.initPropertiesContrast();
            SwingUtilities.updateComponentTreeUI(mainPanel);
            radioButtonContrast.setSelected(true);
        }
    }
}
