import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    private final ColorListener cl;
    private final String defaultFilePath = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Варианты";
    private String userFilePath;

    private final Set<Task> taskSet = new HashSet<>();

    private final JButton[] buttons;

     class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            int elem = Integer.parseInt(button.getText());
            Task task = new Task(elem);

            if(button.getBackground() !=  new JButton().getBackground()) {
                button.setBackground(new JButton().getBackground());
                taskSet.remove(task);
            }
            else
            {
                button.setBackground(new Color(66, 144, 224));
                taskSet.add(task);
            }
        }
    }

    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

             if (radioButtonLight.isSelected()) {
                 try{

                     UIManager.setLookAndFeel(new FlatMacLightLaf());
                 }
                 catch (Exception ex){
                     setDefaultLookAndFeelDecorated(true);
                     ex.printStackTrace();
                 }
                 initPropertiesLight();
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
                 initPropertiesBlack();
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
                 initPropertiesContrast();
                 SwingUtilities.updateComponentTreeUI(page1Panel);
                 SwingUtilities.updateComponentTreeUI(pageSettings);
            }
        }
    }
     class pathListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser rootChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = rootChoose.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = rootChoose.getSelectedFile();
                userFilePath = selectedFile.getAbsolutePath();
                System.out.println(userFilePath);
            }
        }
    }

    class createVarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                int countVar = Integer.parseInt(textFieldCountVar.getText());
                String answer;
                answer = "Создание успешно завершено! Ваши " + countVar + " вариантов находятся в папке " + Objects.requireNonNullElse(userFilePath, "Варианты на рабочем столе ") +
                        "\nНабор номеров в варианте: ";

                String remark = "\n\nТак же при желании вы можете сменить путь сохранения сгенерированных вариантов во вкладке 'Настройки'.";
                /* пацаны вы просто зацените эту строку, это вообще кайф. Она столько когда заменила.
                   У меня ещё было пару вариантов немного другой реализации, но в итоге я выбрал эту,
                   она и по времени сбалансированная и лаконичная, и читабельная. */
                String stringNumbersOfSet = taskSet.stream()
                        .sorted(Task.numberComparator)
                        .map(Task::toString)
                        .collect(Collectors
                                .joining(",")
                        );
                if(taskSet.size() == 0)
                    JOptionPane.showMessageDialog(mainPanel, "Выберете хотя бы один номер!");
                else {
                    JOptionPane.showMessageDialog(mainPanel, answer + stringNumbersOfSet + "." + remark );
                    //Пример вызова класса с back-end кода
                    int [] taskArray = taskSet.stream()
                            .sorted(Task.numberComparator)
                            .mapToInt(Task::getNumberTask)
                            .toArray();

                   WordWriter wordWriter = new WordWriter(taskArray, countVar, Objects.requireNonNullElse(userFilePath, defaultFilePath));
                }
            }
            catch (Exception ex){
                String answer = "Количество вариантов должно быть целым числом!";
                JOptionPane.showMessageDialog(mainPanel,answer);
                textFieldCountVar.setText("");
            }
        }
    }
    class checkItemListener implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e) {
            for (JButton button : buttons) {
                selectButton(button);
                //todo time wait
            }
        }
    }
    App(){
        super("Генератора задач по Теории вероятности");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(720, 580);
        setResizable(false);
        setVisible(true);
        buttons = new JButton []{
                buttonTask1,buttonTask2,buttonTask3,buttonTask4,buttonTask5, buttonTask6,buttonTask7,
                buttonTask8,buttonTask9,buttonTask10,buttonTask11,buttonTask12,buttonTask13,buttonTask14,
                buttonTask15, buttonTask16, buttonTask17, buttonTask18,buttonTask19, buttonTask20,buttonTask21
        };
        cl = new ColorListener();
        RadioListener rl = new RadioListener();
        buttonProp();
        createVarListener crl = new createVarListener();
        checkItemListener il = new checkItemListener();
        buttonCreateVar.addActionListener(crl);
        pathListener pl = new pathListener();
        buttonChoose.addActionListener(pl);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonDark);
        buttonGroup.add(radioButtonLight);
        buttonGroup.add(radioButtonContrast);
        radioButtonDark.addActionListener(rl);
        radioButtonLight.addActionListener(rl);
        radioButtonContrast.addActionListener(rl);
        initPropertiesBlack();
        checkAllTask.addItemListener(il);
    }

    private void buttonProp(){

        for (JButton button : buttons) {
            button.addActionListener(cl);
            button.setFont(new Font("Verdana", Font.PLAIN, 18));
        }
    }
    public void selectButton (JButton button) {

        int elem = Integer.parseInt(button.getText());
        Task task = new Task(elem);
        if (checkAllTask.isSelected()){
            button.setBackground( new Color(66,144,224) );
            taskSet.add(task);

        }
        else{
            button.setBackground(new JButton().getBackground());
            taskSet.remove(task);
        }

    }
    private void initPropertiesBlack() {

        tabPane1.setBackground(new Color(26, 26, 26));
        page1Panel.setBackground(new Color(194, 194, 194));
        topPanel.setBackground(new Color(194, 194, 194));
        buttonPanel.setBackground(new Color(194, 194, 194));
        lowPanel.setBackground(new Color(194, 194, 194));
        mainPanel.setBackground(new Color(194, 194, 194));
        pageSettings.setBackground(new Color(194, 194, 194));
        settingsTopPanel.setBackground(new Color(194, 194, 194));
        settingsTreePanel.setBackground(new Color(194, 194, 194));
        labelInputCountVar.setFont(new Font("Verdana", Font.PLAIN, 28));
        labelInputCountVar.setForeground(new Color(1,1,1));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setFont(new Font("Verdana", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setForeground(new Color(1,1,1));
        textFieldCountVar.setForeground(new Color(68, 68, 68));
        textFieldCountVar.setBackground(new Color(222, 216, 216));
        textFieldCountVar.setFont(new Font("Verdana" , Font.PLAIN, 16));
        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Verdana" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(1,1,1));
        buttonCreateVar.setFont(new Font("Verdana" , Font.PLAIN , 20));
        labelChooseTheme.setForeground(new Color(1, 1, 1));
        labelChooseTheme.setFont(new Font("Verdana" , Font.PLAIN, 16));
        radioButtonLight.setForeground(new Color(1, 1, 1));
        radioButtonLight.setFont(new Font("Verdana" , Font.PLAIN, 16));
        radioButtonDark.setForeground(new Color(1, 1, 1));
        radioButtonDark.setFont(new Font("Verdana" , Font.PLAIN, 16));
        radioButtonContrast.setForeground(new Color(1, 1, 1));
        radioButtonContrast.setFont(new Font("Verdana" , Font.PLAIN, 16));
        labelChoosePath.setForeground(new Color(1, 1, 1));
        labelChoosePath.setFont(new Font("Verdana" , Font.PLAIN, 16));
    }

    //todo lightDesign
    private void initPropertiesLight(){
        page1Panel.setBackground(new Color(255, 255, 255));
        topPanel.setBackground(new Color(255, 255, 255));
        tabPane1.setBackground(new Color(96, 96, 96));
        buttonPanel.setBackground(new Color(255, 255, 255));
        lowPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBackground(new Color(255, 255, 255));
        pageSettings.setBackground(new Color(255, 255, 255));
        settingsTopPanel.setBackground(new Color(255, 255, 255));
        settingsTreePanel.setBackground(new Color(255, 255, 255));
        textFieldCountVar.setForeground(new Color(0, 0, 0));
        textFieldCountVar.setBackground(new Color(255, 255, 255));
        textFieldCountVar.setFont(new Font("Verdana" , Font.PLAIN, 16));
    }
    //todo contrastDesign
    private void initPropertiesContrast() {
        tabPane1.setBackground(new Color(30, 30, 30));
        page1Panel.setBackground(new Color(30, 30, 30));
        topPanel.setBackground(new Color(50, 50, 50));
        buttonPanel.setBackground(new Color(30, 30, 30));
        lowPanel.setBackground(new Color(50, 50, 50));
        mainPanel.setBackground(new Color(70, 70, 70));
        pageSettings.setBackground(new Color(30, 30, 30));
        settingsTopPanel.setBackground(new Color(50, 50, 50));
        settingsTreePanel.setBackground(new Color(40, 40, 40));
        labelInputCountVar.setFont(new Font("Verdana", Font.PLAIN, 28));
        labelInputCountVar.setForeground(new Color(170,170,170));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setFont(new Font("Verdana", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setForeground(new Color(170,170,170));
        textFieldCountVar.setForeground(new Color(217, 220, 225));
        textFieldCountVar.setBackground(new Color(88, 88, 88));
        textFieldCountVar.setFont(new Font("Verdana" , Font.PLAIN, 16));
        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Verdana" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(133,133,133));
        labelChooseTheme.setForeground(new Color(150, 150, 150));
        labelChooseTheme.setFont(new Font("Verdana" , Font.PLAIN, 16));
        radioButtonLight.setForeground(new Color(150, 150, 150));
        radioButtonLight.setFont(new Font("Verdana" , Font.PLAIN, 16));
        radioButtonDark.setForeground(new Color(150, 150, 150));
        radioButtonDark.setFont(new Font("Verdana" , Font.PLAIN, 16));
        radioButtonContrast.setForeground(new Color(150, 150, 150));
        radioButtonContrast.setFont(new Font("Verdana" , Font.PLAIN, 16));
        labelChoosePath.setForeground(new Color(133,133,133));
        labelChoosePath.setFont(new Font("Verdana" , Font.PLAIN, 16));

    }

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
