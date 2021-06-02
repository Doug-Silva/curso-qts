package bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import modelos.Boleto;
 
public class BancoDadosBoleto {
    private Connection connection = null;  
    
public BancoDadosBoleto(){
    conectaBanco();
}
    
 
// funciona somente no banco de dados postgress
// deve ser inserido o driver.
// deve ser criado a tabela no banco

 
private void conectaBanco() { 
           
	
	try {
		String url = "jdbc:postgresql://localhost/qts";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","123456");
		connection = DriverManager.getConnection(url, props);
		if (connection != null) {
	        System.out.println("STATUS--->Conectado com sucesso!");
	    } else {
	        System.out.println("STATUS--->Não foi possivel realizar conexão");
	    }
		
	}catch(Exception e) {
		 	System.out.println("Error ao conectar o banco de dados");
	        e.printStackTrace();
	}

	
    }

	public void deletaTudo() {
		String sql = "delete from boleto";
		 System.out.println("sql deleteTudo: " + sql);
		 try{
	            connection.createStatement().execute(sql);
	         
	        }catch(Exception e){
	            System.out.println("Error na remocao boleto " + e);
	            
	        }
	}
    
    public int insertboleto(Boleto p){
        String sql = "insert into boleto (valor,sacado) values('"+
                p.valor+ "','"+ p.sacado + "') RETURNING id";
     
        System.out.println("sql insert " + sql);
        
        try{
        	ResultSet rs = connection.createStatement().executeQuery(sql);
        	rs.next();
            int id =  rs.getInt(1);
            p.id =id ;
         
            return id;
           
        }catch(Exception e){
            System.out.println("Error na insercao boleto " + e);
            return -1;
        }
                
    }
    
    public boolean deleteboleto(int id){
        String sql = "delete from  boleto where id = "+ id;
        System.out.println("sql delete " + sql);
        
        try{
            connection.createStatement().execute(sql);
         
        }catch(Exception e){
            System.out.println("Error na remocao boleto " + e);
            return false;
        }
        
        return true;
    }
    
    public boolean updateboleto(Boleto p){
        String sql = "update  boleto set valor = '" + p.valor 
                + "', sacado = '" + p.sacado + "' where id = " + p.id ;
              
        System.out.println("sql update " + sql);
        
        try{
            connection.createStatement().execute(sql);
         
        }catch(Exception e){
            System.out.println("Error na update boleto " + e);
            return false;
        }
        
        return true;
    }
    
    public List<Boleto> listboleto(){
        List<Boleto> lista = new ArrayList<Boleto>();
        String sql = "select * from boleto";
        System.out.println("sql select " + sql);
        try{
        connection.createStatement().execute(sql);
             ResultSet resultSet = connection.createStatement().
                     executeQuery(sql);
          
         while(resultSet.next()){
        	Boleto pessoa = new Boleto();
            pessoa.id = (resultSet.getInt("id"));
            pessoa.valor = (resultSet.getFloat("valor"));
            pessoa.sacado =(resultSet.getString("sacado"));
            lista.add(pessoa);
         }    
       
             
        }catch(Exception e){
            
        }
        
        return lista;
    }
    
     public Boleto  buscaboleto(int idPessoa){
       
        String sql = "select * from boleto where id =" + idPessoa;             ;
        System.out.println("sql select " + sql);
        Boleto pessoa = null;
        try{
        connection.createStatement().execute(sql);
             ResultSet resultSet = connection.createStatement().
                     executeQuery(sql);
          
             while(resultSet.next()){
    	 pessoa = new Boleto();
        pessoa.id = (resultSet.getInt("id"));
        pessoa.valor = (resultSet.getFloat("valor"));
        pessoa.sacado =(resultSet.getString("sacado"));
             }
               
     
        }catch(Exception e){
            
        }
        
        return pessoa;
    }
     
     public void closeConnection() {
    	 try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
     }
}
