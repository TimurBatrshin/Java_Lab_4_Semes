package ru.itis.api.redis.services;

import ru.itis.api.models.User;


public interface RedisUsersService {
    void addTokenToUser(User user, String token);

    void addAllTokensToBlackList(User user);
}
