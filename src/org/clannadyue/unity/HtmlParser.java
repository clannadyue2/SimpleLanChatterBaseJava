//package org.clannadyue.unity;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
///**
// * Html解析的工具类
// */
//public class HtmlParser {
//
//    public static Elements getHtmlElements(String url, String siftCondition) throws IOException {
//        Document document = Jsoup.connect(url).get();
//        Elements eles = document.select(siftCondition);
//        return eles;
//    }
//    /*public static Elements getHtmlElements(String html,String siftCondition) throws IOException{
//     Document document = Jsoup.connect(url).get();
//     Elements eles = document.select(siftCondition);
//     return eles;
//     }*/
//
//    public static String getHtmlContentByUrl(String url) throws ClientProtocolException, IOException {
//        DefaultHttpClient httpclient = new DefaultHttpClient();
//        HttpGet req = new HttpGet(url);
//        HttpResponse res = httpclient.execute(req);
//        return EntityUtils.toString(res.getEntity());
//    }
//
//    public static String getHtmlContentByUrl(String url, String charSet) throws ClientProtocolException, IOException {
//        DefaultHttpClient httpclient = new DefaultHttpClient();
//        HttpGet req = new HttpGet(url);
//        HttpResponse res = httpclient.execute(req);
//        BufferedReader br = new BufferedReader(new InputStreamReader(res.getEntity().getContent(), charSet));
//        String htmlStr = "";
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            htmlStr += line + "\n";
//        }
//        //System.out.println(res.getEntity().getContentType());
//        return htmlStr;
//    }
//}
