package org.hnust.MYSec.Mode;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hnust.MYSec.Mode.Base.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@Component
public class CTFUser {
    //用户名
    private String username;
    //账号密码
    private String password;
    //是否为校内成员
    private boolean isIN;
    //邮箱
    private String email;
    @Autowired
    //校内成员信息
    private Student studentInfo;
    //是否为管理员
    private boolean isManager;

}
