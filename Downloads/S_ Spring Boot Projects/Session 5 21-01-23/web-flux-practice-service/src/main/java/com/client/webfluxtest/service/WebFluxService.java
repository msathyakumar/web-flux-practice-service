package com.client.webfluxtest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WebFluxService {
	
	public Mono<Map<String,Object>> getMonoMapObject(){
		
		Map<String,Object> mapdesc = new HashMap<>();
		
		mapdesc.put("s.no", 1);
		mapdesc.put("name","Sathya");
		mapdesc.put("company", "Infosys");
		Mono<Map<String, Object>> monoObject = Mono.just(mapdesc);
		monoObject.subscribe(a-> {
			Set<Entry<String, Object>> s= a.entrySet();
			for(Entry<String,Object> entry: s) {
				log.info(entry.getKey()+" "+ entry.getValue());
			}
			
		});
		Mono<Map<String, Object>> filter = monoObject.filter(a-> a.containsKey("s.no")).log();
		filter.subscribe(a->{
			Set<Entry<String, Object>> s= a.entrySet();
			for(Entry<String,Object> entry: s) {
				log.info(entry.getKey()+" "+ entry.getValue());
			}});
			
			
		return monoObject;
	}
	

}
