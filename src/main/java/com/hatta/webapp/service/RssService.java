/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.service;

import com.hatta.webapp.entity.Item;
import com.hatta.webapp.exception.RssException;
import com.hatta.webapp.rss.ObjectFactory;
import com.hatta.webapp.rss.TRss;
import com.hatta.webapp.rss.TRssChannel;
import com.hatta.webapp.rss.TRssItem;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hatta NR
 */
@Service
public class RssService {
    
    public List<Item> getitems(File file) throws RssException{
        return getItems(new StreamSource(file));
    }
    
    public List<Item> getitems(String url) throws RssException{
        return getItems(new StreamSource(url));
    }
    
    private List<Item> getItems(Source source) throws RssException{
        ArrayList<Item> list = new ArrayList<>();
        try {
           JAXBContext jAXBContext= JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
            TRss rss = jaxbElement.getValue();
            
            List<TRssChannel> channels = rss.getChannel();            
            for (TRssChannel channel : channels) {
               List<TRssItem> items = channel.getItem();
                for (TRssItem rssItem : items) {
                   Item item = new Item();
                   item.setTitle(rssItem.getTitle());
                   item.setDescription(rssItem.getDescription());
                   item.setLink(rssItem.getLink());
                   Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.ENGLISH).parse(rssItem.getPubDate());
                   item.setPublishDate(pubDate);
                   list.add(item);
                }
            }
        } catch (JAXBException e) {
            throw new RssException(e);
        } 
        catch (ParseException e) {
            throw new RssException(e);
        } 
        return list;
    }
}
