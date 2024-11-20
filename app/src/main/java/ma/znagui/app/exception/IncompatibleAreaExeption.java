package ma.znagui.app.exception;

public class IncompatibleAreaExeption extends RuntimeException{
    public IncompatibleAreaExeption(Long farmID,Double supDispo){
        super(String.format("la superficie que vous saisissez n'est pas compatible avec superficie de la ferme ID : %d \n la superficie dispo : %f ",farmID,supDispo));
    }
}
