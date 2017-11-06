package com.bjsxt.server.demo4;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    
    public static final String CRLF="\r\n";
    public static final String BLANK=" ";
    
    private ServerSocket server;
    
    private boolean isShutdown= false;
    
    public static void main(String[] args) throws IOException{
        Server server = new Server();
        server.start();
        server.receive();
    }
    
    public void start() {
        start(8888);
    }
    
    
    public void start(int port) {
        try {
            server = new ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
    private void receive() {
        try {

            while (!isShutdown) {
                new Thread(new Dispatcher(server.accept())).start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void stop(){
        isShutdown = true;
        try {
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
   

}