package ayudadoc.helpers.error;

public class ApiException extends RuntimeException {
  private String detail;

  public ApiException(String title, String detail) {
    super(title);
    this.detail = detail;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
