package com.codingrecipe.board.repository;

import com.codingrecipe.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //JpaRepository 상속받고 인자를 Entity클래스 이름과 Entity클래스가 가지고있는 pk의 타입을 명시한다
    //Repository는 기본적으로 Entity클래스만 받아준다.
}
