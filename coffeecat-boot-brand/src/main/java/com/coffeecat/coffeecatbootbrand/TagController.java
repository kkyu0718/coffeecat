package com.coffeecat.coffeecatbootbrand;

import com.coffeecat.coffeecatdatabrand.entity.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {
    private final TagFacadeService tagFacadeService;

    public TagController(TagFacadeService tagFacadeService) {
        this.tagFacadeService = tagFacadeService;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTag() {
        return ResponseEntity.status(HttpStatus.OK).body(tagFacadeService.findAllTag());
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<Tag> getTagByTagId(@PathVariable int tagId) {
        return ResponseEntity.status(HttpStatus.OK).body(tagFacadeService.findTagByTagId(tagId));
    }
}
