package com.shuwen.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AlgoPO implements Serializable {

    private String algoName;

    private List<String> mediaTypeList;

    private boolean open;

    private AlgoParamPO algoParam;

    private List<AlgoPO> onSuccess;

}
