package vip.wush.simple.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName: SayHelloService
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 16:43
 */

public interface SayHelloService extends Remote {

    String hello(String name) throws RemoteException;
}
