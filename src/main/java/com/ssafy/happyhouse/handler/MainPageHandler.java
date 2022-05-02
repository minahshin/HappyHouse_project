package com.ssafy.happyhouse.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.AptDto;
import com.ssafy.happyhouse.model.DongcodeDto;
import com.ssafy.happyhouse.model.service.DongService;

@Service
public class MainPageHandler {
	
	@Autowired
	DongService dong;
	
	public Map<String, ArrayList<String>> pageInit() throws Exception {
		// 동, 구 동적으로 준비
		List<DongcodeDto> list = dong.getDongInfo();
		Map<String, ArrayList<String>> dongList = new HashMap<String, ArrayList<String>>();
		for(DongcodeDto it : list) {
			if(dongList.containsKey(it.getGugunName())) {
				dongList.get(it.getGugunName()).add(it.getDongName());
			}
			else {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(it.getDongName());
				dongList.put(it.getGugunName(), temp);
			}
		}
		return dongList;
	}
}
