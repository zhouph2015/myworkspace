package indeed;



public class Token {
    
    public boolean isiSHtmlEntity() {
        return iSHtmlEntity;
    }

    
    public void setiSHtmlEntity(boolean iSHtmlEntity) {
        this.iSHtmlEntity = iSHtmlEntity;
    }

    String value;
    boolean iSHtmlEntity ;
    
    public Token(){
        this.iSHtmlEntity = false;
    }
    
    public String ToString(){
        if(iSHtmlEntity){
            return value+"@True";
        }
        
        return value+"@False";
    }
}