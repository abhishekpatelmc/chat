package com.example.karth.chat;

public class Message {
    private String Message;
    private String Name;


    public Message(){}

    public Message(String message,String name) {
        Message = message;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {

        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
