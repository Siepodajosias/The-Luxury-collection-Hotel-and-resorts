package Fenetre2;

import java.util.Date;

public class Service {
	
	private Integer serviceId;
	private String Descp;
	private Date DDserv;
	private Date DFserv;
	
	public Service() {
		
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getDescp() {
		return Descp;
	}

	public void setDescp(String descp) {
		Descp = descp;
	}

	public Date getDFserv() {
		return DFserv;
	}

	public void setDFserv(Date dFserv) {
		DFserv = dFserv;
	}

	public Date getDDserv() {
		return DDserv;
	}

	public void setDDserv(Date dDserv) {
		DDserv = dDserv;
	}
	
	
}
