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
    private DataController dataController;
    private static final Logger logger = LogManager.getLogger(ApplicationController.class);

    public ApplicationController(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            responseStream = new ObjectOutputStream(socket.getOutputStream());
            requestStream = new ObjectInputStream(socket.getInputStream());
            dataController = DataController.getInstance();

            TransferObject transferObject = readTransferObject();

            handleRequest(transferObject);

        } catch (IOException e) {
            logger.error("Проблема на уровне подключения сервера"+e.getStackTrace().toString());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("Некорректный класс пришел jopa");
            e.printStackTrace();
        } finally {
            try {
                requestStream.close();
                responseStream.close();
                socket.close();

            } catch (IOException e) {
                logger.error("не удалось освободить ресурсы");
                e.printStackTrace();
            }
            System.out.println("Client disconnected");
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
