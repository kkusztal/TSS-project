package pl.webapplicationKK.websockets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

/**
 *
 * @author kasia
 */
@ApplicationScoped
public class WebSocketResources {
    private final Set<Session> sessions = new HashSet<>();
    
    public void addSession(Session session) {
        sessions.add(session);
    }
    
    public void removeSession(Session session) {
        sessions.remove(session);
    }
    
    public void sendToAllConnectedSessions(String message) throws IOException {
        for(Session session : sessions) {
            sendToSession(session, message);
        }
    }
    
    private void sendToSession(Session session, String message) throws IOException {
            session.getBasicRemote().sendText(message);
    }
}
