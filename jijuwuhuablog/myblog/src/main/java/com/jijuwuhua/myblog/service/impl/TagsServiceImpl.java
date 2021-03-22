package com.jijuwuhua.myblog.service.impl;

import com.jijuwuhua.myblog.dao.TgasRepository;
import com.jijuwuhua.myblog.handler.NotFindException;
import com.jijuwuhua.myblog.pojo.Tag;
import com.jijuwuhua.myblog.service.TagsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：chenjiajun
 * @description：标签服务实现类
 * @date ：2021/3/22 15:41
 */
@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TgasRepository tgasRepository;

    @Transactional
    @Override
    public Tag saveByName(Tag tag) {
        return tgasRepository.save(tag);
    }

    //这里先测试了getOne(id)看一下有没有用
    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tgasRepository.getOne(id);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tgasRepository.findByName(name);
    }

    @Transactional
    @Override
    public Tag updateTag(Tag tag) {
        //先验证数据的合法性，对实际存在的数据进行覆盖更新
        Tag tag1 = tgasRepository.getOne(tag.getId());
        //查询不到，则拒绝更新，返回错误信息，交由错误异常处理
        if(tag1 == null){
            throw new NotFindException("不存在该标签，拒绝更新");
        }
        BeanUtils.copyProperties(tag,tag1);
        return tgasRepository.save(tag1);
    }

    @Transactional
    @Override
    public Page<Tag> listPage(Pageable pageable) {
        return tgasRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void deleteTags(Tag tag) {
        tgasRepository.delete(tag);
    }

//    public static void main(String[] args) {
//          这里本来想测试一下方法，但是鉴于tagservice中使用的tagsRepository是一个接口，
//          只有启动了springmvc才会注入，否则为空，不能直接用来插叙
//        long l = -1;
//        System.out.println(new TagsServiceImpl().getTag(l).toString());
//    }
}
