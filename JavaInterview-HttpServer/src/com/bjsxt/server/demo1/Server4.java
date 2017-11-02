package com.bjsxt.server.demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class Server4 {
    
    public static final String CRLF="\r\n";
    public static final String BLANK=" ";
    
    private ServerSocket server;
    
    public static void main(String[] args) throws IOException{
        Server4 server = new Server4();
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
           
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);
            String requestInfo =  new String(data, 0, len).trim();
            
            System.out.println(requestInfo);

            Response rep = new Response(client.getOutputStream());
            rep.print("<html><head><title>response title sample</title></head><body>Hellow Bjsxt</body></html>");
            rep.pushToClient(200);
    
       
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void stop(){
        
    }

}