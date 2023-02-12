package sg.edu.nus.iss.app.day23workshop.repository;

public class Queries {
    
    public static final String SQL_SELECT_ORDERS_DETAILS_BY_ID= """
                            SELECT o.id, o.order_date, o.customer_id, 
                            SUM(od.quantity * od.unit_price) as subtotal,
                            SUM(od.quantity * od.unit_price * od.discount) as discount,
                            SUM(od.quantity * od.unit_price * (1 - od.discount)) as totaldiscountedprice, 
                            SUM(p.standard_cost * od.quantity) as cost_price
                            FROM orders o
                            JOIN order_details od ON o.id = od.order_id
                            JOIN products p ON od.product_id = p.id
                            WHERE o.id = ?
                            GROUP BY o.id; 
                            """;
}
