package com.meta12.yuni01.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDTO {
    Long  Id;
    String Subject;
    String Content;
    String Writer;
}
