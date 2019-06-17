package vip.wush.simple.rmi.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: UserSkeleton
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 17:59
 */

public class UserSkeleton extends Thread {

    private UserServer userServer;

    public UserSkeleton(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(socket);

            if(socket != null){
                final Socket finalSocket = socket;
                executorService.submit(new Runnable() {
                    public void run() {
                        try {
                            ObjectInputStream inputStream = new ObjectInputStream(finalSocket.getInputStream());
                            String method = (String) inputStream.readObject();

                            if ("name".equals(method)) {
                                String name = userServer.getName();
                                ObjectOutputStream outputStream = new ObjectOutputStream(finalSocket.getOutputStream());
                                outputStream.writeObject(name);
                                outputStream.flush();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }finally {
                            if(finalSocket != null){
                                try {
                                    finalSocket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
