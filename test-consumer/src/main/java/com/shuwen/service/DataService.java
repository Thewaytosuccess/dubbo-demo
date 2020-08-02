package com.shuwen.service;

import com.shuwen.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataService {

    @Reference
    private UserFacade userFacade;

    public void dataImport(String path){
        log.info("result === {}",userFacade.dataImport(path));
    }
}
