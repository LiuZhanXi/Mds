package com.seaboxdata.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seaboxdata.mapper.MdsObjectMapper;
import com.seaboxdata.mapper.MdsObjectMysqlMapper;
import com.seaboxdata.model.MdsObject;
import com.seaboxdata.model.MdsObjectMysql;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ClassName:    MdsObjectMysqlService
 * Package:    com.seaboxdata.service
 * Description:
 * Datetime:    2021年01月12日   15:48
 * Author:     LiuZhanXi
 */
@Service
@Slf4j
public class MdsObjectMysqlService extends ServiceImpl<MdsObjectMysqlMapper, MdsObjectMysql> implements IMdsObjectMysqlService {

    private MdsObjectMapper mdsObjectMapper;
    private MdsObjectMysqlMapper mdsObjectMysqlMapper;

    @Autowired
    private IMdsObjectMysqlService mdsObjectMysqlService;

    @Autowired
    public MdsObjectMysqlService(MdsObjectMapper mdsObjectMapper, MdsObjectMysqlMapper mdsObjectMysqlMapper) {
        this.mdsObjectMapper = mdsObjectMapper;
        this.mdsObjectMysqlMapper = mdsObjectMysqlMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean mdsObjectToMongo() {
        LocalDateTime statTime = LocalDateTime.now();
        log.info("开始执行脚本,执行时间为:" + statTime);
        // 判断mysql表中是否有数据,有数据则清空表
        log.info("开始清空mysql表中数据");
        LambdaQueryWrapper<MdsObjectMysql> queryWrapper = new LambdaQueryWrapper().select();
        List<MdsObjectMysql> mdsObjectMysqls = mdsObjectMysqlMapper.selectList(queryWrapper);
        if (!mdsObjectMysqls.isEmpty()) {
            mdsObjectMysqlMapper.deleteMdsObjectMysql();
        }
        log.info("清空mysql表中数据成功,开始处理businessCategoryIds集合中的数据");
        List<MdsObject> allByBusinessCategoryIds = mdsObjectMapper.findAllByBusinessCategoryIds();
        List<MdsObject> allByBusinessCategoryNoIds = mdsObjectMapper.findAllByBusinessCategoryNoIds();
        // 处理businessCategoryIds这个字段的数据
        List<MdsObjectMysql> mysqlList = new ArrayList<>();
        allByBusinessCategoryIds.forEach(businessCategoryIds -> {
            MdsObjectMysql mysql = new MdsObjectMysql();
            BeanUtils.copyProperties(businessCategoryIds, mysql);
            List<Long> ids = businessCategoryIds.getBusinessCategoryIds();
            if (!ids.isEmpty()) {
                String collect = ids.parallelStream().
                        filter(Objects::nonNull)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
                mysql.setBusinessCategoryIds(collect);
            }
            mysqlList.add(mysql);
        });

        log.info("businessCategoryIds集合数据处理成功,开始处理其他数据");
        // 处理没有businessCategoryIds字段的数据
        if (!allByBusinessCategoryNoIds.isEmpty()) {
            allByBusinessCategoryNoIds.forEach(allByBusinessCategoryNoId -> {
                MdsObjectMysql mysql = new MdsObjectMysql();
                BeanUtils.copyProperties(allByBusinessCategoryNoId, mysql);
                mysqlList.add(mysql);
            });
        }
        log.info("数据处理成功,开始插入数据");
        if (!mysqlList.isEmpty()) {
            log.info("本次处理数据共:" + mysqlList.size() + "条");
            mdsObjectMysqlService.saveBatch(mysqlList);
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(statTime, endTime);
        long minutes = duration.toMillis();
        log.info("数据插入成功,共用时" + minutes + "毫秒," + "结束时间为" + endTime);
        return true;
    }
}
