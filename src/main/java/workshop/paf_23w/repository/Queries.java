package workshop.paf_23w.repository;

public class Queries {
    public static final String ALL_ORDERS = 
            """
            select id, order_date, customer_id, quantity*unit_price*(1-discount) as total, quantity*standard_cost as cost
                from (select o.id, o.order_date, o.customer_id, p.product_name, d.quantity, d.unit_price, d.discount, p.standard_cost
		        from orders o
		        join order_details d on o.id = d.order_id
		        join products p on d.product_id = p.id ) t;
            """;

    
}
