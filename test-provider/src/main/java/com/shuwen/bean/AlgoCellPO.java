package com.shuwen.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AlgoCellPO implements Serializable {

    @ExcelProperty(value = "tenantId",index = 3)
    private String tenantId;

    @ExcelProperty(value = "content",index = 4)
    private String content;
}
