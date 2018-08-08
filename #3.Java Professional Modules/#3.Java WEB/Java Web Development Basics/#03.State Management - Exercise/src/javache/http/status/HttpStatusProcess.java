package http.status;

public interface HttpStatusProcess {

    byte[] ok(byte[] content);
    byte[] badRequest(byte[] content);
    byte[] notFound(byte[] content);
    byte[] redirect(byte[] content,String location);
    byte[] internalServerError(byte[] content);

}
