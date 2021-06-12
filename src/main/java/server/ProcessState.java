package server;

import java.util.concurrent.TimeUnit;

public class ProcessState implements IServerState{

    //Received data in waiting state
    private static String data;
    //Processed data to be send in Send state
    private String reverse = "";

    //Singleton
    private static ProcessState instance = null;

    private ProcessState() {}

    public static ProcessState instance(String data) {
        setData(data);
        if (instance == null)
            instance = new ProcessState();

        return instance;
    }

    private static void setData(String input_data){
        data = input_data;
    }

    //Interface method is useless here
    @Override
    public void waitServerState(ServerContext serverContext) {
        System.out.println("Data is processed. Can't receive any data");
    }

    //Process data and server state change
    @Override
    public void processServerState(ServerContext serverContext) {
        System.out.println("We are in a process state");
        //Reverse received data
        for(int i = data.length() - 1; i >= 0; i--)
        {
            reverse = reverse + data.charAt(i);
        }

        //Delay - time taken from application properties file
        String delay = new PropertyReader().getPropertyValue("min.time");
        try
        {
            TimeUnit.SECONDS.sleep(Integer.parseInt(delay));
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        //Server state change
        serverContext.setServerState(SendState.instance(reverse));
    }

    //Interface method is useless here
    @Override
    public void sendServerState(ServerContext serverContext) {
        System.out.println("Data is processed. Can't send any data");
    }
}