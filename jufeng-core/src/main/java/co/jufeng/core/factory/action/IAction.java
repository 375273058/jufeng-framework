package co.jufeng.core.factory.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IAction {
	
    public static final String SUCCESS = "success";

    public static final String NONE = "none";

    public static final String ERROR = "error";

    public static final String INPUT = "input";

    public static final String LOGIN = "login";

    public void index() throws Exception;

    public void index(HttpServletRequest request) throws Exception;

    public void index(HttpServletResponse response) throws Exception;

    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
