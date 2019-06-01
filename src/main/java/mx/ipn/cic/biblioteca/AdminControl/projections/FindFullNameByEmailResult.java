package mx.ipn.cic.biblioteca.AdminControl.projections;

public interface FindFullNameByEmailResult {

	String getNombre();
	String getApPat();
	String getApMat();

	  default String getNombreCompleto() {
	    return getNombre().concat(" ").concat(getApPat()).concat(" ").concat(getApMat());
	  }
}
