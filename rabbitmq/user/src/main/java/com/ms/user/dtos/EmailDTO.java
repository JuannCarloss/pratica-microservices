package com.ms.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private Long userId;
    private String emailTo;
    private String subject;
    private String body;
}
