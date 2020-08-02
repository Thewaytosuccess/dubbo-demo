package com.shuwen.controller;

import com.alibaba.fastjson.JSON;
import com.shuwen.bean.AlgoPO;
import com.shuwen.dto.AlgoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestController {

    /**
     * try-catch 异常处理
     * executor必要性
     * @param str
     * @return
     */

    @PostMapping("/data/import")
    public boolean dataImport(String str){
        String[] strs = str.split("\t");
        log.info("split length:{}",strs.length);

        List<AlgoDTO> list = Lists.newArrayList();
        AlgoDTO dto ;
        for(int i=0,len = strs.length;i < len - 1;i+=2){
            if(StringUtils.isEmpty(strs[i])) continue;
            dto = new AlgoDTO(strs[i], JSON.parseArray(strs[i+1], AlgoPO.class));
            list.add(dto);
        }
        log.info("dto length:{}",list.size());

        return true;
    }
}
