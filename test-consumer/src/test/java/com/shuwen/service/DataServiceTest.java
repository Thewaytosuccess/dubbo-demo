package com.shuwen.service;

import com.shuwen.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class DataServiceTest {

    @Autowired
    private DataService dataService;

    @Test
    public void testDataImport(){
        String path = "/Users/xhzy/Downloads/algo.xlsx";
        dataService.dataImport(path);
    }
}
