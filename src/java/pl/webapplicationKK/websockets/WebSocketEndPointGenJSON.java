package pl.webapplicationKK.websockets;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
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
@ServerEndpoint("/webSocketEndPointGenJSON")
public class WebSocketEndPointGenJSON {
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
        Gson gsonBuilder = new GsonBuilder().create();
        int [] dataPointsParam = new int [50];

        randomNumbers(dataPointsParam);
        
        String jsonFromJavaArrayList = gsonBuilder.toJson(dataPointsParam);
        
        webSocketResources.sendToAllConnectedSessions(jsonFromJavaArrayList);
    }
    
    private static int[] randomNumbers(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }

        return array;
    }
}
