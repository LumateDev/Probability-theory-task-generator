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
    private JLabel labelChooseTheme;
    private JPanel settingsTopPanel;
    private JPanel settingsTreePanel;
    private JLabel labelChoosePath;
    private JButton buttonChoose;

    private final ColorListener cl;


    static class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            if(button.getBackground() !=  new JButton().getBackground()) {
                button.setBackground(new JButton().getBackground());
            }
            else {
                button.setBackground(new Color(66, 144, 224));

            }
        }
    }

    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

             if (radioButtonLight.isSelected()) {
                radioButtonDark.setSelected(false);
                 try {

                     UIManager.setLookAndFeel(new FlatMacLightLaf());
                 } catch (Exception ex) {
                     setDefaultLookAndFeelDecorated(true);
                     ex.printStackTrace();
                 }
                 initPropertiesLight();
                 SwingUtilities.updateComponentTreeUI(page1Panel);
                 SwingUtilities.updateComponentTreeUI(pageSettings);
            }

             else if (radioButtonDark.isSelected()) {
                 try {

                     UIManager.setLookAndFeel(new FlatMacDarkLaf());
                 } catch (Exception ex) {
                     setDefaultLookAndFeelDecorated(true);
                     ex.printStackTrace();
                 }
                 initPropertiesBlack();
                 SwingUtilities.updateComponentTreeUI(page1Panel);
                 SwingUtilities.updateComponentTreeUI(pageSettings);

             }
        }
    }

    static class pathListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser rootChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = rootChoose.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = rootChoose.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        }
    }

    class createVarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                int countVar = Integer.parseInt(textFieldCountVar.getText());
                String answer = "Запрос на создание " + countVar + " вариантов получен" + "\nНомера:";
                JOptionPane.showMessageDialog(mainPanel,answer);
                textFieldCountVar.setText("");
            }
            catch (Exception ex){
                String answer = "Количество вариантов должно быть целым числом";
                JOptionPane.showMessageDialog(mainPanel,answer);
                textFieldCountVar.setText("");
            }
        }
    }



    App(){

        super("Генератора задач по Теории вероятности");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(720, 460);
        setResizable(false);
        setVisible(true);
        cl = new ColorListener();
        RadioListener rl = new RadioListener();

        buttonProp(buttonTask1);
        buttonProp(buttonTask2);
        buttonProp(buttonTask3);
        buttonProp(buttonTask4);
        buttonProp(buttonTask5);
        buttonProp(buttonTask6);
        buttonProp(buttonTask7);
        buttonProp(buttonTask8);
        buttonProp(buttonTask9);
        buttonProp(buttonTask10);
        buttonProp(buttonTask11);
        buttonProp(buttonTask12);
        buttonProp(buttonTask13);
        buttonProp(buttonTask14);

        createVarListener crl = new createVarListener();
        buttonCreateVar.addActionListener(crl);

        pathListener pl = new pathListener();
        buttonChoose.addActionListener(pl);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonDark);
        buttonGroup.add(radioButtonLight);
        radioButtonDark.addActionListener(rl);
        radioButtonLight.addActionListener(rl);
        initPropertiesBlack();

        checkAllTask.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                selectButton(buttonTask1);
                selectButton(buttonTask2);
                selectButton(buttonTask3);
                selectButton(buttonTask4);
                selectButton(buttonTask5);
                selectButton(buttonTask6);
                selectButton(buttonTask7);
                selectButton(buttonTask8);
                selectButton(buttonTask9);
                selectButton(buttonTask10);
                selectButton(buttonTask11);
                selectButton(buttonTask12);
                selectButton(buttonTask13);
                selectButton(buttonTask14);

            }
            public void selectButton (JButton button) {

                if (checkAllTask.isSelected()){
                    button.setBackground( new Color(66,144,224) );

                }
                else{
                    button.setBackground(new JButton().getBackground());

                }
            }
        });

    }

    private void buttonProp(JButton button){
        button.addActionListener(cl);
        button.setFont(new Font("Comic sans mc" , Font.PLAIN , 18));
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

        labelInputCountVar.setFont(new Font("Comic sans mc", Font.PLAIN, 28));
        labelInputCountVar.setForeground(new Color(1,1,1));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));

        labelChoseTask.setFont(new Font("Comic sans mc", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 0));
        labelChoseTask.setForeground(new Color(1,1,1));

        textFieldCountVar.setForeground(new Color(68, 68, 68));
        textFieldCountVar.setBackground(new Color(222, 216, 216));
        textFieldCountVar.setFont(new Font("Comic sans mc" , Font.PLAIN, 16));

        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        checkAllTask.setFont(new Font("Comic sans mc" , Font.PLAIN , 24));
        checkAllTask.setForeground(new Color(1,1,1));
        buttonCreateVar.setFont(new Font("Comic sans mc" , Font.PLAIN , 20));

        labelChooseTheme.setForeground(new Color(1, 1, 1));
        labelChooseTheme.setFont(new Font("Comic sans mc" , Font.PLAIN, 16));

        radioButtonLight.setForeground(new Color(1, 1, 1));
        radioButtonLight.setFont(new Font("Comic sans mc" , Font.PLAIN, 16));

        radioButtonDark.setForeground(new Color(1, 1, 1));
        radioButtonDark.setFont(new Font("Comic sans mc" , Font.PLAIN, 16));

        labelChoosePath.setForeground(new Color(1, 1, 1));
        labelChoosePath.setFont(new Font("Comic sans mc" , Font.PLAIN, 16));



    }
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
        textFieldCountVar.setFont(new Font("Comic sans mc" , Font.PLAIN, 16));
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
