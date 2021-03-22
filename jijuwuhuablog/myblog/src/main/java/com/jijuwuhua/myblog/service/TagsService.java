package com.jijuwuhua.myblog.service;

import com.jijuwuhua.myblog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagsService {

    Tag save(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Tag updateTag(Tag tag);

    //分页获取tag的page
    Page<Tag> listPage(Pageable pageable);

    void deleteTags(Tag tag);
}
