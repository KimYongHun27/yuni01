package com.meta12.yuni01.service;

import com.meta12.yuni01.dto.MemoDTO;
import com.meta12.yuni01.entity.Memo;
import com.meta12.yuni01.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public void setInsert(MemoDTO memoDTO)//chuga
    {//DTO 로 받아와서 객체 내 정보를 엔티티에 담아준다.
        Memo memo = new Memo(); //객체 생성
        memo.setId(memoDTO.getId());
        memo.setSubject(memoDTO.getSubject());
        memo.setContent(memoDTO.getContent());
        memo.setWriter(memoDTO.getWriter());//값 저장
        
        memoRepository.save(memo);//실제 데이터 베이스에 저장
    }
    public void setUpdate(MemoDTO memoDTO)//sujung
    {//DTO의 아이디와 업데이트 내용을 받아와 엔티티에 담아준다.
        //단, 작성자가 변경 시킬 수 없는 값은 사전/ 후 처리를 해준다.
        Memo memo = new Memo();
        memo.setId(memoDTO.getId());
        memo.setSubject(memoDTO.getSubject());
        memo.setContent(memoDTO.getContent());
        memo.setWriter(memoDTO.getWriter());//값 저장
        //기본키가 데이터 베이스에 있는지 확인한다.

        //계정 정보 혹은 비밀 번호가 일치하는지 확인한다.
        memoRepository.save(memo);//일치하는 경우 : 수정 내용을 저장.
        //일치하지 않는 경우 : 비정상적인 접근.

    }
    public void setDelete(MemoDTO memoDTO)//sakje
    {//DTO의 아이디와 업데이트 내용을 받아와 엔티티에 담아준다.
        Memo memo = new Memo();
        memo.setId(memoDTO.getId());//아이디 저장
        //기본키가 데이터 베이스에 있는지 확인한다.
        //계정 정보 혹은 비밀 번호가 일치하는지 확인한다.
        //memoRepository.delete(memo);//일치하는 경우 : 기본키에 해당하는 객체 삭제
        memoRepository.deleteById(memoDTO.getId());//일치하는 경우 : 기본키에 해당하는 객체 삭제
        //일치하지 않는 경우 : 비정상적인 접근.
    }
    public List<Memo> getSelectAll()//list
    {
        return memoRepository.findAll();
    }
    public Memo getSelectOne(Long id)//view
    {
        Memo memo = null;
        Optional<Memo> optionalMemo = memoRepository.findById(id);
        if (optionalMemo.isPresent())
        {
            memo = optionalMemo.get();
        }

        return memo;
    }

}
