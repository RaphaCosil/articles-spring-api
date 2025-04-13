package com.example.articlesapi.contract;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/articles")
@Tag(name = "Articles")
public interface ArticleContract {

}
