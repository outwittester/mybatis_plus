package com.example.mybatis_plus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.entity.User;
import com.example.mybatis_plus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    @Test
    public void testInsert() {
        User user = new User();
        user.setName("xiong");
        user.setAge(29);
        user.setEmail("419799016@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(2L);
        user.setAge(99);
        int i = userMapper.updateById(user);
        System.out.println(i);

    }

    @Test
    public void testOptimisticLockerInterceptor() {
        User user = userMapper.selectById(2L);
        user.setEmail("123.qq.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(2, 3, 4));
        users.forEach(System.out::println);
    }

    @Test // concise search
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", "28");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

    @Test
    public void testSelectPagination() {
        //to which table you want to do pagination?
        Page<User> page = new Page<>(2, 2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        long current = userIPage.getCurrent();//current page number
        long pages = userIPage.getPages(); // total pages number
        long size = userIPage.getSize(); // every page records
        long total = userIPage.getTotal(); //total records
        List<User> records = userIPage.getRecords();
        System.out.println(current);
        System.out.println(pages);
        System.out.println(size);
        System.out.println(total);
        records.forEach(System.out::println);

    }

    @Test
    public void testSelectMapsPage() {
        Page<User> page = new Page<>(2, 2);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        List<Map<String, Object>> records = mapIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());

    }

    @Test
    public void testDeletById() {
        int i = userMapper.deleteById(2L);
        System.out.println(i);
    }

    @Test
    public void testDeleteByBatchIds() {
        int i = userMapper.deleteBatchIds(Arrays.asList(4, 5));
        System.out.println(i);
    }

    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "xiong");
        map.put("age", "30");
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }


    @Test
    public void testLogicDelete() {
        int i = userMapper.deleteById(1175957215145615362L);
        System.out.println(i);
    }


    @Test
    public void testSelectList() {
        //after set deleted field,select will update too
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
