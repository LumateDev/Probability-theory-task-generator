package HomeClasses.docx;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

import java.io.*;

public class FileDocx {
    private final String nameFile;
    private final XWPFDocument docx;
    private XWPFTable table;
    private XWPFParagraph paragraph;
    private XWPFRun run;
    private final String font;
    private final int fontSize;
    FileDocx(String nameFile, String font, int fontSize){
        this.nameFile = nameFile;
        this.font = font;
        this.fontSize = fontSize;
        docx = new XWPFDocument();
    }
    void newParagraph(){
        paragraph = docx.createParagraph();
        run = paragraph.createRun();
    }
    void addHeader(String str){
        addTextBoltCenter(str);
        newParagraph();
        run.setFontSize(fontSize);
        run.setText("Фамилия______________________Группа________");
        run.addBreak();
        run.setFontFamily(font);
    }
    void addTextBreak(String str){
        run = paragraph.createRun();
        run.setFontSize(fontSize);
        run.setText(str);
        run.addBreak();
        run.setFontFamily(font);
    }
    void addText(String str){
        run = paragraph.createRun();
        run.setFontSize(fontSize);
        run.setText(str);
        run.addTab();
        run.setFontFamily(font);
    }
    void addTextArray(int[] array){
        run.setFontSize(fontSize);
        run.setFontFamily(font);
        for (int j : array) run.setText(j + ", ");
    }
    void addTextBoltCenter(String str){
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run.setFontSize(fontSize);
        run.setBold(true);
        run.setText(str);
        run.addBreak();
        run.setFontFamily(font);
    }
    void addTextBolt(String str){
        run.setFontSize(fontSize);
        run.setBold(true);
        run.setText(str);
        run.setFontFamily(font);
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
        table.setCellMargins(5, 200, 5, 200);
    }
    void addTaleItem(String str, int row, int col){
        paragraph = table.getRow(row).getCell(col).getParagraphs().get(0);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setFontSize(fontSize);
        run.setText(str);
        run.setFontFamily(font);
    }
    void addTableArrayRow(String[] s, int row){
        for(int i = 0; i < s.length; i++){
            addTaleItem(s[i], row, i);
        }
    }
    void initCol(int[] taskArray){
        for(int i = 0; i < taskArray.length; i++) {
            addTaleItem(String.valueOf(taskArray[i]), i + 1, 0);
        }
    }
    void initRow(int numRow){
        addTaleItem("№", 0, 0);
        for(int i = 1; i <= numRow; i++){
            addTaleItem("Вар-"+i, 0, i);
        }
    }
    void initRow(int a, int b){
        addTaleItem("№", 0, 0);
        for(int i = 0; i < b; i++){
            addTaleItem("Вар-" + a, 0, i+1);
            a++;
        }
    }

    void addPicture(String picture, int width, int height){
        File image = new File(picture);
        FileInputStream imageData = null;
        try {
            imageData = new FileInputStream(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
        String imageFileName = image.getName();
        try {
            run.addPicture(imageData, imageType, imageFileName,
                    Units.toEMU(width),
                    Units.toEMU(height));
            run.addBreak();
        } catch (InvalidFormatException | IOException e) {
            throw new RuntimeException(e);
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
