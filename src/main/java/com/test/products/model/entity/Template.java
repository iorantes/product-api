package com.test.products.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CTG_TEMPLATE")
public class Template extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3148966785066664223L;

	@Id
	@Column(name = "CTG_TEMPLATE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long templateID;

	@Column(name = "CTG_TEMPLATE_BODY")
	private String templateBody;

	@Column(name = "CTG_TEMPLATE_IDENTIFIER")
	private String templateIden;

	@Column(name = "CTG_TEMPLATE_ACTIVE")
	private String templateActive;

	public Long getTemplateID() {
		return templateID;
	}

	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}

	public String getTemplateBody() {
		return templateBody;
	}

	public void setTemplateBody(String templateBody) {
		this.templateBody = templateBody;
	}

	public String getTemplateIden() {
		return templateIden;
	}

	public void setTemplateIden(String templateIden) {
		this.templateIden = templateIden;
	}

	public String getTemplateActive() {
		return templateActive;
	}

	public void setTemplateActive(String templateActive) {
		this.templateActive = templateActive;
	}

	public Template() {
		super();
	}

	public Template(Long templateID, String templateBody, String templateIden, String templateActive) {
		super();
		this.templateID = templateID;
		this.templateBody = templateBody;
		this.templateIden = templateIden;
		this.templateActive = templateActive;
	}

}
