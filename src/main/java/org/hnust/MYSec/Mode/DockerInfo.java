package org.hnust.MYSec.Mode;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
@NoArgsConstructor
public class DockerInfo {
    //靶机id
    private int id;
    //题目名字
    private String name;
    //开启的用户
    private CTFUser user;
    //剩余时间
    private Date leave_time;
    //是否生效
    private boolean isEnable;


}
