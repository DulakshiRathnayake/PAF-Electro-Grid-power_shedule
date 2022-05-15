package Frontend;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Frontend.pshedulerRepository;

/**
 * Servlet implementation class pshedulerAPI
 */
@WebServlet("/pshedulerAPI")
public class pshedulerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	pshedulerRepository pshedulerObj = new pshedulerRepository(); 
	
    public pshedulerAPI() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NOT USED
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
	{
		String output = pshedulerObj.createpsheduler(request.getParameter("pLid"),
							request.getParameter("pduration"),
							request.getParameter("plocation"),
							request.getParameter("preason"),
							request.getParameter("pdesc"));
		
		response.getWriter().write(output);
	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
    {
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
					scanner.useDelimiter("\\A").next() : "";
			scanner.close();
	 
			String[] params = queryString.split("&");
			for (String param : params)
			{ 
				String[] p = param.split("=");
				map.put(p[0], p[1]);
		    }
		 }
				
		 catch (Exception e)
	     {
		 }
		 
		return map;
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
	{
		Map paras = getParasMap(request);
		String output = pshedulerObj.updatepsheduler(paras.get("hidPsheduleIDSave").toString(),
										   paras.get("pLid").toString(),
										   paras.get("pduration").toString(),
										   paras.get("plocation").toString(),
										   paras.get("preason").toString(),
										   paras.get("pdesc").toString());
			
		response.getWriter().write(output);
	}
			
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
	{
		Map paras = getParasMap(request);
		String output = pshedulerObj.deletePsheduler(paras.get("pLid").toString());
		response.getWriter().write(output);
	}
	
	


}
