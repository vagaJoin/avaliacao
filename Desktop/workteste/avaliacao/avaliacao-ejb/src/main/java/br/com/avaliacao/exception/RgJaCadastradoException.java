package br.com.avaliacao.exception;


/**
 * 
 * @author francisco.alves
 *
 */
public class RgJaCadastradoException extends AvaliacaoException {

	
	private static final String MSG = "O RG informado já esta cadastrado.";
	private static final long serialVersionUID = -7704947879239486816L;

   
	 public RgJaCadastradoException(){
	        super(MSG);
	 }
	
	 public RgJaCadastradoException(Throwable cause){
	        super(MSG, cause);
	    }
}
