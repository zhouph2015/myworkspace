package com.bjsxt.server.demo4;


public class LoginServlet extends Servlet {
    
    @Override
    public void doGet(Request req, Response rep) throws Exception{
        
        String name = req.getParameterValue("uname");
        String pwd = req.getParameterValue("pwd");
        
        if( login(name, pwd)){
            rep.print("<html><head><title>register login</title></head><body>");
            rep.print(req.getParameterValue("uname")).print(" login successfully");
            rep.print("</body></html>");
            
        }else{
            rep.print("<html><head><title>register login</title></head><body>");
            rep.print(req.getParameterValue("uname")).print(" login failed");
            rep.print("</body></html>");
            
        }
 
        
    }
    
    public boolean login(String name, String password){
        return name.equals("bjsxt") && password.equals("123456");
    }
    
    @Override
    public void doPost(Request req, Response rep) throws Exception{
        
    }

}
