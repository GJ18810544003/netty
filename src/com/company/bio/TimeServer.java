package com.company.bio;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: guojun
 * @Date: 2018/12/5
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
            ServerSocket serverSocket = null;

            try {
                serverSocket = new ServerSocket(port);
                System.out.println("The time server is start in port :" + port);

                Socket socket = null;
                while (true) {
                    socket = serverSocket.accept();
                    new Thread(new TimeServerHandler(socket)).start();
                }
            }finally {
                if (serverSocket != null) {
                    serverSocket.close();
                    serverSocket = null;
                    System.out.println("The time server close");
                }
            }

    }
}
