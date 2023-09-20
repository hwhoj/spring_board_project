package com.codingrecipe.board.repository;

import com.codingrecipe.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //JpaRepository 상속받고 인자를 Entity클래스 이름과 Entity클래스가 가지고있는 pk의 타입을 명시한다
    //Repository는 기본적으로 Entity클래스만 받아준다.

    //조회수를 증가시키는 쿼리
    //update board_table set board_hits = board_hits + 1 where id = ?
    @Modifying //update나 delete 쿼리를 실행할때 필요한 어노테이션
    @Query(value = "update BoardEntity b set b.boardHits = b.boardHits + 1 where b.id = :id")
    //jpa에서 제공하는 어노테이션. 테이블 명이 아닌 Entity를 기준으로 쿼리한다. :id는 @Param부분과 매칭됨
    void updateHits(@Param("id") Long id);
}
