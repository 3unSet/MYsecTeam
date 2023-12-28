package org.hnust.MYSec.Service.DockerAPI;

import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.hnust.MYSec.Utils.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContainerAPI {

    //获取所有容器
    public static List getAllContainer(String host){
        List containers=null;
        String url=host+"/containers/json";
        containers= (List)JSON.parse(Http.doGet(url));
        return containers;
    }

    //启动一个容器
    public static void createContain(String composeFilePath) {
        try {
            // 定义 Docker Compose 文件路径
            String composeFile = composeFilePath + "/docker-compose.yml";

            // 构建 Docker Compose 命令
            ProcessBuilder processBuilder = new ProcessBuilder("sudo docker-compose", "-f", composeFile, "up", "-d");

            // 设置工作目录（Docker Compose 文件所在的目录）
            processBuilder.directory(new java.io.File(composeFilePath));

            // 启动 Docker Compose
            Process process = processBuilder.start();

            // 等待 Docker Compose 进程执行完毕
            int exitCode = process.waitFor();

            // 输出执行结果
            if (exitCode == 0) {
                System.out.println("Docker Compose containers started successfully.");
            } else {
                System.err.println("Error starting Docker Compose containers. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    //开启远程的docker

    /**
     *
     * @param remoteHost 远程主机对象
     * @param remoteComposeDirectory docker-compose.yaml所在的目录

     */
    public static void  RemoteStartContainer(RemoteHost remoteHost,String remoteComposeDirectory){

            try {
                // 使用 JSch 创建 SSH 会话
                JSch jsch = new JSch();
                Session session = jsch.getSession(remoteHost.username, remoteHost.host, 22);
                session.setConfig("StrictHostKeyChecking", "no"); // 跳过 Host Key 检查
                session.setPassword(remoteHost.password);
                session.connect();

                // 远程 Docker Compose 文件路径
                String remoteComposeFilePath = remoteComposeDirectory+"/docker-compose.yml";

                // 远程 Docker Compose 项目目录

                // 构建 Docker Compose 启动命令
                String startCommand = "sudo docker-compose -f " + remoteComposeFilePath + " up -d";

                System.out.println(startCommand);
                // 执行 SSH 命令
                ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
                channelExec.setCommand(startCommand);

                // 读取命令执行的输出
                BufferedReader reader = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
                String line;
                StringBuilder output = new StringBuilder();

                // 执行命令并读取输出
                channelExec.connect();
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                // 关闭 SSH 会话
                channelExec.disconnect();
                session.disconnect();

                // 输出执行结果
                System.out.println("Docker Compose containers on remote host started successfully.");
                System.out.println("Output:\n" + output.toString());
            } catch (IOException | com.jcraft.jsch.JSchException e) {
                e.printStackTrace();
            }
    }


    //关闭容器
        public static void stopContainer(String containerId)  {
        try{
            // 构建 Docker 命令
            ProcessBuilder processBuilder = new ProcessBuilder("docker", "stop", containerId);

            // 启动 Docker 命令
            Process process = processBuilder.start();

            // 读取命令执行的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // 等待 Docker 命令执行完毕
            int exitCode = process.waitFor();

            // 输出执行结果
            if (exitCode == 0) {
                System.out.println("Container stopped successfully.");
                System.out.println("Output:\n" + output.toString());
            } else {
                System.err.println("Error stopping container. Exit code: " + exitCode);
                System.err.println("Output:\n" + output.toString());
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    //关闭远程的docker
    public static void RemoteStopContainer(RemoteHost remoteHost,String remoteComposeDirectory){
        try {
            // 远程 Docker 主机的 SSH 相关信息
            // 使用 JSch 创建 SSH 会话
            JSch jsch = new JSch();
            Session session = jsch.getSession(remoteHost.username, remoteHost.host, 22);
            session.setConfig("StrictHostKeyChecking", "no"); // 跳过 Host Key 检查
            session.setPassword(remoteHost.password);
            session.connect();
            // 远程 Docker Compose 文件路径
            String remoteComposeFilePath = remoteComposeDirectory+"/docker-compose.yml";
            // 构建 Docker Compose 停止命令
            String stopCommand = "sudo docker-compose -f " + remoteComposeFilePath + " down";
            // 执行 SSH 命令
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(stopCommand);
            // 读取命令执行的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            // 执行命令并读取输出
            channelExec.connect();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            // 关闭 SSH 会话
            channelExec.disconnect();
            session.disconnect();
            // 输出执行结果
            System.out.println("Docker Compose containers on remote host stopped successfully.");
            System.out.println("Output:\n" + output.toString());
        } catch (IOException | com.jcraft.jsch.JSchException e) {
            e.printStackTrace();
        }
    }
}
