package org.hnust.MYSec.Service.DockerAPI;

import com.alibaba.fastjson.JSON;
import org.hnust.MYSec.Utils.Http;

import java.util.ArrayList;
import java.util.List;

public class ImageAPI {


   //获取全部image信息
    public static List getAllImages(String host){
        List images=null;
        String url=host+"/images/json";
        images=(List) JSON.parse(Http.doGet(url));
        return images;
    }


}
