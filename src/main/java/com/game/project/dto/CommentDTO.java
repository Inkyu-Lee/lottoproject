package com.game.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.project.entity.BoardEntity;
import com.game.project.entity.CommentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;

    @JsonProperty("article_id")
    private Long articleId;

    private String nickname;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static CommentDTO toDTO(CommentEntity g) {
        return new CommentDTO(
                g.getId(),
                g.getArticle().getId(),
                g.getNickname(),
                g.getContent(),
                g.getCreateTime(),
                g.getUpdateTime()
        );
    }
}