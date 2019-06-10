 package com.example.springbootjpa.util;


import com.example.springbootjpa.entity.PpmsWorkBreakdownStructure;
import com.example.springbootjpa.service.PpmsWorkBreakdownStructureService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Jmy
 * @date 2019/6/7 2:52
 * @email jiaomingyu5778@gmail.com
 */
@RestController
public class ImportExcel {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PpmsWorkBreakdownStructureService ppmsService;

    /**读取一个excel文件的内容
     * @param
     * @throws Exception
     */
    @PostMapping(value = "/test")
    public void testExcelImp (){
        Map<String, List<List<String>>> map = new ExcelUtil()
                .read("C:\\Users\\29109\\Desktop\\标准设施PBS库 (1).xls");
        List<List<String>> excelList = map.get("result");
        if (excelList == null) {
            System.out.println("excel中没有内容！");
            return;
        }

        insertPpmsWorkBreakdownStructure(excelList);
    }

    private void insertPpmsWorkBreakdownStructure(List<List<String>> excelList){

        Long startDate = System.currentTimeMillis();

        int maxVeal = (excelList.get(0).size() - 1) / 2;
        Long[] prentIdArr = new Long[maxVeal];
        // i 从 1 开始不要列头
        List<PpmsWorkBreakdownStructure> maxVealList = new ArrayList<>();
        for (int i = 1; i < excelList.size(); i++) {
            PpmsWorkBreakdownStructure ppms = new PpmsWorkBreakdownStructure();
            List<String> list = excelList.get(i);
            if (i == 1 ) {
                boolean fistVeal = list.get(1) == null || StringUtils.isBlank(list.get(1));
                if (fistVeal) {
                    logger.info("没有第一级节点");
                    return;
                }
            }

            int layer = 1;

            for (int j = 0; j < list.size(); j++) {
                String cellValue = list.get(j);
                if (j == 0) {
                    ppms.setRemark(cellValue);
                    continue;
                }
                if (StringUtils.isBlank(list.get(j))) {
                    continue;
                }
                int codeOrName = j%2;
                if (codeOrName == 0) {
                    layer = j/2;
                    ppms.setPbsName(cellValue);
                    break;
                }
                if (codeOrName == 1) {
                    ppms.setPbsCode(cellValue);
                }
            }
            ppms.setLayer(layer);
            if (layer == 1) {
                ppms.setParentNodeGuid(-1L);
                PpmsWorkBreakdownStructure rtnPpms = ppmsService.savePpms(ppms);
                prentIdArr[0] = rtnPpms.getSid();
            } else if(layer == maxVeal){
                ppms.setParentNodeGuid(prentIdArr[layer - 2]);
                maxVealList.add(ppms);
            } else {
                ppms.setParentNodeGuid(prentIdArr[layer - 2]);
                PpmsWorkBreakdownStructure rtnPpms = ppmsService.savePpms(ppms);
                prentIdArr[layer - 1] = rtnPpms.getSid();
            }
        }

        ppmsService.savePpmsList(maxVealList);

        Long endDate = System.currentTimeMillis();

        logger.info("执行时间" + (endDate - startDate));
    }
}
