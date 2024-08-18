package com.game.project.api;

import com.game.project.dto.BoardDTO;
import com.game.project.entity.BoardEntity;
import com.game.project.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // POST
    @PostMapping("/api/article/add")
    public ResponseEntity<BoardEntity> createNewArticle(@RequestBody BoardDTO boardDTO){

        if ( boardDTO == null ) {
            throw new NoSuchElementException("DTO값 확인불가");
        }

        BoardEntity boardEntity = boardService.createNewArticle(boardDTO);

        return ( boardEntity != null ) ? ResponseEntity.status(HttpStatus.OK).body(boardEntity) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @PostMapping("/api/article/hits/{id}")
    public ResponseEntity<BoardEntity> updateHits(@PathVariable Long id){
        boardService.updateArticleHits(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // GET
    @GetMapping("/api/article/{id}")
    public ResponseEntity<BoardEntity> findByArticleId(@PathVariable Long id, HttpSession session, HttpServletRequest request) {

        BoardEntity article = boardService.findByArticleWithId(id);
        boolean isNotNull = article != null;

        return isNotNull ? ResponseEntity.status(HttpStatus.OK).body(article) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/api/article/all")
    public List<BoardEntity> findAllArticle(){
        List<BoardEntity> articles = boardService.findAll();
        BoardEntity testBoard = articles.get(1);
        return boardService.findAll();
    }

    // DELETE
    @DeleteMapping("/api/article/delete/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id){
        BoardEntity article = boardService.findByArticleWithId(id);

        if ( article != null ) {
            boardService.deleteArticle(id);
        }

        return ( article != null ) ? ResponseEntity.status(HttpStatus.OK).body(String.valueOf(id) + "번 게시글 삭제완료") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 실패");
    }

    // PATCH
    @PatchMapping("/api/article/update/{id}")
    public ResponseEntity<BoardEntity> updateArticle(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
        BoardEntity article = boardService.updateArticle(id, boardDTO);

        return ( article == null ) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.status(HttpStatus.OK).body(article);
    }



}
