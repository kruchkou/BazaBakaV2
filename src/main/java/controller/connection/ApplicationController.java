package controller.connection;

import controller.DataController;
import controller.connection.entity.TransferObject;
import entity.Command;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ApplicationController implements Runnable {

    private final Socket socket;
    private ObjectInputStream requestStream;
    private ObjectOutputStream responseStream;
    private static final Logger logger = LogManager.getLogger(ApplicationController.class);

    public ApplicationController(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            responseStream = new ObjectOutputStream(socket.getOutputStream());
            requestStream = new ObjectInputStream(socket.getInputStream());
            TransferObject transferObject = readTransferObject();

            handleRequest(transferObject);

        } catch (IOException e) {
            logger.error("Проблема на уровне подключения сервера",e);
        } catch (ClassNotFoundException e) {
            logger.error("Некорректный класс пришел",e);
        } finally {

            try {
                if(requestStream != null) {
                    requestStream.close();
                }
                if(responseStream != null) {
                    responseStream.close();
                }
                if (socket != null) {
                    socket.close();
                }

            } catch (IOException e) {
                logger.error("не удалось освободить ресурсы",e);
            }
        }
    }

    private TransferObject readTransferObject() throws IOException, ClassNotFoundException {
        return (TransferObject) requestStream.readObject();
    }

    public void handleRequest(TransferObject transferObject) throws IOException {
        transferObject.execute();
        responseStream.writeObject(transferObject);
        responseStream.flush();
    }
}
