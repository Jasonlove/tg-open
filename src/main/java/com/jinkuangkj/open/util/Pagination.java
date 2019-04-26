package com.jinkuangkj.open.util;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页的包装类，主要解决Page对象无法被dubbo系列化的问题
 */
public class Pagination<E> implements Serializable{
	private static final long serialVersionUID = -5223030895184117498L;

	private int pageNum;
	private int pageSize;
	private int pages;
	private long total;
	private final List<E> list;
	
	public Pagination(int pageNum,int pageSize,int pages,long total,List<E> list) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pages = pages;
		this.total = total;
		this.list = list;
	}
	
	public List<E> getList() {
		if(this.list != null){
			return this.list;
		}
		return new ArrayList<>();
	}
	
    public int getPages() {
        return this.pages;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotal() {
        return this.total;
    } 
	
    public Map<String,Object> toMap(){
    	HashMap<String,Object> map = new HashMap<>();
    	map.put("pageNum", this.pageNum);
    	map.put("pages", this.pages);
    	map.put("total", this.total);
    	map.put("list", this.list);
    	return map;
    }


}
