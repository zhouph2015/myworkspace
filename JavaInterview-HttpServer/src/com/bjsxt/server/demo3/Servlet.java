package com.bjsxt.server.demo3;

import java.net.Socket;

public abstract class Servlet {
    
    public void service (Request req, Response rep) throws Exception{
       this.doGet(req, rep);
       this.doPost(req, rep);
  
       
    }

    public void doGet(Request req, Response rep) throws Exception {
        // TODO Auto-generated method stub
        
    }

    public void doPost(Request req, Response rep) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
