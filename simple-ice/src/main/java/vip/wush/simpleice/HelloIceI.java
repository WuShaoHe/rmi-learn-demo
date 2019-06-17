package vip.wush.simpleice;

import com.zeroc.Ice.Current;
import vip.wush.ice.demo.demo.HelloIce;

/**
 * @ClassName: HelloIceI
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/17 17:02
 */

public class HelloIceI implements HelloIce {

    @Override
    public String Hello(String request, Current current) {
        return "Hello, " + request+", I'm a Ice!";
    }
}
