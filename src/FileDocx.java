import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDocx {
    private String nameFile;
    private XWPFDocument docx;
    private XWPFParagraph paragraph;
    private XWPFRun run;
    FileDocx(String nameFile){
        this.nameFile = nameFile;
        docx = new XWPFDocument();
        paragraph = docx.createParagraph();
    }

    //other code
    public void addTextBreak(String str){
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.addBreak();
    }
    void addText(String str){
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.addTab();
    }

    void addTextBolt(String str){
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setBold(true);
        run.setText(str);
        run.addBreak();
    }
    void printToFile(){
        try {
            FileOutputStream out = new FileOutputStream(nameFile+".docx");
            docx.write(out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
