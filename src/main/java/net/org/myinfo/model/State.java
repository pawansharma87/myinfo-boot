package net.org.myinfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_states_tab")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer state_id;
	private String state_name;
	private String state_code;
	private String capital;
	private Integer no_of_distt;
	private String official_lang;
	private String type;
	private Integer area;
	private Integer population;
	private Integer sex_ratio;

	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Integer getNo_of_distt() {
		return no_of_distt;
	}

	public void setNo_of_distt(Integer no_of_distt) {
		this.no_of_distt = no_of_distt;
	}

	public String getOfficial_lang() {
		return official_lang;
	}

	public void setOfficial_lang(String official_lang) {
		this.official_lang = official_lang;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getSex_ratio() {
		return sex_ratio;
	}

	public void setSex_ratio(Integer sex_ratio) {
		this.sex_ratio = sex_ratio;
	}
}
