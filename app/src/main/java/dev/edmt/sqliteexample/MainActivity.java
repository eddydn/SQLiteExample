package dev.edmt.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtId,edtName,edtEmail;
    Button btnAdd,btnUpdate,btnDelete;
    ListView lstPersons;

    List<Person> data = new ArrayList();
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseHelper(this);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        lstPersons = (ListView)findViewById(R.id.list);

        edtId = (EditText)findViewById(R.id.edtId);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtName = (EditText)findViewById(R.id.edtName);



        //Load Data
        refreshData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),edtName.getText().toString(),edtEmail.getText().toString());
                db.addPerson(person);
                refreshData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),edtName.getText().toString(),edtEmail.getText().toString());
                db.updatePerson(person);
                refreshData();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()),edtName.getText().toString(),edtEmail.getText().toString());
                db.deletePerson(person);
                refreshData();

            }
        });


    }

    private void refreshData(){
        data=db.getAllPerson();
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,edtId,edtName,edtEmail);
        lstPersons.setAdapter(adapter);
    }
}
