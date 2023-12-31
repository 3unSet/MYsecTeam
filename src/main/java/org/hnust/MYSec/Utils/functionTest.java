package org.hnust.MYSec.Utils;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.hnust.MYSec.Mode.CTFUser;
import org.hnust.MYSec.Service.DockerAPI.ContainerAPI;
import org.hnust.MYSec.Service.DockerAPI.DockerManger;
import org.hnust.MYSec.Configure.RemoteHost;

public class functionTest {

	public static void main(String[] args) throws JSchException {
		String basepath="/var/www/html/vulhub/";

		String host="http://192.168.120.128:2375";

//		String path="log4j/CVE-2021-44228";
//		int count=dockerManger.getCurrentContainerCount(basepath+path);
//		System.out.println(count);
//		System.out.println();
		test2();
	}

	public static void test1() throws JSchException {
		String command="sudo docker ps -q --latest";
		Session session=ContainerAPI.connectSSH(new RemoteHost());
		String res=ContainerAPI.executeRemoteCommand(session,command);
		session.disconnect();
		System.out.println(res);
	}

	public  static void test2(){
	//	DockerManger dockerManger=new DockerManger();
		CTFUser use=new CTFUser();
		use.setUsername("yyjcycc");
		//dockerManger.addContainer(use,"/var/www/html/vulhub/flask/ssti");
		System.out.println();
	}
}
