package nancy.util;

import nancy.model.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Util
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 19:09
 * @Version 1.0
 **/
public class Util {
    public static Page parse(HttpServletRequest request){
        Page p = new Page();
        p.setSearchText(request.getParameter("searchText"));
        p.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        p.setSortOrder(request.getParameter("sortOrder"));
        p.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
        return p;
    }
}
