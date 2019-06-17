package vip.wush.simple.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @ClassName: server
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 16:43
 */

public class server {


    public static void main(String[] args) {
        try {
            SayHelloService helloService = new SayHelloServiceImpl();

            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/hello", helloService);

            System.out.println("server start success");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
