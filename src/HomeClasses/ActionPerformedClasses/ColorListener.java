package HomeClasses.ActionPerformedClasses;

import HomeClasses.TaskManager.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ColorListener implements ActionListener {
    private final Set<Task> taskSet;

    public ColorListener(Set<Task> taskSet){
        this.taskSet = taskSet;
    }
    @Override
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
    public Set<Task> getTaskSet() {
        return taskSet;
    }
}
