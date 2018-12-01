package com.example.karth.chat;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Message_adapter extends ArrayAdapter<Message> {
    public Message_adapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null)
        {
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.simple_message,parent,false);
        }
        Message message=getItem(position);

        TextView nameTextView=(TextView)convertView.findViewById(R.id.name);
        TextView messageTextView=(TextView)convertView.findViewById(R.id.message);

        nameTextView.setText(message.getName());
        messageTextView.setText(message.getMessage());
        return convertView;
    }
}
