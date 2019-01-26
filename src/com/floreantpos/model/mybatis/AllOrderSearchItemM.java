package com.floreantpos.model.mybatis;

public class AllOrderSearchItemM {

    private String order_id;
    private String product_name;
    private float current_service_charge;
    private float current_surcharge;
    private float current_discount;
    private float current_qty;
    private float current_subtotal;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getCurrent_service_charge() {
        return current_service_charge;
    }

    public void setCurrent_service_charge(float current_service_charge) {
        this.current_service_charge = current_service_charge;
    }

    public float getCurrent_surcharge() {
        return current_surcharge;
    }

    public void setCurrent_surcharge(float current_surcharge) {
        this.current_surcharge = current_surcharge;
    }

    public float getCurrent_discount() {
        return current_discount;
    }

    public void setCurrent_discount(float current_discount) {
        this.current_discount = current_discount;
    }

    public float getCurrent_qty() {
        return current_qty;
    }

    public void setCurrent_qty(float current_qty) {
        this.current_qty = current_qty;
    }

    public float getCurrent_subtotal() {
        return current_subtotal;
    }

    public void setCurrent_subtotal(float current_subtotal) {
        this.current_subtotal = current_subtotal;
    }
}
