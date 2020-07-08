package nancy.dao;

import nancy.exception.SystemExcption;
import nancy.model.Classes;
import nancy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClassesDAO
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/6 20:57
 * @Version 1.0
 **/

public class ClassesDAO {
    public static List<Classes> queryList() {
        List<Classes> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql ="select id, classes_name, classes_graduate_year, classes_major from classes";
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){

                Classes cl = new Classes();
                cl.setDictionaryTagKey(String.valueOf(r.getInt("id")));
                cl.setDictionaryTagValue(r.getString("classes_name"));
                cl.setClassesMajor(r.getString("classes_major"));
                cl.setClassesGraduateYear(r.getString("classes_graduate_year"));
                list.add(cl);
            }

        }catch(Exception e){
            throw new SystemExcption("0002","查询班级信息出错",e);
        }finally {
            DBUtil.close(c,p, r);
        }
        return list;
    }
}
