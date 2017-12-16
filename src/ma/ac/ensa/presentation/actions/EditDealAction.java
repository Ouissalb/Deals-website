package ma.ac.ensa.presentation.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class EditDealAction extends ActionSupport implements SessionAware{

	private SessionMap sessionMap;
	public EditDealAction() {
		
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}

}
