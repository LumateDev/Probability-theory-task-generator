import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> tl;
    TaskList(){
        tl = new ArrayList<>();
    }

    void add(Task task){

        int ind = -1;
        for(int i=0; i < tl.size(); i ++){
            if(tl.get(i).getNumberTask() == task.getNumberTask())
                ind = i;
        }
        if (ind > -1){
            System.out.println("Элемент " + ind + " уже в списке");
        }
        else
        {

            tl.add(task);
            System.out.println("Элемент " + ind + " был добавлен");
        }

    }
    /*void add(Task task){
        tl.add(task);
    }*/

    void delByTaskNumber(int taskNumber){
        int ind = -1;
        for(int i=0; i < tl.size(); i ++){
            if(tl.get(i).getNumberTask() == taskNumber)
                ind = i;
        }
        if (ind > -1){
            tl.remove(ind);
            System.out.println("Элемент " + ind + " был удалён");
        }
        else
        {
            System.out.println("Элемент " + ind + " не найден");
        }
    }

    public void print() {
        for(int i = 0; i < tl.size(); i ++)
            System.out.println(tl.get(i).getNumberTask());
            //tl.get(i).printNumber();
        ;
    }
    public String printNumber(){
        StringBuilder s= new StringBuilder();
        for(int i = 0; i <tl.size();i ++)
            s.append(" ").append(tl.get(i).getNumberTask());
        return s.toString();
    }
    //todo
    public void sort(){

    }

}

