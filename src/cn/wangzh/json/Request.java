package cn.wangzh.json;

public class Request {
	private String header;
	private String parameters;
	private String body;
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String paramters) {
		this.parameters = paramters;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "request [header=" + header + ", paramters=" + parameters
				+ ", body=" + body + "]";
	}
	
}
