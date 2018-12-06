package com.company.nio;

import java.io.IOException;

/**
 * @Description:
 * @Author: guojun
 * @Date: 2018/12/6
 */
public class TimeServer {

    public static void main(String[] args) throws IOException{
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {

            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();

    }
}