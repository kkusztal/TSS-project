package pl.webapplicationKK.websockets;

import java.io.IOException;
import java.util.Arrays;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author kasia
 */
@ApplicationScoped
@ServerEndpoint("/webSocketEndPointGen")
public class WebSocketEndPointGen {
    private WebSocketResources webSocketResources = new WebSocketResources();
    
    @OnOpen
        public void open(Session session) {
            webSocketResources.addSession(session);
    }

    @OnClose
        public void close(Session session) {
            webSocketResources.removeSession(session);
    }

    @OnError
        public void onError(Throwable error) {
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        int [] dataPointsParam = new int [50];

        randomNumbers(dataPointsParam);
        
        String dataArrayString = Arrays.toString(dataPointsParam);
        
        webSocketResources.sendToAllConnectedSessions(dataArrayString);
    }
    
    private static int[] randomNumbers(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }

        return array;
    }
}
