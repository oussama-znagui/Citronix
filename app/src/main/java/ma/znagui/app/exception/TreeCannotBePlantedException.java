package ma.znagui.app.exception;

public class TreeCannotBePlantedException extends RuntimeException{
  public TreeCannotBePlantedException(Long fieldID){
      super(String.format("Cette arbre ne peux pas etre planter dans le chamnp ID: %d a cause d'espace",fieldID));
  }
}
