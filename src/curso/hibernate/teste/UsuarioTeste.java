package curso.hibernate.teste;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import curso.hibernate.modelo.Endereco;
import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;
import curso.hibernate.modelo.Veiculo;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		//usuario.setId(2);
		usuario.setNome("Jovita Alves");
		usuario.setDataNascimento(new Date());
		//usuario.setIdade(30);
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		Veiculo fusca = new Veiculo("Polo", 2006);
		usuario.setVeiculo(fusca);
		//fusca.setUsuario(usuario);
		
		/*Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua teste");
		endereco.setNumero(123);  
		endereco.setCidade("Taguatinga");
		
		Endereco enderecoComercial = new Endereco();
		enderecoComercial.setLogradouro("Rua sem nome");
		enderecoComercial.setNumero(1235);
		enderecoComercial.setCidade("Ocidental");*/
		
		//usuario.setEndereco(endereco);
		//usuario.setEnderecoComercial(enderecoComercial);
		//usuario.getEnderecos().add(endereco);
		//usuario.getEnderecos().add(enderecoComercial);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		//Salva no banco
		//session.save(fusca);
		session.save(usuario);
		
		session.getTransaction().commit();
		//fazer a busca no banco de dados
		//Usuario usuarioBanco = (Usuario) session.get(Usuario.class, 3);
		//imprime o usuario do banco buscado
		//System.out.println("Buscou tudo do banco");
		//System.out.println("Nome: "+ usuarioBanco.getNome());
		//List<Endereco> enderecos = usuarioBanco.getEnderecos();
		//System.out.println("Ainda não buscou do banco");
		//System.out.println("Endereco "+ usuarioBanco.getEnderecos().get(0).getLogradouro());
		//fecha a sessão
		session.close();
	}
}
