package app.user.controller;

import app.user.model.User;
import app.user.repository.UserRepository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    // 전체 조회
    @GetMapping(value = "/search")
    public List<User> getAllUsers() throws Exception {
        if(isEmpty(userRepository.findAll())){
            throw new Exception("데이터 없음");
        }
        return userRepository.findAll();
    }

    // 회원 조회
   @GetMapping(value = "/{userId}")
    public User getUserByUserId(@PathVariable String userId) throws Exception {
        if(isEmpty(userRepository.findUserByUserId(userId))){
            throw new Exception("아이디 없음");
        }
        return userRepository.findUserByUserId(userId);
    }

    // 회원 가입
    @PostMapping(path = "/create")
    public User createUser(@RequestBody User user) throws Exception {
        if(!isEmpty(userRepository.findUserByUserId(user.getUserId()))){
            throw new Exception("아이디 중복");
        }
        return userRepository.save(user);
    }

    // 비밀번호 변경
    @PutMapping(value = "/update/{userId}")
    public User updateUser(@PathVariable String userId, @RequestParam String password) throws Exception {
        User user = userRepository.findUserByUserId(userId);
        if(isEmpty(user)){
            throw new Exception("아이디 없음");
        }
        user.update(password);
        return userRepository.save(user);
    }

    // 회원 삭제
    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable String userId) throws Exception {
        if(isEmpty(userRepository.findUserByUserId(userId))){
            throw new Exception("아이디 없음");
        }
        userRepository.deleteByUserId(userId);
    }

}
