package com.study.spring.board.service;

import com.study.spring.board.dto.RequestBoard;
import com.study.spring.board.repository.Board;
import com.study.spring.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageNumber());
        return boardRepository.findAll(pageable);
    }

    public Board findBoardByIdx(Long idx) {
        return boardRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
    }

    @Transactional(readOnly = true)
    public Board getBoardContent(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
    }

    @Transactional
    public void createBoardContent(RequestBoard reqBoard) {
        Board board = Board.builder().writer(reqBoard.getWriter()).contents(reqBoard.getContents()).title(reqBoard.getTitle()).build();
        boardRepository.save(board);
    }

    @Transactional
    public void modifyBoardContent(RequestBoard reqBoard) {
        Board board = boardRepository.findById(reqBoard.getBoardId()).orElseThrow(() -> new IllegalArgumentException(("해당 게시물이 없습니다.")));
        board.updateBoard(reqBoard);
    }

    @Transactional
    public void deleteBoardContent(Long boardId) {
        // 1. select 한 결과를 delete
//        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException(("해당 게시물이 없습니다.")));
//        boardRepository.delete(board);

        // 2. BoardRepository 에서 delete 부분 추가 작성
        boardRepository.deleteBoard(boardId);
    }
}
