package net.org.myinfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_distt_tab")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer distt_id;
	private String distt_name;
	private Integer area;
	private String distt_hq;
	private String state_code;
	private Integer population;
	private Integer distance_from_capital;
	private String official_website;

	public Integer getDistt_id() {
		return distt_id;
	}

	public void setDistt_id(Integer distt_id) {
		this.distt_id = distt_id;
	}

	public String getDistt_name() {
		return distt_name;
	}

	public void setDistt_name(String distt_name) {
		this.distt_name = distt_name;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getDistt_hq() {
		return distt_hq;
	}

	public void setDistt_hq(String distt_hq) {
		this.distt_hq = distt_hq;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getDistance_from_capital() {
		return distance_from_capital;
	}

	public void setDistance_from_capital(Integer distance_from_capital) {
		this.distance_from_capital = distance_from_capital;
	}

	public String getOfficial_website() {
		return official_website;
	}

	public void setOfficial_website(String official_website) {
		this.official_website = official_website;
	}
}
