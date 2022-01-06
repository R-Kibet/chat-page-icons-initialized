package com.example.clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clone.databinding.ActivityChatBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //hide extra toolbar :always default
        getSupportActionBar().hide();

        //initialize firebase
        database = FirebaseDatabase.getInstance();
        auth =  FirebaseAuth.getInstance();


        final String senderId = auth.getUid();
        String receiveId = getIntent().getStringExtra("userId");
        String  userName = getIntent().getStringExtra("userName");
        String profilePic = getIntent().getStringExtra("profilePic");//use same text format in the user model


        // setting name and profile picture
        binding.userName.setText(userName);
        Picasso.get().load(profilePic).placeholder(R.drawable.avatar).into(binding.profimage);

        //initializing back arrow

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //moves back to main activity
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }


}