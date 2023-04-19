package HomeClasses.docx;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDocx {
    private final String nameFile;
    private final XWPFDocument docx;
    private XWPFTable table;
    private XWPFParagraph paragraph;
    private XWPFRun run;
    FileDocx(String nameFile){
        this.nameFile = nameFile;
        docx = new XWPFDocument();
    }
    void newParagraph(){
        paragraph = docx.createParagraph();
        run = paragraph.createRun();
    }
    void addHeader(String str){
        addTextBoltCenter(str);
        newParagraph();
        run.setFontSize(18);
        run.setText("Фамилия______________________Группа________");
        run.addBreak();
        run.setFontFamily("Times New Roman");
    }
    void addTextBreak(String str){
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.addBreak();
        run.setFontFamily("Times New Roman");
    }
    void addText(String str){
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.addTab();
        run.setFontFamily("Times New Roman");
    }
    void addTextArray(int[] array){
        run.setFontSize(18);
        run.setFontFamily("Times New Roman");
        for (int j : array) run.setText(j + ", ");
    }
    void addTextBoltCenter(String str){
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run.setFontSize(18);
        run.setBold(true);
        run.setText(str);
        run.addBreak();
        run.setFontFamily("Times New Roman");
    }
    void addTextBolt(String str){
        run.setFontSize(18);
        run.setBold(true);
        run.setText(str);
        run.setFontFamily("Times New Roman");
        run.addTab();
    }
    void setTableAlign(XWPFTable table,ParagraphAlignment align) {
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
        STJc.Enum en = STJc.Enum.forInt(align.getValue());
        jc.setVal(en);
    }
    void initTable(int row, int col){
        table = docx.createTable(row, col);
        setTableAlign(table, ParagraphAlignment.CENTER);
        table.setCellMargins(5, 100, 5, 100);
    }
    void addTaleItem(String str, int row, int col){
        paragraph = table.getRow(row).getCell(col).getParagraphs().get(0);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setFontSize(18);
        run.setText(str);
        run.setFontFamily("Times New Roman");
    }
    void addTableArrayRow(String[] s, int row){
        for(int i = 0; i < s.length; i++){
            addTaleItem(s[i], row, i);
        }
    }
    void initCol(int numCol){
        for(int i = 1; i <= numCol; i++){
            addTaleItem(i+"", i, 0);
        }
    }
    void initRow(int numRow){
        addTaleItem("№", 0, 0);
        for(int i = 1; i <= numRow; i++){
            addTaleItem("Вар-"+i, 0, i);
        }
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
