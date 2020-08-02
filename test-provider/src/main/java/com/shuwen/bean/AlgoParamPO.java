package com.shuwen.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AlgoParamPO implements Serializable {

    private List<String> inclusive_ids;

    private float threshold;
}
