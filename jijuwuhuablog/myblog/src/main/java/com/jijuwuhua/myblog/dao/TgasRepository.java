package com.jijuwuhua.myblog.dao;

import com.jijuwuhua.myblog.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TgasRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);
}
