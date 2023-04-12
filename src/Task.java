import java.util.Comparator;

public class Task {

    private final int numberTask;

    Task(int numberTask) {
        this.numberTask = numberTask;
    }

    public int getNumberTask() {
        return numberTask;
    }

    public static Comparator<Task> numberComparator = Comparator.comparingInt(Task::getNumberTask);
}
