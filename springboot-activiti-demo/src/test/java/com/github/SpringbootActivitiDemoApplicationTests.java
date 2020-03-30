package com.github;


import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootActivitiDemoApplicationTests {

	@Autowired
	RuntimeService runtimeService;

	@Autowired
	RepositoryService repositoryService;

	@Test
	public void deploymenyProcessDefinition(){
		//与流程定义和部署对象相关的service
		//创建一个部署对象
		//添加部署的名称
		//从classpath资源中加载文件,一次加载一个
		Deployment deployment=repositoryService
				.createDeployment().name("activiti_Introduction")
				.addClasspathResource("processes/vacation.bpmn")
				.deploy();//部署
		System.out.println("流程Id:"+deployment.getId());
		System.out.println("流程名称:"+deployment.getName());
	}
	@Test
	public void startProcessInstance(){
		//流程定义的key
		String processDedinitionKey="vacationProcess";
		//与正在执行的流程实例和执行对象相关的service
		 ProcessInstance pi=runtimeService.startProcessInstanceByKey(processDedinitionKey);//通过key启动流程实例,key对应***.bpmn文件中id的属性值
		System.out.println("流程实例id:"+pi.getId());
		System.out.println("流程定义id:"+pi.getProcessDefinitionId());
	}

	@Test
	public void viewProcess(){
		//流程定义的key
		String deploymengId="5001";
		List<String> list=repositoryService.getDeploymentResourceNames(deploymengId);

		String resourceName="";
		if(list!=null && list.size()>0){
			for(String name:list){
				if(name.indexOf(".png")>0){
					resourceName=name;
				}
			}
		}

		//获取图片的输入流
		InputStream is=repositoryService.getResourceAsStream(deploymengId, resourceName);

		File file=new File("D:/"+resourceName);

		//将输入流的图片写入到磁盘下
		try {
			Files.copy(is, file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
