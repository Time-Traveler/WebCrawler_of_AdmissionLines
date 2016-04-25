package main;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class GaokaoPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        //page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
    	//page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        
    	//page.putField("universityname", page.getHtml().xpath("//div[@class='bg_sez']/h2/tidyText()"));
    	//page.putField("diagram", page.getHtml().xpath("//div[@id='pointbyarea']//tbody/tr/td/tidyText()").all());
    	
//    	page.putField("university", page.getHtml().xpath("//div[@class='scores_List']//dl/tidyText()").all());
        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
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
        for(university=1; university<=10; university++){				//university代表高校
        	for(province=1; province<=3; province++){
        		Spider.create(new GaokaoPageProcessor())
                //从"https://github.com/code4craft"开始抓
        		// 1/1代表北京地区，理科分数线
                .addUrl("http://college.gaokao.com/school/tinfo/"+university+"/result/"+province+"/1/")		
                .addPipeline(new FilePipeline(province, university))
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();
        	}
        }*/
    	
//    	for(university=1; university<=50; university++){				//university代表高校
//        		Spider.create(new GaokaoPageProcessor())
//                //从"https://github.com/code4craft"开始抓
//                .addUrl("http://college.gaokao.com/school/tinfo/"+university+"/result/4/2/")
//                .addPipeline(new FilePipeline(4, university))
//                //开启5个线程抓取
//                .thread(1)
//                //启动爬虫
//                .run();
//        }
        
    	
    	Spider.create(new GaokaoPageProcessor())
    	//从"https://github.com/code4craft"开始抓
    	  .addUrl("http://college.gaokao.com/schlist/p1")
    	  .addUrl("http://college.gaokao.com/schlist/p2")
    	  .addUrl("http://college.gaokao.com/schlist/p3")
    	  .addUrl("http://college.gaokao.com/schlist/p4")
    	  .addUrl("http://college.gaokao.com/schlist/p5")
    	  .addUrl("http://college.gaokao.com/schlist/p6")
    	  .addPipeline(new FilePipeline(4, 2))
	      //开启5个线程抓取
	      .thread(1)
	      //启动爬虫
	      .run();
    	
    	
        System.out.println("=============================FINISH=================================");
    }
}