package HomeClasses.ActionPerformedClasses;

import HomeClasses.TaskManager.Task;
import HomeClasses.docx.WordWriter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateVarListener implements ActionListener {
    private final String defaultFilePath = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Варианты";
    private final Set<Task> taskSet;
    private String userFilePath;
    private final JPanel mainPanel;
    private final JTextField textFieldCountVar;
    FontSizeListener fontSizeListener;
    FontFamilyListener fontFamilyListener;

    public CreateVarListener
    (
            ColorListener colorListener, JPanel mainPanel, JTextField textFieldCountVar,
            FontSizeListener fontSizeListener, FontFamilyListener fontFamilyListener
    )
    {
        this.taskSet = colorListener.getTaskSet();
        this.mainPanel = mainPanel;
        this.textFieldCountVar = textFieldCountVar;
        this.fontSizeListener = fontSizeListener;
        this.fontFamilyListener = fontFamilyListener;
    }

    public void setUserFilePath(String userFilePath) {
        this.userFilePath = userFilePath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            int countVar = Integer.parseInt(textFieldCountVar.getText());
            String answer;
            answer = "Создание успешно завершено! Ваши " + countVar + " вариантов находятся в папке " +
                    Objects.requireNonNullElse(userFilePath, "'Варианты' на рабочем столе ") +
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

                WordWriter wordWriter = new WordWriter
                (
                        taskArray,
                        countVar,
                        Objects.requireNonNullElse(userFilePath, defaultFilePath),
                        Integer.parseInt(fontSizeListener.getFontSize()),
                        fontFamilyListener.getFontFamily()
                );
            }
        }
        catch (Exception ex){
            String answer = "Количество вариантов должно быть целым числом!";
            JOptionPane.showMessageDialog(mainPanel,answer);
            textFieldCountVar.setText("");
        }
    }
}