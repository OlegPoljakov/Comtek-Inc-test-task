package server;

import java.util.concurrent.TimeUnit;

public class SendState implements IServerState {

    //Received and transmitted data
    private static String data;

    //Singleton
    private static SendState instance = null;

    private SendState() {}

    public static SendState instance(String data) {
        setData(data);
        if (instance == null)
            instance = new SendState();

        return instance;
    }

    private static void setData(String input_data){
        data = input_data;
    }

    //Interface method is useless here
    @Override
    public void waitServerState(ServerContext serverContext) {
        System.out.println("Data is send. Can't wait any data");
    }

    //Interface method is useless here
    @Override
    public void processServerState(ServerContext serverContext) {
        System.out.println("Data is send. Can't process any data");
    }

    //Sending data
    @Override
    public void sendServerState(ServerContext serverContext) {
        System.out.println("We are in the send state");

        //Delay - time taken from application properties file
        String tmp = new PropertyReader().getPropertyValue("min.time");
        try
        {
            TimeUnit.SECONDS.sleep(Integer.parseInt(tmp));
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println(data);

        serverContext.setServerState(WaitState.instance());
    }
}

