package cm.geolocalisation.tripcity.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Referentiel implements Parcelable {
	private Long re_id;
	private String re_nom;
	private float re_geoLatitude;
	private float re_geoLongitude;
	private String re_dateInsertion;
	private String quartier_nom;
	private String departement_nom;
	private Long superviseur_id;
	
	public Referentiel() { }
	public Referentiel(String nom, float latitude, float longitude, String quartier, String departement, Long utilisateur) {
		this.re_nom = nom;
		this.re_geoLatitude = latitude;
		this.re_geoLongitude = longitude;
		this.quartier_nom = quartier;
		this.departement_nom = departement;
		this.superviseur_id = utilisateur;
	}
	
	public Referentiel(Parcel in) {
		re_id = in.readLong();
		re_nom = in.readString();
		re_geoLatitude = in.readFloat();
		re_geoLongitude = in.readFloat();
		re_dateInsertion = in.readString();
		quartier_nom = in.readString();
		departement_nom = in.readString();
		superviseur_id = in.readLong();
    }
	
	public void setReferentielId(Long id) {
		this.re_id = id;
	}
	public void setReferentielNom(String nom) {
		this.re_nom = nom;
	}
	public void setReferentielLatitude(float latitude) {
		this.re_geoLatitude = latitude;
	}
	public void setReferentielLongitude(float longitude) {
		this.re_geoLongitude = longitude;
	}
	
	public void  setReferentielDateInsertion(String date) {
		this.re_dateInsertion = date;
	}

	public void setReferentielQuartier(String quartier) {
		this.quartier_nom = quartier;
	}
	public void setReferentielDepartement(String departement) {
		this.departement_nom = departement;
	}
	public void setReferentielUtilisateur(Long utilisateur) {
		this.superviseur_id = utilisateur;
	}
	
	public Long getReferentielId() {
		return this.re_id;
	}
	public String getReferentielNom() {
		return this.re_nom;
	}
	public float getReferentielLatitude() {
		return this.re_geoLatitude;
	}
	public float getReferentielLongitude() {
		return this.re_geoLongitude;
	}
	public String getReferentielDateInsertion() {
		return this.re_dateInsertion;
	}
	public String getReferentielQuartier() {
		return this.quartier_nom;
	}
	public String getReferentielDepartement() {
		return this.departement_nom;
	}
	public Long getReferentielSuperviseur() {
		return this.superviseur_id;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(re_id);
		dest.writeString(re_nom);
		dest.writeFloat(re_geoLatitude);
		dest.writeFloat(re_geoLongitude);
		dest.writeString(re_dateInsertion);
		dest.writeString(quartier_nom);
		dest.writeString(departement_nom);
		dest.writeLong(superviseur_id);
	}
	
	public static final Parcelable.Creator<Referentiel> CREATOR = new Parcelable.Creator<Referentiel>() {

		@Override
		public Referentiel createFromParcel(Parcel source) {
			return new Referentiel(source);
		}

		@Override
		public Referentiel[] newArray(int size) {
			return new Referentiel[size];
		}
	};
}
