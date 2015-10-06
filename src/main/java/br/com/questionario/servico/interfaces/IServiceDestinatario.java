package br.com.questionario.servico.interfaces;

import br.com.questionario.model.Destinatario;


/**
 *
 * @author EudesSilva
 * 
 */
public interface IServiceDestinatario {
     
    void enviarQuestionario(int idQuestionario, String email); 
    boolean validarRespostaQuestionario(int idQuestionario, String email);
    void registrarRespostaQuestionario(Destinatario destinatario);
}
