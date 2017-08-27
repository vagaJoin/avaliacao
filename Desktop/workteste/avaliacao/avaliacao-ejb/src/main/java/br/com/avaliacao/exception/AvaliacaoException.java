package br.com.avaliacao.exception;




public class AvaliacaoException extends Exception {

	
	private static final long serialVersionUID = -7704947879239486816L;

   
    public AvaliacaoException(String msg){
        super(msg);
    }

    public AvaliacaoException(String msg, Throwable cause){
        super(msg, cause);
    }
	
}
