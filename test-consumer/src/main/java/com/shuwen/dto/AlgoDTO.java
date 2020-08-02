package com.shuwen.dto;

import com.shuwen.bean.AlgoPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlgoDTO implements Serializable {

    private String tenantId;

    private List<AlgoPO> algoPO;

}
