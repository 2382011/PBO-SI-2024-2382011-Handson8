import Services.TodoListService;
import Services.TodoListServicesImpl;
import Views.TodoListTerminalView;
import Views.TodoListView;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServicesImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();

    }
}