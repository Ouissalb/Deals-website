package ma.ac.ensa.presentation.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostDealServlet  extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 165L;
	
	public PostDealServlet() {}

	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException
	{
		if(request.getSession().getAttribute("currentSessionUser")==null)
		{
		    this.getServletContext().getRequestDispatcher( "/vues/index-logged-out.jsp" ).forward( request, response );
		}
		else 
		{
			this.getServletContext().getRequestDispatcher( "/vues/post-a-deal.jsp" ).forward( request, response );
		}


	}
}



