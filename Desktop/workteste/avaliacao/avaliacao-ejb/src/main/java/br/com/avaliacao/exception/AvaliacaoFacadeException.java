package br.com.avaliacao.exception;


/**
 * 
 * @author francisco.alves
 *
 */
public class AvaliacaoFacadeException extends AvaliacaoException {

	
	private static final String MSG = "Ocorreu uma Exeção na camada de negocios";
	private static final long serialVersionUID = -7704947879239486816L;

   
	 public AvaliacaoFacadeException(){
	        super(MSG);
	 }
	
	 public AvaliacaoFacadeException(Throwable cause){
	        super(MSG, cause);
	    }
}
