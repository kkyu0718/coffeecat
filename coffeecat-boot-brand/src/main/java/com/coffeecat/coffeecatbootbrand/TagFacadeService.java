package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatdatabrand.entity.Tag;
import com.coffeecat.coffeecatdatabrand.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagFacadeService{
    private final TagService tagService;

    public TagFacadeService(TagService tagService) {
        this.tagService = tagService;
    }

    public List<Tag> findAllTag() {
        return tagService.findAllTag();
    }

    public Tag findTagByTagId(int tagId) {
        return tagService.findTagByTagId(tagId)
                .orElseThrow(BusinessException.TagNotFoundException::new);
    }
}
