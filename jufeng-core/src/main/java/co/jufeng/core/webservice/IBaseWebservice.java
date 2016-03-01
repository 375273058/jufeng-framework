package co.jufeng.core.webservice;

import javax.jws.WebParam;

public interface IBaseWebservice {
	
	public AuthenticateResult validRequest(@WebParam(name = "jsonString")String jsonString);
	
}
