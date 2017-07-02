package br.com.web.interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("/")){
			return true;
		}
		else if(request.getSession().getAttribute("usuario") != null){
			if(request.getSession().getAttribute("admin").equals("yes") && (uri.endsWith("/adm"))){
				return true;
			}
			else if(request.getSession().getAttribute("admin").equals("yes") && (uri.endsWith("/usuario"))){
				response.sendRedirect("/adm");
				return true;	
			}
			else if(request.getSession().getAttribute("admin").equals("no") && (uri.endsWith("/usuario"))){
				return true;
			}
			else if(request.getSession().getAttribute("admin").equals("no") && (uri.endsWith("/adm"))){
				response.sendRedirect("/");
				return true;	
			}
			else{
				return true;
			}
		}
		else if((uri.endsWith("/adm") || uri.endsWith("/usuario")) && request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("/");
			return true;
		}
		else{
			response.sendRedirect("ErrorPage");
			return true;
		}
		
	}
}
