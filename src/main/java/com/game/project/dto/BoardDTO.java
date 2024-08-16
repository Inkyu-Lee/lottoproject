package com.game.project.dto;

import com.game.project.entity.BoardEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
