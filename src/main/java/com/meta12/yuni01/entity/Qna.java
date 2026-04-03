package com.meta12.yuni01.entity;


import com.meta12.yuni01.dto.QnaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String subject;
        private String content;

        public static Qna dtoToEntity(QnaDTO QnaDTO)
        {
            Qna qna = new Qna();
            qna.setId(QnaDTO.getId());
            qna.setContent(QnaDTO.getContent());
            qna.setName(QnaDTO.getName());
            return qna;
        }
}
