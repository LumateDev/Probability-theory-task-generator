package HomeClasses.ActionPerformedClasses;

import HomeClasses.ConfigurationClasses.PathWRC;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PathListener implements ActionListener {
    public String userFilePath;
    private final JLabel labelChoosePath;
    private final JButton buttonChoose;
    private final CreateVarListener createVarListener;
    public PathListener (JLabel labelChoosePath, JButton buttonChoose, CreateVarListener createVarListener) {
        this.labelChoosePath = labelChoosePath;
        this.buttonChoose = buttonChoose;
        this.createVarListener = createVarListener;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser rootChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = rootChoose.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = rootChoose.getSelectedFile();
            userFilePath = selectedFile.getAbsolutePath();
            labelChoosePath.setText(userFilePath);
            System.out.println(userFilePath);
            createVarListener.setUserFilePath(userFilePath);
            buttonChoose.setText("Изменить");
            PathWRC pathWRC = new PathWRC();
            pathWRC.writeInTxt(userFilePath);
        }
    }
}
