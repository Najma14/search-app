package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView courseRV;
    private CourseAdapter adapter;
    private ArrayList<modal> modalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseRV = findViewById(R.id.idRVCourses);
        buildRecyclerView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<modal> filteredlist = new ArrayList<modal>();

        for (modal item : modalArrayList) {
            if (item.getCourseName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "not found data", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filteredlist);
        }
    }

    public void buildRecyclerView()
    {
        modalArrayList=new ArrayList<modal>();
        modalArrayList.add(new modal("English", "this is English language you can learn easily",R.drawable.english));
        modalArrayList.add(new modal("Math","mathematics is good for your knowledge",R.drawable.math));
        modalArrayList.add(new modal("Arabic","learn arabic here",R.drawable.arabic));
        modalArrayList.add(new modal("Geo","know your countries land",R.drawable.geo));
        modalArrayList.add(new modal("Python","mathematics is good for your knowledge",R.drawable.python));
        modalArrayList.add(new modal("Statistics","mathematics is good for your knowledge",R.drawable.statistics));
        modalArrayList.add(new modal("Ethics","mathematics is good for your knowledge",R.drawable.ethics));
        modalArrayList.add(new modal("Biology","know your countries land",R.drawable.biology));
        modalArrayList.add(new modal("chemistry","know your countries land",R.drawable.img));



        adapter = new CourseAdapter(modalArrayList, MainActivity.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        courseRV.setHasFixedSize(true);
        //setting layoutmanager to recylerview
        courseRV.setLayoutManager(manager);
        // setting adapter to
        // our recycler view.
        courseRV.setAdapter(adapter);






    }
}