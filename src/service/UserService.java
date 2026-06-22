package service;

import model.User;
import repository.Repository;

public class UserService {

    private Repository<User> repository =
            new Repository<>();

    public void register(User user) {
        repository.add(user);
    }
}