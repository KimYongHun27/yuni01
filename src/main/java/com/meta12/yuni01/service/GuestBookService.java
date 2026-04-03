package com.meta12.yuni01.service;

import com.meta12.yuni01.dto.GuestBookDTO;
import com.meta12.yuni01.entity.GuestBook;
import com.meta12.yuni01.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public List<GuestBook> getSelectAll()
    {
        return guestBookRepository.findAll();
    }
public GuestBook getSelectOne(Long id)
    {
        Optional<GuestBook> optionalGuestBook = guestBookRepository.findById(id);
        GuestBook guestBook = null;

        if (optionalGuestBook.isPresent()){
            guestBook = optionalGuestBook.get();
        }

        return guestBook;

    }
public void setInsert(GuestBookDTO guestBookDTO)
    {
        GuestBook guestBook = GuestBook.dtoToEntity(guestBookDTO);
        guestBookRepository.save(guestBook);

    }
public void setUpdate(GuestBookDTO guestBookDTO)
    {
        GuestBook guestBook = GuestBook.dtoToEntity(guestBookDTO);
        guestBookRepository.save(guestBook);
    }
public void setDelete(GuestBookDTO guestBookDTO)
    {
        GuestBook guestBook = GuestBook.dtoToEntity(guestBookDTO);
        guestBookRepository.delete(guestBook);
    }
}
