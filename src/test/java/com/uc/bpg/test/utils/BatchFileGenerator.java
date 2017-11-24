package com.uc.bpg.test.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class BatchFileGenerator {
	
	@Test
	public void generate(){
		File file=new File("D:/doc/项目管理/瑞康体检中心/804云南致远MAC地址.csv");
		File output=new File("d:/temp/batch.txt");
		try{
		InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file), "gbk");
		BufferedReader reader=new BufferedReader(inputStreamReader);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(output), "gbk");
		BufferedWriter writer=new BufferedWriter(outputStreamWriter);
		writer.write("新增    血压计 WIFI804");
		while(true){
			String line=reader.readLine();
			if(line==null) break;
			String[] items=line.split(",");
			for(String item:items){
				String string=item.trim();
				int index=string.indexOf(':');
				if(index ==-1 ) continue;
				string = string.substring(index+1);
				if(string.length()==12){
					System.err.println(string);
					writer.write(string);
					writer.newLine();
				}
			}
		}
		reader.close();
		writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
