package main;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * 参考网址：                    http://blog.csdn.net/u010983881/article/details/9700677
 * 					http://wuhongyu.iteye.com/blog/1074105
 *
 */

public class Excel {

	public static void createExcelFile(String filename){
		try{   
		//打开文件   
		WritableWorkbook book=   
		Workbook.createWorkbook(new File(filename));   
		//生成名为“第一页”的工作表，参数0表示这是第一页   
		WritableSheet sheet=book.createSheet("第一页",0);   
		//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)   

		sheet.addCell(new Label(0, 0, "大学名称"));
		sheet.addCell(new Label(1, 0, "所在地"));
		sheet.addCell(new Label(2, 0, "211"));
		sheet.addCell(new Label(3, 0, "985"));
		sheet.addCell(new Label(4, 0, "高校类型"));
		sheet.addCell(new Label(5, 0, "隶属"));
		sheet.addCell(new Label(6, 0, "性质"));
		sheet.addCell(new Label(7, 0, "官网"));
		/*生成一个保存数字的单元格  
		必须使用Number的完整包路径，否则有语法歧义  
		单元格位置是第二列，第一行，值为789.123*/   
		//jxl.write.Number number = new jxl.write.Number(1,0,789.123);   
		//sheet.addCell(number);   
		//写入数据并关闭文件   
		book.write();   
		book.close();   
		}catch(Exception e){   
			System.out.println(e);  
		}
	}
	
	
	public static void saveUniverInfo(String pathname, String universityInfo){
		File mfile = new File(pathname);
		if(!mfile.exists()){
			createExcelFile(pathname);
		}
		try {   
		//Excel获得文件   
		Workbook wb=Workbook.getWorkbook(mfile);   
		//打开一个文件的副本，并且指定数据写回到原文件   
		WritableWorkbook book= Workbook.createWorkbook(mfile,wb);   
		//添加一个工作表   
		WritableSheet sheet=book.getSheet(0);
		int totalRows = sheet.getRows();
		
		String[] strarray = universityInfo.split(", ");
        for(int i=0; i<strarray.length; i++){
        	String location = "", tese211= "",tese985= "", type= "", belong= "", xingzhi= "", website= "";
        	
        	String[] itemarray = strarray[i].split("\n");
        	for(int j=0; j<itemarray.length; j++){
        		if(itemarray[j].contains("高校所在地")){
        			location = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(1, totalRows+i, location));
        		}
        		if(itemarray[j].contains("院校特色")){
        			if(itemarray[j].contains("211")){
        				tese211 = "yes";
        				sheet.addCell(new Label(2, totalRows+i, tese211));
        			}
        			if(itemarray[j].contains("985")){
        				tese985 = "yes";
        				sheet.addCell(new Label(3, totalRows+i, tese985));
        			}
        			//tese = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].length()-1);
        		}
        		if(itemarray[j].contains("高校类型")){
        			type = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(4, totalRows+i, type));
        		}
        		if(itemarray[j].contains("高校隶属")){
        			belong = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(5, totalRows+i, belong));
        		}
        		if(itemarray[j].contains("高校性质")){
        			xingzhi = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(6, totalRows+i, xingzhi));
        		}
        		if(itemarray[j].contains("学校网址")){
        			if(itemarray[j].contains("]")){
        				website = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].indexOf("]")-1);
        			}else{
        				website = itemarray[j].substring(itemarray[j].indexOf("：")+1, itemarray[j].length()-1);
        			}
        			sheet.addCell(new Label(7, totalRows+i, website));
        		}
        		
        	}
        	System.out.println(location+"-"+tese211+"-"+tese985+","+type+"-"+belong+"-"+xingzhi+"-"+website);
        	
//        	if("".equals(strarray[i]) || strarray[i] == null){
//        		continue;
//        	}
//        	if(strarray[i].contains("[")){
//        		strarray[i] = strarray[i].substring(strarray[i].indexOf("[")+1);	//减去1表示去掉'<'前面的空格
//        	}
//        	if(strarray[i].contains("]")){
//        		strarray[i] = strarray[i].substring(0, strarray[i].indexOf("]"));	//减去1表示去掉'<'前面的空格
//        	}
        	
//        	System.out.println(i+": "+strarray[i]);
        	
        	//sheet.addCell(new Label(0, totalRows+i, strarray[i]));
        }
        System.out.println("-----------------------------");
		book.write();   
		book.close();   
		}catch(Exception e) {  
			System.out.println(e); 
		}
	}
	
	public static void saveUniverName(String pathname, String universityName){
		File mfile = new File(pathname);
		if(!mfile.exists()){
			createExcelFile(pathname);
		}
		try {   
		//Excel获得文件   
		Workbook wb=Workbook.getWorkbook(mfile);   
		//打开一个文件的副本，并且指定数据写回到原文件   
		WritableWorkbook book= Workbook.createWorkbook(mfile,wb);   
		//添加一个工作表   
		WritableSheet sheet=book.getSheet(0);
		int totalRows = sheet.getRows();
		
		String[] strarray = universityName.split(", ");
        for(int i=0; i<strarray.length; i++){
        	if("".equals(strarray[i]) || strarray[i] == null){
        		continue;
        	}
        	if(strarray[i].contains("[")){
        		strarray[i] = strarray[i].substring(strarray[i].indexOf("[")+1);	//减去1表示去掉'<'前面的空格
        	}
        	if(strarray[i].contains("]")){
        		strarray[i] = strarray[i].substring(0, strarray[i].indexOf("]"));	//减去1表示去掉'<'前面的空格
        	}
        	if(strarray[i].contains("<")){
        		strarray[i] = strarray[i].substring(0,strarray[i].indexOf("<"));	//减去1表示去掉'<'前面的空格
        	}
        	System.out.println(i+": "+strarray[i]);
        	
        	sheet.addCell(new Label(0, totalRows+i, strarray[i]));
        }
        
		book.write();   
		book.close();   
		}catch(Exception e) {  
			System.out.println(e); 
		}
	}
	
	public static void updateExcelFile(String pathname, String universityName, String str){
		File mfile = new File(pathname);
		if(!mfile.exists()){
			createExcelFile(pathname);
		}
		int rowsnumber = getTotleRows(mfile);
		try {   
		//Excel获得文件   
		Workbook wb=Workbook.getWorkbook(mfile);   
		//打开一个文件的副本，并且指定数据写回到原文件   
		WritableWorkbook book= Workbook.createWorkbook(mfile,wb);   
		//添加一个工作表   
		WritableSheet sheet=book.getSheet(0);
		rowsnumber = rowsnumber+2;
		sheet.addCell(new Label(0, rowsnumber, universityName));		//保存大学名称
		
		String[] strarray = str.split(", ");
        for(int i=0; i<strarray.length; i++){
        	if("".equals(strarray[i]) || strarray[i] == null){
        		continue;
        	}
        	if(strarray[i].charAt(0) == '['){
        		strarray[i] = strarray[i].substring(1);
        	}
        	if(strarray[i].charAt(strarray[i].length() - 1) == ']'){
        		strarray[i] = strarray[i].substring(0, strarray[i].length() - 1);
        	}
        	if(strarray[i].contains("<")){
        		strarray[i] = strarray[i].substring(0,strarray[i].indexOf("<") - 1);	//减去1表示去掉'<'前面的空格
        	}
        	System.out.println(i+": "+strarray[i]);
        	
        	sheet.addCell(new Label(i%6, rowsnumber+1+i/6, strarray[i]));
        }
        
        rowsnumber = rowsnumber+1+strarray.length/6;
        Label label=new Label(0,0,rowsnumber+"");   
		//将定义好的单元格添加到工作表中   
		sheet.addCell(label);   
		book.write();   
		book.close();   
		}catch(Exception e) {  
			System.out.println(e); 
		}
	}
	
	private static int getTotleRows(File mfile){		//获得excel表总行数
		if(!mfile.exists()){
			return 0;
		}
		int rows = 0;
		try {   
		Workbook book=   
		Workbook.getWorkbook(mfile);   
		//获得第一个工作表对象   
		Sheet sheet=book.getSheet(0);   
		//得到第一列第一行的单元格   
		Cell cell1=sheet.getCell(0,0);   
		String result=cell1.getContents();   
		System.out.println("总共行数: "+result);   
		if(!"".equals(result)){
			rows = Integer.valueOf(result);
		}
		book.close();   
		}catch(Exception e)  {   
			System.out.println(e);   
		}
		return rows;   
	}
	
	
	
	public static void readExcel(String pathname){
		File mfile = new File(pathname);
		if(!mfile.exists()){
			createExcelFile(pathname);
		}
		try {   
		Workbook book=   
		Workbook.getWorkbook(new File(pathname));   
		//获得第一个工作表对象   
		Sheet sheet=book.getSheet(0);   
		//得到第一列第一行的单元格   
		Cell cell1=sheet.getCell(0,0);   
		String result=cell1.getContents();   
		System.out.println(result);   
		book.close();   
		}catch(Exception e)  {   
			System.out.println(e);   
		}   
	}
}
