package HomeClasses.docx;

import HomeClasses.ActionPerformedClasses.CreateVarListener;

import java.io.File;
import java.util.*;

public class WordWriter {
    private final int[] taskArray;
    private final int countVariants;
    private FileDocx fileDocx;
    private FileDocx fileAnswers;
    private final String filesPath;
    int fontSize;
    String fontFamily;
    private final String[] specialSymbols = {"xᵢ", "xᵢ₊₁", "xᵢ - xᵢ₊₁", "nᵢ", "n₃", "X̅", "ʙ",  "x̅ᵧ", "ρyx", "y̅", "x̅", "y̅ₓ"};
    private final String [] specialSymbolsX = {"x₁", "x₂" ,"x₃", "x₄"};
    public WordWriter(int[] taskArray, int countVariants, String filesPath, int fontSize, String fontFamily){
        this.taskArray = taskArray;
        this.countVariants = countVariants;
        this.filesPath = filesPath;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        System.out.println(filesPath);
        File theDir = new File(filesPath);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        System.out.println(filesPath);
        createVariants();
    }
    String arrayToString(int[] array){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < array.length-1; i++)
            str.append(array[i]).append(", ");
        str.append(array[array.length - 1]).append(" ");
        return str.toString();
    }
    int getRandomNumber(int min, int max){
        return new Random().nextInt(max - min) + min;
    }

    double getRandomNumber(double min, double max){
        return min + Math.random() * (max - min);
    }

    void createVariants(){
        fileAnswers = new FileDocx(filesPath + "\\ответы", fontFamily, 16);
        int k = 0;
        int col = 1;
        int row = 1;
        for(int variant = 1; variant <= countVariants; variant++){
            //code create File variant
            if(k  == 8 || k == 0){
                if(countVariants - variant >= 8){
                    fileAnswers.newParagraph();
                    fileAnswers.initTable(taskArray.length+1, 9);
                    fileAnswers.initRow(variant, 8);
                    fileAnswers.initCol(taskArray);
                    col = 1;
                    row = 1;
                }
                else{
                    fileAnswers.newParagraph();
                    fileAnswers.initTable(taskArray.length+1, (countVariants - variant) + 2);
                    fileAnswers.initRow(variant, countVariants - variant + 1);
                    fileAnswers.initCol(taskArray);
                    col = 1;
                    row = 1;
                }
                k = 0;
            }
            k++;
            fileDocx = new FileDocx(filesPath + "\\Вариант " + variant, fontFamily, fontSize);
            fileDocx.newParagraph();
            fileDocx.addHeader("Тест 2. Вариант " + variant);
            for(int task = 0; task < taskArray.length; task++){
                fileDocx.newParagraph();
                createTask(taskArray[task], variant, row, col);
                row++;
            }
            col++;
            row = 1;
            fileDocx.printToFile();
        }

        fileAnswers.printToFile();
    }

    void createTask(int t, int var, int row, int col) {
        switch (t){
            case 1:
                fileDocx.addTextBolt("1.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask1(var), row, col);
                break;
            case 2:
                fileDocx.addTextBolt("2.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask2(var), row, col);
                break;
            case 3:
                fileDocx.addTextBolt("3.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask3(var), row, col);
                break;
            case 4:
                fileDocx.addTextBolt("4.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask4(var), row, col);
                break;
            case 5:
                fileDocx.addTextBolt("5.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask5(var), row, col);
                break;
            case 6:
                fileDocx.addTextBolt("6.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask6(var), row, col);
                break;
            case 7:
                fileDocx.addTextBolt("7.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask7(var), row, col);
                break;
            case 8:
                fileDocx.addTextBolt("8.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask8(var), row, col);
                break;
            case 9:
                fileDocx.addTextBolt("9.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask9(var), row, col);
                break;
            case 10:
                fileDocx.addTextBolt("10.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask10(var), row, col);
                break;
            case 11:
                fileDocx.addTextBolt("11.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask11(var), row, col);
                break;
            case 12:
                fileDocx.addTextBolt("12.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask12(var), row, col);
                break;
            case 13:
                fileDocx.addTextBolt("13.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask13(var), row, col);
                break;
            case 14:
                fileDocx.addTextBolt("14.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask14(var), row, col);
                break;
            case 15:
                fileDocx.addTextBolt("15.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask15(var), row, col);
                break;
            case 16:
                fileDocx.addTextBolt("16.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask16(var), row, col);
                break;
            case 17:
                fileDocx.addTextBolt("17.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask17(var), row, col);
                break;
            case 18:
                fileDocx.addTextBolt("18.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask18(var), row, col);
                break;
            case 19:
                fileDocx.addTextBolt("19.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask19(var), row, col);
                break;
            case 20:
                fileDocx.addTextBolt("20.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask20(var), row, col);
                break;
            case 21:
                fileDocx.addTextBolt("21.");
                fileDocx.addTab();
                fileAnswers.addTaleItem(createTask21(var), row, col);
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
        String[] rowTable = new String[]{ specialSymbols[2], "0-2", "2-4", "4-6", "6-8", "8-10" };
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
        rowTable = new String[]{specialSymbols[3], "6", "14", specialSymbols[4], "20", "12"};
        fileDocx.addTableArrayRow(rowTable, 1);

        fileDocx.newParagraph();
        fileDocx.addTextBreak("Тогда значение " + specialSymbols[4] + " равно:");

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
        String[] rowTable = new String[]{ specialSymbols[0], "3", "4", "5", "6", "7" };
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
        rowTable = new String[]{specialSymbols[3], "15", "35", specialSymbols[4], "25", "7"};
        fileDocx.addTableArrayRow(rowTable, 1);

        fileDocx.newParagraph();
        fileDocx.addTextBreak("Тогда относительная частота варианты " + specialSymbols[0] + " = 5 равна:");

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

    String createTask5(int var){
        while (var > 4)
            var -= 4;
        double answer = 0.0;
        fileDocx.addText("Из генеральной совокупности извлечена выборка объема n = 160,");

        if(var == 1){
            answer = 0.15;
        }
        else if(var == 2){
            answer = 0.36;
        }
        else if(var == 3){
            answer = 0.25;
        }
        else if(var == 4){
            answer = 0.13;
        }
        fileDocx.addTextBreak("полигон частот которой имеет вид: ");
        fileDocx.addPicture("src\\res\\image\\график задание 5.png", 309, 196);
        fileDocx.addTextBreak("Тогда относительная частота варианты " + specialSymbolsX[var-1] + " = " + var *2 +" в выборке равна:");

        String[] s = {"0.15", "0.36", "0.25", "0.13"};
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
    String createTask6(int var){
        while (var > 4)
            var -= 4;
        String answer = "0";
        String questionStr = "Из генеральной совокупности извлечена выборка объёма n = 250, гистограмма относительных частот которой имеет вид:";
        if(var == 1){
            fileDocx.addTextBreak(questionStr);
            fileDocx.addPicture("src\\res\\image\\график задание 6А.png", 385, 268);
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStr);
            fileDocx.addPicture("src\\res\\image\\график задание 6Б.png", 385, 268);
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStr);
            fileDocx.addPicture("src\\res\\image\\график задание 6В.png", 385, 268);
        }
        else if(var == 4){
            fileDocx.addTextBreak("Из генеральной совокупности извлечена выборка объёма n = 252, гистограмма относительных частот которой имеет вид:");
            //fileDocx.addPicture("src\\res\\image\\график задание 6A.png", 385, 268);
        }
        String[] rowHeader = new String[]{ specialSymbols[2], "0-4", "4-8", "8-12", "12-16" };
        String[] rowTable;
        String[] s = {"1", "2", "3", "4"};
        String [] b = new String[] {"а", "б", "в","г"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        for(int i = 0; i < 4; i++){
            fileDocx.newParagraph();
            fileDocx.addText(" " + b[i] + ") ");
            if(v.get(i).equals(Integer.toString(var)))
                answer = b[i];
            if(v.get(i).equals(Integer.toString(1))){
                fileDocx.initTable(2, 5);
                fileDocx.addTableArrayRow(rowHeader,0);
                rowTable = new String[]{specialSymbols[3], "20", "50", "120", "60"};
                fileDocx.addTableArrayRow(rowTable,1);
            }
            if(v.get(i).equals(Integer.toString(2))){
                fileDocx.initTable(2, 5);
                fileDocx.addTableArrayRow(rowHeader,0);
                rowTable = new String[]{specialSymbols[3], "20", "50", "60", "120"};
                fileDocx.addTableArrayRow(rowTable,1);
            }
            if(v.get(i).equals(Integer.toString(3))){
                fileDocx.initTable(2, 5);
                fileDocx.addTableArrayRow(rowHeader,0);
                rowTable = new String[]{specialSymbols[3], "120", "50", "20", "60"};
                fileDocx.addTableArrayRow(rowTable,1);
            }
            if(v.get(i).equals(Integer.toString(4))){
                fileDocx.initTable(2, 5);
                fileDocx.addTableArrayRow(rowHeader,0);
                rowTable = new String[]{specialSymbols[3], "48", "64", "20", "120"};
                fileDocx.addTableArrayRow(rowTable,1);
            }
        }
        return answer;
    }
    String createTask7(int var){
        while (var > 4)
            var -= 4;
        double answer = 0.0;
        String[] rowTable = new String[]{ specialSymbols[0], "12", "14", "15", "19"};
        String questionStr = "Из генеральной совокупности извлечена выборка объёма n = ";
        if(var == 1){
            fileDocx.addTextBreak(questionStr + 40 + ":");
            answer = 13.1;
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStr + 27.5 + ":");
            answer = 19.0;
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStr + 655 + ":");
            answer = 0.8;
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStr + 349 + ":");
            answer = 1.5;
        }
        //запись таблицы
        fileDocx.initTable(2, 5);
        fileDocx.addTableArrayRow(rowTable, 0);
        rowTable = new String[]{specialSymbols[3], "22", "14", "3", "1"};
        fileDocx.addTableArrayRow(rowTable, 1);

        fileDocx.newParagraph();
        fileDocx.addTextBreak("Тогда несмещенная оценка математического ожидания равна: ");

        String[] s = {"0.8", "1.5", "13.1", "19.0"};
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
    String createTask8(int var){
        while (var > 4)
            var -= 4;
        double answer = 0.0;
        String questionStrBegin = "В результате измерений некоторой физической величины одним прибором " +
                "(без систематических ошибок) получены следующие результаты (в мм): ";
        String questionStrEnd = "Тогда несмещенная оценка дисперсии равна:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "4,6; 6,2; 6,6. " + questionStrEnd);
            answer = 1.12;
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "5,2; 6,4; 7,0. " + questionStrEnd);
            answer = 0.84;
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin +"7,3; 8,4; 9,2. " + questionStrEnd);
            answer = 0.91;
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "5,2; 6,5; 9,3. " + questionStrEnd);
            answer = 4.39;
        }

        String[] s = {"1.12", "0.84", "0.91", "4.39"};
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

    String createTask9(int var){
        while (var > 4)
            var -= 4;
        int answer = 0;
        String questionStrBegin = "Проведено четыре измерения (без систематических ошибок) некоторой " +
                "случайной величины (в мм): 2, 3, 4, x. Если выборочная дисперсия равна ";
        String questionStrEnd =", то значение x равно:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + 3.5 + questionStrEnd);
            answer = 7;
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + 0.5 + questionStrEnd);
            answer = 3;
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + 12.5 + questionStrEnd);
            answer = 11;
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + 27.5 + questionStrEnd);
            answer = 15;
        }

        String[] s = {"7", "3", "11", "15"};
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

    String createTask10(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Если все варианты " + specialSymbols[0] + " исходного вариационного ряда увеличить ";
        String questionStrEnd = ", то выборочная дисперсия Dв:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "в 2 раза" + questionStrEnd);
            answer = "увеличится в четыре раза";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "в 3 раза" + questionStrEnd);
            answer = "увеличиться в девять раз";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "на 9 единиц" + questionStrEnd);
            answer = "не измениться";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "в 5 раз" + questionStrEnd);
            answer = "увеличиться в 25 раз";
        }

        String[] s = {"увеличится в четыре раза", "увеличиться в девять раз", "не измениться", "увеличиться в 25 раз"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addTextBreak("   а) " + v.get(0));
        fileDocx.addTextBreak("   б) " + v.get(1));
        fileDocx.addTextBreak("   в) " + v.get(2) );
        fileDocx.addTextBreak("   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }
    String createTask11(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Если все варианты " + specialSymbols[0] + " исходного вариационного ряда ";
        String questionStrEnd = ", то выборочное среднее " + specialSymbols[5] + specialSymbols[6] + ":";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "уменьшить на 3 единицы" + questionStrEnd);
            answer = "уменьшится на три единицы";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "увеличить в три раза" + questionStrEnd);
            answer = "увеличиться в три раза";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "уменьшить в три раза" + questionStrEnd);
            answer = "уменьшиться в три раза";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "увеличить на три единицы" + questionStrEnd);
            answer = "увеличиться на 3 единицы";
        }

        String[] s = {"уменьшится на три единицы", "увеличиться в три раза",
                "уменьшиться в три раза", "увеличиться на 3 единицы"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addTextBreak("   а) " + v.get(0));
        fileDocx.addTextBreak("   б) " + v.get(1));
        fileDocx.addTextBreak("   в) " + v.get(2));
        fileDocx.addText("   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask12(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Дан доверительный интервал ";
        String questionStrEnd = " для оценки математического ожидания нормально распределенного количественного признака" +
                " при известном среднем квадратическом отклонении генеральной совокупности. Тогда при увеличении объема выборки ";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "(20,4; 25,6)" + questionStrEnd + "в четыре раза этот" +
                    " доверительный интервал примет вид:");
            answer = "(21,7; 24,3)";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "(10,3; 12,7)" + questionStrEnd + "в девять раз этот" +
                    " доверительный интервал примет вид:");
            answer = "(10.7; 12.3)";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "(14,1; 20,5)" + questionStrEnd + "в четыре раза этот" +
                    " доверительный интервал примет вид:");
            answer = "(15,7; 18,9)";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "(16,4; 24,2)" + questionStrEnd + "в девять раз этот" +
                    " доверительный интервал примет вид:");
            answer = "(17,7; 22,9)";
        }

        String[] s = {"(21,7; 24,3)", "(10.7; 12.3)", "(15,7; 18,9)", "(17,7; 22,9)"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask13(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Дан доверительный интервал ";
        String questionStrEnd = " для оценки математического ожидания нормально распределенного количественного признака." +
                " Тогда точность этой оценки равна:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "(15,24; 17,64)" + questionStrEnd );
            answer = "1,2";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "(14,91; 22,61)" + questionStrEnd );
            answer = "3,85";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "(5,15; 11,05)" + questionStrEnd );
            answer = "2,95";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "(13,57; 17,97)" + questionStrEnd );
            answer = "2,2";
        }

        String[] s = {"1,2", "3,85", "2,95", "2,2"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask14(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Точечная оценка математического ожидания нормально распределенного количественного признака равна ";
        String questionStrEnd = "Тогда его интервальная оценка с точностью";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "10,05. " + questionStrEnd  + " 0,95 имеет вид:");
            answer = "(9,1; 11)";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "9,6. " + questionStrEnd + " 1,4 имеет вид:" );
            answer = "(4,1; 5,5)";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "14. " + questionStrEnd + " 2 имеет вид:");
            answer = "(6; 8)";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "5,2. " + questionStrEnd + " 1,1 имеет вид:");
            answer = "(2,05; 3,15)";
        }

        String[] s = {"(9,1; 11)", "(4,1; 5,5)", "(6; 8)", "(2,05; 3,15)"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }
    String createTask15(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "может определяться из соотношения:";
        if(var == 1){
            fileDocx.addTextBreak("Левосторонняя критическая область " + questionStrBegin);
            answer = "P(K < – 2,4) = 0,06";
        }
        else if(var == 2){
            fileDocx.addTextBreak("Правосторонняя критическая область " + questionStrBegin);
            answer = "P(K >2,4) = 0,06";
        }
        else if(var == 3){
            fileDocx.addTextBreak("Двусторонняя критическая область " + questionStrBegin);
            answer = "P(K < – 2,4) + P(K >2,4)=0,12";
        }
        else if(var == 4){
            fileDocx.addTextBreak("Область принятия гипотезы " + questionStrBegin);
            answer = "P(K > – 2,4) = 0,06";
        }

        String[] s = {"P(K < – 2,4) = 0,06", "P(K >2,4) = 0,06", "P(K < – 2,4) + P(K >2,4)=0,12", "P(K > – 2,4) = 0,06"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addTextBreak("   а) " + v.get(0) + "   б) " + v.get(1));
        fileDocx.addTextBreak("   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask16(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Соотношением вида ";
        String questionStrEnd = " можно определить";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "P(K < − 1,09) = 0,03" + questionStrEnd);
            answer = "левостороннюю критическую область";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "P(K >  1,09) = 0,03" + questionStrEnd);
            answer = "правостороннюю критическую область";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "P(K < – 1,09) + P(K >1,09) = 0,03" + questionStrEnd);
            answer = "двустороннюю критическую область";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "P(K > − 1,09) = 0,03" + questionStrEnd);
            answer = "область принятия гипотезы";
        }

        String[] s = {"левостороннюю критическую область", "правостороннюю критическую область",
                "двустороннюю критическую область", "область принятия гипотезы"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addTextBreak("   а) " + v.get(0));
        fileDocx.addTextBreak("   б) " + v.get(1));
        fileDocx.addTextBreak("   в) " + v.get(2));
        fileDocx.addText("   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask17(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Основная гипотеза имеет вид H₀:";
        String questionStrEnd = "Тогда конкурирующей может являться гипотеза:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + " ρ = 0,7 " + questionStrEnd);
            answer = "H₁: ρ > 0,7";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + " ρ = 2 " + questionStrEnd);
            answer = "H₁: ρ ≤ 1";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + " ρ = 1 " + questionStrEnd);
            answer = "H₁: ρ ≠ 1";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + " ρ = 0,9 " + questionStrEnd);
            answer = "H₁: ρ ≠ 0,9";
        }

        String[] s = {"H₁: ρ > 0,7", "H₁: ρ ≤ 1", "H₁: ρ ≠ 1", "H₁: ρ ≠ 0,9"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask18(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Выборочное уравнение прямой линии регрессии X на Y имеет вид ";
        String questionStrEnd = ". Тогда выборочное среднее признака";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[7] + " - 35,2 = -3,5(y - 25,9)" + questionStrEnd + " y равно:");
            answer = "25,9";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[7] + " - 35,2 = -3,5(y + 25,9)" + questionStrEnd + " x равно:");
            answer = "35,2";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[7] + " + 35,2 = -3,5(y + 25,9)" + questionStrEnd + " x равно:");
            answer = "-35,2";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[7] + " -35,2 = -3,5(y + 25,9)" + questionStrEnd + " y равно:");
            answer = "-25,9";
        }

        String[] s = {"25,9", "35,2", "-35,2", "-25,9"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask19(int var){
        while (var > 4)
            var -= 4;
        String answer = "";
        String questionStrBegin = "Выборочное уравнение прямой линии регрессии X на Y имеет вид: ";
        String questionStrEnd = ". Тогда выборочный коэффициент корреляции может быть равен:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + "x = -5,72 + 3,36y" + questionStrEnd);
            answer = "0,81";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + "x = 5,72 - 3,36y" + questionStrEnd);
            answer = "-0,5";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + "y = -5,72 + 3,36x" + questionStrEnd);
            answer = "0,81";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + "y = 5,72 - 3,36x" + questionStrEnd);
            answer = "-0,5";
        }

        String[] s = {"-0,5", "-2", "0,81", "2,36"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals((answer)))
                return b[k];
            k ++;
        }
        return "Error";
    }

    String createTask20(int var){
        while (var > 4)
            var -= 4;
        String answer = "0";
        String questionStrBegin = "При построении выборочного уравнения прямой линии регрессии Y на X вычислены выборочный коэффициент регрессии ";
        String questionStrEnd = ". Тогда уравнение регрессии примет вид:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[8] + " = -3,4 и выборочные средние " + specialSymbols[10] +
                    " = 7,54 и " + specialSymbols[9] + " = 2,67 " + questionStrEnd);
            answer = specialSymbols[11] + " = -3,4x + 28,306";
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[8] + " = 3,4 и выборочные средние " + specialSymbols[10] +
                    " = -7,54 и " + specialSymbols[9] + " = 2,67 " + questionStrEnd);
            answer = specialSymbols[11] + " = 3,4x + 28,306";
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[8] + " = -3,4 и выборочные средние " + specialSymbols[10] +
                    " = 1,7 и " + specialSymbols[9] + " = 1,76 " + questionStrEnd);
            answer = specialSymbols[11] + " = -3,4x + 7,54";
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + specialSymbols[8] + " = -3,4 и выборочные средние " + specialSymbols[10] +
                    " = 0,5 и " + specialSymbols[9] + " = 7,54 " + questionStrEnd);
            answer = specialSymbols[11] + " -7,54 = -3,4x + 1,7";
        }
        String[] s = {specialSymbols[11] + " = -3,4x + 28,306", specialSymbols[11] + " = 3,4x + 28,306", specialSymbols[11] + " = -3,4x + 7,54", specialSymbols[11] + " -7,54 = -3,4x + 1,7"};
        List<String> v = new ArrayList<>(Arrays.asList(s));
        Collections.shuffle(v);
        fileDocx.addText("   а) " + v.get(0) + "   б) " + v.get(1) + "   в) " + v.get(2) + "   г) " + v.get(3));
        String [] b = new String[] {"а", "б", "в","г"};
        int k = 0;
        for(String i : v){
            if(i.equals(answer))
                return b[k];
            k ++;
        }
        return "Error";
    }
    String createTask21 (int var){
        while (var > 4)
            var -= 4;
        double answer = 0.0;
        String questionStrBegin = "При построении выборочного уравнения парной регрессии вычислены выборочный коэффициент корреляции";
        String questionStrEnd = "и выборочные средние квадратические отклонения \uF073X = 2,5, \uF073Y = 1,25. Тогда выборочный коэффициент регрессии Y на X равен:";
        if(var == 1){
            fileDocx.addTextBreak(questionStrBegin + " r" + specialSymbols[6] +" = 0,64  " + questionStrEnd);
            answer = 0.32;
        }
        else if(var == 2){
            fileDocx.addTextBreak(questionStrBegin + " r" + specialSymbols[6] +" = -0,64  " + questionStrEnd);
            answer = -0.32;
        }
        else if(var == 3){
            fileDocx.addTextBreak(questionStrBegin + " r" + specialSymbols[6] +" = 0,54  " + questionStrEnd);
            answer = 0.27;
        }
        else if(var == 4){
            fileDocx.addTextBreak(questionStrBegin + " r" + specialSymbols[6] +" = -0,54  " + questionStrEnd);
            answer = -0.27;
        }

        String[] s = {"0.32", "-0.32", "0.27", "-0.27"};
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
