package com.jijuwuhua.myblog.service.impl;

import com.jijuwuhua.myblog.dao.TypeRepository;
import com.jijuwuhua.myblog.handler.NotFindException;
import com.jijuwuhua.myblog.pojo.Type;
import com.jijuwuhua.myblog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：chenjiajun
 * @description：分类服务层接口
 * @date ：2021/3/20 23:15
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    //添加方法
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        //先验证type的合法性，合法的话进行复制保存
        Type t = typeRepository.findById(id).get();
        if (t == null){
            throw new NotFindException("不存在该id");
        }
        BeanUtils.copyProperties(type,t);
        return null;
    }

    @Transactional
    @Override
    public void deleteType(Long id) {

    }
}
