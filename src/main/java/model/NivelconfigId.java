package model;


// Generated 27/11/2014 02:27:56 AM by Hibernate Tools 3.4.0.CR1

/**
 * NivelconfigId generated by hbm2java
 */
public class NivelconfigId implements java.io.Serializable {

	private Integer idNivelConfig;
	private Integer idEtiqueta;
	private Integer idPlantilla;

	public NivelconfigId() {
	}

	public NivelconfigId(Integer idNivelConfig, Integer idEtiqueta, Integer idPlantilla) {
		this.idNivelConfig = idNivelConfig;
		this.idEtiqueta = idEtiqueta;
		this.idPlantilla = idPlantilla;
	}

	public Integer getIdNivelConfig() {
		return this.idNivelConfig;
	}

	public void setIdNivelConfig(Integer idNivelConfig) {
		this.idNivelConfig = idNivelConfig;
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
		if (!(other instanceof NivelconfigId))
			return false;
		NivelconfigId castOther = (NivelconfigId) other;

		return (this.getIdNivelConfig() == castOther.getIdNivelConfig())
				&& (this.getIdEtiqueta() == castOther.getIdEtiqueta())
				&& (this.getIdPlantilla() == castOther.getIdPlantilla());
	}
}
