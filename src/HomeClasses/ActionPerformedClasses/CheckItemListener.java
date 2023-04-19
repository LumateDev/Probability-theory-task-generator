package HomeClasses.ActionPerformedClasses;

import HomeClasses.TaskManager.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

public class CheckItemListener implements ItemListener
{
    private final Set<Task> taskSet;
    private final JCheckBox checkAllTask;
    private final JButton[] buttons;
    public CheckItemListener(Set<Task> taskSet, JCheckBox checkAllTask, JButton[] buttons){
        this.taskSet = taskSet;
        this.checkAllTask = checkAllTask;
        this.buttons = buttons;
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (JButton button : buttons) {
            selectButton(button);
        }
    }
}
