package com.bjsxt.server.demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class Server5 {
    
    public static final String CRLF="\r\n";
    public static final String BLANK=" ";
    
    private ServerSocket server;
    
    public static void main(String[] args) throws IOException{
        Server5 server = new Server5();
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
            //handle request
            Request req = new Request(client.getInputStream());
            //make response
            Response rep = new Response(client.getOutputStream());
            rep.print("<html><head><title>response title sample</title></head><body>");
            rep.print("Welcome: ").print(req.getParameterValue("uname")).print(" back");
            rep.print("</body></html>");
            rep.pushToClient(200);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void stop(){
        
    }

}
