package action;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.websocket.*;

import java.util.List;
import java.util.ArrayList;

@ServerEndpoint("/chat/{userId}")
public class ChatWebSocket {

    private Session session;
    private static final Map<String, List<Session>> userSessions = new HashMap<>();  // Store user sessions by userId

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        // Store multiple sessions per userId (in case they open multiple tabs)
        userSessions.computeIfAbsent(userId, k -> new ArrayList<>()).add(session);
        // Store userId in session properties
        session.getUserProperties().put("userId", userId);
        System.out.println("User " + userId + " connected with session ID: " + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
    	System.out.println("Message received: " + message);
        try {
            // Split the message to determine receiver and content
            String[] parts = message.split(":", 2); // Limit split to 2 parts
            if (parts.length < 2) {
                System.out.println("Invalid message format. Expected 'receiverId:content'");
                return;
            }
            
            String receiverId = parts[0];
            String content = parts[1];

            // Find the session(s) of the receiver (could be on any of their tabs)
            List<Session> receiverSessions = userSessions.get(receiverId);
            if (receiverSessions != null) {
                // Send message to all sessions of the receiver
                for (Session receiverSession : receiverSessions) {
                    receiverSession.getBasicRemote().sendText(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        String userId = (String) session.getUserProperties().get("userId");
        // Remove the session from the list of user sessions
        if (userId != null) {
            userSessions.get(userId).remove(session);
            if (userSessions.get(userId).isEmpty()) {
                userSessions.remove(userId);  // Remove user entry if no sessions are left
            }
            System.out.println("User " + userId + " disconnected");
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
