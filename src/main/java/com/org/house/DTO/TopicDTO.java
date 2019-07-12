package com.org.house.DTO;

import com.org.house.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class TopicDTO {
    private int id;
    @Null
    private Date date;
    @NotBlank
    private String theme;
    @NotBlank
    private String Description;
    private User user;
}
