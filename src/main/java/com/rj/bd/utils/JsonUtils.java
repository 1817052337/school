package com.rj.bd.utils;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;


/**
 * fastJson  工具类
 * @author YuanJinTao
 * @date 2021年3月31日
 */
public class JsonUtils {
	public static void sendJson(PrintWriter writer,int code,String msg,List list){
		
		Gson jsonObject = new Gson();
		String ret = "{\"msg\":\""+code+"\",\"code\":\""+msg+"\",\"data\":"+jsonObject.toJson(list)+"}";
		writer.write(ret);
	}
}
