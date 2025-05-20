package tercero.com.base.controller.dao.dao_models;

import tercero.com.base.controller.DataEstruct.List.Linkendlist;
import tercero.com.base.controller.dao.AdapterDao;
import tercero.com.base.models.Cancion;


public class DaoCancion extends AdapterDao<Cancion> {
    private Cancion obj;
    private Linkendlist<Cancion> aux;

    public DaoCancion() {
        super(Cancion.class);
    }

    public Cancion getObj() {
        if (obj == null) {
            this.obj = new Cancion();

        }
        return this.obj;
    }



    public void setObj(Cancion obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            this.obj.setId(this.listAll().getLength() + 1);
            this.persist(obj);
            return true;
        } catch (Exception e) {

            return false;
        }
    }


    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos - 1);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public Cancion getCancionById(Integer id)throws Exception {
        if (id != null) {
            return this.get(id);
        }
        return null;
    }

    public Linkendlist<Cancion> getListAll() {
        if (aux == null) {
            this.aux = listAll();
        }
        return aux;
    }


    public static void main(String[] args) {
        DaoCancion da = new DaoCancion();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setNombre("Cancion 1");
        da.getObj().setId_genero(1);
        da.getObj().setDuracion(120);
        da.getObj().setUrl("url");
        da.getObj().setTipo(null);
        da.getObj().setId_album(2);
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al momento de guardar la cancion :v");

        }
        System.out.println(da.getListAll().getLength());


    }

}
