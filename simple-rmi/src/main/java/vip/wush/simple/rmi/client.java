package vip.wush.simple.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @ClassName: client
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 16:43
 */

public class client {


    public static void main(String[] args) {

        try {
            SayHelloService helloService = (SayHelloService) Naming.lookup("rmi://localhost:8888/hello");

//            System.out.println(helloService);
            System.out.println(helloService.hello("wush"));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


}
