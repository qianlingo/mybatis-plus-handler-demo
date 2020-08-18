package com.qianlingo.mybatisplushandlerdemo.service.data.impl;

import com.qianlingo.mybatisplushandlerdemo.mybatis.domain.data.DataClassroom;
import com.qianlingo.mybatisplushandlerdemo.mybatis.mapper.data.DataClassroomMapper;
import com.qianlingo.mybatisplushandlerdemo.service.data.IDataClassroomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教室数据表 服务实现类
 * </p>
 *
 * @author qianlingo
 * @since 2020-08-18
 */
@Service
public class DataClassroomServiceImpl extends ServiceImpl<DataClassroomMapper, DataClassroom> implements IDataClassroomService {

}
