package org.hnist.modul;

import java.util.List;

/**
 * 根据societyTerm分类的实体
 * @author HELLO WORLD
 *
 */

public class SocietyNumberTerm {

	private String societyTerm;				//任届
	private List<SocietyNumber> snlist;		//list对象
	
	public String getSocietyTerm() {
		return societyTerm;
	}
	public void setSocietyTerm(String societyTerm) {
		this.societyTerm = societyTerm;
	}
	public List<SocietyNumber> getSnlist() {
		return snlist;
	}
	public void setSnlist(List<SocietyNumber> snlist) {
		this.snlist = snlist;
	}
	
	
}
