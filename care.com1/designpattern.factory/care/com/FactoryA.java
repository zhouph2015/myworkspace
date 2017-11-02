package care.com;


public class FactoryA implements IFactory {
    
    IProduct productA;
    
    public FactoryA(){
        this.productA = new ProductA();
    }
    @Override
    public IProduct getProduct() {
        // TODO Auto-generated method stub
        return this.productA;
    }

}
