package ayudadoc.helpers.error;

public class AyudaDocException extends ApiException {
    
    public AyudaDocException(String title, String detail) {
        super(title, detail);
    }
}
