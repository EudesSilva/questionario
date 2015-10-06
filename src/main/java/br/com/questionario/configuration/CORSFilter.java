package br.com.questionario.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EudesSilva
 * 
 */

public class CORSFilter implements Filter {
    
    // Ref
    //http://www.w3.org/TR/cors/
    //https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS
    //http://www.html5rocks.com/en/tutorials/cors/
    
    
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            System.out.println("Filtering on...........................................................");
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("Access-Control-Allow-Origin", "*"); // *(allow from all servers) OR http://example.com/
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
            //response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}