package com.example.customlistviewsearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        SearchView searchView=findViewById(R.id.searchView);
        setUpData();

    }

    public void setUpData(){
        ArrayList<String> shapeName=new ArrayList<String>();
        shapeName.add("Circle");
        shapeName.add("Rectangle");
        shapeName.add("Square");
        shapeName.add("Triangle");
        ArrayList<Integer> shapeImage=new ArrayList<>();
        shapeImage.add(R.drawable.circle);
        shapeImage.add(R.drawable.rectangle);
        shapeImage.add(R.drawable.square);
        shapeImage.add(R.drawable.triangle);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),shapeName,shapeImage);
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String shapeSelected= shapeName.get(position).toString();
                int imageSelected=shapeImage.get(position);
                Intent sendData = new Intent(getApplicationContext(),DetailedActivity.class);
                sendData.putExtra("shapeName",shapeSelected);
                sendData.putExtra("imageResource",imageSelected);
                startActivity(sendData);
            }
        });
        queryListener(shapeName,shapeImage,listView);
    }

//    Create a new filtered arrayList when user starts typing queries and add relevant matches to the arrayList whilst setting Adapters atn the same time
public void queryListener(ArrayList<String> s, ArrayList<Integer> img, ListView list){
        SearchView searchView=findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> filteredShape = new ArrayList<>();
                ArrayList<Integer> imageR= new ArrayList<>();
                for (String input:s){
                    if (input.toString().toLowerCase().contains(newText.toString().toLowerCase())){
                        filteredShape.add(input);
                        int index= s.indexOf(input);
                        imageR.add(img.get(index));
                        CustomAdapter newCustomAdapter = new CustomAdapter(getApplicationContext(),filteredShape,imageR);
                        list.setAdapter(newCustomAdapter);
                    }
                }
                return false;
            }
        });
}

}