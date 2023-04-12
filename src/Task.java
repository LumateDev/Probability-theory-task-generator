public class Task {
    private int value;
    private String description;
    private int numberTask;

    Task(int value, String description, int numberTask) {
        this.value = value;
        this.numberTask = numberTask;
        this.description = description;


    }

    Task(int numberTask) {
        this.numberTask = numberTask;
    }


    public int getNumberTask() {
        return numberTask;
    }
}
