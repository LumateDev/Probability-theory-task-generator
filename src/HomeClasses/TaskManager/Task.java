package HomeClasses.TaskManager;

import java.util.Comparator;
import java.util.Objects;
public class Task {
    private final int numberTask;
    public Task(int numberTask) {
        this.numberTask = numberTask;
    }
    public int getNumberTask() {
        return numberTask;
    }
    public static Comparator<Task> numberComparator = Comparator.comparingInt(Task::getNumberTask);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return numberTask == task.numberTask;
    }
    @Override
    public int hashCode() {
        return Objects.hash(numberTask);
    }
    @Override
    public String toString() {
        return "" + numberTask;
    }
}

