package vip.wush.simple.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @ClassName: SayHelloServiceImpl
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 16:44
 */

public class SayHelloServiceImpl extends UnicastRemoteObject implements SayHelloService {

    public SayHelloServiceImpl() throws RemoteException {
    }

    public String hello(String name) throws RemoteException {

        return "hello: " + name+ ", I'm RMI" ;
    }
}
