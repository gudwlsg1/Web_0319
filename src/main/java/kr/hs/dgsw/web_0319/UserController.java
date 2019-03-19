package kr.hs.dgsw.web_0319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return this.userService.list();
    }

    @GetMapping("/user/{user_id}")
    public User view(@PathVariable int user_id){
        return this.userService.view(user_id);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/user/{user_id}")
    @ResponseBody
    public boolean delete(@PathVariable int user_id){
        return this.userService.deleteUser(user_id);
    }
}
