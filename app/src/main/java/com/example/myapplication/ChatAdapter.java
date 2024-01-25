package com.example.myapplication;

//public class ChatAdapter {
//}

// ChatAdapter.java - Adapter for displaying chat messages in a ListView
//package com.example.doctorconsultation;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;
        import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter<String> {

    public ChatAdapter(Context context, ArrayList<String> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String message = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message, parent, false);
        }

        // Lookup view for data population
        TextView messageTextView = convertView.findViewById(R.id.messageTextView);

        // Populate the data into the template view using the data object
        messageTextView.setText(message);

        // Return the completed view to render on screen
        return convertView;
}
}