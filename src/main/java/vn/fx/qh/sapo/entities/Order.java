package vn.fx.qh.sapo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_code", nullable = false, length = 50)
    private String orderCode;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "mobile", length = 50)
    private String mobile;

    @Column(name = "line1", length = 50)
    private String line1;

    @Column(name = "line2", length = 50)
    private String line2;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "province", length = 50)
    private String province;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "create_at", nullable = false, length = 50)
    private Instant createAt;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_status_code", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_status_code",  nullable = false)
    private OrderStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status_code", insertable = false, updatable = false)
    private OrderStatusCode orderStatusCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status_code", insertable = false, updatable = false)
    private OrderStatusCode paymentStatusCode;

    @Column(name = "grand_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal grandTotal;

    @Column(name = "sub_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotal;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    @OneToMany(targetEntity = PaymentOrder.class, mappedBy = "order")
    private Set<PaymentOrder> paymentOrderSet;

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer customerId, Integer employeeId, OrderStatusCode orderStatus, OrderStatusCode paymentStatus) {
        setCustomerId(customerId);
        setEmployeeId(employeeId);
        setOrderStatusCode(orderStatusCode);
        setOrderStatusCode(orderStatusCode);
    }

    public Order setCustomerId(Integer customerId) {
        this.customer = new Customer(this.customerId = customerId);
        return this;
    }

    public Order setOrderStatus(OrderStatusCode orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
        this.orderStatus = new OrderStatus(orderStatusCode.getValue());
        return this;
    }

    public Order setPaymentStatus(OrderStatusCode paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
        this.paymentStatus = new OrderStatus(paymentStatusCode.getValue());
        return this;
    }

    public Order setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }
}