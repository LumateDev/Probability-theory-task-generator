package HomeClasses.ActionPerformedClasses;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PathListener implements ActionListener {
    public String userFilePath;
    private final JLabel labelChoosePath;
    private final JButton buttonChoose;
    public PathListener (JLabel labelChoosePath, JButton buttonChoose) {
        this.labelChoosePath = labelChoosePath;
        this.buttonChoose = buttonChoose;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser rootChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = rootChoose.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = rootChoose.getSelectedFile();
            userFilePath = selectedFile.getAbsolutePath();
            labelChoosePath.setText(userFilePath);
            buttonChoose.setText("Изменить");
        }
    }

    public String getUserFilePath() {
        return userFilePath;
    }
}
