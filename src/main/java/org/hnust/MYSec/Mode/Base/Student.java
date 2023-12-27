package org.hnust.MYSec.Mode.Base;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class Student {
    //真实姓名
    private String realName;
    //年级
    private int age;
    //学院
    private String department;
    //专业
    private String major;
    //方向
    private String[] direction;
}
