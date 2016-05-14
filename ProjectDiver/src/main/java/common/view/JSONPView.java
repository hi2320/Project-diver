package common.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONPView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String callback = request.getParameter("callback")!=null?request.getParameter("callback"):"?";
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(model);
		
		response.setContentType("javascript/jsonp");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(callback+"("+json+");");
	}
}