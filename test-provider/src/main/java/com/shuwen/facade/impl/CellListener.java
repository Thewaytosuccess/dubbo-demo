package com.shuwen.facade.impl;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.shuwen.bean.AlgoCellPO;
import com.shuwen.bean.AlgoPO;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CellListener extends AnalysisEventListener<AlgoCellPO> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 10;
    List<AlgoCellPO> list = new ArrayList<>();

    @Override
    public void invoke(AlgoCellPO algoCellPO, AnalysisContext analysisContext) {
        //todo
        List<AlgoPO> algoList = JSON.parseArray(algoCellPO.getContent(),AlgoPO.class);
        for(AlgoPO po:algoList){
            log.info("解析到一条数据:"+ po);
        }
        log.info("================");
        list.add(algoCellPO);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("all is done !");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        //todo
        //export2File();
        log.info("存储数据库成功！");
    }

    private void export2File() {
        String exportPath = "./result.txt";

        try(
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(baos.toByteArray())));
                BufferedWriter writer = new BufferedWriter(new PrintWriter(new File(exportPath)));
        ){
            oos.writeObject(list);

            String str ;
            while((str = reader.readLine()) != null){
                writer.append(str);
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            log.error("read file error:{}",e.getMessage());
        }

    }
}
