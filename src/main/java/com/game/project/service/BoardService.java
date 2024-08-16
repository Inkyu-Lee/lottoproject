package com.game.project.service;

import com.game.project.dto.BoardDTO;
import com.game.project.entity.BoardEntity;
import com.game.project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // POST

    public BoardEntity createNewArticle(BoardDTO boardDTO) {
        BoardEntity article = boardDTO.toEntity();
        return boardRepository.save(article);
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
        BoardEntity article = boardDTO.toEntity();
        return boardRepository.save(article);
    }

    // DELETE

    public BoardEntity deleteArticle(Long id) {
        BoardEntity article = findByArticleWithId(id);
        boardRepository.delete(article);
        return article;
    }
}
