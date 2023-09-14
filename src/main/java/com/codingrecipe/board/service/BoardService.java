package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Service 클래스에서 하는작업
// DTO > Entity,  Entity > DTO
// 컨트롤러로 부터 데이터를 넘겨받을때는 DTO, Repository로 넘겨줄때는 Entity로 넘겨준다
// entity클래스는 DB와 직접적으로 연관이 있기 때문에 되도록 view단에 노출이 안되는게 좋다
// 그래서 service 클래스에서 DTO > Entity (Entity 클래스에서),  Entity > DTO (DTO클래스에서) 변환하는 과정이 많이 발생한다

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; //생성자 주입방식으로 의존성을 주입받는다
    public void save(BoardDTO boardDTO) {

        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        //repositoy로 가져올때는 무조건 entity로 온다
        //entity로 넘어온 객체를 DTO객체로 옮겨담아서 컨트롤러로 리턴을 해줘야한다

        List<BoardDTO> boardDTOList = new ArrayList<>();
        //boardEntityLis에 담긴 데이터를 boardDTOList에 옮겨담는 과정

        for (BoardEntity boardEntity : boardEntityList){
            //entity 객체를 DTO로 변환을 하고 변환된 객체를 boardDTOList에 담는다
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
}
