package reservation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Car's specifications.
 * 
 * @author inikolov2
 * 
 */
@Entity
public class CarSpecification implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Autogenerated PK.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	/**
	 * Entity's version number.
	 */
	@Version
	@Column(name = "version")
	private int version;

	@Column(name = "description")
	private String description;

	protected CarSpecification() {
	}

	public CarSpecification(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarSpecification other = (CarSpecification) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarSpecification [description=" + description + "]";
	}

}
