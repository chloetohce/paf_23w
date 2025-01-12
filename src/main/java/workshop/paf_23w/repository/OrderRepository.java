package workshop.paf_23w.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import workshop.paf_23w.model.Order;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate template;

    public Optional<Order> getOrderDetails(int oid) {
        SqlRowSet rs = template.queryForRowSet(Queries.ALL_ORDERS, oid);
        if (!rs.next()) {
            return Optional.empty();
        }

        // System.out.println(rs.getTimestamp("order_date").getClass());
        System.out.println(rs.getObject("order_date").getClass());
        System.out.println(rs.getObject("order_date"));


        Order o = new Order(rs.getInt("id"), LocalDateTime.parse(rs.getObject("order_date").toString()), rs.getInt("customer_id"), 
            rs.getDouble("total"), rs.getDouble("cost"));
        return Optional.of(o);

    //     String sql = Queries.ALL_ORDERS;  // Assuming the SQL query is stored in Queries.ALL_ORDERS
    // return template.query(sql, new Object[]{oid}, new RowMapper<Order>() {
    //     @Override
    //     public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
    //         // Retrieve the order date as a LocalDateTime directly from ResultSet
    //         Timestamp timestamp = rs.getTimestamp("order_date");
    //         LocalDateTime orderDate = timestamp != null ? timestamp.toLocalDateTime() : null;
            
    //         return new Order(
    //             rs.getInt("id"),
    //             orderDate,
    //             rs.getInt("customer_id"),
    //             rs.getDouble("total"),
    //             rs.getDouble("cost")
    //         );
    //     }
    // }).stream().findFirst();
    }
}
