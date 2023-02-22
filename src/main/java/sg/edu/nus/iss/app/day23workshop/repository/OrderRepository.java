package sg.edu.nus.iss.app.day23workshop.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.day23workshop.model.Order;


import static sg.edu.nus.iss.app.day23workshop.repository.Queries.*;


@Repository
public class OrderRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // method to retrieve order details by their order ID
    public Order getOrderDetails(Integer orderId) {
       
        // execute the query to retrieve the order details by order ID
        return jdbcTemplate.queryForObject(SQL_SELECT_ORDERS_DETAILS_BY_ID, BeanPropertyRowMapper.newInstance(Order.class), orderId);
    

    }
}
