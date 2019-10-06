package cn.wayne.travel.dao.impl;

import cn.wayne.travel.dao.ISellerDao;
import cn.wayne.travel.domain.Seller;
import cn.wayne.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class SellerDaoImpl implements ISellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findBySid(int sid) {
        String sql = "select * from tab_seller where sid = ?";

        return template.queryForObject(sql,
                new BeanPropertyRowMapper<Seller>(Seller.class), sid);
    }
}
