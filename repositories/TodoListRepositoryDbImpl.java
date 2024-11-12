package repositories;

import Config.Database;
import entities.TodoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryDbImpl implements TodoListRepository{
    private final Database database;

    public TodoListRepositoryDbImpl(final Database database){
        this.database = database;
    }

    @Override
    public TodoList[] getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECTT * FROM todos";
        List<TodoList> todoLists = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                TodoList todoList = new TodoList();
                int id = resultSet.getInt(1);
                String todo = resultSet.getString(2);
                todoList.setId(id);
                todoList.setTodo(todo);
                todoLists.add(todoList);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return todoLists.toArray(TodoList[]::new);
    }

    @Override
    public void add(TodoList todoList) {

    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean edit(TodoList todoList) {
        return null;
    }
}
