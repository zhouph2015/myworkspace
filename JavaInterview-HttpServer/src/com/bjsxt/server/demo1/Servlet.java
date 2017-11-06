package com.bjsxt.server.demo1;

import java.net.Socket;

public class Servlet {
    
    public void service (Request req, Response rep) {

        rep.print("<html><head><title>response title sample</title></head><body>");
        rep.print("Welcome: ").print(req.getParameterValue("uname")).print(" back");
        rep.print("</body></html>");
    }
    

}
