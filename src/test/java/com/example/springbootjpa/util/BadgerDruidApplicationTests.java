package com.example.springbootjpa.util;

import com.example.springbootjpa.SpringbootjpaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jmy
 * @date 2019/6/10 14:07
 * @email jiaomingyu5778@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringbootjpaApplication.class })
public class BadgerDruidApplicationTests {

    @Autowired
    DataSource dataSource;


    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from ppms_work_breakdown_structure where parent_node_guid='-1'");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String cityName = resultSet.getString("name");
            System.out.println(cityName);
        }
    }

}
