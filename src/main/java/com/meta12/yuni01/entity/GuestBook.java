package com.meta12.yuni01.entity;


import com.meta12.yuni01.dto.GuestBookDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GuestBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
        private String content;

        public static GuestBook dtoToEntity(GuestBookDTO guestBookDTO)
        {
            GuestBook guestBook = new GuestBook();
            guestBook.id = guestBookDTO.getId();
            guestBook.content = guestBookDTO.getContent();
            guestBook.email = guestBookDTO.getEmail();
            guestBook.password = guestBookDTO.getPassword();
            guestBook.name = guestBookDTO.getName();
            return guestBook;
        }
}
