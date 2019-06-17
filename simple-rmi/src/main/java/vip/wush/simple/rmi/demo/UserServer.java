package vip.wush.simple.rmi.demo;

/**
 * @ClassName: UserServer
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 17:58
 */

public class UserServer extends User {


    public static void main(String[] args) {

        UserServer userServer = new UserServer();
        userServer.setName("RMI-demo");

        UserSkeleton userSkeleton = new UserSkeleton(userServer);
        userSkeleton.start();
    }


}
