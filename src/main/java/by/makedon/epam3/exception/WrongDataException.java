package by.makedon.epam3.exception;

public class WrongDataException extends Exception {
    public WrongDataException() {}
    public WrongDataException(String m) {
        super(m);
    }
    public WrongDataException(String m, Throwable th) {
        super(m, th);
    }
    public WrongDataException(Throwable th) {
        super(th);
    }
}