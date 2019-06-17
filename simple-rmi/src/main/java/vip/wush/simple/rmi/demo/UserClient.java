package vip.wush.simple.rmi.demo;

import java.io.IOException;

/**
 * @ClassName: UserClient
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 18:07
 */

public class UserClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new UserStub();
        String name = user.getName();
        System.out.println(name);

    }


}
