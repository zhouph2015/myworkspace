package com.bjsxt.server.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    
    private ServerSocket server;
    
    public static void main(String[] args) throws IOException{
        Server3 server = new Server3();
        server.start();
        server.receive();
    }
    
    public void start() {
        try {
            server = new ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
    private void receive() {
        try {
            Socket client = server.accept();
            String msg = null;
            StringBuilder sb = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            if (br != null) {
                while ((msg = br.readLine()).length() > 0) {
                    sb.append(msg);
                    sb.append("\r\n");
                    if (null == msg)
                        break;
                }
                String requestInfo = sb.toString().trim();
                
                System.out.println(requestInfo);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void stop(){
        
    }

}
