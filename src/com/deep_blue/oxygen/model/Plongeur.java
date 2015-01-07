package com.deep_blue.oxygen.model;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Classe repr�sentant un plongeur d'une palanqu�e
 * @author Raphael
 *
 */
public class Plongeur implements Parcelable {

	public static final Parcelable.Creator<Plongeur> CREATOR = new Parcelable.Creator<Plongeur>() {
		@Override
		public Plongeur createFromParcel(Parcel source) {
			return new Plongeur(source);
		}

		@Override
		public Plongeur[] newArray(int size) {
			return new Plongeur[size];
		}
	};

	/**
	 * Id du plongeur
	 */
	private Long id;
	
	/**
	 * Id du plongeur sur le serveur distant
	 */
	private Integer idWeb;

	/**
	 * Id de la palanqu�e � laquel appartient ce plongeur
	 */
	private Long idPalanquee;
	
	/**
	 * Id de la fiche de s�curit� � laquel appartient ce plongeur=
	 */
	private Long idFicheSecurite;
	
	/**
	 * Nom du plongeur
	 */
	private String nom;
	
	/**
	 * Pr�nom du plongeur
	 */
	private String prenom;
	
	/**
	 * Liste des aptitudes de ce plongeur
	 */
	private ListeAptitudes aptitudes;
	
	/**
	 * Num�ro de t�l�phone du plongeur
	 */
	private String telephone;
	
	/**
	 * Num�ro de t�l�phone � contacter d'urgence du plongeur
	 */
	private String telephoneUrgence;
	
	/**
	 * Date de naissance du plongeur, sous forme de chaine de caract�res
	 */
	private String dateNaissance;
	
	/**
	 * Version du plongeur, pour la synchronisation
	 */
	private Long version;
	
	/**
	 * Profondeur qu'a r�alis� le plongeur (en m�tre)
	 */
	private Float profondeurRealisee;
	
	/**
	 * Dur�e de plong� r�alis� par le plongeur (en seconde)
	 */
	private Integer dureeRealisee;

	public Plongeur() {
		super();
		this.id = -1L;
		this.idWeb = -1;
		this.idPalanquee = -1L;
		this.idFicheSecurite = -1L;
		this.nom = "";
		this.prenom = "";
		this.aptitudes = new ListeAptitudes();
		this.telephone = "";
		this.telephoneUrgence = "";
		this.dateNaissance = "";
		this.profondeurRealisee = 0F;
		this.dureeRealisee = 0;
		this.version = -1L;
	}
	
	/**
	 * 
	 * @param id
	 * @param idWeb
	 * @param idPalanquee
	 * @param idFicheSecurite
	 * @param nom
	 * @param prenom
	 * @param aptitudes
	 * @param telephone
	 * @param telephoneUrgence
	 * @param dateNaissance
	 * @param profondeurRealisee
	 * @param dureeRealisee
	 * @param version
	 */
	public Plongeur(Long id, Integer idWeb, Long idPalanquee, Long idFicheSecurite,
			String nom, String prenom, ListeAptitudes aptitudes,
			String telephone, String telephoneUrgence, String dateNaissance, Float profondeurRealisee,
			Integer dureeRealisee,
			Long version) {
		super();
		this.id = id;
		this.idWeb = idWeb;
		this.idPalanquee = idPalanquee;
		this.idFicheSecurite = idFicheSecurite;
		this.nom = nom;
		this.prenom = prenom;
		this.aptitudes = aptitudes;
		this.telephone = telephone;
		this.telephoneUrgence = telephoneUrgence;
		this.dateNaissance = dateNaissance;
		this.profondeurRealisee = profondeurRealisee;
		this.dureeRealisee = dureeRealisee;
		this.version = version;
	}
	
	/**
	 * 
	 * @param source
	 */
	public Plongeur(Parcel source){
		id = source.readLong();
		idWeb = source.readInt();
		idPalanquee = source.readLong();
		idFicheSecurite = source.readLong();
		nom = source.readString();
		prenom = source.readString();
		aptitudes = source.readParcelable(ListeAptitudes.class.getClassLoader());
		telephone = source.readString();
		telephoneUrgence = source.readString();
		dateNaissance = source.readString();
		profondeurRealisee = source.readFloat();
		dureeRealisee = source.readInt();
		version = source.readLong();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idWeb
	 */
	public Integer getIdWeb() {
		return idWeb;
	}

	/**
	 * @param idWeb the idWeb to set
	 */
	public void setIdWeb(Integer idWeb) {
		this.idWeb = idWeb;
	}

	public Long getIdPalanquee() {
		return idPalanquee;
	}

	public void setIdPalanquee(Long idPalanquee) {
		this.idPalanquee = idPalanquee;
	}

	public Long getIdFicheSecurite() {
		return idFicheSecurite;
	}

	public void setIdFicheSecurite(Long idFicheSecurite) {
		this.idFicheSecurite = idFicheSecurite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ListeAptitudes getAptitudes() {
		return aptitudes;
	}

	public void setAptitudes(ListeAptitudes aptitudes) {
		this.aptitudes = aptitudes;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephoneUrgence() {
		return telephoneUrgence;
	}

	public void setTelephoneUrgence(String telephoneUrgence) {
		this.telephoneUrgence = telephoneUrgence;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public Float getProfondeurRealisee() {
		return profondeurRealisee;
	}

	public void setProfondeurRealisee(Float profondeurRealisee) {
		this.profondeurRealisee = profondeurRealisee;
	}
	
	public Integer getDureeRealisee() {
		return dureeRealisee;
	}

	public void setDureeRealisee(Integer dureeRealisee) {
		this.dureeRealisee = dureeRealisee;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	/**
	 * Met � jours la version
	 */
	public void updateVersion(){
		this.version = (new Date()).getTime() / 1000;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " {\n\tid: " + id + "\n\tidWeb: " + idWeb
				+ "\n\tidPalanquee: " + idPalanquee + "\n\tidFicheSecurite: "
				+ idFicheSecurite + "\n\tnom: " + nom + "\n\tprenom: " + prenom
				+ "\n\taptitudes: " + aptitudes + "\n\ttelephone: " + telephone
				+ "\n\ttelephoneUrgence: " + telephoneUrgence
				+ "\n\tdateNaissance: " + dateNaissance + "\n\tversion: "
				+ version + "\n\tprofondeurRealisee: " + profondeurRealisee
				+ "\n\tdureeRealisee: " + dureeRealisee + "\n}";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(id);
		dest.writeInt(idWeb);
		dest.writeLong(idPalanquee);
		dest.writeLong(idFicheSecurite);
		dest.writeString(nom != null ? nom : "");
		dest.writeString(prenom != null ? prenom : "");
		dest.writeParcelable(aptitudes, flags);
		dest.writeString(telephone != null ? telephone : "");
		dest.writeString(telephoneUrgence != null ? telephoneUrgence : "");
		dest.writeString(dateNaissance != null ? dateNaissance : "");
		dest.writeFloat(profondeurRealisee);
		dest.writeInt(dureeRealisee);
		dest.writeLong(version);		
	}
}
