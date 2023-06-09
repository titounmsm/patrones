package ayudadoc.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import ayudadoc.helpers.error.AyudaDocException;

import java.util.Locale;
import java.util.Map;

@Component
public class ApiErrorHandler {
  private static ApiErrorResponse response = new ApiErrorResponse();

  public ApiErrorResponse handle(Map<String, Object> errorAttributes, Throwable error) {
    String path = (String) errorAttributes.get("path");
    switch (error.getClass().getSimpleName().toLowerCase(Locale.ROOT)) {
      case "ayudadocexception":
        response = new ApiErrorResponse(
            "/v1/errors/ayudadoc",
            error.getMessage(),
            HttpStatus.BAD_REQUEST,
            ((AyudaDocException) error).getDetail(),
            path
        );
        break;
      default:
        response.setType("/v1/errors/api");
        response.setTitle(error.getMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setDetail("Ocurrió un error, contacte con el administrador");
        response.setInstance(path);
    }

    return response;
  }
}
