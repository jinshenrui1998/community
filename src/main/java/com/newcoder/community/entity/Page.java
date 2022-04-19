package com.newcoder.community.entity;

/**
 * Created on 2022/4/13 -- 15:59.
 *
 * @author 金伸睿
 * @version 1.0
 */

/*封装分页相关的信息*/
public class Page {
    //当前页码
    private int current = 1;
    //显示上限
    private int limit = 10;
    //数组总数(用于计算总页数)
    private int rows;
    //查询路径(用于复用分页链接)
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * 因为执行sql需要起始行，可以根据传进来的page中的参数运算得出
     * @return
     */
    public int getOffset() {
        //(current - 1) * limit
        return (current - 1) * limit;
    }

    /**
     * 获得总页数
     *
     * @return
     */
    public int getTotal() {
       if (rows % limit == 0) {
           return rows / limit;
       }
       return rows / limit + 1;
    }

    /**
     * 获得起始页
     *
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获得结束页码
     *
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to >total ? total : to;
    }
}
