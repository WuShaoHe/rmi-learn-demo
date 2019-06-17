package vip.wush.simple.rmi.demo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName: UserStub
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 17:49
 */

public class UserStub extends User{

    private Socket socket;

    public UserStub() throws IOException {
        this.socket = new Socket("localhost", 8888);
    }

    public UserStub(Socket socket) {
        this.socket = socket;
    }

    public String getName() throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject("name");
        objectOutputStream.flush();
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        String name = (String) inputStream.readObject();
        return name;

    }


}
