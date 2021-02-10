package ch07.notifier;

public class SpyEmailNotifier implements EmailNotifier {
    private boolean called;
    private String email;

    public boolean isCalled() {
        return called;
    }

    public String getEmail() {
        return email;
    }

}
