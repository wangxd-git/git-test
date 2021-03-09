package cn.com.straw.portal.dto;

import lombok.Data;

@Data
public class StudentRegisterDTO {
    private String inviteCode;
    private String phone;
    private String nickName;
    private String password;

}
