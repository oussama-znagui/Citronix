package ma.znagui.app.exception;

import java.time.LocalDate;

public class UnproductiveTreeException extends Exception{
    public UnproductiveTreeException(Long treeID){
        super(String.format("L'arbre ID : %d est considéré comme non productif (age > 20 ans)",treeID));
    }
}
