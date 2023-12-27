package org.hnust.MYSec.Conteller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.hnust.MYSec.Mode.CTFUser;
import org.hnust.MYSec.Mode.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctf")
public class Ctfer {

    //首页
    @RequestMapping("/")
    public String index(){
        CTFUser ctfUser=new Member();
        return JSON.toJSONString(ctfUser, SerializerFeature.WriteMapNullValue);
    }
}
