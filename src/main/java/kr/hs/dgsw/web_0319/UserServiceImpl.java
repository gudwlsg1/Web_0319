package kr.hs.dgsw.web_0319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    List<User> lstList;

    public UserServiceImpl(){
        this.lstList = new ArrayList<>();

        User user1 = new User(1,"user1","user111@dgsw");
        User user2 = new User(2,"user2","user222@dgsw");
        User user3 = new User(3,"user3","user333@dgsw");

        addUser(user1);
        addUser(user2);
        addUser(user3);
    }

    @Override
    public boolean addUser(User user) {
        User found = find2(user.getUser_id());

        if(found == null){
            return this.lstList.add(user);
        }
        return false;
    }

    @Override
    public User updateUser(User user) {
        User found = find2(user.getUser_id());

        if(found != null)
            found.setEmail(user.getEmail());

        return found;
    }

    @Override
    public boolean deleteUser(int user_id) {
        User found = find2(user_id);

        return this.lstList.remove(found);
    }

    @Override
    public List<User> list() {
        return this.lstList;
    }

    @Override
    public User view(int user_id) {
        User found = null;

        for (User user: this.lstList) {
            found = user;

            if(found.getUser_id() == user_id){
                return found;
            }
        }
        return null;
    }

    public User find1(int user_id){
        Iterator<User> iterator = this.lstList.iterator();

        while(iterator.hasNext()){
            User found = iterator.next();

            if(found.getUser_id() == user_id){
                return found;
            }
        }

        return null;
    }

    public User find2(int user_id){ // Java 8+
        User found = this.lstList.stream().filter(user -> user.getUser_id() == user_id).findAny().orElse(null);
        return found;
    }
}
