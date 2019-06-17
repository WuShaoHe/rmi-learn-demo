package vip.wush.simple.rmi.demo;

import java.io.IOException;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/16 17:47
 */

public class User {

    private String name;


    public String getName() throws IOException, ClassNotFoundException {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
