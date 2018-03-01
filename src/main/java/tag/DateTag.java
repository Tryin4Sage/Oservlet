package tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	private String layout;

	public void setLayout(String layout) {
		this.layout = layout;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();
		JspWriter out = pc.getOut();
		
		SimpleDateFormat sdf = new SimpleDateFormat(layout);
		out.println(sdf.format(new Date()));
	}
	
	
}
