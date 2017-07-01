package com.techbins.niki;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;


/**
 * @author partha.jena
 *
 */
public class OpenAppiumServer 
{
	
	
	// To start appium server
	public static void startAppiumSever() throws Exception
	{
		// set path for node.exe and appium.js files
		String nodePath="C:\\PROGRA~2\\Appium\\node.exe";
		String appiumJsPath="C:\\PROGRA~2\\Appium\\node_modules\\appium\\bin\\appium.js";
		
	    //Created object of Apache commandLine to start command line in background
		CommandLine command=new CommandLine("cmd");
		System.out.println("opening command line tool in OS type : window");
		command.addArgument("/c");
		
		// add different arguments to start appium server
		command.addArgument(nodePath);
		command.addArgument(appiumJsPath);
		
		//set server address
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		
		//set server pot
		command.addArgument("--port");
		command.addArgument("4723");
		
		//Execute command line arguments to start Appium server
		DefaultExecuteResultHandler resultHandler=new DefaultExecuteResultHandler();
		DefaultExecutor executor=new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command,resultHandler);
		Thread.sleep(10000);	
	}
	
	// To stop appium server
	public static void stopAppiumServer() throws Exception

	{
		//Created object of Apache commandLine to start command line in background
		CommandLine command=new CommandLine("cmd");
		
		// add different arguments to stop appium server
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		
		//Execute command line arguments to stop Appium server
		DefaultExecuteResultHandler resultHandler=new DefaultExecuteResultHandler();
		DefaultExecutor executor=new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command,resultHandler);	
	}


}
