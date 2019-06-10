package com.example.springbootjpa.service;

import com.example.springbootjpa.dao.PpmsWorkBreakdownStructureDao;
import com.example.springbootjpa.entity.PpmsWorkBreakdownStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jmy
 * @date 2019/6/7 2:46
 * @email jiaomingyu5778@gmail.com
 */

@Service
@Transactional(rollbackOn = Exception.class)
public class PpmsWorkBreakdownStructureService {

    @Autowired
    private PpmsWorkBreakdownStructureDao ppmsDao;

    public PpmsWorkBreakdownStructure savePpms(PpmsWorkBreakdownStructure ppms){
        return ppmsDao.saveAndFlush(ppms);
    }

    public void savePpmsList(List<PpmsWorkBreakdownStructure> listPpms){
        ppmsDao.saveAll(listPpms);
    }
}
