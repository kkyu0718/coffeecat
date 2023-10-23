package com.coffeecat.coffeecatdatabrand.service;

import com.coffeecat.coffeecatdatabrand.entity.Tag;
import com.coffeecat.coffeecatdatabrand.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> findAllTag() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findTagByTagId(int tagId) {
        return tagRepository.findById(tagId);
    }
}
