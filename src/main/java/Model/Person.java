package Model;

import java.util.UUID;

public class Person{
		private String vorname;
		private String nachname;
		private String uuid;
		
		public Person(String vorname, String nachname) {
			this.vorname = vorname;
			this.nachname = nachname;
			this.uuid = UUID.randomUUID().toString();
		}
		public Person(String uuid, String vorname, String nachname) {
			this.uuid = uuid;
			this.vorname = vorname;
			this.nachname = nachname;
		}

		public String getVorname() {
			return vorname;
		}

		public void setVorname(String vorname) {
			this.vorname = vorname;
		}

		public String getNachname() {
			return nachname;
		}

		public void setNachname(String nachname) {
			this.nachname = nachname;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
	}