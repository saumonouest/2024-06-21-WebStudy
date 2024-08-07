package com.sist.dao;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class main {
   public static void main(String[] args) {
      main re = new main();
      re.campgoodsData();
   }

   public void campgoodsData() {
      recipeDAO dao = recipeDAO.newInstance();

      try {
         int k = 1;
         for (int i = 1; i <= 347; i++) {
            Document doc = Jsoup.connect("https://www.10000recipe.com/recipe/list.html?order=reco&page=" + i).get();
            Elements link1 = doc.select("ul.common_sp_list_ul  li.common_sp_list_li  div.common_sp_caption_tit a ");
            for (int j = 0; j < link1.size(); j++) {
               try {
                  
                  /*
                   *    CNO                  
                  NAME           
                  BRAND          
                  DELIVERY                
                  PRICE                  
                  POSTER        
                  DETAIL_POSTER
                   */
               
                String url = "https://www.10000recipe.com//"+link1.get(j).attr("href");
                 if(j>0 && (j<link1.size()-1)) {
                     String prevurl = "https://www.10000recipe.com/"+link1.get(j-1).attr("href");
                     if(url.equals(prevurl)) continue;
                 }
                 
                  System.out.println(url);
                  //System.out.println(link1);
                  System.out.println("상품번호 : " + k++);

//                  // 링크
//                  // 상세보기로 이동
//                  // <li class="aa bb cc dd">
                    Document doc2 = Jsoup.connect(url).get();
                    Element poster = doc2.selectFirst("div.detailArea div.KeyImg img.Bigimage");
                    System.out.println(poster.attr("src"));
                    Element gname = doc2.selectFirst("div.infoArea div.xans-element- tr.xans-record- td");
                    if(gname.text().contains("/")) System.out.println(gname.text().substring(0, gname.text().indexOf("/")));
                    else if(gname.text().contains("(")) System.out.println(gname.text().substring(0, gname.text().indexOf("(")));
                    else System.out.println(gname.text());
                    
                       
                    
                    Element price = doc2.selectFirst("div.infoArea div.xans-element- tr.xans-record- td span strong#span_product_price_text ");
                    System.out.println(price.text());
                   
                    Element saleprice = doc2.selectFirst("div.infoArea div.xans-element- tr.xans-record- td span span#span_product_price_custom ");
               if(saleprice==null) {saleprice=price; System.out.println(saleprice.text());}
               else System.out.println(price.text());
               
                    Element detail_poster = doc2.selectFirst("div.xans-element- div#prdDetail div.cont img");
                    String dposter="http://ogcamping.com"+detail_poster.attr("ec-data-src");
                    System.out.println(dposter);
                    Elements brandElements = doc2.select("div.infoArea div.xans-element- tbody tr.xans-record- td span ");
                    List<String> brands = new ArrayList<>();
                    for (Element element : brandElements) {
                        brands.add(element.text());
                    }
                    
                    // 문자열을 콤마를 기준으로 분할하여 배열로 변환
                    String joinedString = String.join(", ", brands);
                    String[] brandsArray = joinedString.split(",\\s*");
                    System.out.println(joinedString);
                    String brand=brandsArray[1];
                    System.out.println(brand);
                    String origin=brandsArray[2];
                    System.out.println(origin);
                    System.out.println("=======================================");
                    //rno, hit, id, name, subname, amount, time, grade, ingredients, steps, poster, detail_poster
                    recipeVO vo = new recipeVO();
                    vo.setRno(.text());
                    vo.setId(brand);
                    vo.setName(price.text());
                    vo.setSubname(saleprice.text());
                    vo.setAmount(origin);
                    vo.setTime(origin);
                    vo.setGrade(origin);
                    vo.setIngredients(origin);
                    vo.setSteps(dposter);
                    vo.setPoster(poster.attr("src"));
                    vo.setDetail_poster(dposter);
                    
                    dao.cgoodsInsert(vo);

               } catch (Exception ex) {
                  ex.printStackTrace();
               }
            }
         }
         System.out.println("저장 완료!!");
      } catch (Exception ex) {
      }
   }
}