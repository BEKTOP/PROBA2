package com.example.kravchik.proba2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kravchik.proba2.todo.TodoDetails;
import com.example.kravchik.proba2.todo.TodoDocument;

import java.util.ArrayList;
import java.util.List;


public class TodoList extends AppCompatActivity {

    public static String TODO_DOCUMENT = "com.example.kravchik.proba2.todo.TodoDocument";
    public static int TODO_DETAILS_REQUEST = 1;

    private ListView listTasks;

    private ArrayAdapter<TodoDocument> arrayAdapter;
    private static List<TodoDocument> listDocument = new ArrayList<TodoDocument>();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        listTasks = (ListView) findViewById(R.id.listTasks);

        listTasks.setOnItemClickListener(new ListViewClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        fillTodoList();

    }

    private void fillTodoList() {
        arrayAdapter = new ArrayAdapter<TodoDocument>(getApplicationContext(),
                R.layout.listview_row, listDocument);
        listTasks.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_task: {
                TodoDocument todoDocument = new TodoDocument();
                todoDocument.setName(getResources()
                        .getString(R.string.new_document));
                showDocument(todoDocument);
                return true;
            }

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDocument(TodoDocument todoDocument) {
        Intent intentTodoDetails = new Intent(this, TodoDetails.class);
        intentTodoDetails.putExtra(TODO_DOCUMENT, todoDocument);
        startActivityForResult(intentTodoDetails, TODO_DETAILS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TODO_DETAILS_REQUEST) {

            TodoDocument todoDocument = null;
            switch (resultCode) {
                case RESULT_CANCELED:

                    break;

                case TodoDetails.RESULT_SAVE:
                    todoDocument = (TodoDocument) data
                            .getSerializableExtra(TODO_DOCUMENT);

                    addDocument(todoDocument);
                    break;

                case TodoDetails.RESULT_DELETE:
                    todoDocument = (TodoDocument) data
                            .getSerializableExtra(TODO_DOCUMENT);
                    deleteDocument((TodoDocument) data
                            .getSerializableExtra(TODO_DOCUMENT));
                    break;

                default:
                    break;
            }
        }
    }

    @SuppressLint("NewApi")
    private void addDocument(TodoDocument todoDocument) {
        listDocument.add(todoDocument);
        todoDocument.setNumber(listDocument.indexOf(todoDocument));
        arrayAdapter.notifyDataSetChanged();

    }

    @SuppressLint("NewApi")
    private void deleteDocument(TodoDocument todoDocument) {

        listDocument.remove(todoDocument);
        arrayAdapter.notifyDataSetChanged();

    }

    class ListViewClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            TodoDocument todoDocument = (TodoDocument) parent.getAdapter()
                    .getItem(position);
            showDocument(todoDocument);
        }

    }


}
