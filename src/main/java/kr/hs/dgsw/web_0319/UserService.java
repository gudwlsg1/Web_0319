package kr.hs.dgsw.web_0319;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(int user_id);
    boolean addUser(User user);
    User updateUser(User user);
    boolean deleteUser(int user_id);
}
