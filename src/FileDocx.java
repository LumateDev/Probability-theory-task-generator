import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDocx {
    private String nameFile;
    private XWPFDocument docx;
    private XWPFTable table;
    private XWPFParagraph paragraph;
    private XWPFRun run;
    FileDocx(String nameFile){
        this.nameFile = nameFile;
        docx = new XWPFDocument();
        paragraph = docx.createParagraph();
    }
    //other code
    void addHeader(){
        paragraph = docx.createParagraph();
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText("Фамилия______________________Группа________");
        run.addBreak();
        run.setFontFamily("Times New Roman");
    }
    void addTextBreak(String str){
        //paragraph = docx.createParagraph();
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.addBreak();
        run.setFontFamily("Times New Roman");
    }
    void addText(String str){
        paragraph = docx.createParagraph();
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.addTab();
        run.setFontFamily("Times New Roman");
    }
    void addTextBoltCenter(String str){
        paragraph = docx.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setBold(true);
        run.setText(str);
        run.addBreak();
        run.setFontFamily("Times New Roman");
    }
    void addTextBolt(String str){
        //paragraph = docx.createParagraph();
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setBold(true);
        run.setText(str);
        run.setFontFamily("Times New Roman");
    }
    //Tables
    void setTableAlign(XWPFTable table,ParagraphAlignment align) {
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
        STJc.Enum en = STJc.Enum.forInt(align.getValue());
        jc.setVal(en);
    }
    void initTable(int row, int col){
        table = docx.createTable(row, col);
        setTableAlign(table, ParagraphAlignment.CENTER);
    }
    void addTaleItem(String str, int row, int col){
        paragraph = table.getRow(row).getCell(col).getParagraphs().get(0);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.setFontFamily("Times New Roman");
    }

    void printToFile(){
        try {
            FileOutputStream out = new FileOutputStream(nameFile+".docx");
            docx.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
