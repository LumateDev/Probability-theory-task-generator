package HomeClasses.ActionPerformedClasses;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PathListener implements ActionListener {
    public String userFilePath;

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser rootChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = rootChoose.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = rootChoose.getSelectedFile();
            userFilePath = selectedFile.getAbsolutePath();
        }
    }

    public String getUserFilePath() {
        return userFilePath;
    }
}
