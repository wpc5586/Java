package com.aaron.aaronworld.service;

import com.aaron.aaronworld.dao.entity.EmchatUserEntity;
import com.aaron.aaronworld.emchat.api.impl.EasemobIMUsers;
import com.aaron.aaronworld.utils.Auth;
import com.google.gson.Gson;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestMain {
    private static EasemobIMUsers easemobIMUsers = new EasemobIMUsers();

    public static void main(String[] args) {
        RegisterUsers users = new RegisterUsers();
        User user = new User().username("wpc5586123321").password("123456");
//        User user1 = new User().username("wpc55861" + new Random().nextInt(500)).password("123456");
        users.add(user);
//        users.add(user1);
//        Object result = easemobIMUsers.createNewIMUserSingle(users);
//        System.out.println("~!~ = " + result.toString());
        EmchatUserEntity result = new Gson().fromJson(easemobIMUsers.createNewIMUserSingle(users).toString(), EmchatUserEntity.class);
        System.out.println(result);
        System.out.println(result.getEntities().get(0).getUuid());
        Assert.assertNotNull(result);
    }
}
