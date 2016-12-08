package test;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStreamWriter;  
import java.net.HttpURLConnection;  
import java.net.URL;  

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class EfutureApiExecute {  
//final static String url ="http://per.cloud360.com.cn/amp-openapi-service/rest/?method=daemon.omo.order.receive&token=1549233384587402900";
//final static String urlpara ="amp-openapi-service/rest/?method=daemon.omo.order.receive&token="+Config.TOKEN;  
final static String params="{\"order\":[{\"accounting_org_code\":\"SH14\",\"bill_type\":\"1\",\"buyer\":{\"account\":\"10442955\",\"nick\":\"APP鐢ㄦ埛\",\"old_score\":\"458\",\"tel\":\"13901704965\",\"this_time_score\":\"0\"},\"channel_keyword\":\"jstore\",\"channel_sheetno\":\"8624100000010022\",\"channel_status\":\"11\",\"logistics_mode_keyword\":\"1\",\"logistics_store\":\"SH14\",\"logistics_value\":\"0\",\"order_content\":\"1\",\"order_detail\":[{\"barcode\":\"4901301230843\",\"channel_detail_sheetno\":\"2468466\",\"disc_value\":\"50\",\"erp_item_code\":\"0\",\"flag\":\"1\",\"item_code\":\"135800\",\"item_name\":\"鑺辩帇M64鐗囩焊灏胯￥\",\"order_no\":\"1\",\"sale_price\":\"178\",\"sale_qty\":\"1\",\"sale_value\":\"178\",\"sku_code\":\"048801\",\"transaction_value\":\"128\"},{\"barcode\":\"4901301230843\",\"channel_detail_sheetno\":\"2468466\",\"disc_value\":\"50\",\"erp_item_code\":\"0\",\"flag\":\"1\",\"item_code\":\"135800\",\"item_name\":\"看看\",\"order_no\":\"2\",\"sale_price\":\"178\",\"sale_qty\":\"1\",\"sale_value\":\"178\",\"sku_code\":\"048801\",\"transaction_value\":\"128\"}],\"order_payment\":[{\"channel_payment_sheetno\":\"2468466\",\"order_no\":\"1\",\"pay_mode_keyword\":\"1002\",\"pay_mode_name\":\"POS\",\"payment\":\"256\",\"rate\":\"1\"}],\"order_time\":\"2016-08-06 15:18:18\",\"order_type\":\"7\",\"org_code\":\"SH14\",\"pay_over\":\"true\",\"payable_logistics_value\":\"0\",\"payable_value\":\"256\",\"payment\":\"256\",\"round_value\":\"0\",\"source_type_keyword\":\"R2005\",\"total_disc_value\":\"100\",\"total_sale_value\":\"356\"}]}";
final static String urlpara ="omo-daemon/rest?method=daemon.omo.order.receive&ent_id=1515788623151101111";


private WebDriver dr;
int orderNum;
String host;
private StringBuffer verificationErrors = new StringBuffer();
/** 
     * 鍙戦�HttpPost璇锋眰 
     *  
     * @param strURL 
     *            鏈嶅姟鍦板潃 
     * @param params 
     *            json瀛楃涓�渚嬪: "{ \"id\":\"12345\" }" ;鍏朵腑灞炴�鍚嶅繀椤诲甫鍙屽紩鍙�br/> 
     * @return 鎴愬姛:杩斿洖json瀛楃涓�br/> 
     */  
public static String post(String strURL, String params) {  
        System.out.println(strURL);  
        System.out.println(params);  
try {  
            URL url = new URL(strURL);// 鍒涘缓杩炴帴  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 璁剧疆璇锋眰鏂瑰紡  
            connection.setRequestProperty("Content-Type", "appliaction/json"); // 璁剧疆鍙戦�鏁版嵁鐨勬牸寮� 
            connection.connect();  
            OutputStreamWriter out = new OutputStreamWriter(  
            connection.getOutputStream(), "UTF-8"); // utf-8缂栫爜  
            out.append(params);  
            out.flush();  
            out.close();  
            // 璇诲彇鍝嶅簲  
           int length = (int) connection.getContentLength();// 鑾峰彇闀垮害  
            InputStream is = connection.getInputStream();  
            if (length != -1) {  
            byte[] data = new byte[length];  
            byte[] temp = new byte[512];  
            int readLen = 0;  
            int destPos = 0;  
            while ((readLen = is.read(temp)) > 0) {  
                    System.arraycopy(temp, 0, data, destPos, readLen);  
                    destPos += readLen;  
                }  
                String result = new String(data, "UTF-8"); // utf-8缂栫爜  
                System.out.println(result);  
                return result;  
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
            return "error"; // 鑷畾涔夐敊璇俊鎭� 
    }  

@BeforeClass(alwaysRun = true)
public void Setup() {
	 orderNum = Config.ORDERNUM;
	 host = Config.HOST;
}
 

@Test
public void insertOrders() {
	String channel_sheetno="";
	String channel_sheetno_para="20161027";
	String params="";
	for (int i = 0; i < orderNum; i++) {
	   channel_sheetno=channel_sheetno_para+i;
	   params="{\"order\":[{\"accounting_org_code\":\"SH14\",\"bill_type\":\"1\",\"buyer\":{\"account\":\"10442955\",\"nick\":\"APP鐢ㄦ埛\",\"old_score\":\"458\",\"tel\":\"13901704965\",\"this_time_score\":\"0\"},\"channel_keyword\":\"jstore\",\"channel_sheetno\":\""+channel_sheetno+"\",\"channel_status\":\"11\",\"logistics_mode_keyword\":\"1\",\"logistics_store\":\"SH14\",\"logistics_value\":\"0\",\"order_content\":\"1\",\"order_detail\":[{\"barcode\":\"4901301230843\",\"channel_detail_sheetno\":\"2468466\",\"disc_value\":\"50\",\"erp_item_code\":\"0\",\"flag\":\"1\",\"item_code\":\"135800\",\"item_name\":\"鑺辩帇M64鐗囩焊灏胯￥\",\"order_no\":\"1\",\"sale_price\":\"178\",\"sale_qty\":\"1\",\"sale_value\":\"178\",\"sku_code\":\"048801\",\"transaction_value\":\"128\"},{\"barcode\":\"4901301230843\",\"channel_detail_sheetno\":\"2468466\",\"disc_value\":\"50\",\"erp_item_code\":\"0\",\"flag\":\"1\",\"item_code\":\"135800\",\"item_name\":\"看看\",\"order_no\":\"2\",\"sale_price\":\"178\",\"sale_qty\":\"1\",\"sale_value\":\"178\",\"sku_code\":\"048801\",\"transaction_value\":\"128\"}],\"order_payment\":[{\"channel_payment_sheetno\":\"2468466\",\"order_no\":\"1\",\"pay_mode_keyword\":\"1002\",\"pay_mode_name\":\"POS\",\"payment\":\"256\",\"rate\":\"1\"}],\"order_time\":\"2016-08-06 15:18:18\",\"order_type\":\"7\",\"org_code\":\"SH14\",\"pay_over\":\"true\",\"payable_logistics_value\":\"0\",\"payable_value\":\"256\",\"payment\":\"256\",\"round_value\":\"0\",\"source_type_keyword\":\"R2005\",\"total_disc_value\":\"100\",\"total_sale_value\":\"356\"}]}";
	   String url= host+urlpara; 
	   post(url, params);
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

@AfterClass(alwaysRun = true)
public void tearDown() throws Exception {
	//dr.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
		Assert.fail(verificationErrorString);
	}
}
}

