package net.org.myinfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_category_tab")
public class OrgCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cat_id;
	private String cat_name;
	private String cat_desc;
	private String cat_owner;

	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_desc() {
		return cat_desc;
	}

	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}

	public String getCat_owner() {
		return cat_owner;
	}

	public void setCat_owner(String cat_owner) {
		this.cat_owner = cat_owner;
	}
}
