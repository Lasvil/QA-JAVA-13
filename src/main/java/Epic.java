public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String subtasks[]) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getEpic() {

        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}