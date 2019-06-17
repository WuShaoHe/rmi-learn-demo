package vip.wush.simpleice;

import vip.wush.ice.demo.demo.HelloIcePrx;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/17 16:29
 */


public class Client
{
    public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("HelloClient:tcp -h 127.0.0.1 -p 31220");
            HelloIcePrx helloIce =  HelloIcePrx.checkedCast(base);
            if(helloIce == null)
            {
                System.err.println("未连接上");
                throw new Error("Invalid proxy");
            }
            String response = helloIce.Hello("wush");

            System.out.println(response);
        }
    }
}
