package HomeClasses.AppFiles;

import HomeClasses.ActionPerformedClasses.*;
import HomeClasses.TaskManager.Task;
import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

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
    ColorListener colorListener;
    RadioListener radioListener;
    PathListener pathListener;
    CreateVarListener createVarListener;
    ThemesDesign themesDesign;
    CheckItemListener chekItemListener;
    ButtonProperties buttonProperties;
    App(){
        super("Генератора задач по Теории вероятности");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(720, 580);
        setResizable(false);
        setVisible(true);
        Set<Task> taskSet = new HashSet<>();
        JButton[] buttons = new JButton[]
                {
                        buttonTask1, buttonTask2, buttonTask3, buttonTask4, buttonTask5, buttonTask6, buttonTask7,
                        buttonTask8, buttonTask9, buttonTask10, buttonTask11, buttonTask12, buttonTask13, buttonTask14,
                        buttonTask15, buttonTask16, buttonTask17, buttonTask18, buttonTask19, buttonTask20, buttonTask21
                };
        pathListener = new PathListener();
        colorListener = new ColorListener(taskSet);
        themesDesign = new ThemesDesign(textFieldCountVar, labelInputCountVar, lowPanel, buttonCreateVar, checkAllTask,
                labelChoseTask, topPanel, tabPane1, page1Panel, pageSettings, radioButtonLight, radioButtonDark, radioButtonContrast,
                labelChooseTheme, settingsTopPanel, settingsTreePanel, labelChoosePath, mainPanel, buttonPanel);
        radioListener = new RadioListener(radioButtonLight, radioButtonDark, radioButtonContrast, page1Panel, pageSettings, themesDesign);
        buttonProperties = new ButtonProperties(colorListener, buttons);
        buttonProperties.buttonPropertiesRun();
        createVarListener = new CreateVarListener(colorListener, pathListener, mainPanel, textFieldCountVar);
        chekItemListener = new CheckItemListener(taskSet, checkAllTask, buttons);
        buttonCreateVar.addActionListener(createVarListener);
        buttonChoose.addActionListener(pathListener);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonDark);
        buttonGroup.add(radioButtonLight);
        buttonGroup.add(radioButtonContrast);
        radioButtonDark.addActionListener(radioListener);
        radioButtonLight.addActionListener(radioListener);
        radioButtonContrast.addActionListener(radioListener);
        themesDesign.initPropertiesBlack();
        checkAllTask.addItemListener(chekItemListener);
    }
}
