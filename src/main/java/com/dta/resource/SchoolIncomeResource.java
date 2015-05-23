package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import com.dta.bean.SchoolIncome;
import com.dta.service.ISchoolIncomeService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SchoolFinanceVo;

@Path("schoolIncome")
public class SchoolIncomeResource extends BaseAllResource<SchoolIncome, SchoolFinanceVo>{
	//@Autowired
	public ISchoolIncomeService service = (ISchoolIncomeService)ServiceProvider.getBean("schoolIncomeServiceImpl");
	public SchoolIncomeResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SCHOOLINCOME);
	}
}