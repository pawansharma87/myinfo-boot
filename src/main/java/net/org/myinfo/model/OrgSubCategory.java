package net.org.myinfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cd_sub_category")
public class OrgSubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sub_cat_id;
	private String sub_cat_name;
	private String desc;
	private String cat_id;

	public Integer getSub_cat_id() {
		return sub_cat_id;
	}

	public void setSub_cat_id(Integer sub_cat_id) {
		this.sub_cat_id = sub_cat_id;
	}

	public String getSub_cat_name() {
		return sub_cat_name;
	}

	public void setSub_cat_name(String sub_cat_name) {
		this.sub_cat_name = sub_cat_name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
}