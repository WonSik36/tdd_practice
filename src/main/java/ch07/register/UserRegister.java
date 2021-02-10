package ch07.register;

import ch07.User;
import ch07.exception.DupIdException;
import ch07.exception.WeakPasswordException;
import ch07.passwordchecker.WeakPasswordChecker;
import ch07.repository.UserRepository;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
    }

    public void register(String id, String pw, String email) {
        if(passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }

        User user = userRepository.findById(id);
        if(user != null) {
            throw new DupIdException();
        }

        userRepository.save(new User(id, pw, email));
    }
}
