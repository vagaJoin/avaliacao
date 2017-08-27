package br.com.avaliacao.exception;

/**
 * 
 * @author francisco.alves
 *
 */
public class AvaliacaoAcessoADadosException extends AvaliacaoException {

	private static final String MSG = "Ocorreu uma Exeção na camada de persistencia";
	private static final long serialVersionUID = -7704947879239486816L;

	 public AvaliacaoAcessoADadosException(){
	        super(MSG);
	 }
	
	 public AvaliacaoAcessoADadosException(Throwable cause){
	        super(MSG, cause);
	    }
	
	
}
