package server;

public class Main {

    public static void main(String[] args) {
        //Context object creation
        ServerContext server = new ServerContext();
        while(true) {
            server.waitServerState();
            server.processServerState();
            server.sendServerState();
        }
    }
}