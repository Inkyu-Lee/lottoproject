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

    @Column
    private String content;

    @Column
    private int hits;

    public BoardDTO toDTO(){
        return new BoardDTO(id, title, nickname, content, hits);
    }


}
