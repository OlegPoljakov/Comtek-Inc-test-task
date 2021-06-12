package server;

public interface IServerState {
    void waitServerState(ServerContext serverContext);
    void processServerState(ServerContext serverContext);
    void sendServerState(ServerContext serverContext);
}
