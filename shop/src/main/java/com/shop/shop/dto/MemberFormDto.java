package com.shop.shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {
    @NotBlank(message="이름을 입력하세요")
    private String name;
    @NotEmpty(message = "이메일을 입력하세요")
    @Email(message="올바른 형식을 입력하세요")
    private String email;

    @NotEmpty(message="비밀번호를 입력하세요")
    private String password;

    @NotEmpty(message="주소를 입력하세요")
    private String address;
}
