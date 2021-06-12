package server;

import java.util.Scanner;

public class WaitState implements IServerState{

    //anticipated data for further processing
    private String data;

    //Singleton class
    private static WaitState instance = null;

    private WaitState() {}

    public static WaitState instance() {
        if (instance == null)
            instance = new WaitState();

        return instance;
    }


    //Receiving data and server state change
    public void waitServerState(ServerContext serverContext) {
        System.out.println("We are in a wait state");
        System.out.println("Print the word and server will reverse it and return");
        Scanner sc = new Scanner(System.in);
        data = sc.nextLine();
        //Server state change
        serverContext.setServerState(ProcessState.instance(data));
    }

    //Interface method is useless here
    @Override
    public void processServerState(ServerContext serverContext) {
        System.out.println("Server doesn't have data to process");
    }

    //Interface method is useless here
    @Override
    public void sendServerState(ServerContext serverContext) {
        System.out.println("Server doesn't have data to send");
    }
}