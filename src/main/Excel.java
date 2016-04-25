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
 * �ο���ַ��                    http://blog.csdn.net/u010983881/article/details/9700677
 * 					http://wuhongyu.iteye.com/blog/1074105
 *
 */

public class Excel {

	public static void createExcelFile(String filename){
		try{   
		//���ļ�   
		WritableWorkbook book=   
		Workbook.createWorkbook(new File(filename));   
		//������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ   
		WritableSheet sheet=book.createSheet("��һҳ",0);   
		//��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)   

		sheet.addCell(new Label(0, 0, "��ѧ����"));
		sheet.addCell(new Label(1, 0, "���ڵ�"));
		sheet.addCell(new Label(2, 0, "211"));
		sheet.addCell(new Label(3, 0, "985"));
		sheet.addCell(new Label(4, 0, "��У����"));
		sheet.addCell(new Label(5, 0, "����"));
		sheet.addCell(new Label(6, 0, "����"));
		sheet.addCell(new Label(7, 0, "����"));
		/*����һ���������ֵĵ�Ԫ��  
		����ʹ��Number��������·�����������﷨����  
		��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123*/   
		//jxl.write.Number number = new jxl.write.Number(1,0,789.123);   
		//sheet.addCell(number);   
		//д�����ݲ��ر��ļ�   
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
		//Excel����ļ�   
		Workbook wb=Workbook.getWorkbook(mfile);   
		//��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�   
		WritableWorkbook book= Workbook.createWorkbook(mfile,wb);   
		//���һ��������   
		WritableSheet sheet=book.getSheet(0);
		int totalRows = sheet.getRows();
		
		String[] strarray = universityInfo.split(", ");
        for(int i=0; i<strarray.length; i++){
        	String location = "", tese211= "",tese985= "", type= "", belong= "", xingzhi= "", website= "";
        	
        	String[] itemarray = strarray[i].split("\n");
        	for(int j=0; j<itemarray.length; j++){
        		if(itemarray[j].contains("��У���ڵ�")){
        			location = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(1, totalRows+i, location));
        		}
        		if(itemarray[j].contains("ԺУ��ɫ")){
        			if(itemarray[j].contains("211")){
        				tese211 = "yes";
        				sheet.addCell(new Label(2, totalRows+i, tese211));
        			}
        			if(itemarray[j].contains("985")){
        				tese985 = "yes";
        				sheet.addCell(new Label(3, totalRows+i, tese985));
        			}
        			//tese = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].length()-1);
        		}
        		if(itemarray[j].contains("��У����")){
        			type = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(4, totalRows+i, type));
        		}
        		if(itemarray[j].contains("��У����")){
        			belong = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(5, totalRows+i, belong));
        		}
        		if(itemarray[j].contains("��У����")){
        			xingzhi = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].length()-1);
        			sheet.addCell(new Label(6, totalRows+i, xingzhi));
        		}
        		if(itemarray[j].contains("ѧУ��ַ")){
        			if(itemarray[j].contains("]")){
        				website = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].indexOf("]")-1);
        			}else{
        				website = itemarray[j].substring(itemarray[j].indexOf("��")+1, itemarray[j].length()-1);
        			}
        			sheet.addCell(new Label(7, totalRows+i, website));
        		}
        		
        	}
        	System.out.println(location+"-"+tese211+"-"+tese985+","+type+"-"+belong+"-"+xingzhi+"-"+website);
        	
//        	if("".equals(strarray[i]) || strarray[i] == null){
//        		continue;
//        	}
//        	if(strarray[i].contains("[")){
//        		strarray[i] = strarray[i].substring(strarray[i].indexOf("[")+1);	//��ȥ1��ʾȥ��'<'ǰ��Ŀո�
//        	}
//        	if(strarray[i].contains("]")){
//        		strarray[i] = strarray[i].substring(0, strarray[i].indexOf("]"));	//��ȥ1��ʾȥ��'<'ǰ��Ŀո�
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
		//Excel����ļ�   
		Workbook wb=Workbook.getWorkbook(mfile);   
		//��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�   
		WritableWorkbook book= Workbook.createWorkbook(mfile,wb);   
		//���һ��������   
		WritableSheet sheet=book.getSheet(0);
		int totalRows = sheet.getRows();
		
		String[] strarray = universityName.split(", ");
        for(int i=0; i<strarray.length; i++){
        	if("".equals(strarray[i]) || strarray[i] == null){
        		continue;
        	}
        	if(strarray[i].contains("[")){
        		strarray[i] = strarray[i].substring(strarray[i].indexOf("[")+1);	//��ȥ1��ʾȥ��'<'ǰ��Ŀո�
        	}
        	if(strarray[i].contains("]")){
        		strarray[i] = strarray[i].substring(0, strarray[i].indexOf("]"));	//��ȥ1��ʾȥ��'<'ǰ��Ŀո�
        	}
        	if(strarray[i].contains("<")){
        		strarray[i] = strarray[i].substring(0,strarray[i].indexOf("<"));	//��ȥ1��ʾȥ��'<'ǰ��Ŀո�
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
		//Excel����ļ�   
		Workbook wb=Workbook.getWorkbook(mfile);   
		//��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�   
		WritableWorkbook book= Workbook.createWorkbook(mfile,wb);   
		//���һ��������   
		WritableSheet sheet=book.getSheet(0);
		rowsnumber = rowsnumber+2;
		sheet.addCell(new Label(0, rowsnumber, universityName));		//�����ѧ����
		
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
        		strarray[i] = strarray[i].substring(0,strarray[i].indexOf("<") - 1);	//��ȥ1��ʾȥ��'<'ǰ��Ŀո�
        	}
        	System.out.println(i+": "+strarray[i]);
        	
        	sheet.addCell(new Label(i%6, rowsnumber+1+i/6, strarray[i]));
        }
        
        rowsnumber = rowsnumber+1+strarray.length/6;
        Label label=new Label(0,0,rowsnumber+"");   
		//������õĵ�Ԫ����ӵ���������   
		sheet.addCell(label);   
		book.write();   
		book.close();   
		}catch(Exception e) {  
			System.out.println(e); 
		}
	}
	
	private static int getTotleRows(File mfile){		//���excel��������
		if(!mfile.exists()){
			return 0;
		}
		int rows = 0;
		try {   
		Workbook book=   
		Workbook.getWorkbook(mfile);   
		//��õ�һ�����������   
		Sheet sheet=book.getSheet(0);   
		//�õ���һ�е�һ�еĵ�Ԫ��   
		Cell cell1=sheet.getCell(0,0);   
		String result=cell1.getContents();   
		System.out.println("�ܹ�����: "+result);   
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
		//��õ�һ�����������   
		Sheet sheet=book.getSheet(0);   
		//�õ���һ�е�һ�еĵ�Ԫ��   
		Cell cell1=sheet.getCell(0,0);   
		String result=cell1.getContents();   
		System.out.println(result);   
		book.close();   
		}catch(Exception e)  {   
			System.out.println(e);   
		}   
	}
}
