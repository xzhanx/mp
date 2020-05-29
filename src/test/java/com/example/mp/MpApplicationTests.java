package com.example.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mp.enums.SexEnum;
import com.example.mp.model.User;
import com.example.mp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MpApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = userService.getById(7);
        user.setName("update");
//        userService.saveOrUpdate(user);
        userService.removeById(10);
        userService.removeByIds(Arrays.asList(8, 9));
        userService.updateById(user);
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.list();
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
        System.out.println(userService.count());
        System.out.println(userService.lambdaQuery().eq(User::getId, 16).list());
    }

    @Test
    public void testCrud() {
        userService.save(new User("xzx", 18, "123@321.com", SexEnum.man));
        List<User> list = new ArrayList<>();
        list.add(new User("xzx", 19, "123@321.com", SexEnum.man));
        list.add(new User("xzx", 20, "123@321.com", SexEnum.man));
        userService.saveBatch(list);
        list.add(new User("xzx", 21, "123@321.com", SexEnum.man));
        userService.saveBatch(list, 2);
    }

    @Test
    public void testPage() {
        IPage<User> page = userService.selectPage(new Page<>(1, 3));
        System.out.println(page);
    }

    @Test
    public void testDeleted() {
        userService.removeById(11);
    }

    @Test
    public void testEnum() {
        userService.save(new User("enum", 22, "aaa@ccc.com", SexEnum.women));
    }
}
