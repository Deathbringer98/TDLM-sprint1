public class TaskList {
    private TaskNode head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        TaskNode newNode = new TaskNode(newTask);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markTaskAsCompleted(String description) {
        TaskNode current = head;
        while (current != null) {
            if (current.getTask().getDescription().equals(description)) {
                current.getTask().markAsCompleted();
                return;
            }
            current = current.getNext();
        }
        System.out.println("Task not found: " + description);
    }

    public void printTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.getTask());
            current = current.getNext();
        }
    }
}
