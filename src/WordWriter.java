import java.util.Random;

public class WordWriter {
    private int[] taskArray;
    private int counterVariantos;
    private FileDocx fileDocx;
    WordWriter(int[] taskArray, int counterVariantos){
        this.taskArray = taskArray;
        this.counterVariantos = counterVariantos;

        createToVariantos();
    }

    int getRandomNumber(int min, int max){
        return new Random().nextInt(max - min) + min;
    }

    double getRandomNumber(double min, double max){
        return min + Math.random() * (max - min);
    }

    void createToVariantos(){
        //create File result
        for(int variant = 1; variant <= counterVariantos; variant++){
            //code create File variant
            fileDocx = new FileDocx("Вариант " + String.valueOf(variant));
            fileDocx.addTextBoltCenter("Тест 2. Вариант " + variant);
            fileDocx.addHeader();
            for(int task = 0; task < taskArray.length; task++){
                fileDocx.addTextBolt("Задание " + taskArray[task]);
                createTask(taskArray[task]);
            }
            fileDocx.printToFile();
        }
    }

    void createTask(int t){
        switch (t){
            case 1:
                //other code
                fileDocx.addTextBreak("Два стрелка стреляют по мишени. Вероятность попадания в мишень при одном выстреле для первого стрелка равна " +
                        getRandomNumber(0.1, 1) +
                        ", а для второго —" +
                        getRandomNumber(0.1, 1) +
                        ". Найти вероятность того, что при одном залпе в мишень попадает только один из стрелков."
                );
                break;
            case 2:
                fileDocx.addTextBreak("В ящике " +
                        getRandomNumber(5, 15) +
                        " деталей, среди которых шесть окрашенных. Сборщик наудачу извлекает четыре детали. Найти вероятность того, что все извлеченные детали окажутся окрашенными."
                );
                //other code
                break;
            case 3:
                //other code
                break;
        }
    }
}
