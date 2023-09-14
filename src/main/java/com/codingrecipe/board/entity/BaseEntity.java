package com.codingrecipe.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    //시간 정보는 회원가입일이라던지 댓글쓴 시간이라던지 다른곳에서도 활용할 수 있기때문에 시간정보는 클래스를 따로만들고
    //상속받아서 쓴다

    @CreationTimestamp // 생성된 시간을 기록
    @Column(updatable = false) // 수정 시에는 시간 기록 관여 x
    private LocalDateTime createdTime;

    @UpdateTimestamp // 수정된 시간을 기록
    @Column(insertable = false) // 생성 시에는 시간 기록 관여 x
    private LocalDateTime updatedTime;
}
