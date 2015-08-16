package com.dta.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.dta.bean.SchoolDepositRecord;
import com.dta.service.ISchoolDepositRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.utils.SessionUtil;
import com.dta.vo.SchoolDepositRecordVo;

@Path("schoolDepositRecord")
public class SchoolDepositRecordResource extends
		BaseAllResource<SchoolDepositRecord, SchoolDepositRecordVo> {
	private ISchoolDepositRecordService service = (ISchoolDepositRecordService)ServiceProvider.getBean("schoolDepositRecordServiceImpl");
	public void init(){
		super.setService(service);
		super.setMianId(GlobalConstant.SCHOOLDEPOSITRECORD);
	}
	
	@Override
	public Response add(@BeanParam SchoolDepositRecord po){
		po.setOperator(SessionUtil.getUserIdByRequest(super.getRequest()));
		return super.add(po);
	}
}
