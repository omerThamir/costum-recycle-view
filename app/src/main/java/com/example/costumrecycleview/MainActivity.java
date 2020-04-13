package com.example.costumrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText msgeditText;

    private MessageAdapter messageAdapter;

    private RecyclerView recyclerView;

    private ArrayList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recycler view in activity layout
        recyclerView = findViewById(R.id.recycle_view);

        // Initialize messages
        messages = new ArrayList<Message>();

        for (int i = 1; i <= 5; i++) {
            messages.add(new Message(" comment " + i, R.drawable.ic_launcher_foreground, false));
        }

        // Create adapter passing in the sample user data
        messageAdapter = new MessageAdapter(messages);
        // Attach the adapter to the recycler view to populate items
        recyclerView.setAdapter(messageAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        sendBtn = findViewById(R.id.button);

        msgeditText = findViewById(R.id.editText);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (msgeditText.length() != 0) {
                    messages.add(new Message(msgeditText.getText().toString(), R.drawable.ic_launcher_foreground, false));

                    msgeditText.setText(null);
                }
            }
        });


    }
}
