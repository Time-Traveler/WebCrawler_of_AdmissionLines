package main;

import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class FilePipeline implements Pipeline {
	private int province = -1;		//用作Excel文件名称
	private int university = -1;
	
	public FilePipeline(int province, int university) {
		// TODO Auto-generated constructor stub
		this.province = province;
		this.university = university;
	}

    @Override
    public void process(ResultItems resultItems, Task task) {
        //System.out.println("get page: " + resultItems.getRequest().getUrl());
        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
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
//    		if(entry.getKey().equals("info")){				//学校信息
//            	univerInfo = entry.getValue().toString();
//            	Excel.saveUniverInfo("universityInfo.xls", univerInfo);
//            }
            
            if(entry.getKey().equals("logo")){			//学校名称
            	String univerName = entry.getValue().toString();
                Excel.saveUniverName("universityLogo.xls", univerName);
            }
    	}
    }
    
  
}