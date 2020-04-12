package com.test.products.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.products.model.entity.Template;

public interface TemplateRepository extends AbstractBaseRepository<Template, Long> {
	
	@Query("SELECT t FROM Template t WHERE t.templateIden=:iden AND t.templateActive = 1")
	public Template findTemplateByIden(@Param(value="iden") String iden);

}
	