package com.codingrecipe.board.dto;


import com.codingrecipe.board.entity.BoardEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter //lombok이라는 라이브러리에서 자동으로 get, set 메소드를 만들어준다
@Setter
@ToString //필드값을 확인 할때 자주 사용됨, 필수적이진 않음
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class BoardDTO {
    //DTO = Data Transfer Object, 데이터를 전송할 때 사용하는 객체 (VO, Bean으로 표현하기도 함)

    private Long id; //게시글 id
    private String boardWriter; //게시글 작성자
    private String boardPass; //게시글 비밀번호
    private String boardTitle; //게시글 제목
    private String boardContents; //게시글 내용
    private int boardHits; //조회수
    private LocalDateTime boardCreatedTime; //게시글 작성시간
    private LocalDateTime boardUpdatedTime; //게시글 수정시간

    private MultipartFile boardFile; // save.html -> Controller 올때 파일을 담는 용도
    private String originalFileName; // 원본 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름
    private int fileAttached; // 파일 첨부 여부 (첨부 1, 미첨부 0)

    public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());

        return boardDTO;
    }
}
