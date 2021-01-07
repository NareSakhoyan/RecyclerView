package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> data = new ArrayList<>();
    private RecyclerView dataList;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add(new Item("Armen", "Computer Engineer", "https://lh3.googleusercontent.com/proxy/JKQt1SNwa1Olmj1oeopKjnFGbPLmwj5Wa7nqpFGcXHFoGQI3JQnSfBBEzdpf54VEtA-lRc6qDjYwh73cc6Re6EsjSM9uPokpdlvoigu31nzKHJEdNtZpgOR4z0z5BLMNE6ic2DTr"));
        data.add(new Item("Serob", "Computer Scientist", "https://widgetwhats.com/app/uploads/2019/11/free-profile-photo-whatsapp-4.png"));
        data.add(new Item("Ani", "Software Engineer", "https://www.eharmony.co.uk/dating-advice/wp-content/uploads/2011/04/profilephotos-960x640.jpg"));
        data.add(new Item("Aram", "Project Manager", "https://cdn.fastly.picmonkey.com/contentful/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=800&q=70"));
        data.add(new Item("Narek", "Android Developer", "https://i.redd.it/v0caqchbtn741.jpg"));
        data.add(new Item("Gegham", "Web Designer", "https://images.pexels.com/photos/2078265/pexels-photo-2078265.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));


        dataList = findViewById(R.id.dataList);
        adapter = new ItemAdapter(this, data);
        dataList.setAdapter(adapter);
        dataList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}