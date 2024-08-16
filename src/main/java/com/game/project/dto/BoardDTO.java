package com.game.project.dto;

import com.game.project.entity.BoardEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long id;

    private String title;

    private String nickname;

    private String content;

    private int hits;

    public BoardEntity toEntity(){
        return new BoardEntity(id, title, nickname, content, hits);
    }
}
