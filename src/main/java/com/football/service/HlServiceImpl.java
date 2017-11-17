package com.football.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.domain.Highlight;
import com.football.repository.HlRepository;

@Service
public class HlServiceImpl implements HlService{

	@Autowired
	private HlRepository hlRepository;
	
	@Override
	public Iterable<Highlight> findAll() {
		return hlRepository.findAll();
	}
	
//	@Override
//	public List<Highlight> search(String f) {
//		return hlRepository.findByTitle(f);
//	}

	@Override
	public Highlight findOne(int id_hl) {
		return hlRepository.findOne(id_hl);
	}

	@Override
	public void save(Highlight highlight) {
		hlRepository.save(highlight);
	}

	@Override
	public void delete(int id_hl) {
		hlRepository.delete(id_hl);
	}
	
	public static List<Highlight> getDataParseTrucTiepHD() throws ParseException, IOException {
		  Document doc = Jsoup.connect("http://tructiephd.com/").userAgent("Chrome").get();
		  Element body = doc.body();

		  Element listvideos = doc.getElementById("list-videos");
		  Elements highlight = listvideos.getElementsByClass("highlight");
		  List<Highlight> list = new ArrayList<Highlight>();
		  for (Element link : highlight) {
		   Elements links = link.getElementsByTag("a");
		   Elements images = link.getElementsByTag("img");
		   Elements titles = link.getElementsByTag("h2");
		   Elements days = link.getElementsByClass("meta");
		   String dayTemp = days.text();
		   String dateString = dayTemp.substring(dayTemp.indexOf("-") + 2, dayTemp.length());

		   Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
		   String title = titles.text();
		   
		   list.add(new Highlight(title, images.attr("src"), links.attr("href"), date1, false));

		  }
		  return list;
		 }

}
