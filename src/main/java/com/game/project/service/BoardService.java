package com.game.project.service;

import com.game.project.dto.BoardDTO;
import com.game.project.entity.BoardEntity;
import com.game.project.entity.CommentEntity;
import com.game.project.repository.BoardRepository;
import com.game.project.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    // POST

    public BoardEntity createNewArticle(BoardDTO boardDTO) {
        BoardEntity article = boardDTO.toEntity();
        return boardRepository.save(article);
    }

    @Transactional
    public void updateArticleHits(Long id){
        boardRepository.updateHits(id);
    }

    // GET

    public List<BoardEntity> findAll(){
        return boardRepository.findAll();
    }

    public BoardEntity findByArticleWithId(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("값을 찾을 수 없음"));

    }

    // PATCH

    public BoardEntity updateArticle(Long id, BoardDTO boardDTO) {
        BoardEntity article = boardRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("찾을 수 없음(게시글 변경)"));
        article.patch(boardDTO);
        return boardRepository.save(article);
    }

    // DELETE
    @Transactional
    public BoardEntity deleteArticle(Long id) {
        BoardEntity article = findByArticleWithId(id);
        List<CommentEntity> comments = commentRepository.findByArticleById(id);
        if (!comments.isEmpty()) {
            commentRepository.deleteAll(comments);
        }
        boardRepository.delete(article);
        return article;
    }


}
