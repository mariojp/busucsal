package br.ucsal.busucsal.model;

public class Horario {
	private Long id;
	private String diaDaSemana;
	private String horaInicio;
	private Roteiro roteiro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Roteiro getRoteiro() {
		return roteiro;
	}
	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}
	
}
