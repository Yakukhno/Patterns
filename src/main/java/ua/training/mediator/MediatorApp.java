package ua.training.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        Chat chat = new TextChat();

        Admin admin = new Admin(chat);
        User user1 = new SimpleUser(chat);
        User user2 = new SimpleUser(chat);
        User user3 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);

        admin.sendMessage("hello");
        user1.sendMessage("i'm user");

    }
}

interface User {
    void sendMessage(String message);
    void getMessage(String message);
}

class Admin implements User {

    private Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin receives message : " + message);
    }
}

class SimpleUser implements User {

    private Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User receives message : " + message);
    }
}

interface Chat {
    void sendMessage(String message, User user);
    void addUser(User user);
    void setAdmin(Admin admin);
}

class TextChat implements Chat {
    private Admin admin;
    private List<User> users = new ArrayList<>();

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.getMessage(message);
            }
        }
    }
}