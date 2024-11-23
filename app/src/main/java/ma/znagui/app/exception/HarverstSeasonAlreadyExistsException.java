package ma.znagui.app.exception;

public class HarverstSeasonAlreadyExistsException extends Exception{
    public HarverstSeasonAlreadyExistsException(String season,Long harvestID){
        super(String.format("la ricolte ID : %d de la saison : %s existe deja",harvestID,season));
    }

}
