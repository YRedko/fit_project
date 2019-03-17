package project.service;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;
import project.dao.UserRepository;
import project.domain.User;
import project.domain.UserDto;
import project.exeptions.UncorrectGrant;
import project.exeptions.UserAlreadyExsists;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserDto userDto){
        if(userRepository.isUserWithLongExists(userDto.getLogin())){
            throw new UserAlreadyExsists(userDto.getLogin());
        }
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPasswordHash(encryptPassword(userDto.getPassword()));
        return userRepository.save(user);
    }

    public User login(UserDto userDto){
        return userRepository.findUserByLogin(userDto.getLogin())
                .filter(user -> checkPassword(userDto, user))
                .orElseThrow(UncorrectGrant::new);
    }

    private boolean checkPassword(UserDto userDto, User user){
        String encryptPassword = encryptPassword(userDto.getPassword());
        return encryptPassword.equals(user.getPasswordHash());
    }

    private static String encryptPassword(String password){
        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes(UTF_8));
            return new BigInteger(1, crypt.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
