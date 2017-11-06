package com.bjsxt.server.demo2;


public class RegisterServlet extends Servlet {
    
    @Override
    public void doGet(Request req, Response rep) throws Exception{
   
        
    }
    
    @Override
    public void doPost(Request req, Response rep) throws Exception{
        rep.print("<html><head><title>response to regisgter</title></head><body>");
        rep.print("You username has registered: ").print(req.getParameterValue("uname"));
        rep.print("</body></html>");
    }

}
