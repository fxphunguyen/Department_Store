package vn.fx.qh.sapo.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PurchaseOrderPays {

    PAYS("Đã thanh toán"),
    UNPAID("Chưa thanh toán"),
    PARTIAL_PAYMENT("Thanh toán một phần");

    private final String value;

    PurchaseOrderPays(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PurchaseOrderPays parsePurchaseOrderPays(String value) {
        PurchaseOrderPays[] values = values();
        for (PurchaseOrderPays purchaseOrderPays : values) {
            if (purchaseOrderPays.value.equals(value)) return purchaseOrderPays;
        }
        throw new IllegalArgumentException(value + "invalid");
    }
}
