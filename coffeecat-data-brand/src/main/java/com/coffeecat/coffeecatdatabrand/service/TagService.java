package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> findAllTag();
    Optional<Tag> findTagByTagId(int tagId);
}
