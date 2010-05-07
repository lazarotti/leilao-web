package br.com.redhat.leilaoweb.aplicacao;



import static org.jboss.seam.ScopeType.SESSION;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.security.Identity;

import br.com.redhat.leilaoweb.dominio.entidade.Usuario;

@Name("loginListener")
public class LoginListener {
	
	@In
	EntityManager entityManager;
	
	@In
	Identity identity;
	
	@In(create=true) @Out(scope=SESSION)
	@SuppressWarnings("unused")
	private Usuario usuarioLogado;
	
	@Observer(Identity.EVENT_LOGIN_SUCCESSFUL)	
     public void atribuirUsuarioParaSessao(){		 
		 System.out.println("Identity getname ....  "+ identity.getPrincipal().getName());
		 this.usuarioLogado = (Usuario)entityManager.createQuery("select usuario from Usuario usuario where usuario.login = :identity")
		 	.setParameter("identity", identity.getPrincipal().getName()).getSingleResult();
	 }
}