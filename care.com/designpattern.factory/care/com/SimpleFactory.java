package care.com;


public class SimpleFactory {
    int proNo;
    public SimpleFactory(int proNo){
        this.proNo = proNo;
    }
    
    public IProduct GetProduct(){
        switch (proNo) //根据产品标识生产产品
        {
            default:
                return new ProductA();
            case 1:
                return new ProductA();
            case 2:
                return new ProductB();
        }
    }

}
