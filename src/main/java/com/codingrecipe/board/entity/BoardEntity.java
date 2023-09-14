package com.codingrecipe.board.entity;

import com.codingrecipe.board.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter // 객체이기때문에 역시 getter, setter 어노테이션 사용
@Setter
@Table(name = "board_table") //실제로 테이블이 생성되는것이기때문에 별도로 DB에 테이블을 만들 필요가 없다
public class BoardEntity extends BaseEntity{
    //Entity라는 클래스는 DB의 테이블 역할을 하는 클래스. Entity클래스를 사용해서 DB작업을 한다고 생각하면됨
    //BaseEntity에서 시간정보를 상속받아서 쓸 수 있다.


    @Id // pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql기준으로 auto_increment
    private Long id;

    @Column(length = 20, nullable = false) // 크기는 20, not null 지정, 기본값은 크기255, null 가능
    private String boardWriter;

    @Column
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }


}
