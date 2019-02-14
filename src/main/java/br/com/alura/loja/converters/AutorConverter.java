
package br.com.alura.loja.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.alura.loja.models.Autor;

@FacesConverter(forClass = Autor.class, value = "autorConverter")
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		System.out.println("Convertento para objeto: "+ id);
		if (id == null || id.trim().isEmpty())
			return null;
		
		Autor autor = new Autor();
		autor.setId(Integer.valueOf(id));

		return autor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object autorObject) {
		System.out.println("Convertento para String: "+ autorObject);
		if (autorObject == null)
			return null;

		Autor autor = (Autor) autorObject;
		return autor.getId().toString();
	}

}
