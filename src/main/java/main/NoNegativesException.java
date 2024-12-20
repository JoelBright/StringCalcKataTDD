package main;

public class NoNegativesException extends RuntimeException {
  public NoNegativesException(String message) {
    super(message);
  }
}
