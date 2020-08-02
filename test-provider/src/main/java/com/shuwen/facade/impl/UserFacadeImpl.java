package com.shuwen.facade.impl;

import com.alibaba.excel.EasyExcel;
import com.shuwen.bean.AlgoCellPO;
import com.shuwen.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.io.File;

@Service(interfaceClass = UserFacade.class)
@Slf4j
public class UserFacadeImpl implements UserFacade {

    @Override
    public Boolean dataImport(String path) {
        log.info("path == {}",path);
        EasyExcel.read(path, AlgoCellPO.class, new CellListener())
                .autoTrim(true)
                .ignoreEmptyRow(true)
                .autoCloseStream(true)
                .doReadAll();
        return !path.isEmpty();
//        File file = new File(path);
//        return file.exists() && file.delete();

    }
}
