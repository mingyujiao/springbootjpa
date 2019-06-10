package com.example.springbootjpa.util;

import com.example.springbootjpa.SpringbootjpaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Jmy
 * @date 2019/6/9 0:02
 * @email jiaomingyu5778@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootjpaApplication.class})
public class ImportExcelTest {

    @Test
    public void testExcelImp() {
        ImportExcel importExcel = new ImportExcel();
        importExcel.testExcelImp();
    }
}