class TaskManager {

    class Task implements Comparable<Task> {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return priority == other.priority
                ? taskId - other.taskId
                : priority - other.priority;
        }
    }

    static final int CAPACITY = (int) 1e5 + 1;

    Task[] tasks;
    int[] userIds;
    TreeSet<Task> top;

    public TaskManager(List<List<Integer>> tasks) {
        this.tasks = new Task[CAPACITY];
        this.userIds = new int[CAPACITY];
        this.top = new TreeSet<>();

        for (List<Integer> raw : tasks) {
            add(raw.get(0), raw.get(1), raw.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        tasks[taskId] = task;
        top.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task current = tasks[taskId];
        top.remove(current);
        add(current.userId, taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        top.remove(tasks[taskId]);
        tasks[taskId] = null;
    }
    
    public int execTop() {
        if (top.isEmpty()) {
            return -1;
        }

        Task current = top.pollLast();
        rmv(current.taskId);
        return current.userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
