package tercero.com.base.controller.services;

import java.util.*;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.core.io.ResourceLoader;
import tercero.com.base.controller.dao.dao_models.DaoCancion;
import tercero.com.base.models.Cancion;
import tercero.com.base.models.TipoArchivoEnum;

@BrowserCallable
@AnonymousAllowed
public class CancionService {

    private final DaoCancion db;
    public CancionService(ResourceLoader resourceLoader) {
        db = new DaoCancion();
    }


    public Cancion getCancion() {
        return db.getObj();
    }
    public void setCancion(Cancion cancion) {
        db.setObj(cancion);
    }
    public Cancion getCancionById(Integer id) throws Exception {
        if (id != null) {
            return db.getCancionById(id);
        }
        return null;
    }

    public void createCancion(String nombre, String duracion, String tipo, String idAlbum, String idGenero) throws Exception {
        if (nombre.trim().length() > 0 && duracion.trim().length() > 0 && tipo != null) {
            Integer id = listAllCancion().size() + 1;

            Cancion nueva = new Cancion();
            nueva.setId(id);
            nueva.setNombre(nombre.trim());
            nueva.setDuracion(Integer.parseInt(duracion));
            nueva.setId_album(Integer.valueOf(idAlbum));
            nueva.setId_genero(Integer.valueOf(idGenero));

            String urlGenerada = "cancion/" + id;
            nueva.setUrl(urlGenerada);
            nueva.setTipo(TipoArchivoEnum.valueOf(tipo));

            db.setObj(nueva);
            if (!db.save()) {
                throw new Exception("Error al momento de guardar la cancion");
            }
        }
    }

    public Boolean createCancion(Cancion cancion) throws Exception {
        if (cancion != null) {
            db.setObj(cancion);
            int id = listAllCancion().size() + 1;
            db.getObj().setUrl("cancion/" + id);
            if (!db.save()) {
                throw new Exception("Error al momento de guardar la cancion");
            }
            return true;
        }
        return false;
    }

    public void updateCancion(Integer id, String nombre, String duracion, String url, TipoArchivoEnum tipo) throws Exception {
        if (id == null || nombre == null || nombre.trim().isEmpty()
                || duracion == null || duracion.trim().isEmpty()
                || url == null || url.trim().isEmpty()
                || tipo == null) {
            throw new IllegalArgumentException("Inválido para la canción");
        }

        int duracionNum;
        try {
            duracionNum = Integer.parseInt(duracion);
            if (duracionNum <= 0) {
                throw new IllegalArgumentException("La duración tiene que ser mayor a 0");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Duración incorrecta: debe ser en numeros");
        }

        db.getObj().setId(id);
        db.getObj().setNombre(nombre.trim());
        db.getObj().setDuracion(duracionNum);
        db.getObj().setUrl(url.trim());
        db.getObj().setTipo(tipo);

        if (!db.update(id)) {
            throw new Exception("Falló en el intento de actualizar la canción");
        }
    }


    public List<Cancion> listAllCancion() {
        try {
            return Arrays.asList(db.listAll().toArray());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public TipoArchivoEnum[] getTipoArchivoEnum() {
        return TipoArchivoEnum.values();
    }

}
