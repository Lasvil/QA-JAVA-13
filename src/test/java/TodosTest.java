import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetIdTask() {
        SimpleTask simpleTask = new SimpleTask(7, "Поднять жопу");
        int expected = 7;
        int actual = simpleTask.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitleSimple() {
        SimpleTask simpleTask = new SimpleTask(7, "Убрать трусы");
        String expected = "Убрать трусы";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasksEpic() {
        String[] subtasks = {"Встать", "Сесть"};
        Epic epic = new Epic(78, subtasks);
        String[] expected = {"Встать", "Сесть"};
        String[] actual = epic.getEpic();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetStringTopicMeeting() {
        Meeting meeting = new Meeting(98, "Сделать", "Работу", "Сегодня");
        String expected = "Сделать";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStringProjectMeeting() {
        Meeting meeting = new Meeting(98, "Сделать", "Работу", "Сегодня");
        String expected = "Работу";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStringStartMeeting() {
        Meeting meeting = new Meeting(98, "Сделать", "Работу", "Сегодня");
        String expected = "Сегодня";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchSuccessSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Поз");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesSuccessSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвон");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesUnSuccessSimple() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("Трунь");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSuccessEpic() {
        String[] subtasks = {"Глаза", "Открыть"};
        Epic epic = new Epic(33, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Глаз");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesUnSuccessEpic() {
        String[] subtasks = {"Глаза", "Открыть"};
        Epic epic = new Epic(33, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Проснись");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSuccessTopicMeeting() {
        Meeting meeting = new Meeting(42, "Не смотреть", "Вебинар", "По ДЗ");
        boolean expected = true;
        boolean actual = meeting.matches("Не");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSuccessProjectMeeting() {
        Meeting meeting = new Meeting(42, "Не смотреть", "Вебинар", "По ДЗ");
        boolean expected = true;
        boolean actual = meeting.matches("Веб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesUnSuccessMeeting() {
        Meeting meeting = new Meeting(42, "Не смотреть", "Вебинар", "По ДЗ");
        boolean expected = false;
        boolean actual = meeting.matches("Смотри");
        Assertions.assertEquals(expected, actual);
    }
}
