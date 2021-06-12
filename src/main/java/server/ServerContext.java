package server;

public class ServerContext {

    private IServerState currentState;

    //Initial state is Waiting state
    public ServerContext() {
        this.currentState = WaitState.instance();
    }

    public void setServerState(IServerState iServerState){
        this.currentState = iServerState;
    }

    public void waitServerState(){
        currentState.waitServerState(this);
    }

    public void processServerState() {
        currentState.processServerState(this);
    }

    public void sendServerState() {
        currentState.sendServerState(this);
    }
}
