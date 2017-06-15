
import br.com.sertaodigital.dao.FornecedorDao;
import br.com.sertaodigital.entity.Fornecedor;
import br.com.sertaodigital.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class teste {
    public static void main(String arg[]){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("teste");
        fornecedor.setCnpj("123456");
         
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.save(fornecedor);
        trans.commit();
        
        List lista;
        FornecedorDao fornecedorDao = new FornecedorDao();
        lista = fornecedorDao.getListJQL("t");
        
        for (Object objeto : lista){
            fornecedor = (Fornecedor) objeto;
            System.out.println(fornecedor.getNome());
        }
    }
}
