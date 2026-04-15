package TrabajoColaborativoUD8.src.main.java.com.mycompany.trabajocolaborativoud8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDataAccessObject {
    
    public List<Products> selectAll() throws ProductDataAccessException{
        final String SQL = "SELECT * FROM PRODUCTS";
        List<Products> lista = new ArrayList<>();
        try(Connection conn = DBUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(SQL);){
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Integer productId = rs.getInt(1);
                String productName = rs.getString(2);
                String description = rs.getString(3);
                double standardCost = rs.getDouble(4);
                double listPrice = rs.getDouble(5);
                Integer categoryId = rs.getInt(6);
                lista.add(new Products(productId, productName, description, standardCost, listPrice, categoryId));
            }
            
            return lista;
            
        }catch(SQLException e){
            System.out.println(e);
            throw new ProductDataAccessException("Ha fallado el acceso a los datos de la base de datos");
        }
    }
    
}
