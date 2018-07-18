package com.wen.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wen.GlobalConstant;
import lombok.Data;

import java.util.Date;

/**
 * Created by szty on 2018/7/18.
 */
@Data
public class CreateUserViewModel {
    private String userName;

    private String nickName;

    private String password;
    @JsonFormat(pattern = GlobalConstant.DATA_YMD, timezone = "GMT+8")
    private Date birthday;


    private Integer sex;

    private Integer age;
}
