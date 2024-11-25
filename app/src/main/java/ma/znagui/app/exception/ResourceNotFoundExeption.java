package ma.znagui.app.exception;

public class ResourceNotFoundExeption extends RuntimeException{
    public ResourceNotFoundExeption(String message){
        super(message);
    }

    public ResourceNotFoundExeption(String message, Long id){
        super(String.format("%s avec ID : %d n'existe pas",message,id));
    }


    public ResourceNotFoundExeption(String message, Long id,Long id2){
        super(String.format("%s avec ID : %d / %d n'existe pas",message,id,id2));
    }

}
