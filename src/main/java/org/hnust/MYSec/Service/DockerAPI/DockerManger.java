package org.hnust.MYSec.Service.DockerAPI;

import lombok.Data;
import org.hnust.MYSec.Mode.CTFUser;
import org.hnust.MYSec.Service.DockerAPI.Mode.Container.Container;
import org.hnust.MYSec.Service.DockerAPI.Mode.Container.Label;
import org.hnust.MYSec.Service.DockerAPI.Mode.RemoteHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Data
public class DockerManger {

    public String mode;
    public RemoteHost remoteHost;
    private static final Logger logger = LoggerFactory.getLogger(DockerManger.class);
    public List<Container> activeDocker;
    /**
     * 状态级别:                    <br/>
     * -1 初始化失败，或未初始化       <br/>
     * 1    正常                  <br/>
     * 2    系统超负荷状态         <br/>
     */
    public short status;

    public  HashMap<CTFUser, Container> userDockerMap;

    //用来测试的属性
    private CTFUser ctfUser;
    public DockerManger(){
        this.remoteHost=new RemoteHost();
        try {
            this.activeDocker = ContainerAPI.getAllContainer(remoteHost.dockerApiHost);
        }catch (Exception e){
            this.status=-1;
           logger.error("docker 服务器错误，请检查");
        }
        this.status=1;
        this.userDockerMap=new HashMap<>();

        //用来测试的片段
        this.ctfUser = new CTFUser();
        ctfUser.setUsername("yyjccc");
        ctfUser.setPassword("123456");
        this.mode="remote";
        testaddContainer();

    }
    public DockerManger(String mode){
        this();
        this.mode=mode;
    }

    public void testaddContainer(){

        Container container=activeDocker.get(0);
        Container container2=activeDocker.get(1);
        Container container3=activeDocker.get(2);
        CTFUser ctfUser1=new CTFUser();
        ctfUser1.setUsername("qzy");
        CTFUser ctfUser2=new CTFUser();
        ctfUser2.setUsername("hyx");
        userDockerMap.put(ctfUser,container);
        userDockerMap.put(ctfUser2,container2);
        userDockerMap.put(ctfUser1,container3);

    }

    public synchronized void addContainer(CTFUser ctfUser,String path){
        int count=getCurrentContainerCount(path)+1;
        String containerId=null;
        try {

        if(mode.equals("local")){
            containerId=ContainerAPI.createContain(path,count);
        } else if (mode.equals("remote")) {
            containerId=ContainerAPI.createContain(remoteHost,path,count);
        }}catch (Exception e){
            e.printStackTrace();
        }
        if(containerId!=null){
            activeDocker=ContainerAPI.getAllContainer(remoteHost.dockerApiHost);
            Container container=ContainerAPI.getContainerInfo(remoteHost.dockerApiHost,containerId);
            userDockerMap.put(ctfUser,container);
            logger.info("用户成功启动一个容器"+containerId);
        }else {
            logger.error("启动容器出错");
        }
    }

    public void closeContainer(){

    }


    public void closeAllContainer(){

    }


    //获取同一个题目的开启的实例个数
    public int getCurrentContainerCount(String dockerPath){
        int count=0;
        // 获取HashMap的值集合
        Collection<Container> values = userDockerMap.values();
        // 或者使用增强for循环遍历值集合
        for (Container container : values) {
            Label labels = container.getLabels();
            if(labels.getProjectWorkingDir().equals(dockerPath)){
                count+=1;
            }
        }

        return count;
    }

}
