package main;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class GaokaoPageProcessor implements PageProcessor {

    // ����һ��ץȡ��վ��������ã��������롢ץȡ��������Դ�����
    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

    @Override
    // process�Ƕ��������߼��ĺ��Ľӿڣ��������д��ȡ�߼�
    public void process(Page page) {
        // ���ֶ���������γ�ȡҳ����Ϣ������������
        //page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
    	//page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        
    	//page.putField("universityname", page.getHtml().xpath("//div[@class='bg_sez']/h2/tidyText()"));
    	//page.putField("diagram", page.getHtml().xpath("//div[@id='pointbyarea']//tbody/tr/td/tidyText()").all());
    	
//    	page.putField("university", page.getHtml().xpath("//div[@class='scores_List']//dl/tidyText()").all());
        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // ����������ҳ�淢�ֺ�����url��ַ��ץȡ
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
    	
    	
    	//page.putField("info", page.getHtml().xpath("//div[@class='scores_List']//dl/dd/ul/tidyText()").all());
    	//page.putField("name", page.getHtml().xpath("//div[@class='scores_List']//dl/dt/strong/@title").all());
    	page.putField("logo", page.getHtml().xpath("//div[@class='scores_List']//dl/dt/a/img/@src").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

    	/*int province;
    	int university;
        for(university=1; university<=10; university++){				//university�����У
        	for(province=1; province<=3; province++){
        		Spider.create(new GaokaoPageProcessor())
                //��"https://github.com/code4craft"��ʼץ
        		// 1/1��������������Ʒ�����
                .addUrl("http://college.gaokao.com/school/tinfo/"+university+"/result/"+province+"/1/")		
                .addPipeline(new FilePipeline(province, university))
                //����5���߳�ץȡ
                .thread(1)
                //��������
                .run();
        	}
        }*/
    	
//    	for(university=1; university<=50; university++){				//university�����У
//        		Spider.create(new GaokaoPageProcessor())
//                //��"https://github.com/code4craft"��ʼץ
//                .addUrl("http://college.gaokao.com/school/tinfo/"+university+"/result/4/2/")
//                .addPipeline(new FilePipeline(4, university))
//                //����5���߳�ץȡ
//                .thread(1)
//                //��������
//                .run();
//        }
        
    	
    	Spider.create(new GaokaoPageProcessor())
    	//��"https://github.com/code4craft"��ʼץ
    	  .addUrl("http://college.gaokao.com/schlist/p1")
    	  .addUrl("http://college.gaokao.com/schlist/p2")
    	  .addUrl("http://college.gaokao.com/schlist/p3")
    	  .addUrl("http://college.gaokao.com/schlist/p4")
    	  .addUrl("http://college.gaokao.com/schlist/p5")
    	  .addUrl("http://college.gaokao.com/schlist/p6")
    	  .addPipeline(new FilePipeline(4, 2))
	      //����5���߳�ץȡ
	      .thread(1)
	      //��������
	      .run();
    	
    	
        System.out.println("=============================FINISH=================================");
    }
}