package com.wen.model.core;

import com.wen.UUIDUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
public class User {
    /**
     * 主键
     */
    @Id
    private String id = UUIDUtils.generateOrderedUUID();

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户名
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    @Length(min = 6, message = "密码长度不能小于 6 位")
    private String password;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    @Max(value = 100, message = "年龄不能大于 100 岁")
    @Min(value = 18, message = "必须年满 18 岁！")
    private Integer age;

    /**
     * 是否可用
     */
    private Boolean enable=Boolean.TRUE;

}