package vip.wush.simpleice;

import com.zeroc.Ice.Communicator;

/**
 * @ClassName: Server
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/17 16:28
 */

public class Server
{
    public static void main(String[] args)
    {
        try(Communicator communicator = com.zeroc.Ice.Util.initialize(args)) {

            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("HelloServer", "tcp -h 127.0.0.1 -p 31220");
            com.zeroc.Ice.Object object = new HelloIceI();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("HelloClient"));
            System.out.println("SimplePrinter已经激活");
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}