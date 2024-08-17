package com.game.project.entity;

import com.game.project.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardEntity extends DateEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String nickname;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column
    private int hits;

    public BoardDTO toDTO(){
        return new BoardDTO(id, title, nickname, content, hits);
    }


    public void patch(BoardDTO boardDTO) {
        this.title = boardDTO.getTitle();
        this.nickname = boardDTO.getNickname();
        this.content = boardDTO.getContent();
    }
}
