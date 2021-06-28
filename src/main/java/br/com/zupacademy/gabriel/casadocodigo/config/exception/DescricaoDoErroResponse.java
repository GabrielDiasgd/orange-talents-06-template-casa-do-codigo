package br.com.zupacademy.gabriel.casadocodigo.config.exception;

import java.time.LocalDateTime;

public class DescricaoDoErroResponse {
	
	private String campo;
	private String mensagem;
	private LocalDateTime timestamp;
	private String status;
	
	public DescricaoDoErroResponse(String campo, String mensagem, LocalDateTime timestamp, String status) {
		this.campo = campo;
		this.mensagem = mensagem;
		this.timestamp = timestamp;
		this.status = status;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getStatus() {
		return status;
	}
	
	
	

}
