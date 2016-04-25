package main;

import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class FilePipeline implements Pipeline {
	private int province = -1;		//����Excel�ļ�����
	private int university = -1;
	
	public FilePipeline(int province, int university) {
		// TODO Auto-generated constructor stub
		this.province = province;
		this.university = university;
	}

    @Override
    public void process(ResultItems resultItems, Task task) {
        //System.out.println("get page: " + resultItems.getRequest().getUrl());
        //�������н�������������̨�����������е�"author"��"name"��"readme"����һ��key���������Ƕ�Ӧ��value
    	/*String universityName = "";
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + " = :\t" + entry.getValue());
            if(entry.getKey().equals("universityname")){
            	universityName = entry.getValue().toString();
            }
            
            if(entry.getKey().equals("diagram")){
            	String str = entry.getValue().toString();
                Excel.updateExcelFile(province + ".xls", university+" :"+universityName, str);
            }
            
        }*/
    	
    	for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
    		String univerInfo = "";
    		System.out.println(entry.getKey() + " = :\t" + entry.getValue());
//    		if(entry.getKey().equals("info")){				//ѧУ��Ϣ
//            	univerInfo = entry.getValue().toString();
//            	Excel.saveUniverInfo("universityInfo.xls", univerInfo);
//            }
            
            if(entry.getKey().equals("logo")){			//ѧУ����
            	String univerName = entry.getValue().toString();
                Excel.saveUniverName("universityLogo.xls", univerName);
            }
    	}
    }
    
  
}