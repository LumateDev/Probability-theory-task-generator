import java.io.File;
import java.util.*;

public class WordWriter {
    private final int[] taskArray;
    private final int counterVariantos;
    private FileDocx fileDocx;
    private FileDocx fileOtvet;

    private String filesPath;

    //todo создать путь по умолчанию
    //todo создать путь выбранный пользователем
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

        //todo создавать файлы по выбраному пути
        fileOtvet = new FileDocx("ответы");
        fileOtvet.initTable(taskArray.length+1, counterVariantos);
        for(int variant = 1; variant <= counterVariantos; variant++){
            //code create File variant
            fileDocx = new FileDocx("Вариант " + String.valueOf(variant));
            fileOtvet.addTaleItem("Вар-" + variant,0, variant-1);
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
                fileOtvet.addTaleItem(createTask1(var+1), 1, var);
                break;
            case 2:
                fileDocx.addTextBolt("2. ");
                fileOtvet.addTaleItem(createTask2(var+1), 2, var);
                break;
            case 3:
                //other code
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
}
