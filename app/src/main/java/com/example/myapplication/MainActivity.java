package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

// MainActivity.java - Main activity for doctor consultation chat application
//package com.example.doctorconsultation;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText messageEditText;
    private ListView chatListView;
    private ArrayList<String> chatMessages;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        initializeUI();

        // Button click listener for sending a message
        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the message from the input field
                String message = messageEditText.getText().toString();

                // Add the message to the chat
                addMessage("You", message);

                // Clear the input field
                messageEditText.setText("");
            }
        });
    }

    private void initializeUI() {
        messageEditText = findViewById(R.id.messageEditText);
        chatListView = findViewById(R.id.chatListView);

        // Initialize chat messages list and adapter
        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(this, chatMessages);
        chatListView.setAdapter(chatAdapter);
    }

    private void addMessage(String sender, String message) {
        // Format the message and add it to the chat
        String formattedMessage = String.format("%s: %s", sender, message);
        chatMessages.add(formattedMessage);

        // Notify the adapter that the data set has changed
        chatAdapter.notifyDataSetChanged();

        // Scroll the list view to the bottom to show the latest message
        chatListView.smoothScrollToPosition(chatMessages.size());
}
}