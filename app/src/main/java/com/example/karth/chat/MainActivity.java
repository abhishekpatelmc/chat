package com.example.karth.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView container;
    EditText edittext;
    Button send;
    String username;
    FirebaseDatabase fire;
    DatabaseReference myRef;

     Message_adapter adapter;
     ChildEventListener abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fire=FirebaseDatabase.getInstance();
        myRef=fire.getReference("message");

        username=getIntent().getExtras().getString("username");
        container=(ListView) findViewById(R.id.container);

        List<Message> messageList= new ArrayList<>();
        adapter=new Message_adapter(this,R.layout.simple_message,messageList);
        container.setAdapter(adapter);

        abc=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message message=dataSnapshot.getValue(Message.class);
                adapter.add(message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        myRef.addChildEventListener(abc);
        edittext =(EditText)findViewById(R.id.edittext);
        send =(Button) findViewById(R.id.send);







        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edittext.getText().toString().trim();

                    if( message.isEmpty())
                    {
                        Toast.makeText(MainActivity.this,"enter message",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        HashMap<String,Object>
                         hashMap=new HashMap<>();
                        hashMap.put("Name",username);
                        hashMap.put("Message",message);

                        myRef.push().setValue(hashMap);


                    }

                    edittext.setText("");

            }
        });


        }
}




