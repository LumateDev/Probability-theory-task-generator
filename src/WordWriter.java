import java.io.File;
import java.util.*;

public class WordWriter {
    private final int[] taskArray;
    private final int counterVariantos;
    private FileDocx fileDocx;
    private FileDocx fileOtvet;
    private String filesPath;

    WordWriter(int[] taskArray, int counterVariantos,String filesPath){
        this.taskArray = taskArray;
        this.counterVariantos = counterVariantos;
        this.filesPath = filesPath;
        File theDir = new File(filesPath);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        createToVariantos();
    }
    String arrayToString(int[] array){
        String str = "";
        for(int i = 0; i < array.length-1; i++)
            str += array[i] + ", ";
        str+= array[array.length-1] + " ";
        return str;
    }
    int getRandomNumber(int min, int max){
        return new Random().nextInt(max - min) + min;
    }

    double getRandomNumber(double min, double max){
        return min + Math.random() * (max - min);
    }

    void createToVariantos(){
        fileOtvet = new FileDocx(filesPath + "\\ответы");
        fileOtvet.initTable(taskArray.length+1, counterVariantos + 1);
        fileOtvet.initRow(counterVariantos);
        fileOtvet.initCol(taskArray.length);
        for(int variant = 1; variant <= counterVariantos; variant++){
            //code create File variant
            fileDocx = new FileDocx(filesPath + "\\Вариант " + String.valueOf(variant));
            fileDocx.newParagraph();
            fileDocx.addHeader("Тест 2. Вариант " + variant);
            for(int task = 0; task < taskArray.length; task++){
                fileDocx.newParagraph();
                createTask(taskArray[task], variant-1);
            }
            fileDocx.printToFile();
        }
        fileOtvet.printToFile();
    }

    void createTask(int t, int var){
        switch (t){
            case 1:
                fileDocx.addTextBolt("1. ");
                fileOtvet.addTaleItem(createTask1(var+1), 1, var+1);
                break;
            case 2:
                fileDocx.addTextBolt("2. ");
                fileOtvet.addTaleItem(createTask2(var+1), 2, var+1);
                break;
            case 3:
                fileDocx.addTextBolt("3. ");
                fileOtvet.addTaleItem(createTask3(var+1), 3, var+1);
                break;
            case 4:
                fileDocx.addTextBolt("4. ");
                fileOtvet.addTaleItem(createTask4(var+1), 4, var+1);
                break;
        }
    }

    String createTask1(int var){
        while (var > 4)
            var -= 4;

        double answer;
        int[] n = {12, 12, 16, 18, 18, 18, 19, 20, 21, 22, 22, 23, 25, 25};
        int[] a = {18, 19, 20, 22};
        n[6] = a[var-1];
        answer = (double) (n[6] + n[7]) / 2;
        fileDocx.addTextBreak("Медиана вариационного ряда " + arrayToString(n) + "равна:");
        String[] s = {"19.5", "20.0", "19.0", "21.0"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals(Double.toString(answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask2(int var){
        while (var > 4)
            var -= 4;
        int [] n = new int[9];
        int answer = 0;
        if(var == 1) {
            n = new int[]{1, 4, 5, 5, 7, 9, 9, 9, 12};
            answer = 9;
        }
        else if (var == 2) {
            n = new int[]{1, 4, 5, 5, 7, 9, 12, 12, 12};
            answer = 12;
        }
        else if (var == 3) {
            n = new int[]{1, 4, 5, 5, 5, 7, 9, 9, 12};
            answer = 5;
        }
        else if (var == 4) {
            n = new int[]{1, 1, 1, 5, 7, 7, 9, 9, 12};
            answer = 1;
        }
        fileDocx.addTextBreak("Мода вариационного ряда " + arrayToString(n) + "равна:");
        String[] s = {"1", "5", "9", "12"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals(Integer.toString(answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask3(int var){
        while (var > 4)
            var -= 4;
        int answer = 0;
        String[] rowTable = new String[]{ "Xi-Xi+1", "0-2", "2-4", "4-6", "6-8", "8-10" };
        String questionStr = "Из генеральной совокупности извлечена выборка объёма n = ";
        if(var == 1){
            fileDocx.addTextBreak(questionStr + 80);
            answer = 28;
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStr + 62);
            answer = 10;
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStr + 68);
            answer = 16;
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStr + 72);
            answer = 20;
        }
        //запись таблицы
        fileDocx.initTable(2, 6);
        fileDocx.addTableArrayRow(rowTable, 0);
        rowTable = new String[]{"Ni", "6", "14", "n3", "20", "12"};
        fileDocx.addTableArrayRow(rowTable, 1);

        fileDocx.newParagraph();
        fileDocx.addTextBreak("Тогда значение n3 равно:");

        String[] s = {"20", "16", "10", "28"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals(Integer.toString(answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask4(int var){
        while (var > 4)
            var -= 4;
        double answer = 0.0;
        String[] rowTable = new String[]{ "Xi", "3", "4", "5", "6", "7" };
        String questionStr = "Из генеральной совокупности извлечена выборка объёма n = ";
        if(var == 1){
            fileDocx.addTextBreak(questionStr + 100);
            answer = 0.18;
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStr + 132);
            answer = 0.5;
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStr + 107);
            answer = 0.25;
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStr + 95);
            answer = 0.13;
        }
        //запись таблицы
        fileDocx.initTable(2, 6);
        fileDocx.addTableArrayRow(rowTable, 0);
        rowTable = new String[]{"Ni", "15", "35", "n3", "25", "7"};
        fileDocx.addTableArrayRow(rowTable, 1);

        fileDocx.newParagraph();
        fileDocx.addTextBreak("Тогда относительная частота варианты Xi = 5 равна:");

        String[] s = {"0.5", "0.25", "0.18", "0.13"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals(Double.toString(answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }
}
