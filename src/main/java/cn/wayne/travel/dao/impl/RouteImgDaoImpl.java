package cn.wayne.travel.dao.impl;

import cn.wayne.travel.dao.IRouteImgDao;
import cn.wayne.travel.domain.RouteImg;
import cn.wayne.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class RouteImgDaoImpl implements IRouteImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";

        return template.query(sql,
                new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }
}
