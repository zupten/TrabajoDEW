package filtro;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
/**
 * Servlet Filter implementation class FiltroBasico
 */
@WebFilter("/*")
public class FiltroBasico extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
	private String logPath;
	 
    public FiltroBasico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String usuario = httpRequest.getRemoteUser();
		if (usuario == null) usuario = "ANONIMO";
		
		String lineaLog = String.format(
                "%s %s %s %s %s",
                LocalDateTime.now(),
                usuario,
                httpRequest.getRemoteAddr(),
                httpRequest.getRequestURI(),
                httpRequest.getMethod()
		);
		try (PrintWriter out = new PrintWriter(new FileWriter(logPath, true))) {
            out.println(lineaLog);
        } catch (IOException e) {
        	httpRequest.getServletContext().log("Error al escribir en el log: " + e.getMessage());
        }

        chain.doFilter(request, response);
        
		//ServletContext sc = httpRequest.getServletContext();

		//sc.log("******************paso filtro  |antes");
		// pass the request along the filter chain
		//chain.doFilter(request, response);
		//sc.log("******************paso filtro  |después");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = fConfig.getServletContext();
        String relativePath = context.getInitParameter("logfile");
        if (relativePath == null || relativePath.isEmpty()) {
            throw new ServletException("Parámetro 'logfile' no definido en web.xml");
        }
        this.logPath = relativePath;	}

}
