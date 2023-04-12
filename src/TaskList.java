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
        if (!(ind > -1)){
            tl.add(task);
        }
    }

    void delByTaskNumber(int taskNumber){
        int ind = -1;
        for(int i=0; i < tl.size(); i ++){
            if(tl.get(i).getNumberTask() == taskNumber)
                ind = i;
        }
        if (ind > -1){
            tl.remove(ind);
        }
    }
    public String printNumber(){
        StringBuilder s= new StringBuilder();
        for (Task task : tl) s.append(" ").append(task.getNumberTask());
        return s.toString();
    }
    public void sort(){
       tl.sort(Task.numberComparator);
    }
    public int getSize() {
        return tl.size();
    }

}

