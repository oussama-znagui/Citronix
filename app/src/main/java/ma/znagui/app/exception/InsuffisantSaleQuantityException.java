package ma.znagui.app.exception;

public class InsuffisantSaleQuantityException extends RuntimeException{
    public InsuffisantSaleQuantityException(double qte,Long harvestID){
        super("ya que " + qte +  "Kg dans la ricolt ID : " + harvestID);
    }

}
