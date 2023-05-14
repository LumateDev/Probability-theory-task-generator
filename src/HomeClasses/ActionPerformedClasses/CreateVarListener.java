package HomeClasses.ActionPerformedClasses;

import HomeClasses.ConfigurationClasses.PathWRC;
import HomeClasses.MyException.MyExceptionNotPositive;
import HomeClasses.TaskManager.Task;
import HomeClasses.docx.WordWriter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateVarListener implements ActionListener {
    static PathWRC pathWRC = new PathWRC();
    private final String defaultFilePath = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Варианты";
    private final Set<Task> taskSet;
    private static String userFilePath;
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

    static {
        try {
            userFilePath = pathWRC.readFromTxt();
            if(userFilePath.isEmpty()){
                userFilePath = null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserFilePath() {
        return userFilePath;
    }

    public void setUserFilePath(String userFilePath) {
        CreateVarListener.userFilePath = userFilePath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            int countVar = Integer.parseInt(textFieldCountVar.getText());
            if(countVar <= 0){throw new MyExceptionNotPositive();}
            String answer;
            answer = "Создание успешно завершено! Ваши " + countVar + " вариантов находятся в папке " +
                    Objects.requireNonNullElse(userFilePath, "'Варианты' на рабочем столе ") +
                    "\nНабор номеров в варианте: ";
            String remark = "\n\nТак же при желании вы можете сменить путь сохранения сгенерированных вариантов во вкладке 'Настройки'.";

            /**
             * Пацаны вы просто зацените эту строку, это вообще кайф. Она столько когда заменила.
             * У меня ещё было пару вариантов немного другой реализации, но в итоге я выбрал эту,
             * она и по времени сбалансированная и лаконичная, и читабельная.
             * @see Task
             * @see <a href="https://javarush.com/groups/posts/2203-stream-api">Вот документация по StreamAPI.</a>
             *
             * @author mattakvshi
             */

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

                /**
                 * Пример вызова класса с back-end кода.
                 * @see Task
                 * @see <a href="https://javarush.com/groups/posts/2203-stream-api">Вот документация по StreamAPI.</a>
                 *
                 * @author Dmitriy + mattakvshi
                 */

                int [] taskArray = taskSet.stream()
                        .sorted(Task.numberComparator)
                        .mapToInt(Task::getNumberTask)
                        .toArray();

                /**
                 * Пример вызова класса с back-end кода.
                 * @see WordWriter
                 *
                 * @author Alex + mattakvshi
                 */
                WordWriter wordWriter = new WordWriter
                (
                        taskArray,
                        countVar,
                        Objects.requireNonNullElse(userFilePath, defaultFilePath),
                        Integer.parseInt(fontSizeListener.getFontSize()),
                        fontFamilyListener.getFontFamily(),
                        true
                );
            }
        }
        catch (Exception ex){
            if(ex instanceof MyExceptionNotPositive){
                System.out.println(ex.getMessage());
                String answer = "Введите корректное количество вариантов!\n" +
                        "Количество вариантов должно быть положительным числом!";
                JOptionPane.showMessageDialog(mainPanel,answer);
                textFieldCountVar.setText("");
            }
            else if(ex instanceof  NumberFormatException){
                System.out.println(ex.getMessage());
                String answer = "Введите корректное количество вариантов!\n" +
                        "Вы серьёзно? Колличество должно быть задано целым числом!";
                JOptionPane.showMessageDialog(mainPanel,answer);
                textFieldCountVar.setText("");
            }
            else if(ex instanceof NullPointerException){
                System.out.println(ex.getMessage());
                String answer = "Упс! Что-то пошло не так..\n" +
                        "Попробуйте заного выбрать нужные вам настройки." +
                        "Так же, если вы указывали путь, попробуйте его изменить.";
                JOptionPane.showMessageDialog(mainPanel,answer);
                textFieldCountVar.setText("");
            }
            else {
                System.out.println(ex.getMessage());
                String answer = "Если это сообщение вылезло, всё плохо...\n" +
                        " зовите команду разработчиков!";
                JOptionPane.showMessageDialog(mainPanel, answer);
                textFieldCountVar.setText("");
            }
        }
    }
}