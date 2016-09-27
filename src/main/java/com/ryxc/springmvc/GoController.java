package com.ryxc.springmvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class GoController implements EnvironmentAware{
	private final  Log logger = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value = {"/"}, method = {RequestMethod.HEAD})
	public String head(){
		logger.info("============= processed by HEAD ===========");
		return "go.jsp";
	}
	
	@RequestMapping(value = {"/"}, method = {RequestMethod.GET})
	public String index(Model model){
		logger.info("============= processed by index ===========");
		model.addAttribute("msg","Go Go Go");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:showGo";
	}
	
	
	@RequestMapping(value = {"download"}, method = {RequestMethod.GET})
	public void download(HttpServletRequest req,HttpServletResponse response) throws IOException{
		logger.info("============= download ===========");
	//	response.setHeader("Content-disposition", "attachment; filename=" + "11.txt");
	    BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // bis = new BufferedInputStream(new
            // FileInputStream(getServletContext().getRealPath("" + filename)));
            bis = new BufferedInputStream(new FileInputStream("E:\\eclipse\\workspace_springmvc\\springmvc-demo\\src\\main\\java\\petbnb_1.8.0.apk"));
            bos = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[2048];
            int bytesRead;

            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            System.out.println("出现IOException." + e);
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
	}
	

	@RequestMapping(value = {"/test"}, method = {RequestMethod.POST})
	public void test(@RequestParam String orderId,HttpServletResponse response) throws IOException{
		logger.info("============= processed by test ===========");
		response.getOutputStream().print("{\"CityId\":18,\"CityName\":\"shanghai\"}");
	}

	private Environment environment = null;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	
	
	@RequestMapping(value = {"/Ucenter/ShopGoods/getShopGoodsList"}, method = {RequestMethod.OPTIONS,RequestMethod.GET})
	public void goodList(HttpServletResponse response) throws IOException{
		logger.info("============= processed by goodList ===========");
		   String content = "{\n" +
		            "    \"msg\": \"查询成功\",\n" +
		            "    \"code\": 0,\n" +
		            "    \"data\": {\n" +
		            "        \"pageCount\": 6,\n" +
		            "        \"data\": [\n" +
		            "            {\n" +
		            "                \"goodName\": \"模板\",\n" +
		            "                \"price\": \"2.0\",\n" +
		            "                \"goodType\": \"台盆\",\n" +
		            "                \"updateTime\": \"2016/09/23 09:58:56\",\n" +
		            "                \"typeId\": 50050531,\n" +
		            "                \"goodId\": 7890,\n" +
		            "                \"category\": \"厨房卫浴\",\n" +
		            "                \"goodCode\": \"zsy55555\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"test4444\",\n" +
		            "                \"price\": \"22.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/19 16:05:55\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7905,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test4444\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"DF 海尔  家用厨房 管道超滤净水机 HU603-5\",\n" +
		            "                \"price\": \"1688.0\",\n" +
		            "                \"goodType\": \"净水设备\",\n" +
		            "                \"updateTime\": \"2016/09/12 14:06:15\",\n" +
		            "                \"typeId\": 50050366,\n" +
		            "                \"goodId\": 7923,\n" +
		            "                \"category\": \"日用百货\",\n" +
		            "                \"goodCode\": \"06-00118\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"baijiu\",\n" +
		            "                \"price\": \"1111.0\",\n" +
		            "                \"goodType\": \"白酒\",\n" +
		            "                \"updateTime\": \"2016/09/12 13:58:50\",\n" +
		            "                \"typeId\": 50050405,\n" +
		            "                \"goodId\": 7922,\n" +
		            "                \"category\": \"白酒\",\n" +
		            "                \"goodCode\": \"baijiu\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"DF 海尔  家用厨房 管道超滤净水机 HU603-5\",\n" +
		            "                \"price\": \"1688.0\",\n" +
		            "                \"goodType\": \"净水设备\",\n" +
		            "                \"updateTime\": \"2016/09/12 13:58:43\",\n" +
		            "                \"typeId\": 50050366,\n" +
		            "                \"goodId\": 7921,\n" +
		            "                \"category\": \"日用百货\",\n" +
		            "                \"goodCode\": \"06-00118\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"商品名称\",\n" +
		            "                \"price\": \"2.0\",\n" +
		            "                \"goodType\": \"牙刷/牙线\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050399,\n" +
		            "                \"goodId\": 7892,\n" +
		            "                \"category\": \"个人护理\",\n" +
		            "                \"goodCode\": \"zsy111\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"回归测试1\",\n" +
		            "                \"price\": \"2.0\",\n" +
		            "                \"goodType\": \"消毒柜/洗碗机\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050479,\n" +
		            "                \"goodId\": 7891,\n" +
		            "                \"category\": \"厨房电器\",\n" +
		            "                \"goodCode\": \"hg1\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"test10110\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7878,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test10110\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"asfasdfsdf\",\n" +
		            "                \"price\": \"2.0\",\n" +
		            "                \"goodType\": \"驱蚊防蚊\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050397,\n" +
		            "                \"goodId\": 7875,\n" +
		            "                \"category\": \"生活用品\",\n" +
		            "                \"goodCode\": \"dddd\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"test7070\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7873,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test7070\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"test09090\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7872,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test09090\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"test000\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7871,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test000\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"111test\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7870,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"test_201608291447\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"阿胶枣\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050241,\n" +
		            "                \"goodId\": 7869,\n" +
		            "                \"category\": \"零食\",\n" +
		            "                \"goodCode\": \"test\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "                \"goodName\": \"qihua\",\n" +
		            "                \"price\": \"1.0\",\n" +
		            "                \"goodType\": \"蒸锅/电蒸锅\",\n" +
		            "                \"updateTime\": \"2016/09/09 19:09:29\",\n" +
		            "                \"typeId\": 50050458,\n" +
		            "                \"goodId\": 7893,\n" +
		            "                \"category\": \"厨房电器\",\n" +
		            "                \"goodCode\": \"qihua\"\n" +
		            "            }\n" +
		            "        ],\n" +
		            "        \"totalCount\": 80\n" +
		            "    }\n" +
		            "}";
		response.addHeader("Content-Type", "application/json");
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(content);
		   

	}
	
}
