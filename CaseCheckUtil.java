package com.example.demo;

import java.util.HashMap;
import java.util.Map;

class CaseCheckUtil {
	
	private String refValString = null;
	private Map<Integer, String> caseOrderMap = null;
	private Map<Integer, String> caseDescMap = null;
	private Integer countOfCases = 0;
	
	CaseCheckUtil(String refValParam){
		this.refValString = refValParam;
		this.caseOrderMap = new HashMap<Integer, String>();
		this.caseDescMap = new HashMap<Integer, String>();
	}
	
	public void addCaseOrder(String caseValParam, Integer index) throws Exception {
		if(this.countOfCases == index) {
			this.caseOrderMap.put(index, caseValParam);
			this.countOfCases++;
		} else {
			throw new Exception("There's no case in the index.");
		}
	}
	
	public void addCaseOrder(Integer index, String caseValParam) throws Exception {
		if(this.countOfCases == index) {
			this.caseOrderMap.put(index, caseValParam);
			this.countOfCases++;
		} else {
			throw new Exception("There's no case in the index.");
		}
	}
	
	public void addCaseOrderFromOne(Integer index, String caseValParam, String desc) throws Exception {
		if((this.countOfCases+1) == index) {
			this.caseOrderMap.put(index, caseValParam);
			this.caseDescMap.put(index, desc);
			this.countOfCases++;
		} else {
			throw new Exception("There's no case in the index.");
		}
	}
	
	public void addCaseOrderFromOne(String caseValParam, String desc) throws Exception {
		this.caseOrderMap.put(this.countOfCases+1, caseValParam);
		this.caseDescMap.put(this.countOfCases+1, desc);
		this.countOfCases++;
	}
	
	public void declareCase(String caseValParam, String desc) throws Exception {
		this.caseOrderMap.put(this.countOfCases, caseValParam);
		this.caseDescMap.put(this.countOfCases, desc);
		this.countOfCases++;		
	}
	
	public boolean check(String caseValParam) throws Exception {
		boolean isDeclared = false;
		
		if(this.countOfCases > 0) {
			for(int i = 0; i < this.countOfCases; i++) {
				if(caseValParam.equals(this.caseOrderMap.get(i))) {
					isDeclared = true;
				} else {
					continue;
				}
			}
			
			if(!isDeclared) {
				throw new Exception("There's no case in the index.");
			}
		}
		
		if(this.refValString != null && this.refValString.equals(caseValParam)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean check(Integer index, String caseValParam) throws Exception {
		
		if(caseValParam != this.caseOrderMap.get(index)
		&& !caseValParam.equals( this.caseOrderMap.get(index) )) {
			throw new Exception("There's no case in the index.");
		}
		
		if(this.refValString != null && this.refValString.equals(caseValParam)) {
			//TODO: Debug the description of the caseValParam(from this.caseDescMap).
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		String inputString = "02";
		
		//요건1: inputString 값에 따라 아래를 수행
		CaseCheckUtil ccu = new CaseCheckUtil(inputString);
		ccu.declareCase("00", "Destitute");		//case "00": 난민이면, "Where are you from?" 출력
		ccu.declareCase("01", "Korean");		//case "01": 한국인이면, "안녕하세요." 출력
		ccu.declareCase("02", "Spanish");		//case "02": 스페인인이면, "Hola." 출력
		ccu.declareCase("03", "German");		//case "03": 독일인이면, "Guten Tag." 출력
				
		//case "00":
		if(ccu.check("00")) {
			System.out.println("Where are you from?");
		}
		//case "01":
		else if(ccu.check("01")) {
			System.out.println("안녕하세요.");
		}
		//case "02":
		else if(ccu.check("02")) {
			System.out.println("Hola.");
		}
		//case "03":
		else if(ccu.check("03")) {
			System.out.println("Guten Tag.");
		}
	}
}