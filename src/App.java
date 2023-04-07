import javax.swing.*;

import java.awt.*;

public class App extends JFrame {


    App(){
        super("Генератора задач на Теории Веростности");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(mainPanel);
        setSize(720, 360);
        setResizable(false);
        setVisible(true);
        labelTitle.setFont(new Font("Irial", Font.PLAIN, 28));
        labelInputCountVar.setFont(new Font("Irial", Font.PLAIN, 24));
        labelChoseTask.setFont(new Font("Irial", Font.PLAIN, 24));
        labelChoseTask.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        labelTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        labelInputCountVar.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        checkAllTask.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));



    }

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


    private JLabel labelTitle;
    private JLabel labelInputCountVar;
    private JPanel lowPanel;
    private JButton buttonCreateVar;
    private JCheckBox checkAllTask;
    private JLabel labelChoseTask;


    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            setDefaultLookAndFeelDecorated(true);
        }
        new App();
    }
}
