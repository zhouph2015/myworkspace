package care.com;


public class FactoryA implements IFactory {
    
    IProduct productA;
    
    public FactoryA(){
        this.productA = new ProductA();
    }
    public IProduct getProduct() {
        // TODO Auto-generated method stub
        return this.productA;
    }
    @Override
    public IFridge CreateFridge() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public IAirCondition CreateAirCondition() {
        // TODO Auto-generated method stub
        return null;
    }

}
