package com.scraper.webscraper;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class WebScraper {

    public String findElement(String url, List<String> htmlTag) throws IOException {
        Element doc = Jsoup.connect(url).get();
        StringBuilder HTML_TAG = new StringBuilder();

        for(int i = 0; i < htmlTag.size(); i++){

            if(htmlTag.get(i).charAt(0) == '.'){
                if(htmlTag.get(i).charAt(htmlTag.get(i).length()-1) == '`') {
                    HTML_TAG.append(StringUtils.chop(htmlTag.get(i)));
                }else {
                    HTML_TAG.append(htmlTag.get(i));
                }
            }else{
                if(htmlTag.get(i).charAt(htmlTag.get(i).length()-1) == '`') {
                    HTML_TAG.append(" " + StringUtils.chop(htmlTag.get(i)));
                }else {
                    HTML_TAG.append(" " + htmlTag.get(i));
                }
            }

            if(htmlTag.get(i).charAt(htmlTag.get(i).length()-1) == '`'){
                doc = doc.select(HTML_TAG.toString()).get(0);
                HTML_TAG.setLength(0);
            }
        }

        return doc.select(HTML_TAG.toString()).eachText().get(0);
    }

    public List<String> findElements(String url, List<String> htmlTag) throws IOException{
        Element doc = Jsoup.connect(url).get();
        StringBuilder HTML_TAG = new StringBuilder();

        for(int i = 0; i < htmlTag.size(); i++){

            if(htmlTag.get(i).charAt(0) == '.'){
                if(htmlTag.get(i).charAt(htmlTag.get(i).length()-1) == '`') {
                    HTML_TAG.append(StringUtils.chop(htmlTag.get(i)));
                }else {
                    HTML_TAG.append(htmlTag.get(i));
                }
            }else{
                if(htmlTag.get(i).charAt(htmlTag.get(i).length()-1) == '`') {
                    HTML_TAG.append(" " + StringUtils.chop(htmlTag.get(i)));
                }else {
                    HTML_TAG.append(" " + htmlTag.get(i));
                }
            }

            if(htmlTag.get(i).charAt(htmlTag.get(i).length()-1) == '`'){
                doc = doc.select(HTML_TAG.toString()).get(0);
                HTML_TAG.setLength(0);
            }
        }

        return doc.select(HTML_TAG.toString()).eachText();
    }
}
