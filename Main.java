import Config.Database;
import Services.TodoListService;
import Services.TodoListServicesImpl;
import Views.TodoListTerminalView;
import Views.TodoListView;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryDbImpl;
import repositories.TodoListRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("databaseku", "root", "", "localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);
        TodoListService todoListService = new TodoListServicesImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();

    }
}