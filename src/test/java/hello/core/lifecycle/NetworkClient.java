package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("Call constructor, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Call at service start
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // Call at service end
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("Initializing message.");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
