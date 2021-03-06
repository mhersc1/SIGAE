package model;

// Generated 27/11/2014 02:27:56 AM by Hibernate Tools 3.4.0.CR1

/**
 * EtiquetaId generated by hbm2java
 */
public class EtiquetaId implements java.io.Serializable {

	private Integer idEtiqueta;
	private Integer idPlantilla;

	public EtiquetaId() {
	}

	public EtiquetaId(Integer idEtiqueta, Integer idPlantilla) {
		this.idEtiqueta = idEtiqueta;
		this.idPlantilla = idPlantilla;
	}

	public Integer getIdEtiqueta() {
		return this.idEtiqueta;
	}

	public void setIdEtiqueta(Integer idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public Integer getIdPlantilla() {
		return this.idPlantilla;
	}

	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EtiquetaId))
			return false;
		EtiquetaId castOther = (EtiquetaId) other;

		return (this.getIdEtiqueta() == castOther.getIdEtiqueta())
				&& (this.getIdPlantilla() == castOther.getIdPlantilla());
	}



}
