package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Tag;
import com.coffeecat.coffeecatdatabrand.repository.TagRepository;

import java.util.List;
import java.util.Optional;

public class TagServiceImpl implements TagService{
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findTagByTagId(int tagId) {
        return tagRepository.findById(tagId);
    }
}
