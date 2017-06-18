package br.com.sertaodigital.bean;

import br.com.sertaodigital.entity.Pedido;
//import br.com.sertaodigital.dao.PedidoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PedidoBean {
     private Pedido pedido = new Pedido();
    //private PedidoDao  pedidoDao =new PedidoDao();
    
    public PedidoBean() {
    }
    
       public String adicionarPedido(){
        //   pedidoDao.addPedido(pedido);
           pedido.setId(pedido.getId());
           pedido.setCliente(pedido.getCliente());
           pedido.setItens(pedido.getItens());
          // pedidoDao.addPedido(pedido);
           
        return "index.jsf";
       }
            
        public String removerFornecedor(){
         //   pedidoDao.removePedido(pedido);
            return "Removido com Sucesso!";
        }
/*
         public List getListarCliente(){
          
        //listacliente = clienteDao.getList();
        return this.pedidoDao.getList();
    }
  */  
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
/*
    public PedidoDao getPedidoDao() {
        return pedidoDao;
    }

    public void setPedidoDao(PedidoDao pedidoDao) {
        this.pedidoDao = pedidoDao;
    }
       */ 
    
}
