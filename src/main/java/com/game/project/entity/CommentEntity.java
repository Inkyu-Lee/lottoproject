package com.game.project.entity;

import com.game.project.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity extends DateEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private BoardEntity article;

    @Column
    private String nickname;

    @Column
    private String content;

    public static CommentEntity toEntity(CommentDTO dto, BoardEntity article) {

        if ( dto.getId() != null){
            throw new IllegalArgumentException("댓글 생성 실패!");
        }

        return new CommentEntity(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getContent()
        );
    }

    public void patch(CommentDTO dto) {

        if ( this.id != dto.getId() ){
            throw new IllegalArgumentException("댓글 Id값이 다름");
        }

        this.nickname = dto.getNickname();
        this.content = dto.getContent();
    }
}
