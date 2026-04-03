package com.meta12.yuni01.service;

import com.meta12.yuni01.dto.QnaDTO;
import com.meta12.yuni01.entity.Qna;
import com.meta12.yuni01.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QnaService {

    private final QnaRepository qnaRepository;

    public List<Qna> getSelectAll()
    {
        return qnaRepository.findAll();
    }
public Qna getSelectOne(Long id)
    {
        Optional<Qna> optionalQna = qnaRepository.findById(id);
        Qna qna = null;

        if (optionalQna.isPresent()){
            qna = optionalQna.get();
        }

        return qna;

    }
public void setInsert(QnaDTO qnaDTO)
    {
        Qna qna = Qna.dtoToEntity(qnaDTO);
        qnaRepository.save(qna);

    }
public void setUpdate(QnaDTO qnaDTO)
    {
        Qna qna = Qna.dtoToEntity(qnaDTO);
        qnaRepository.save(qna);
    }
public void setDelete(QnaDTO qnaDTO)
    {
        Qna qna = Qna.dtoToEntity(qnaDTO);
        qnaRepository.delete(qna);
    }
}
