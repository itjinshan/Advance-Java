package socketServer;

public interface SocketServerInterface
{
    boolean openConnection();
    void handleSession();
    void closeSession();
}