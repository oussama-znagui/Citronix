package ma.znagui.app.exception;

public class NonMatchingField extends Exception{
    public NonMatchingField(Long filedHarvestID,Long fieldTreeID){
        super("le champs de recolt est N° : " + fieldTreeID + "\n Mais l'arbre dans le champs N° : " + fieldTreeID);
    }
}
