/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabajoColaborativoUD8.src.main.java.com.mycompany.trabajocolaborativoud8;

import java.util.Objects;

/**
 *
 * @author Usuario25
 */
public class Products implements Comparable{
    
    private Integer productId, categoryId;
    private String productName, description;
    private double standardCost, listPrice;

    @Override
    public int compareTo(Object o) {
        Products p = (Products) o;
        if(productId < p.getProductId()){
            return -1;
        }else if(productId > p.getProductId()){
            return 1;
        }else{
            return 0;
        }
    }

    public Products(Integer productId, String productName, String description, double standardCost, double listPrice, Integer categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.standardCost = standardCost;
        this.listPrice = listPrice;
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getStandardCost() {
        return standardCost;
    }

    public double getListPrice() {
        return listPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.productId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Products other = (Products) obj;
        return Objects.equals(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "Products{" + "productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName + ", description=" + description + ", standardCost=" + standardCost + ", listPrice=" + listPrice + '}';
    }
    
    
    
}
