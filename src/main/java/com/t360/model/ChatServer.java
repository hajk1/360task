package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/6/2020, Mon
 **/
public class ChatServer {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Player initiator = new Player(chat, "initiator");
        Player secondPlayer = new Player(chat, "2nd");
        PrivateMessage privateMessage = new PrivateMessage("Hi there!", initiator, secondPlayer);
        chat.sendMessage(privateMessage);

    }
}
