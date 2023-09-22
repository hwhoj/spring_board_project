# 개발 환경
1. IDE: IntelliJ IDEA Community
2. Spring Boot 2.7.15
3. JDK11
4. MYSQL
5. Spring Data JPA
6. Thymeleaf

# 게시판 주요 기능
1. 글쓰기(/board/save)
2. 글목록(/board/)
3. 글조회(/board/{id})
4. 글수정(/board/update/{id})
   - 상세화면에서 수정 버튼 클릭
   - 서버에서 해당 게시글의 정보를 가지고 수정 화면 출력
   - 제목, 내용 수정 입력 받아서 서버로 요청
   - 수정 처리
5. 글삭제(/board/delete/{id})
6. 페이징처리(/board/paging)
   - /board/paging?page=2
   - ex)게시글이 14개일 때
       -한 페이지에 5개씩 => 3페이지
       -한 페이지에 3개씩 => 5페이지
7. 파일첨부하기
   - 단일 파일 첨부
   - 다중 파일 첨부
   - 파일 첨부와 관련하여 추가될 부분들
      - save.html
      - Board.DTO
      - BoardService.save()
      - BoardEntity
      - BoardFileEntity, BoardFileRepository 추가
      - detail.html
8. 댓글 처리하기
    - 글 상세 페이지에서 댓글 입력(ajax:비동기 통신방식)
      - ajax 다뤄보기 재생목록참조 
    - 상세조회할 때 기존에 작성된 댓글 목록이 보임
    - 댓글을 입력하면 기존 댓글 목록에 새로 작성한 댓글 추가
    - 댓글용 테이블 필요


# mysql Database 계정 생성 및 권한 부여