package com.hengyun.util.pagination;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag  extends TagSupport{

	   private String url; //链接地址
	    private int curpage;// 当前页
	    private int pagesize; // 页大小
	    private int totalLines; // 总记录条数
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getCurpage() {
			return curpage;
		}
		public void setCurpage(int curpage) {
			this.curpage = curpage;
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		public int getTotalLines() {
			return totalLines;
		}
		public void setTotalLines(int totalLines) {
			this.totalLines = totalLines;
		}
	    //计算总页数
	    private int totalPages(){
	    	return totalLines%pagesize==0?totalLines/pagesize:totalLines/pagesize+1;
	    }
	    
	    public int doStartTag() throws JspException {
	    	JspWriter out = this.pageContext.getOut();
	    	 //{0}:url, {1}:curpage, {2}:pagesize, {3}:第一页 上一页 下一页 最后一
	    	  String link = "<a href=''{0}?curpage={1}&pagesize={2}''>{3}</a>";
	    	    if(curpage == 0) curpage = 1;
	            if(pagesize == 0) pagesize = 5;
	            
	            int totalPages = this.totalPages();
	            if(curpage > totalPages) curpage = totalPages;
	            if(curpage < 1) curpage = 1;
	            
	            String first = MessageFormat.format(link, url, "1", pagesize, "第一页");
	            
	            String previous = null;
	            if(curpage <= 1){
	                previous = "上一页";
	            }else{
	                previous = MessageFormat.format(link, url, String.valueOf(curpage - 1), pagesize, "上一页");
	            }
	            
	            String next = null;
	            if(curpage >= totalPages){
	                next = "下一页";
	            }else{
	                next = MessageFormat.format(link, url, String.valueOf(curpage + 1), pagesize, "下一页");
	            }
	            
	            String last = MessageFormat.format(link, url, String.valueOf(totalPages), pagesize, "最后一页");
	            try {
	                String html = "{0} {1} {2} {3} 当前第{4}页 共{5}页 每页显示{6}条 共有{7}条";
	                html = MessageFormat.format(html,
	                        first,
	                        previous,
	                        next,
	                        last,
	                        String.valueOf(curpage) ,
	                        String.valueOf(totalPages),
	                        String.valueOf(pagesize),
	                        String.valueOf(totalLines));
	                
	                out.println(html);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return EVAL_BODY_INCLUDE;
	        }
	 
}
