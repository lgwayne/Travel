package cn.wayne.travel.dao.impl;

import cn.wayne.travel.dao.ICategoryDao;
import cn.wayne.travel.domain.Category;
import cn.wayne.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";

        return template.query(sql,
                new BeanPropertyRowMapper<Category>(Category.class));
    }
}
